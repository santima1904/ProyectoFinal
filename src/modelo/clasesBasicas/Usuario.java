package modelo.clasesBasicas;

import modelo.clasesAbstractas.Entrenador;

public class Usuario extends Entrenador {

    //Atributos
    private double dinero;
    private int aprobados;

    //Constructor por defecto

    public Usuario() {
        this.dinero = 0;
        this.aprobados = 0;
    }

    //Constructor con parámetros

    public Usuario(String nombre, int codigoEntrenador, double dinero, int aprobados) {
        super(nombre, codigoEntrenador);
        this.dinero = dinero;
        this.aprobados = aprobados;
    }

    //Getters and setters

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getAprobados() {
        return aprobados;
    }

    public void setAprobados(int aprobados) {
        this.aprobados = aprobados;
    }

    //Métodos de la clase object
    //toString

    @Override
    public String toString() {
        return super.toString()+
                ", dinero='" + dinero + '\''+
                ", aprobados='" + aprobados
                ;
    }
}
