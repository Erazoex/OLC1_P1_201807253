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
public class listaVariables {
    public variables raiz;
    public variables ultimo;
    public int tamano;
    
    public listaVariables(){
        
    }
    
    public void insertarVariable(String tipo, String id, String valor){
        variables aux = new variables();
        aux.tipo = tipo;
        aux.idVariable  = id;
        aux.valor = valor;
        if(estaVacio()){
            this.raiz = this.ultimo = aux;
            tamano++;
        }else{
            this.ultimo.siguiente = aux;
            this.ultimo = ultimo.siguiente;
            tamano++;
        }
    }
    
    public String getVar(String id){
        variables var = new variables();
        var = this.raiz;
        while(var != null){
            if(var.idVariable.equals(id)){
                return var.valor;
            }
            var = var.siguiente;
        }
        return "";
    }
    
    public void setValorDollar(Repitencia param){
        variables var = new variables();
        var = this.raiz;
        
        while(var != null){
            puntaje temp = param.raiz;
            while(temp != null){
                if(var.valor.equals(temp.archivo + "," + temp.tipo + "," + temp.id)){
                    var.valor = ""+temp.puntaje;
                }
                temp = temp.siguiente;
            }
            var = var.siguiente;
        }
    }
    
    public boolean estaVacio(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }
    
    
    public void imprimirVariables(){
        variables aux = new variables();
        aux = this.raiz;
        while(aux != null){
            System.out.println("el valor de la variable "+ aux.idVariable + " es: " +aux.valor);
            aux = aux.siguiente;
        }
    }
    
}
