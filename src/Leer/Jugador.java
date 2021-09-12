package Leer;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Jugador {

    //Scanner para pedir datos
    private Scanner sc;

    /**
     * Por defecto
     */
    public Jugador() {
        sc = new Scanner(System.in);
        sc.useDelimiter("\n"); //Usado para nextLine()
        sc.useLocale(Locale.US); // Para double
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero entero entre " + minimo + " y " + maximo + ", RECUERDA que 0 es para salir del juego");
            
            }
            

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    
    
    /**
     * Pide una cadena
     *
     * @return cadena introducida por el usuario
     */
    public String pedirString() {

        System.out.println("Introduce un nombre de usuario");
        String cadena = sc.next();

        return cadena;

    }

    /**
     * Pide una cadena
     *
     * @param mensaje
     * @return cadena introducida por el usuario
     */
    public String pedirString(String mensaje) {

        System.out.println(mensaje);
        String cadena = sc.next();

        return cadena;

    }
    

    
}
