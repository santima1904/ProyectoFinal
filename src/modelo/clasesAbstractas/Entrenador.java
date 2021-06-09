package modelo.clasesAbstractas;

import modelo.clasesBasicas.Javamon;

import java.util.ArrayList;
import java.util.List;

public abstract class Entrenador {

    //Atributos
    private String nombre;
    private int codigoEntrenador;
    private List<Javamon> equipo = new ArrayList<>();

    //Constructor por defecto

    public Entrenador() {
        this.nombre = " ";
        this.codigoEntrenador = 0;
    }

    //Constructor con parámetros

    public Entrenador(String nombre, int codigoEntrenador) {
        this.nombre = nombre;
        this.codigoEntrenador = codigoEntrenador;
    }

    //Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoEntrenador() {
        return codigoEntrenador;
    }

    public List<Javamon> getEquipo() {
        return equipo;
    }

    //Métodos de la clase object

    //toString

    @Override
    public String toString() {
        return "Entrenador: " +
                "nombre='" + nombre + '\'' +
                ", codigoEntrenador=" + codigoEntrenador
                ;
    }

    //Métodos anhadidos

    /**
     * <b>Cabecera: </b> void addJavamonEquipo(Javamon javamon) </br>
     * <b>Precondiciones: </b> Javamon diferente de null </br>
     * <b>Entradas: </b> Javamon javamon </br>
     * <b>Salida: </b> Ninguna </br>
     * <b>Postcondiciones: </b> El javamon se inserta en la lista de javamons del entrenador </br>
     *
     * @param javamon
     */
    public void addJavamonEquipo(Javamon javamon){
        equipo.add(javamon);
    }

    /**
     * <b>Cabecera: </b> void delJavamonEquipo(int codigoJavamon) </br>
     * <b>Precondiciones: </b> codigo entero y positivo </br>
     * <b>Entradas: </b> int codigoJavamon </br>
     * <b>Salida: </b> Ninguna </br>
     * <b>Postcondiciones: </b> Se borra el javamon del equipo con el codigo igual al insertado por parámetros </br>
     *
     * @param codigoJavamon
     */
    public void delJavamonEquipo(int codigoJavamon){

        equipo.removeIf(aux -> aux.getCodigoJavamon() == codigoJavamon);//este mmétodo me lo aconsejaba intellij,
        // y básicamente hace un foreach interno en la lista comparando los códigos de los elementos con el pasado por parámetros. Si coincide, lo borra

    }

    /**
     * <b>Cabecera: </b> Javamon getJavamonEquipo(int codigoJavamon) </br>
     * <b>Precondiciones: </b> codigo entero y positivo </br>
     * <b>Entradas: </b> int codigoJavamon </br>
     * <b>Salida: </b> Javamon con el codigo igual al dado </br>
     * <b>Postcondiciones: </b> Busca en el equipo un javamon con el codigo igual al dado y lo devuelve en el return </br>
     *
     * @param codigoJavamon
     */
    public Javamon getJavamonEquipo(int codigoJavamon){
    Javamon javamon = null;
        for (Javamon aux:equipo) {
            if (aux.getCodigoJavamon() == codigoJavamon){
               javamon = aux;
            }
        }
        return javamon;
    }


}
