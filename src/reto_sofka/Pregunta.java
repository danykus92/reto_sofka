package reto_sofka;

import listaDinamica.MonstrarLasPreguntas;

public class Pregunta {
    
    private String pregunta;
    private MonstrarLasPreguntas<Respuesta> respuestas;
    private int puntos;

    public Pregunta(String pregunta, MonstrarLasPreguntas<Respuesta> respuestas, int puntos) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
        this.puntos = puntos;
    }

    public String getPregunta() {
        return pregunta;
    }

    public MonstrarLasPreguntas<Respuesta> getRespuestas() {
        return respuestas;
    }

    public int getPuntos() {
        return puntos;
    }

    
    public void mostrarPregunta(){
        
        System.out.println(pregunta);
        
        int i=0;
        while(i<respuestas.size()){
            System.out.println("\t"+(i+1)+". "+respuestas.get(i));
            i++;
        }
        
    }
    
    public boolean comprobarRespuesta(int respuesta){
        
        Respuesta r = respuestas.get(respuesta - 1);
        
        if(r!=null){
            return r.isCorrecta();
        }
        
        return false;
        
    }
    
}
