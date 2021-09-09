/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import analizadores.*;
import analizadoresjs.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.general.DefaultPieDataset;



/**
 *
 * @author brian
 */
public class manejoArchivos {
    public String proyecto1 = "";
    public String proyecto2 = "";
    public String[] carpeta1;
    public String[] carpeta2;
    public listaSimple listaProyecto1, listaProyecto2;
    public listaSimple variablesArchivo1 = new listaSimple();
    public listaSimple variablesArchivo2 = new listaSimple();
    double contarPuntos1 = 0, contarPuntos2 = 0;
    int cantidadMetodos1 = 0,cantidadMetodos2 = 0;
    public Repitencia puntajes1 = new Repitencia();
    public Repitencia puntajes2 = new Repitencia();
    public String A,B;
    double puntajeGeneral;
    public Repitencia valorE = new Repitencia();
    double[] arrayPuntajes;
    public listaVariables variablesAUsar = new listaVariables();
    public int counter = 0;
    public listaGraficaBarras barras;
    public listaGraficaPie pie;
    public listaGraficaLineas lineas;
    
    
    public manejoArchivos(){
        //proyecto 1
        
       
    }
    
    public void setListaDeVariables(listaVariables varList){
        variablesAUsar = varList;
    }
    
    public void convertirPuntajesConSignoDeDollar(){
        //variablesAUsar.imprimirVariables();
        System.out.println("---------------------------------------------");
        for (int i = 0; i < valorE.tamano; i++) {
            if(variablesArchivo1.isIn(valorE.getNodo(i).id)){
                counter++;
                System.out.println(valorE.getNodo(i).id + "---" + valorE.getNodo(i).puntaje);
                for (int j = 0; j < puntajes1.tamano; j++) {
                    if(valorE.getNodo(i).archivo.equals(puntajes1.getNodo(j).archivo) && valorE.getNodo(i).tipo.equals(puntajes1.getNodo(j).tipo) && valorE.getNodo(i).id.equals(puntajes1.getNodo(j).id)){
                        valorE.getNodo(i).puntaje = puntajes1.getNodo(j).puntaje;
                    }
                }
                System.out.println(valorE.getNodo(i).id + "---" + valorE.getNodo(i).puntaje);
            }else if(variablesArchivo2.isIn(valorE.getNodo(i).id)){
                counter++;
                System.out.println(valorE.getNodo(i).id + "---" + valorE.getNodo(i).puntaje);
                for (int j = 0; j < puntajes2.tamano; j++) {
                    if(valorE.getNodo(i).archivo.equals(puntajes2.getNodo(j).archivo) && valorE.getNodo(i).tipo.equals(puntajes2.getNodo(j).tipo) && valorE.getNodo(i).id.equals(puntajes2.getNodo(j).id)){
                        valorE.getNodo(i).puntaje = puntajes2.getNodo(j).puntaje;
                    }
                }
                System.out.println(valorE.getNodo(i).id + "---" + valorE.getNodo(i).puntaje);
            }
        }
        System.out.println(counter);
    }
    
    public void setArchivos(String proyecto1_, String proyecto2_){
        this.proyecto1 = proyecto1_.replace("\"","");
        this.proyecto2 = proyecto2_.replace("\"","");
        System.out.println("proyecto1");
        System.out.println(proyecto1);
        System.out.println("");
        System.out.println("proyecto2");
        System.out.println(proyecto2);
        carpeta1 = guardarArchivo(this.proyecto1);
        carpeta2 = guardarArchivo(this.proyecto2);
        CompararArchivo();
        
    }
    
    public String[] guardarArchivo(String proyecto){
        File folder = new File(proyecto);
        String[] listaArchivos = folder.list();
        return listaArchivos;
    }
    
    public void CompararArchivo(){
        System.out.println("CompararArchivo");
        for(int i = 0; i < carpeta1.length; i++){
            for(int j = 0; j< carpeta2.length; j++){
                if(carpeta1[i].equals(carpeta2[j])){
                    A = leerarchivojs(this.proyecto1+"/"+carpeta1[i]);
                    B = leerarchivojs(this.proyecto2+"/"+carpeta2[j]);
                    leerArchivos(A,B);
                    calcularPuntaje1(carpeta1[i]);
                    calcularPuntaje2(carpeta2[j]);
                    llenarListaVariablesDeArchivos();
                }
                
            }
        }
    }
    
