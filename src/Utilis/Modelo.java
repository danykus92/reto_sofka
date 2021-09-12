package Utilis;


public class Modelo<T> {

    //Atributos
    private T elemento;
    private Modelo<T> siguiente; //Apunta al siguiente nodo de la lista

    //Contructor
    public Modelo(T elemento, Modelo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    //Metodos
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Modelo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Modelo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return elemento + "\n";
    }

    
    
}
