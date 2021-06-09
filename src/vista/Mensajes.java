package vista;

import modelo.clasesAbstractas.Ataque;
import modelo.clasesBasicas.Javamon;

import java.util.List;

public class Mensajes {

    //Constantes para mensajes
    public static final String USAR = " usó ";
    public static final String PROTEGER = " se está protegiendo";
    public static final String ATACAR = "";
    public static final String MODIFICAR = "";
    public static final String SUPER_EFICAZ = "El ataque es muy eficaz";

    /**
     * <b>Cabecera: </b> void verLista(List<Javamon> equipo) </br>
     * <b>Precondiciones: </b> Lista de Javamons creada </br>
     * <b>Entradas: </b> List<Javamons> </br>
     * <b>Salida: </b> Ninguna </br>
     * <b>Postcondiciones: </b> Muestra el contenido de la lista de javamons </br>
     *
     * @param equipo
     */
    public static void verLista(List<Javamon> equipo){
        for (Javamon aux:equipo) {
            System.out.println(aux.getNombre());
        }
    }

    private static void realizarAtaque(Javamon javamon, int posicion){
        System.out.println(javamon.getNombre()+USAR+javamon.getAtaqueEspecifico(posicion));
    }

    public static void protegido(Javamon javamon){
        System.out.println(javamon.getNombre()+PROTEGER);
    }

    public static void superEficaz(Javamon javamon){
        System.out.println(SUPER_EFICAZ);
    }

    public static void atacar(){

    }
}
