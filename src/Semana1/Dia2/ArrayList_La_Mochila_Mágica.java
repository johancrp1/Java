/*
2. ArrayList – La Mochila Mágica

Pista:
No tiene límite fijo, se agranda sola cuando agregas más cosas.
Usa el método .add() para guardar, .get() para sacar y .remove() para eliminar.

Reto:
Crea un ArrayList<String> llamado mochila.
Guarda 3 objetos que llevarías a una aventura (ej: "Espada", "Mapa", "Poción").
Muestra el segundo objeto usando .get(1).
Quita un objeto con .remove() y muestra la mochila actualizada.

 */

package Dia2;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ArrayList_La_Mochila_Mágica {
    public static void main(String[] args) {
        //Creamos el array llamado mochila
        ArrayList<String> mochila = new ArrayList<>();

        //Guardamos 3 objetos de aventura en la mochila
        mochila.add("Espada");
        mochila.add("Mapa");
        mochila.add("Pocion");

        //Mostramos el segundo objeto (Que esta en el indice 1)
        System.out.println("Segundo objeto en la mochila: " + mochila.get(1));

        //Quitamos un objeto con .remove() (Por ejemplo pocion que esta en el indice 2
        mochila.remove(2);

        //Mostramos la mochila actualizada
        System.out.println("Contenido Actual de la mochila: ");
        for (String objeto : mochila) {
            System.out.println("- "+ objeto);
        }
    }
}
