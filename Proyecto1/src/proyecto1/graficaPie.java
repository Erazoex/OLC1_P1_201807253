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
public class graficaPie {
    public String titulo;
    public String ejex;
    public String valores;
    public graficaPie siguiente;
    
    public graficaPie(){
        this.titulo = "";
        this.ejex = null;
        this.valores = null;
        this.siguiente = null;
    }
    
    public graficaPie(String titulo, String ejex, String valores){
        this.titulo = titulo;
        this.ejex = ejex;
        this.valores = valores;
    }
}
