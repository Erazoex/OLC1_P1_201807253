/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadoresjs;

/**
 *
 * @author brian
 */
public class generadorjs {
    public static void main(String[] args) 
    {
        generarAnalizadores();
    }
    
    private static void generarAnalizadores() 
    {
        try {
            String ruta = "src/analizadoresjs/";
            String opcFlex[] = {ruta + "lexicojs.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);
            
            String opcCUP[] = {"-destdir", ruta, "-parser", "sintacticojs", ruta + "sintacticojs.cup"};
            java_cup.Main.main(opcCUP);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