    public void llenarListaVariablesDeArchivos(){
        System.out.println("llenar lista variables de archivo general");
        //System.out.println("------------------------------------------------ARCHIVO 1----------------------------------------");
        for (int i = 0; i < listaProyecto1.tamano; i++) {
            variablesArchivo1.insertarNodo("variable", listaProyecto1.getNodo(i).id , 0, 0);
        }
        
        //System.out.println("------------------------------------------------ARCHIVO 2----------------------------------------");
        for (int i = 0; i < listaProyecto2.tamano; i++) {
            variablesArchivo2.insertarNodo(listaProyecto2.getNodo(i).Tipo, listaProyecto2.getNodo(i).id , 0, 0);
        }
    }
    
    
    public void calcularPuntaje1(String nombreArchivo){
        System.out.println("calcularPuntaje1");
        nodo nodo_aux = new nodo();
        nodo comparador = new nodo();
        for(int i = 0; i < listaProyecto1.getTamano();i++){
            nodo_aux = listaProyecto1.getNodo(i);
            for(int j = 0; j < listaProyecto2.getTamano(); j++){
                comparador = listaProyecto2.getNodo(j);
                if(nodo_aux.Tipo.equals("variable") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1+=1;
                    //insertar Puntajes
                    puntajes1.insertarPuntaje(nombreArchivo,"variable",nodo_aux.id,contarPuntos1);
                    contarPuntos1=0;
                }else if(nodo_aux.Tipo.equals("metodo") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1+= 0.4;
                    if(nodo_aux.cantidadLineas == comparador.cantidadLineas){
                        contarPuntos1+=0.3;
                    }
                    if(nodo_aux.cantidadParametros == comparador.cantidadParametros){
                        contarPuntos1+=0.3;
                    }
                    //insertar Puntajes
                    puntajes1.insertarPuntaje(nombreArchivo,"metodo",nodo_aux.id,contarPuntos1);
                    contarPuntos1=0;
                    
                }else if(nodo_aux.Tipo.equals("comentario") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1 += 1;
                    //insertar Puntajes
                    puntajes1.insertarPuntaje(nombreArchivo,"comentario" , listaProyecto1.getNodo(i).id , contarPuntos1);
                    contarPuntos1 = 0;
                }else if(nodo_aux.Tipo.equals("clase") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1 += 0.2;
                    if(cantidadMetodos1 == cantidadMetodos2){
                        contarPuntos1 += 0.4;
                    }
                    if(listaProyecto1.getNodo(i).cantidadLineas ==listaProyecto2.getNodo(j).cantidadLineas){
                        contarPuntos1 += 0.4;
                    }
                    puntajes1.insertarPuntaje(nombreArchivo, "clase", listaProyecto1.getNodo(i).id, contarPuntos1);
                    contarPuntos1 = 0;
                }
            }
        }
        nodo uno = new nodo();
        nodo dos = new nodo();
        puntaje prueba = new puntaje();
        for (int i = 0; i < listaProyecto1.getTamano(); i++) {
            uno = listaProyecto1.getNodo(i);
            for (int j = 0; j < listaProyecto2.getTamano(); j++) {
                dos = listaProyecto2.getNodo(j);
                if(uno.Tipo.equals("metodo")&& dos.Tipo.equals("metodo") && uno.id !=dos.id){
                    prueba.archivo = nombreArchivo;
                    prueba.tipo = uno.Tipo;
                    prueba.id = uno.id;
                    prueba.puntaje = 0;
                    if(puntajes1.existe(prueba)){
                    }else{
                        //System.out.println(uno.id);
                        //System.out.println("lineas uno: "+ uno.cantidadLineas);
                        //System.out.println("parametros uno: "+ uno.cantidadParametros);
                        //System.out.println(dos.id);
                        //System.out.println("lineas dos: "+ dos.cantidadLineas);
                        //System.out.println("parametros dos: "+ dos.cantidadParametros);
                        //System.out.println("puntajes 1");
                        if(uno.cantidadLineas == dos.cantidadLineas){
                            contarPuntos1 += 0.3;
                        }
                        if(uno.cantidadParametros == dos.cantidadParametros && uno.cantidadParametros!=0){
                            contarPuntos1+= 0.3;
                        }
                        //System.out.println(contarPuntos1);
                        if(contarPuntos1 != 0 ){
                            puntajes1.insertarPuntaje(nombreArchivo, uno.Tipo, uno.id, contarPuntos1);
                            contarPuntos1 = 0;
                        }
                        
                    }
                }
            }
            
        }
    }
    
    public void contarMetodos(){
        System.out.println("contarMetodos");
        for(int i = 0; i < listaProyecto1.getTamano();i++){
            if(listaProyecto1.getNodo(i).Tipo.equals("metodo")){
                cantidadMetodos1++;
            }
        }
        for(int i = 0; i < listaProyecto2.getTamano();i++){
            if(listaProyecto2.getNodo(i).Tipo.equals("metodo")){
                cantidadMetodos2++;
            }
        }
    }
    
