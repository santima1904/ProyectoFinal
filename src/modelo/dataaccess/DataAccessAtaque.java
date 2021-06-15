package modelo.dataaccess;

import modelo.clasesAbstractas.Ataque;
import modelo.clasesBasicas.Danho;
import modelo.clasesBasicas.Javamon;
import modelo.clasesBasicas.Modificar;
import modelo.clasesBasicas.Proteger;
import modelo.enums.Tipo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessAtaque extends DataAccess{

    public static Statement sentencia;

    //Constantes
    public static final String CONSULTA_GETATAQUES = "SELECT descripcion, stat, cantidad FROM Ataque\n" +
            "\tWHERE nombre = ";
    public static final String CONSULTA_GETATAQUESJAVAMON = "SELECT nombre FROM Ataque\n" +
            "\tWHERE codigoJavamon = ";


    /**
     * <b>Cabecera: </b> private static Ataque crearAtaque(ResultSet res) </br>
     * <b>Precondiciones: </b> res distinto de null </br>
     * <b>Entradas: </b> ResultSet res</br>
     * <b>Salida: </b> Ataque </br>
     * <b>Postcondiciones: </b> crea un ataque </br>
     *
     * @return
     */
    private static Ataque crearAtaque(ResultSet res){
        int cantidad;
        String nombre, descripcion, stat;

        Ataque ataque = null;

        try {
            nombre = res.getString("nombre");
            descripcion = res.getString("descripcion");
            stat = res.getString("stat");
            cantidad = res.getInt("cantidad");

            if(descripcion.equals("Provoca danho en el adversario")) {

                ataque = new Danho(nombre, descripcion);

            }else if(descripcion.equals("Te protege de los ataques del adversario")) {

                ataque = new Proteger(nombre, descripcion);

            }else{

                ataque = new Modificar(nombre, descripcion, stat, cantidad);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        cerrarResultset(res);

        return ataque;

    }


    /**
     * <b>Cabecera: </b> private static ResultSet consultaAtaques(Connection conexion, String nombre) </br>
     * <b>Precondiciones: </b> conexion abierta y nombre distinto de null </br>
     * <b>Entradas: </b> Connection conexion, String nombre </br>
     * <b>Salida: </b> ResultSet </br>
     * <b>Postcondiciones: </b> abre un resultset con los datos de la consulta </br>
     *
     * @return
     */
    private static ResultSet consultaAtaques(Connection conexion, String nombre){
        Statement sentencia2;
        ResultSet res2 = null;

        sentencia2 = crearStatement(conexion);

        try {
            res2 = sentencia2.executeQuery(CONSULTA_GETATAQUES+"'"+nombre+"'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        cerrarStatement(sentencia2);

        return res2;
    }

    /**
     * <b>Cabecera: </b> public static Ataque[] getAtaquesJavamon(Connection conexion, int codigoJavamon) </br>
     * <b>Precondiciones: </b> conexion abierta,codigo un numero entre 1 y 24 </br>
     * <b>Entradas: </b> Connection conexion, int codigoJavamon </br>
     * <b>Salida: </b> array con ataques </br>
     * <b>Postcondiciones: </b> mete en la array todos los ataques del javamon dado </br>
     *
     * @return
     */

    public static Ataque[] getAtaquesJavamon(Connection conexion, int codigoJavamon){
        ResultSet res;
        Ataque ataque = null;
        String nombre;
        Ataque [] ataques = new Ataque[3];
        int posicion = 0;

        sentencia = crearStatement(conexion);

        try {

            res = sentencia.executeQuery(CONSULTA_GETATAQUESJAVAMON+codigoJavamon);

            while(res.next()){
                nombre = res.getString("nombre");
                ataque = crearAtaque(consultaAtaques(conexion, nombre));
                ataques[posicion] = ataque;
                posicion++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return ataques;
    }
}
