package controlador;

import modelo.clasesAbstractas.Ataque;
import modelo.clasesAbstractas.Entrenador;
import modelo.clasesBasicas.Danho;
import modelo.clasesBasicas.Javamon;
import modelo.clasesBasicas.Usuario;
import modelo.dataaccess.DataAccess;
import modelo.dataaccess.DataAccessEntrenador;
import modelo.enums.Tipo;
import vista.Mensajes;

import java.sql.Connection;

//TODO trato de excepciones

public class Main {
    public static void main(String[] args) {
        /*
        Danho ataque1 = new Danho("1", "a");
        Danho ataque2 = new Danho("2", "a");
        Danho ataque3 = new Danho("3", "a");
        Ataque [] ataques = new Ataque [3];
        ataques[0] = ataque1;
        ataques[1] = ataque2;
        ataques[2] = ataque3;

        Javamon javamon = new Javamon(1, "si", Tipo.LEO, "a", 1, 1, 1, 1, false,ataques );
        Entrenador yo = new Usuario("yo", 1, 12, 0);
        yo.addJavamonEquipo(javamon);
        Mensajes.verLista(yo.getEquipo());
        //yo.delJavamonEquipo(1);
        System.out.println(yo.getJavamonEquipo(1));
        Mensajes.verLista(yo.getEquipo());

         */
        Connection conexion;


        conexion = DataAccess.abrirConexion("jdbc:sqlserver://localhost","Santi", "javamaniaco37");
        System.out.println(DataAccessEntrenador.entrenadorCreado(conexion));
        //DataAccessEntrenador.borrarEntrenador(conexion);
        DataAccessEntrenador.addEntrenador(conexion, "Santi");

    }

}
