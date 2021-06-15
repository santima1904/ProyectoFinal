package modelo.dataaccess;

import modelo.clasesAbstractas.Entrenador;
import modelo.clasesBasicas.Javamon;
import modelo.enums.Tipo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessJavamon extends DataAccess {

    public static Statement sentencia;


    //Constantes
    public static final String CONSULTA_GETJAVAMON = "SELECT codigoJavamon, nombre, tipo, descripcion, nivel, salud, danho, velocidad, starter, ISNULL (codigoEntrenador, 0) FROM Javamon\n" +
            "\tWHERE codigoJavamon = ";
    public static final String CONSULTA_CAMBIAENTRENADOR = "UPDATE Javamon SET codigoEntrenador = " ;
    public static final String CONSULTA_CAMBIAENTRENADOR2 = "WHERE codigoJavamon = " ;
    public static final String CONSULTA_GETJAVAMONENTRENADOR = "SELECT codigoJavamon, nombre, tipo, descripcion, nivel, salud, danho, velocidad, starter FROM Javamon\n" +
            "\tWHERE codigoEntrenador = ";


    /**
     * <b>Cabecera: </b> private static Javamon crearJavamon(ResultSet res) </br>
     * <b>Precondiciones: </b> res distinto de null </br>
     * <b>Entradas: </b> ResultSet res</br>
     * <b>Salida: </b> Javamon </br>
     * <b>Postcondiciones: </b> crea un javamon </br>
     *
     * @return
     */
    private static Javamon crearJavamon(ResultSet res){
        int codigoJavamon, nivel, salud, danho, velocidad, intStarter, codigoEntrenador;
        String nombre, cadenaTipo, descripcion;
        boolean starter;
        Tipo tipo;
        Javamon javamon = null;

        try {
                codigoJavamon = res.getInt("codigoJavamon");
                nombre = res.getString("nombre");
                cadenaTipo = res.getString("tipo");
                descripcion = res.getString("descripcion");
                tipo = convertirEnum(cadenaTipo);
                nivel = res.getInt("nivel");
                salud = res.getInt("salud");
                danho = res.getInt("danho");
                velocidad = res.getInt("velocidad");
                intStarter = res.getByte("starter");
                codigoEntrenador = res.getInt("codigoEntrenador");

                if (intStarter == 0) {
                    starter = false;
                } else {
                    starter = true;
                }

                javamon = new Javamon(codigoJavamon, nombre, tipo, descripcion, nivel, salud, danho, velocidad, starter, codigoEntrenador);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

     return javamon;

    }


    /**
     * Convierte la cadena dada en un enum
     *
     * @param cadenaTipo
     * @return
     */
    private static Tipo convertirEnum(String cadenaTipo) {
        Tipo tipo = null;

        if (cadenaTipo.equals("analista")){
            tipo = Tipo.ANALISTA;
        }
        if (cadenaTipo.equals("tester")){
            tipo = Tipo.TESTER;
        }
        if (cadenaTipo.equals("programador")){
            tipo = Tipo.PROGRAMADOR;
        }
        if (cadenaTipo.equals("Leo")){
            tipo = Tipo.LEO;
        }

        return tipo;
    }
    /**
     * <b>Cabecera: </b> public static Entrenador getEntrenador(Connection conexion, int codigoEntrenador) </br>
     * <b>Precondiciones: </b> conexion abierta, codigo positivo entero </br>
     * <b>Entradas: </b> Connection conexion, int codigoEntrenador </br>
     * <b>Salida: </b> Entrenador </br>
     * <b>Postcondiciones: </b> Devuelve el entrenador pasado por parámetros </br>

     * @return
     */
    public static Javamon getJavamon(Connection conexion, int codigoJavamon){
        Javamon javamon = null;
        ResultSet res;

        sentencia = crearStatement(conexion);

        try {

            res = sentencia.executeQuery(CONSULTA_GETJAVAMON + codigoJavamon);

            javamon = crearJavamon(res);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return javamon;
    }


    /**
     * <b>Cabecera: </b> public static void cambiaEntrenadorJavamon(Connection conexion, int codigoJavamon, int codigoEntrenador) </br>
     * <b>Precondiciones: </b> conexion abierta, codigos positivos enteros </br>
     * <b>Entradas: </b> Connection conexion, int codigoEntrenador, int codigoJavamon </br>
     * <b>Salida: </b> ninguna </br>
     * <b>Postcondiciones: </b> cambia el entrenador del javamon dado, si el codigo es 0, se libera el javamon  </br>
     *
     */
    public static void cambiaEntrenadorJavamon(Connection conexion, int codigoJavamon, int codigoEntrenador){

        sentencia = crearStatement(conexion);

        try {

            if (codigoEntrenador != 0){
                sentencia.executeUpdate(CONSULTA_CAMBIAENTRENADOR+codigoEntrenador+CONSULTA_CAMBIAENTRENADOR2+codigoJavamon);
            }else{
                sentencia.executeUpdate(CONSULTA_CAMBIAENTRENADOR+"null"+CONSULTA_CAMBIAENTRENADOR2+codigoJavamon);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



    /**
     * <b>Cabecera: </b> public static Javamon[] getJavamonEntrenador(Connection conexion, int codigoEntrenador) </br>
     * <b>Precondiciones: </b> conexion abierta,codigo un numero entre 1 y 5 </br>
     * <b>Entradas: </b> Connection conexion, int codigoEntrenador </br>
     * <b>Salida: </b> array con javamons </br>
     * <b>Postcondiciones: </b> mete en la array todos los javamons del entreanador dado </br>
     *
     * @return
     */

    public static Javamon[] getJavamonEntrenador(Connection conexion, int codigoEntrenador){
        ResultSet res;
        Javamon javamon = null;
        Javamon [] equipo = new Javamon[3];
        int posicion = 0;

        sentencia = crearStatement(conexion);

        try {

            res = sentencia.executeQuery(CONSULTA_GETJAVAMONENTRENADOR+codigoEntrenador);

            while(res.next()){
                javamon = crearJavamon(res);
                equipo[posicion] = javamon;
                posicion++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return equipo;
    }

}
