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
public class valores {
    public valores siguiente;
    public String valor;
    
    public valores(){
        this.valor = "";
        this.siguiente = null;
    }
    
    public valores(String valor){
        this.valor = valor;
    }
}
