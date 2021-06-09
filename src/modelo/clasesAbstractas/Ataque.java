package modelo.clasesAbstractas;

public abstract class Ataque {

    //Atributos
    private String nombre;
    private String descripcion;

    //Constructor por defecto

    public Ataque() {
        this.nombre = " ";
        this.descripcion = " ";
    }

    //Constructor con parámetros

    public Ataque(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    //Métodos de la clase object

    //toString

    @Override
    public String toString() {
        return "Ataque: " +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'';
    }
}
