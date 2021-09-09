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
public class graficaLineas {
    public String titulo;
    public String archivo;
    public graficaLineas siguiente;
    
    public graficaLineas(){
        this.titulo = "";
        this.archivo = "";
        this.siguiente = null;
    }
    
    public graficaLineas(String titulo, String archivo){
        this.titulo = titulo;
        this.archivo = archivo;
    }
}
