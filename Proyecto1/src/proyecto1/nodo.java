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
public class nodo {
    public String id;
    public String Tipo;
    public int cantidadLineas;
    public int cantidadParametros;
    public nodo siguiente;
            
    
    public nodo(String tipo, String id, int cantidadLineas, int cantidadParametros){
        this.id = id;
        this.Tipo = tipo;
        this.cantidadLineas = cantidadLineas;
        this.cantidadParametros = cantidadParametros;
        this.siguiente = null;
    }
    
    public nodo(){
        
    }
}
