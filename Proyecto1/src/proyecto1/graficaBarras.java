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
public class graficaBarras {
     public String titulo;
    public String ejex;
    public String valores;
    public String titulox;
    public String tituloy;
    public graficaBarras siguiente;
    
    public graficaBarras(){
        this.titulo = "";
        this.ejex = null;
        this.valores = null;
        this.titulox = "";
        this.tituloy = "";
        this.siguiente = null;
    }
    
    public graficaBarras(String titulo, String ejex, String valores,String titulox, String tituloy){
        this.titulo = titulo;
        this.ejex = ejex;
        this.valores = valores;
        this.titulox = titulox;
        this.tituloy = tituloy;
    }
}
