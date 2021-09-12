
package reto_sofka;

import java.io.IOException;

public class IniciarJuego {

        
    public void cambioNivel(int nivel, int puntos) throws IOException{
        Juego juego=new Juego();
       
               juego.cargarFicheroDePreguntas("niveles.txt");
               juego.realizarJuego( puntos, nivel);                                   
       
       
    }
  
    
}
