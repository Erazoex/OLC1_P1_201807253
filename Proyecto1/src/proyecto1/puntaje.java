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
public class puntaje {
    public String archivo,tipo,id;
    public double puntaje;
    public puntaje siguiente;
    
    
    public puntaje(){
        this.archivo = "";
        this.tipo = "";
        this.id = "";
        this.puntaje = 0;
        this.siguiente = null;
    }
    
    public puntaje(String archivo,String tipo,String id,double puntaje){
        this.archivo = archivo;
        this.tipo = tipo;
        this.id = id;
        this.puntaje = puntaje;
        
    }
}
