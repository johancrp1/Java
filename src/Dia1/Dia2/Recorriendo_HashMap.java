/*
HashMap:

Crea un HashMap<Integer, String> que guarde el número de documento como clave y el nombre como valor.
Recorre el mapa e imprime un mensaje así:
Documento: → Nombre:
 */

package Dia2;

import java.util.HashMap;
import java.util.Map;

public class Recorriendo_HashMap {
    public static void main(String[] args) {
        //Creamos el HashMap con documento (Integer) como clave y nombre (String) como valor
        HashMap<Integer, String> personas = new HashMap<>();

        //Agregar elementos al mapa
        personas.put(1035441567, "Yohann");
        personas.put(1235414567, "Andrea");
        personas.put(1835441224, "Pablo");
        personas.put(1724821487, "Yohann");

        //Recorremos el mapa e imprimimos el mensaje

        for (Map.Entry<Integer, String> entrada : personas.entrySet()) {
            System.out.println("Documento: " + entrada.getKey() + "- Nombre: " + entrada.getValue());
        }
    }
}
