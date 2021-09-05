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
public class listaSimple {
    public nodo raiz;
    public int tamano;
    public nodo ultimo;
    
    public void listSimple(){
        this.raiz = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    
    public boolean estaVacia(){
        if(this.raiz == null){
            return true;
        }
        return false;
    }
    
    public int getTamano(){
        return tamano;
    }
    
    public void insertarNodo(String Tipo, String id,int cantidadLineas, int cantidadParametros){
        nodo new_nodo = new nodo();
        new_nodo.id = id;
        new_nodo.Tipo = Tipo;
        new_nodo.cantidadLineas = cantidadLineas;
        new_nodo.cantidadParametros = cantidadParametros;
        
        if(estaVacia()){
            this.raiz = this.ultimo = new_nodo;
            tamano++;
        }else{
            this.ultimo.siguiente = new_nodo;
            this.ultimo = this.ultimo.siguiente;
            tamano++;
        }
    }
    
    public nodo getNodo(int posicion){
        nodo aux = new nodo();
        aux = this.raiz;
        int contador = 0;
        if(posicion <= tamano){
            while(contador != posicion){
                aux = aux.siguiente;
                contador++;
            }
            return aux;
        }
        return null;
    }
    
    
    public void imprimirLista(){
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            nodo aux = new nodo();
            aux = this.raiz;
            while(aux!= this.ultimo.siguiente){
                System.out.println("nombre: "+aux.id);
                System.out.println("tipo: " + aux.Tipo);
                System.out.println("cantidadlineas: " + aux.cantidadLineas);
                System.out.println("cantidadparams: " + aux.cantidadParametros);
                System.out.println("");
                System.out.println("");
                aux = aux.siguiente;
            }
        }
        
    }
    
}
