package modelo.clasesBasicas;

import modelo.clasesAbstractas.Ataque;
import modelo.enums.Tipo;

public class Javamon {

    //Atributos
    private int codigoJavamon;
    private String nombre;
    private Tipo tipo;
    private String descripcion;
    private int nivel;
    private int salud;
    private int danho;
    private int velocidad;
    private boolean starter;
    private Ataque[] ataques;
    private int codigoEntrenador;

    //Constructor por defecto

    public Javamon() {
        this.codigoJavamon = 0;
        this.nombre = " ";
        this.tipo = null;
        this.descripcion = " ";
        this.nivel = 0;
        this.salud = 0;
        this.danho = 0;
        this.velocidad = 0;
        this.starter = false;
        this.ataques = null;
        this.codigoEntrenador = 0;
    }

    //Constructor con parámetros

    public Javamon(int codigoJavamon, String nombre, Tipo tipo, String descripcion, int nivel, int salud, int danho, int velocidad, boolean starter, Ataque[] ataques) {
        this.codigoJavamon = codigoJavamon;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.salud = salud;
        this.danho = danho;
        this.velocidad = velocidad;
        this.starter = starter;
        this.ataques = ataques;
        this.codigoEntrenador = 0;
    }

    //Getters and setters

    public int getCodigoJavamon() {
        return codigoJavamon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getDanho() {
        return danho;
    }

    public void setDanho(int danho) {
        this.danho = danho;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isStarter() {
        return starter;
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public int getCodigoEntrenador() {
        return codigoEntrenador;
    }

    //Métodos de la clase object

    //toString

    @Override
    public String toString() {
        return "Javamon: " +
                "codigoJavamon=" + codigoJavamon +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", nivel=" + nivel +
                ", salud=" + salud +
                ", danho=" + danho +
                ", velocidad=" + velocidad +
                ", starter=" + starter;
    }

    //Métodos anhadidos
    /**
     * <b>Cabecera: </b> String getAtaqueEspecifico(int posicion) </br>
     * <b>Precondiciones: </b> posicion entero y positivo </br>
     * <b>Entradas: </b> int posicion </br>
     * <b>Salida: </b> nombre del ataque en la posicion dada </br>
     * <b>Postcondiciones: </b> busca el nombre del ataaque que ocupa la posicion dada en la array </br>
     *
     * @param posicion
     */
    public String getAtaqueEspecifico(int posicion){

        return ataques[posicion].getNombre();
    }


}
