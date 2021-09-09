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
public class listaGraficaLineas {
    public graficaLineas raiz;
    public graficaLineas ultimo;
    public int tamano;
    
    public listaGraficaLineas(){
        this.raiz = null;
        this.ultimo = null;
        this.tamano = 0;
    }
    
    public void insertarGrafica(graficaLineas nodo){
        graficaLineas aux = new graficaLineas();
        aux = nodo;
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
    
    public graficaLineas getValor(int posicion){
        graficaLineas aux = new graficaLineas();
        aux = this.raiz;
        int contador = 0;
        if(posicion<= this.tamano){
            while(contador != posicion){
                aux = aux.siguiente;
                contador++;
            }
            return aux;
        }
        return null;
    }
}
