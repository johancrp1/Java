package Dia3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Repaso_Del_Dia_2 {

        /*
    1. for :

    Patrón en pirámide Usa dos bucles for para imprimir:

        *
       ***
      *****
     *******

     */
    public static void Piramide() {
        //Definimos la altura de la piramide
        int altura = 4;

        //Creamos un bucle que se ejecuta una vez por cada nivel de la piramide
        for (int i = 1; i <= altura; i++) {
            //Primer bucle interno que imprime los espacios
            for (int j = 1; j <= altura -i; j++) {
                System.out.print(" ");
            }

            //Segundo bucle interno que imprime los asteriscos
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    2. while :
    Inverso de un número Pide un número entero y usando while obtén el número invertido (ejemplo: 12345 → 54321).
    Luego, indica si es capicúa.
     */

    public static void NumeroInverso() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un numero entero: ");
        int numeroOriginal = scanner.nextInt();

        int numero = numeroOriginal; // Copiamos el numero para invertir
        int invertido = 0;

        //Invertimos el numero usando While
        while (numero != 0) {
            int digito = numero % 10; //Obtener el ultimo dijito
            invertido = invertido * 10 + digito; // COnstruir el numero invertido
            numero /= 10; //ELiminar el ultimo digito
        }

        //Mostramos el resultado
        System.out.println("Numero invertido: " +  invertido);

        //Verificamos si es capicúa
        if (numeroOriginal == invertido) {
            System.out.println("El numero es un numero capicua");
        } else {
            System.out.println("El numero no es un numero capicúa");
        }

        scanner.close();
    }

    /*
    3. do-while:
    Usa do-while para repetir hasta que elija 0.

    Número adivinanza con pistas Genera un número aleatorio entre 1 y 100. Usa do-while para que el usuario intente adivinar. Si el número está a ±5 del secreto, muestra "¡Muy cerca!".
     */

    public static void AdivinaNumero() {
        Scanner sc = new Scanner(System.in);

        // Se crea un objeto Random para generar un número aleatorio
        Random rand = new Random();

        // Genera un número aleatorio entre 1 y 100, inclusive
        int secreto = rand.nextInt(100) + 1; // Numero entre 1 y 100
        // Variable para almacenar el intento del jugador
        int intento;

        // Se muestra un mensaje inicial al usuario indicando el rango del número
        System.out.println("Adivina el numero entre 1 y 100!");
        System.out.println("Ingresa 0 para salir.");

        // Bucle que se ejecuta mientras el jugador no adivine el número
        do {
            // Solicita al jugador que ingrese su intento
            System.out.print("Tu intento: ");
            intento = sc.nextInt(); // Lee el número ingresado por el jugador

            // Si el jugador ingresa 0, se termina el juego
            if (intento == 0) {
                System.out.println("Has salido del juego.");
                break; // Sale del bucle y termina el juego
            }

            // Si el intento es igual al número secreto, el jugador ha ganado
            if (intento == secreto) {
                System.out.println("¡Correcto! Adivinaste el numero.");
            } else {
                // Si el intento está muy cerca del número secreto (dentro de 5 unidades), se le da una pista
                if (Math.abs(intento - secreto) <= 5) {
                    System.out.println("¡Muy Cerca!");
                } else if (intento < secreto) {
                    // Si el intento es menor que el número secreto, se le indica que el número es mayor
                    System.out.println("El numero es mayor.");
                } else {
                    // Si el intento es mayor que el número secreto, se le indica que el número es menor
                    System.out.println("El numero es menor.");
                }
            }
            // El bucle sigue hasta que el jugador adivine el número (cuando intento == secreto)
        } while (intento != secreto);

        // Se cierra el objeto Scanner para liberar los recursos
        sc.close();
    }

    /*
    4. for-each :
    Frecuencia de palabras Dado un arreglo de String, muestra cuántas veces aparece cada palabra.
    Ejemplo: ["hola", "mundo", "hola"] → hola=2, mundo=1. Reto extra: ignora mayúsculas/minúsculas.
     */
    public static void FrecuenciaDePalabras() {
        String[] palabras = {"Hola", "mundo", "hola", "MUNDO", "Java", "java", "phyton"};

        //Mapa para contar las frecuencias
        Map<String, Integer> frecuencia = new HashMap<>();

        //Recorremos el arreglo con for-each
        for (String palabra : palabras) {
            //AL recorrer el arreglo convertimos a las palabras a minusculas para ignorar mayusculas/minusculas
            String clave = palabra.toLowerCase();

            //Actualizar el conteo en el mapa
            frecuencia.put(clave, frecuencia.getOrDefault(clave, 0) + 1);
        }

        //Mostrar los resultados (Tambien con for-each)
        for (Map.Entry<String, Integer> entry : frecuencia.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


    public static void main(String[] args) {
        //Piramide();
        //NumeroInverso();
        //AdivinaNumero();
        FrecuenciaDePalabras();
    }
}
