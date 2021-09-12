package Juego;

import Leer.Jugador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Utilis.MonstrarLasPreguntas;
import Utilis.CrearArchivo;

public class Juego {

    //atributos
    private MonstrarLasPreguntas<Pregunta> preguntas;
    private int puntosTotales;
    private int preguntaActual;
     private int nivel;

    //Constructor
    public Juego() {
        preguntas = new MonstrarLasPreguntas<>();
        puntosTotales = 0;
        preguntaActual = 0;
        nivel = 1;
    }

    //Getter
    public MonstrarLasPreguntas<Pregunta> getPreguntas() {
        return preguntas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPreguntaActual() {
        return preguntaActual;
    }

    
      public int getNivel() {
        return nivel;
    }
    
    

    public void reiniciarTest() {
        preguntaActual = 0;
        puntosTotales = 0;
    }

    public void realizarJuego(int puntos, int niveles) throws IOException {

        puntosTotales = puntos;
        nivel = niveles;
        System.out.println("\u001B[42m"+"reto_sofka.Test.realizarTest()");
        
        //si estan vacias las preguntas, no hacemos nada
        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas");
        } else {
            
            
            //Creamos un objeto Jugador
            Jugador teclado = new Jugador();

            int i = 0, respuesta;
            int j = 0;
            int rango = 5;
            String usuario;
            Pregunta p;
            usuario = teclado.pedirString();
            //recorremos las los niveles
            while (i < 5) { 
               SimpleDateFormat  fecha = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
               String fechaJuego = fecha.format(new Date());
               j = (int)(Math.random()* (rango - (rango-4)) + (rango-4));
                System.out.println("\u001B[31m" + "Recuerda que puedes salir del juego ingresando 0 y te llevas los punto acomulados");
                System.out.println("EL NIVEL ACTUAL ES: "+ nivel); 
                CrearArchivo archivo = new CrearArchivo();
                
                
                //Cojemos una pregunta
                p = preguntas.get(j);
                
                //La mostramos
                p.mostrarPregunta();

               
                //Pedimos una respuesta
                respuesta = teclado.pedirIntRango(0, p.getRespuestas().size(), "Introduce la respuesta");
                
                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta)) {
                    
                    puntosTotales += p.getPuntos();
                    System.out.println("Has acertado y tus puntos acumulados son: "+puntosTotales);
                    nivel = nivel +1;
                   
                    if (nivel > 5) {
                        
                        JOptionPane.showMessageDialog(null, "Haz ganado el juego tus puntos totales son: "+ puntosTotales);
                        archivo.escribirLog("log/Resultados del Juego.txt", puntosTotales, usuario, fechaJuego, "GANO"); 
                                      
                    break;
                    }
                   
               } if(respuesta == 0){ 
                     JOptionPane.showMessageDialog(null, "Te haz retirado del juego, tus puntos totales son: "+ puntosTotales);    
                       archivo.escribirLog("log/Resultados del Juego.txt", puntosTotales, usuario, fechaJuego,"SE RETIRO"); 
                    break;
                   
                }if (!p.comprobarRespuesta(respuesta)) {
                       puntosTotales = 0;
                     JOptionPane.showMessageDialog(null, "No has acertado :( " +  "Haz PERDIDO el juego y  tus puntos totales son: " + puntosTotales);
                       archivo.escribirLog("log/Resultados del Juego.txt", puntosTotales, usuario, fechaJuego,"PERDIO"); 
                    break;
                }
            
                rango = rango +5;
                i++;
                
            }
            
        }


    }

    public void cargarFicheroDePreguntas(String fichero) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        
        //variables necesarias
        String linea;
        Pregunta p;
        MonstrarLasPreguntas<Respuesta> respuestas = new MonstrarLasPreguntas<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea = br.readLine()) != null) {
                 
            try {

                //si empieza por ;P; es una pregunta
                if (linea.startsWith(";P;")) {
                    texto_pregunta = linea.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea.startsWith(";R;")) {
                    opcioncorrecta = Integer.parseInt(linea.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, cojo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, cojo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas.addLast(new Respuesta(linea));

                    //Si tiene mas de 4 respuestas o menso de 4 respuestas, lanzo excepcion
                    if (respuestas.size() > 4 ) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas.size() == 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p = new Pregunta(texto_pregunta, respuestas, puntosPregunta);

                    //añado la pregunta
                    preguntas.addLast(p);

                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas = new MonstrarLasPreguntas<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas = new MonstrarLasPreguntas<>();
            }

        }

       
        br.close();
 

    }

}