    public void calcularPuntaje2(String nombreArchivo){
        System.out.println("calcularPuntaje2");
        nodo nodo_aux = new nodo();
        nodo comparador = new nodo();
        for(int i = 0; i < listaProyecto2.getTamano();i++){ 
            nodo_aux = listaProyecto2.getNodo(i);
            for(int j = 0; j < listaProyecto1.getTamano(); j++){
                comparador = listaProyecto1.getNodo(j);
                if(nodo_aux.Tipo.equals("variable") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1+=1;
                    //insertar Puntajes
                    puntajes2.insertarPuntaje(nombreArchivo,"variable",nodo_aux.id,contarPuntos1);
                    contarPuntos1=0;
                }else if(nodo_aux.Tipo.equals("metodo") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1+= 0.4;
                    if(nodo_aux.cantidadLineas == comparador.cantidadLineas){
                        contarPuntos1+=0.3;
                    }
                    if(nodo_aux.cantidadParametros == comparador.cantidadParametros){
                        contarPuntos1+=0.3;
                    }
                    //insertar Puntajes
                    puntajes2.insertarPuntaje(nombreArchivo,"metodo",nodo_aux.id,contarPuntos1);
                    contarPuntos1=0;
                    
                }else if(nodo_aux.Tipo.equals("comentario") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1 += 1;
                    //insertar Puntajes
                    puntajes2.insertarPuntaje(nombreArchivo,"comentario" , listaProyecto1.getNodo(i).id , contarPuntos1);
                    contarPuntos1 = 0;
                }else if(nodo_aux.Tipo.equals("clase") && nodo_aux.id.equals(comparador.id)){
                    contarPuntos1 += 0.2;
                    if(cantidadMetodos1 == cantidadMetodos2){
                        contarPuntos1 += 0.4;
                    }
                    if(listaProyecto1.getNodo(i).cantidadLineas ==listaProyecto2.getNodo(j).cantidadLineas){
                        contarPuntos1 += 0.4;
                    }
                    puntajes2.insertarPuntaje(nombreArchivo, "clase", listaProyecto1.getNodo(i).id, contarPuntos1);
                    contarPuntos1 = 0;
                }
            }
        }
        nodo uno = new nodo();
        nodo dos = new nodo();
        puntaje prueba = new puntaje();
        for (int i = 0; i < listaProyecto2.getTamano(); i++) {
            uno = listaProyecto2.getNodo(i);
            for (int j = 0; j < listaProyecto1.getTamano(); j++) {
                dos = listaProyecto1.getNodo(j);
                if(uno.Tipo.equals("metodo")&& dos.Tipo.equals("metodo") && uno.id !=dos.id){
                    prueba.archivo = nombreArchivo;
                    prueba.tipo = uno.Tipo;
                    prueba.id = uno.id;
                    prueba.puntaje = 0;
                    if(puntajes1.existe(prueba)){
                    }else{
                        //System.out.println(uno.id);
                        //System.out.println("lineas uno: "+ uno.cantidadLineas);
                        //System.out.println("parametros uno: "+ uno.cantidadParametros);
                        //System.out.println(dos.id);
                        //System.out.println("lineas dos: "+ dos.cantidadLineas);
                        //System.out.println("parametros dos: "+ dos.cantidadParametros);
                        if(uno.cantidadLineas == dos.cantidadLineas){
                            contarPuntos1 += 0.3;
                            if(uno.cantidadParametros == dos.cantidadParametros && uno.cantidadParametros!=0){
                                contarPuntos1+= 0.3;
                            }
                        }
                        //System.out.println(contarPuntos1);
                        if(contarPuntos1 != 0 ){
                            puntajes1.insertarPuntaje(nombreArchivo, uno.Tipo, uno.id, contarPuntos1);
                            contarPuntos1 = 0;
                        }
                        
                    }
                }
            }
            
        }
    }
    
