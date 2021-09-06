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
    
    public variables getVar(String id, String valor){
        variables var = new variables();
        var = this.raiz;
        while(var != null){
            if(var.idVariable.equals(id) && var.valor.equals(valor)){
                return var;
            }
            var = var.siguiente;
        }
        return null;
    }
    
    public boolean estaVacio(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }
    
}
