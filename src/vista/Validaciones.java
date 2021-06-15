package vista;

import java.util.Scanner;

public class Validaciones {

    //Teclado
    public static Scanner teclado = new Scanner(System.in);

    /**
     * Cabecera: public static int pedirString()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: string cadena
     * Postcondiciones: Pide una cadena al usuario
     */

    public static String pedirNombre(){
        String cadena = null;//variable para recoger los datos insertados por teclado y devolverlo

        while(cadena == null || cadena.equals(" ")){//mientras no sea nulo o este vacio
            System.out.println("Introduzca el nombre: ");
            cadena = teclado.nextLine();
        }

        return cadena;//devuelvo la variable
    }
}
