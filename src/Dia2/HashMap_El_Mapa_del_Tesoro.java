/*
3. HashMap – El Mapa del Tesoro

Pista:
Cada tesoro se guarda con una clave.
Para guardar usas .put(clave, valor).
Para buscar un tesoro, usas .get(clave).

Reto:
Crea un HashMap<String, Integer> llamado tesoros.
Guarda 3 pares clave-valor: ("Oro", 100), ("Plata", 50), ("Diamantes", 5).
Muestra cuántos diamantes tienes usando la clave "Diamantes".
Actualiza el valor de "Oro" a 200 y vuelve a imprimirlo.
 */

package Dia2;

import java.util.HashMap;

public class HashMap_El_Mapa_del_Tesoro {
    public static void main(String[] args) {
        //Creamos EL HashMap
        HashMap<String, Integer> tesoros = new HashMap<>();

        //Guardamos 3 Pares clave-valor
        tesoros.put("Oro", 100);
        tesoros.put("Plata", 50);
        tesoros.put("Diamantes", 5);

        //Mostramos cuantos diamantes tengo usando la clave "Diamantes"
        System.out.println("Diamantes: " + tesoros.get("Diamantes"));

        //Actualizamos el valor de "Oro" a 200
        tesoros.put("Oro", 200);

        //Volvemos a imprimir el valor de "Oro"
        System.out.println("Oro actualizado: " + tesoros.get("Oro"));
    }
}
