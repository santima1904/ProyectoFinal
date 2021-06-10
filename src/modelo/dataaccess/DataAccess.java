package modelo.dataaccess;

import java.sql.*;

public class DataAccess {

    /**
     * <b>Cabecera: </b> public static Connection abrirConexion(String url, String usuario, String contrasenha) </br>
     * <b>Precondiciones: </b> cadenas distintas de null </br>
     * <b>Entradas: </b> String url, String usuario, String contrasenha </br>
     * <b>Salida: </b> Connection conexionBaseDatos </br>
     * <b>Postcondiciones: </b> abre la conexion con la base de datos </br>
     *
     * @param url
     * @param usuario
     * @param contrasenha
     * @return
     */
    public static Connection abrirConexion(String url, String usuario, String contrasenha){
        Connection connexionBaseDatos = null;

            try {
                connexionBaseDatos = DriverManager.getConnection("jdbc:sqlserver://localhost","Santi", "javamaniaco37");//abro la conexion
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        return connexionBaseDatos;
    }

    /**
     * <b>Cabecera: </b> protected static Statement crearStatement(Connection conexion) </br>
     * <b>Precondiciones: </b> Connection creado </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> Statement sentencia </br>
     * <b>Postcondiciones: </b> crea un objeto Statement </br>
     *
     * @param conexion
     * @return
     */
    protected static Statement crearStatement(Connection conexion){
        Statement sentencia = null;

            try {
                sentencia = conexion.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        return sentencia;
    }

    /**
     * <b>Cabecera: </b> public static void cerrarConexion(Connection conexion) </br>
     * <b>Precondiciones: </b> Connection creado </br>
     * <b>Entradas: </b> Connection conexion </br>
     * <b>Salida: </b> Ninguna </br>
     * <b>Postcondiciones: </b> cierra la conexion con la base de datos </br>
     *
     * @param conexion
     */
    public static void cerrarConexion(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * <b>Cabecera: </b> protected static void cerrarStatement(Statement sentencia) </br>
     * <b>Precondiciones: </b> Statement creado </br>
     * <b>Entradas: </b> Statement sentencia </br>
     * <b>Salida: </b> Ninguna </br>
     * <b>Postcondiciones: </b> cierra el Statement </br>
     *
     * @param sentencia
     */
    protected static void cerrarStatement(Statement sentencia){
        try {
            sentencia.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * <b>Cabecera: </b> protected static void cerrarResultset(ResultSet res) </br>
     * <b>Precondiciones: </b> ResultSet creado </br>
     * <b>Entradas: </b> ResultSet res </br>
     * <b>Salida: </b> Ninguna </br>
     * <b>Postcondiciones: </b> cierra el Resultset </br>
     *
     * @param res
     */
    protected static void cerrarResultset(ResultSet res){
        try {
            res.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
