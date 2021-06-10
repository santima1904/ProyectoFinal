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
    public static final String CONSULTA_ENTRENADOR_INSERTADO2 = ", 50, null, 1)";//poner aprobados en 0


    /**
     * <b>Cabecera: </b> public static boolean entrenadorCreado(Connection conexion) </br>
     * <b>Precondiciones: </b> conexion abierta </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> booleano </br>
     * <b>Postcondiciones: </b> devuelve true si el entrenador existe y false si no </br>

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

     * @return
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

     * @return
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
     * <b>Cabecera: </b> public static boolean entrenadorCreado(Connection conexion) </br>
     * <b>Precondiciones: </b> conexion abierta </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> booleano </br>
     * <b>Postcondiciones: </b> devuelve true si el entrenador existe y false si no </br>

     * @return
     */
    public static boolean getEntrenador(Connection conexion, int codigoEntrenador){
      Entrenador entrenador;

      sentencia = crearStatement(conexion);

        try {

            ResultSet res = sentencia.executeQuery(CONSULTA_ENTRENADOR_CREADO);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return creado;
    }




}
