

package listaDinamica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class crearArchivo {
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
    
    public crearArchivo(){
       
       ruta="";
       puntuacion=0;
       jugador="";
   }
    
public  void escribirLog(String ruta, int puntuacion, String jugador){
        try {
            
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Para el Jugador:  "+jugador+"  ,la  puntuacon fue:  "+puntuacion);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
