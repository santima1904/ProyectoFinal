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
    public static final String INICIO = "Buenas entrenador\n" +
            "Bienvenido a Nervionia, la región en la que podrás demostrar tu valía y nivel.\n" +
            "Antes de todo, como te llamas?\n";
    public static final String ELECCION_MAQUINA = "Le ha salido ";
    public static final String ELECCION_MAQUINA2 = "Que desea hacer?\n " +
            "1. Quedartelo" + "2. Dejarlo";



    /**
     * <b>Descripcion: </b> Muestra el contenido de la lista de javamons </br>
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

    public static void atacar(){     }

    public static void menu(){
        System.out.println(INICIO);
    }
    public static void eleccionMaquina(){
        System.out.println(INICIO);
    }
}
