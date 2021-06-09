package modelo.clasesBasicas;

import modelo.clasesAbstractas.Entrenador;

public class Lider extends Entrenador {

    //Atibutos
    private String frase;

    //Constructor por defecto

    public Lider() {
        this.frase = " ";
    }

    //Constructor con parámetros

    public Lider(String nombre, int codigoEntrenador, String frase) {
        super(nombre, codigoEntrenador);
        this.frase = frase;
    }

    //Getters and setters

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    //Métodos de la clase object
    //toString

    @Override
    public String toString() {
        return super.toString()+
                ", frase='" + frase + '\''
                ;
    }
}
