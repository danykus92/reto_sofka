package Funcionalidades;


public class MonstrarLasPreguntas<T> {

    
    private Modelo<T> primero;
    private Modelo<T> ultimo;
    private int tamanio;

    public MonstrarLasPreguntas() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    /**
     * Indica si esta la lista vacia o no
     *
     * @return
     */
    public boolean isEmpty() {
        return tamanio == 0;
    }

    /**
     * Devuelve el tamaño de la lista
     *
     * @return
     */
    public int size() {
        return tamanio;
    }

   
    /**
     * Devuelve el primer elemento, null si esta vacia la lista
     *
     * @return
     */
    public T getFirst() {
        //Si esta vacia, no hay primero que coger
        if (isEmpty()) {
            return null;
        } else {
            return primero.getElemento();
        }
    }

    /**
     * Devuelve el ultimo elemento, null si esta vacia la lista
     *
     * @return
     */
    public T getLast() {
        //Si esta vacia, no hay ultimo que coger
        if (isEmpty()) {
            return null;
        } else {
            return ultimo.getElemento();
        }
    }

    /**
     * Devuelve el nodo completo de una posicion concreta
     *
     * @param index
     * @return
     */
    private Modelo<T> getNode(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return primero; //devuelvo el primero
        } else if (index == size() - 1) {
            return ultimo; //devuelvo el ultimo
        } else {

            Modelo<T> buscado = primero;

            //Busco el nodo deseado con un recorrido
            int contador = 0;
            while (contador < index) {
                contador++;
                buscado = buscado.getSiguiente();
            }

            //Me devuelve el buscado
            return buscado;

        }

    }
    
    /**
     * Devuelve el elemento en la posicion indicada
     *
     * @param index
     * @return
     */
    public T get(int index) {

        //si esta vacio o el indice no es correcto, devuelve null
        if (isEmpty() || (index < 0 || index >= size())) {
            return null;
        } else if (index == 0) {
            return getFirst(); //Cojo el primero
        } else if (index == size() - 1) {
            return getLast(); //Cojo el ultimo
        } else {

            //Uso la funcion getNode para coger el nodo deseado
            Modelo<T> buscado = getNode(index);

            return buscado.getElemento();

        }

    }


    /**
     * Añade un elemento al final de la lista
     *
     * @param elemento
     * @return elemento añadido
     */
    public T addLast(T elemento) {

        Modelo<T> aux;

        //Si esta vacia, hago lo mismo que si fuera añadir el primero
        if (isEmpty()) {
            return addFirst(elemento);
        } else {

            //Hago el intercambio
            aux = new Modelo<>(elemento, null);

            ultimo.setSiguiente(aux);
            ultimo = aux;

        }

        //Aumento el tamanño
        tamanio++;
        return ultimo.getElemento();

    }

    /**
     * Añade el elemento al principio de la lista
     *
     * @param elemento
     * @return elemento añadido
     */
    public T addFirst(T elemento) {

        Modelo<T> aux;

        //si esta vacia, el nodo será el primero y ultimo
        if (isEmpty()) {
            aux = new Modelo<>(elemento, null);
            primero = aux;
            ultimo = aux;
        } else {
            //Hago el intercambio
            Modelo<T> primeroActual = primero;
            aux = new Modelo<>(elemento, primeroActual);
            primero = aux;

        }

        //Aumento el tamanño
        tamanio++;
        return primero.getElemento();

    }

    

}
