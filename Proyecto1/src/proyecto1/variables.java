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
public class variables {
    public String tipo;
    public String idVariable;
    public String valor;
    public variables siguiente;
    
    public variables(){ 
        this.tipo = "";
        this.idVariable = "";
        this.valor = "";
        this.siguiente = null;
        
    }
    
    public variables(String tipoVar, String idVar, String valorVar){
        this.tipo = tipoVar;
        this.idVariable = idVar;
        this.valor = valorVar;
    }
    
}
