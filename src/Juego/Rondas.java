
package Juego;

import java.io.IOException;


public class Rondas {

    public static void main(String[] args) {
        
        IniciarJuego carga = new IniciarJuego();
        
        int nivel = 1;
        int puntos= 0;
     
        try {
            carga.cambioNivel(nivel, puntos);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
       }
           
}
