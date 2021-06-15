package controlador;

import modelo.clasesBasicas.Javamon;
import modelo.clasesBasicas.Usuario;
import modelo.dataaccess.DataAccessEntrenador;
import modelo.dataaccess.DataAccessJavamon;

import java.sql.Connection;


public class Gestora {

    /**
     * <b>Cabecera: </b> public static Usuario obtenerEntrenador(Connection conexion, String nombre) </br>
     * <b>Precondiciones: </b> conexion abierta, nombre distinto de null </br>
     * <b>Entradas: </b> Connection conexion, String nombre </br>
     * <b>Salida: </b> Usuario </br>
     * <b>Postcondiciones: </b> Crea un entrenador a partir del nombre, o coge uno existente </br>
     *
     * @return
     */
    public static Usuario obtenerEntrenador(Connection conexion, String nombre){

        Usuario entrenador;

        if (DataAccessEntrenador.entrenadorCreado(conexion)){//si el entrenador esta creado
            entrenador = (Usuario) DataAccessEntrenador.getEntrenador(conexion, 5);
        }else{
            entrenador = new Usuario(nombre, 5, 50, 0);
            DataAccessEntrenador.addEntrenador(conexion, nombre);
        }

        return entrenador;
    }


    /**
     * <b>Cabecera: </b> public static void tirarMaquina(Connection conexion, Usuario entrenador) </br>
     * <b>Precondiciones: </b> conexion abierta, entrenador creado </br>
     * <b>Entradas: </b> Connection conexion, Usuario entrenador </br>
     * <b>Salida: </b> ninguna </br>
     * <b>Postcondiciones: </b> hace una tirada, en la que elige si dejar o coger el javamon </br>
     *
     * @return
     */
    public static void tirarMaquina(Connection conexion, Usuario entrenador){
        Javamon javamon = null;

        if (entrenador.getDinero() >= 50){
          javamon = javamonRandom(conexion);
            System.out.println("en resguardo");
        }
    }

    /**
     * <b>Cabecera: </b> public static Javamon javamonRandom(Connection conexion) </br>
     * <b>Precondiciones: </b> conexion abierta </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> Javamon </br>
     * <b>Postcondiciones: </b> coge un javamon de forma random </br>
     *
     * @return
     */
    public static Javamon javamonRandom(Connection conexion){
        int codigoJavamon, codigoEntrenador = 1;
        Javamon javamon = null;

        while(codigoEntrenador != 0) {//mientras el javamon no tenga el entrenador
            codigoJavamon = (int) Math.random() * (20 - 3) + 3;

            javamon = DataAccessJavamon.getJavamon(conexion, codigoJavamon);
            codigoEntrenador = javamon.getCodigoEntrenador();

        }

        return javamon;
    }
}
