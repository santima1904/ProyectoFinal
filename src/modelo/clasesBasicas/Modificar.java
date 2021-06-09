package modelo.clasesBasicas;

import modelo.clasesAbstractas.Ataque;

public class Modificar extends Ataque {

    //Atributos
    private String stat;
    private int cantidad;

    //Constructor por defecto

    public Modificar() {
        this.stat = " ";
        this.cantidad = 0;
    }

    //Constructor con parámetros

    public Modificar(String nombre, String descripcion, String stat, int cantidad) {
        super(nombre, descripcion);
        this.stat = stat;
        this.cantidad = cantidad;
    }

    //Getters and setters

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
