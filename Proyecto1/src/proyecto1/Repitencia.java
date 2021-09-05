/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author brian
 */
public class Repitencia {
    public puntaje raiz;
    public puntaje ultimo;
    
    public void Repitencia(){
        this.raiz = null;
        this.ultimo = null;
    }
    
    public void insertarPuntaje(String archivo_, String tipo_, String id_, double puntaje_){
        puntaje new_puntaje = new puntaje();
        new_puntaje.archivo = archivo_;
        new_puntaje.tipo = tipo_;
        new_puntaje.id = id_;
        new_puntaje.puntaje = puntaje_;
        if(estaVacio()){
            this.raiz = this.ultimo = new_puntaje;
        }else{
            this.ultimo.siguiente = new_puntaje;
            this.ultimo= this.ultimo.siguiente;
        }
    }
    
    public void imprimirPuntajes(){
        puntaje aux = new puntaje();
        aux = this.raiz;
        if(estaVacio()){
            System.out.println("no existen puntajes");
        }else{
            while(aux != null){
                System.out.println("Puntaje especifico");
                System.out.println("Archivo: "+ aux.archivo);
                System.out.println("Tipo: "+ aux.tipo);
                System.out.println("Id: "+ aux.id);
                System.out.println("Puntaje: "+ aux.puntaje);
                System.out.println("");
                System.out.println("");
                aux = aux.siguiente;
            }
        }
    }
    
    public double getPuntaje(String tipo, String id){
        puntaje puntaje_aux = new puntaje();
        puntaje_aux = this.raiz;
        while(puntaje_aux != null){
            if(puntaje_aux.tipo.equals(tipo) && puntaje_aux.id.equals(id)){
                return puntaje_aux.puntaje;
            }
        }
        System.out.println("no se encontro el puntaje");
        return 0;
    }
    
    public boolean existe(puntaje comparar){
        puntaje aux = new puntaje();
        aux = this.raiz;
        while(aux!= null){
            if(aux.id.equals(comparar.id)){
                return true;
            }
            //System.out.println("comprobando");
            aux = aux.siguiente;
        }
        return false;
    }
    
    public boolean estaVacio(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }
}
