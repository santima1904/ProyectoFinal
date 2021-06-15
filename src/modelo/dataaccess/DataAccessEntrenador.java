package modelo.dataaccess;

import modelo.clasesAbstractas.Entrenador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessEntrenador extends DataAccess{

    public static Statement sentencia;

    //Constantes
    public static final int CODIGO_USUARIO = 5;//este es el codigoEntrenador reservado para el entrenador creado por el usuario
    public static final String CONSULTA_ENTRENADOR_CREADO = "SELECT nombre FROM Entrenador\n" +
            "\tWHERE codigoEntrenador = "+CODIGO_USUARIO;
    public static final String CONSULTA_ENTRENADOR_BORRADO = "DELETE FROM Entrenador\n" +
            "\twhere codigoEntrenador = "+CODIGO_USUARIO;
    public static final String CONSULTA_ENTRENADOR_INSERTADO1 = "INSERT INTO Entrenador\n" +
            "\tVALUES ("+CODIGO_USUARIO+", ";
    public static final String CONSULTA_ENTRENADOR_INSERTADO2 = ", 50, null, 0)";
    public static final String CONSULTA_GETENTRENADOR_LIDER = "SELECT codigoEntrenador, nombre, frase FROM Entrenador\n" +
            "\tWHERE codigoEntrenador = ";
    public static final String CONSULTA_GETENTRENADOR_USUARIO = "SELECT codigoEntrenador, nombre, dinero, aprobados FROM Entrenador\n" +
            "\tWHERE codigoEntrenador = ";
    public static final String CONSULTA_UPDATE1 = "UPDATE Entrenador SET dinero = " ;
    public static final String CONSULTA_UPDATE2 = "WHERE codigoEntrenador = 5" ;


    /**
     * <b>Cabecera: </b> public static boolean entrenadorCreado(Connection conexion) </br>
     * <b>Precondiciones: </b> conexion abierta </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> booleano </br>
     * <b>Postcondiciones: </b> devuelve true si el entrenador existe y false si no </br>
     *
     * @return
     */
    public static boolean entrenadorCreado(Connection conexion){
        boolean creado = true;

        sentencia = crearStatement(conexion);
        try {
            ResultSet res = sentencia.executeQuery(CONSULTA_ENTRENADOR_CREADO);
            if (!res.next()){
                creado = false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return creado;
    }

    /**
     * <b>Cabecera: </b> public static void borrarEntrenador(Connection conexion) </br>
     * <b>Precondiciones: </b> conexion abierta </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> ninguna </br>
     * <b>Postcondiciones: </b> borra el entrenador creado previamente por el usuario </br>
     *
     */
    public static void borrarEntrenador(Connection conexion){
        sentencia = crearStatement(conexion);

        try {
           sentencia.executeUpdate(CONSULTA_ENTRENADOR_BORRADO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    /**
     * <b>Cabecera: </b> public static void addEntrenador(Connection conexion, String nombre) </br>
     * <b>Precondiciones: </b> conexion abierta, nombre distinto de null </br>
     * <b>Entradas: </b> Connection conexion, String nombre </br>
     * <b>Salida: </b> ninguna </br>
     * <b>Postcondiciones: </b> añade el entreandor con el nombre a la base de datos </br>
     *
     */
    public static void addEntrenador(Connection conexion, String nombre){
        sentencia = crearStatement(conexion);

        try {
            sentencia.executeUpdate(CONSULTA_ENTRENADOR_INSERTADO1+"'"+nombre+"'"+CONSULTA_ENTRENADOR_INSERTADO2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    /**
     * <b>Cabecera: </b> public static Entrenador getEntrenador(Connection conexion, int codigoEntrenador) </br>
     * <b>Precondiciones: </b> conexion abierta, codigo positivo entero </br>
     * <b>Entradas: </b> Connection conexion, int codigoEntrenador </br>
     * <b>Salida: </b> Entrenador </br>
     * <b>Postcondiciones: </b> Devuelve el entrenador pasado por parámetros </br>
     *
     * @return
     */
    public static Entrenador getEntrenador(Connection conexion, int codigoEntrenador){
      Entrenador entrenador = null;
      ResultSet res;

      sentencia = crearStatement(conexion);

        try {

            if (codigoEntrenador <= 4 && codigoEntrenador >= 1) {
                res = sentencia.executeQuery(CONSULTA_GETENTRENADOR_LIDER + codigoEntrenador);
            }
            else{
                res = sentencia.executeQuery(CONSULTA_GETENTRENADOR_USUARIO + codigoEntrenador);
            }

            entrenador = (Entrenador) res;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return entrenador;
    }


    /**
     * <b>Cabecera: </b> public static void actualizarDinero(Connection conexion, double dinero) </br>
     * <b>Precondiciones: </b> conexion abierta, dinero positivo real </br>
     * <b>Entradas: </b> Connection conexion, double dinero </br>
     * <b>Salida: </b> ninguna </br>
     * <b>Postcondiciones: </b> Actualiza el dienero del entreandor usuario </br>
     *
     */
    public static void actualizarDinero(Connection conexion, double dinero){

        sentencia = crearStatement(conexion);

        try {

            sentencia.executeUpdate(CONSULTA_UPDATE1+dinero+CONSULTA_UPDATE2);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
