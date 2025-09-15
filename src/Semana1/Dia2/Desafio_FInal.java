/*
4. Desafío Final
Con lo que investigaste:

Usa un Array para guardar 3 códigos secretos (ej: 123, 456, 789).
Usa un ArrayList para guardar los nombres de 3 exploradores.
Usa un HashMap para asignar a cada explorador la cantidad de oro que encontró.
Muestra el explorador con más oro.
 */

package Dia2;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.HashMap;

public class Desafio_FInal {
    public static void main(String[] args) {
        //Creamos un Array para guardar 3 codigos secretos
        int[] codigosSecretos = {777, 333, 101};

        //Creamos un ArrayList para guardar los nombres de 3 exploradores
        ArrayList<String> exploradores = new ArrayList<>();
        exploradores.add("Pablo");
        exploradores.add("Pipe");
        exploradores.add("Sergio");

        //Creamos el HashMap para asignar a cada explorador la cantidad de oro que encontro
        HashMap<String, Integer> oroEncontrado = new HashMap<>();
        oroEncontrado.put("Pablo", 384);
        oroEncontrado.put("Pipe", 890);
        oroEncontrado.put("Sergio", 738);

        //Motramos el explorador con mas oro
        String exploradorMaxOro = "";
        int maxOro = 0;

        for (String explorador : exploradores) {
            int oro = oroEncontrado.get(explorador);
            if (oro > maxOro) {
                maxOro = oro;
                exploradorMaxOro = explorador;
            }
        }

        System.out.println("EL Explorador con mas oro es: " + exploradorMaxOro + " Con " + maxOro + " de oro.");
    }
}
