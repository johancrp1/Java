/*
ArrayList:

Crea un ArrayList con al menos 4 nombres de tus compañeros.
Recorre el ArrayList e imprime: "Hola, ".
 */

package Dia2;

import java.util.ArrayList;

public class Recorriendo_ArrayList {
    public static void main(String[] args) {
        //Creamos un ArrayList de nombres
        ArrayList<String> compañeros = new ArrayList<>();

        //Agregar al menos 4 nombres
        compañeros.add("Carlos");
        compañeros.add("Maria");
        compañeros.add("Luis");
        compañeros.add("Ana");

        // Recorrer el ArrayList y saludar a cada uno
        for (String nombre : compañeros) {
            System.out.println("Hola, "+ nombre + "!");
        }
    }
}