    public void puntajeGeneralDeRepitencia(){
        nodo uno = new nodo();
        nodo dos = new nodo();
        int contarVariables = 0;
        int contarMetodos = 0;
        int contarClases = 0;
        int contarComentarios = 0;
        //repetidos
        int variablesRepetidas = 0;
        int metodosRepetidos = 0;
        int clasesRepetidas = 0;
        int comentariosRepetidos = 0;
        
        
        for (int i = 0; i < listaProyecto1.getTamano(); i++) {
            uno = listaProyecto1.getNodo(i);
            if(uno.Tipo.equals("variable")){
                contarVariables++;
            }else if(uno.Tipo.equals("metodo")){
                contarMetodos++;
            }else if(uno.Tipo.equals("clase")){
                contarClases++;
            }else if(uno.Tipo.equals("comentario")){
                contarComentarios++;
            }
        }
        
        for (int j = 0; j < listaProyecto2.getTamano(); j++) {
            dos = listaProyecto2.getNodo(j);
            if(dos.Tipo.equals("variable")){
                contarVariables++;
            }else if(dos.Tipo.equals("metodo")){
                contarMetodos++;
            }else if(dos.Tipo.equals("clase")){
                contarClases++;
            }else if(dos.Tipo.equals("comentario")){
                contarComentarios++;
            }
        }
        
        variablesRepetidas = puntajes1.cantidadRepetida("variable");
        metodosRepetidos = puntajes1.cantidadRepetida("metodo");
        clasesRepetidas = puntajes1.cantidadRepetida("clase");
        comentariosRepetidos = puntajes1.cantidadRepetida("comentario");
        
        puntajeGeneral = (comentariosRepetidos/(contarComentarios*0.2))+(variablesRepetidas/(contarVariables*0.2))+(metodosRepetidos/(contarMetodos*0.3))+(clasesRepetidas/(contarClases*0.3));
        
    }
    
    public String leerarchivojs(String ruta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String salida = "";
        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                salida += linea + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return salida;
    }
    
    public void puntajeEspecificoFCA(){
        System.out.println("puntajeEspecificoFCA");
        double[] specificScore = new double[valorE.tamano];
        puntaje auxNodo = new puntaje();
        for (int i = 0; i < valorE.tamano; i++) {
            auxNodo = valorE.getNodo(i);
            if(puntajes1.isIn(auxNodo.id.replace("\"", "")) || puntajes2.isIn(auxNodo.id.replace("\"", ""))){
                specificScore[i] = puntajes1.getPuntaje(auxNodo.archivo.replace("\"", ""), auxNodo.tipo.replace("\"", ""), auxNodo.id.replace("\"", ""));
                //System.out.println(puntajes1.getPuntaje(auxNodo.archivo.replace("\"", ""), auxNodo.tipo.replace("\"", ""), auxNodo.id.replace("\"", "")));
            }else{
                specificScore[i] = 0;
            }
        }
        this.arrayPuntajes = specificScore;
        
    }
    
    public void setListaValorEspecifico(Repitencia aux){
        System.out.println("setListaValorEspeifico");
        valorE = aux;
        //valorE.imprimirPuntajes();
        /*for (int i = 0; i < arrayPuntajes.length; i++) {
            System.out.println(arrayPuntajes[i]);
        }*/
    }
    
    public void leerArchivos(String ruta1, String ruta2){
        //ARCHIVO 1
        lexicojs lexicoAux1 = new lexicojs(new StringReader(ruta1));
        sintacticojs sintacticoAux1 = new sintacticojs(lexicoAux1);
        
        
        //ARCHIVO 2
        lexicojs lexicoAux2 = new lexicojs(new StringReader(ruta2));
        sintacticojs sintacticoAux2 = new sintacticojs(lexicoAux2);
        
        
        try{
            sintacticoAux1.parse();
            sintacticoAux2.parse();
        }
        catch(Exception e){
            System.out.println("Error al analizar la entrada");
            System.out.println("debido a: "+e.getCause());
        }
        this.listaProyecto1 = sintacticoAux1.getLista();
        this.listaProyecto2 = sintacticoAux2.getLista();
        
    } 
    
    public void setListaGraficas(listaGraficaLineas listlineas, listaGraficaBarras listbarras, listaGraficaPie listpie){
        lineas = listlineas;
        barras = listbarras;
        pie = listpie;
        //generarGrafica();
    }
    
    public void generarGrafica(){
        if(pie.estaVacio()){
            System.out.println("no existen graficas de pie");
            
        }else{
            System.out.println("a");
            int counter = 0;
            for (int i = 0; i < pie.tamano; i++) {
                counter++;
                graficaPie aux = new graficaPie();
                aux = pie.getValor(i);
                DefaultPieDataset p = new DefaultPieDataset();
                String[] listaejex = aux.ejex.split(",");
                String[] listavalores = aux.valores.split(",");
                System.out.println(listaejex.length);
                System.out.println(listavalores.length);
                for (int j = 0; j < listaejex.length; j++) {
                    System.out.println(listaejex[j]);
                    System.out.println(listavalores[j]);
                    System.out.println("b");
                    p.setValue(listaejex[j],Double.parseDouble(listavalores[j]));
                }
                JFreeChart graph = ChartFactory.createPieChart(aux.titulo, p);
                try{
                    final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                    final File f = new File("graficaPie ("+counter+").png");
                    ChartUtilities.saveChartAsPNG(f, graph, 600, 400, info);
                }catch(Exception e){
                    
                }
            }
            counter = 0;
        }
    }
    
    
}
