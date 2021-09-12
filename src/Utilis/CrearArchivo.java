

package Utilis;

import java.io.*;


public class CrearArchivo {
    private String ruta;  
    private int puntuacion;
    private String jugador;
    
    public int getPuntucion(){
    return puntuacion;
     }
    
    public String getRuta(){
    return ruta;
    }
    
    public String getJugador(){
    return jugador;
     }
    
    public CrearArchivo(){
       
       ruta="";
       puntuacion=0;
       jugador="";
   }
    
public  void escribirLog(String ruta, int puntuacion, String jugador, String fechaJuego, String statusDelJuego){
        try {
            
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            
            
             BufferedReader br=new BufferedReader(new FileReader(new File(ruta)));
            
             FileWriter bw = new FileWriter(file, true);
             
           String linea=br.readLine();
                    
           
            if (br.lines().count() != 0) {
              for (int i = 0; i < br.lines().count(); i++) {
                if(i == br.lines().count ()) {
                       bw.write("<<<<<<< Para el Jugador:  "+jugador+", su puntuacon fue  "+  puntuacion + " ,la fecha del juego fue  " +fechaJuego + " y el juegador "+ statusDelJuego+" >>>>>>>>>");
                }
            }
            } else {
                bw.write("<<<<<<< Para el Jugador:  "+jugador+", su puntuacon fue  "+  puntuacion + " ,la fecha del juego fue  " +fechaJuego + " y el juegador "+ statusDelJuego+" >>>>>>>>>");
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
