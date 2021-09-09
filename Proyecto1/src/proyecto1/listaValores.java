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
public class listaValores {
    public valores raiz;
    public valores ultimo;
    public int tamano;
    
    public listaValores(){
        this.raiz = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    
    
    public void insertarValor(String val){
        valores aux = new valores();
        aux.valor = val;
        if(estaVacio()){
            this.raiz = this.ultimo = aux;
            this.tamano++;
        }else{
            this.ultimo.siguiente = aux;
            this.ultimo = this.ultimo.siguiente;
            this.tamano++;
        }
        
    }
    
    public boolean estaVacio(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }
    
    public int getTamano(){
        return this.tamano;
    }
    
    public void setValorDollar(Repitencia param){
        valores var = new valores();
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
    
    
    
    public String getValor(int posicion){
        valores aux = new valores();
        aux = this.raiz;
        int contador = 0;
        if(posicion<= this.tamano){
            while(contador != posicion){
                aux = aux.siguiente;
                contador++;
            }
            return aux.valor;
        }
        return "";
    }
    
    public void vaciarLista(){
        this.raiz = null;
        this.tamano = 0;
    }
    
    
    public void imprimir(){
        valores val = new valores();
        val = this.raiz;
        if(estaVacio()){
            System.out.println("la lista esta vacia");
        }else{
            while(val!= null){
            System.out.println("-------ARRAY------------->"+ val.valor);
            val = val.siguiente;
        }
        }
        
    }
}
