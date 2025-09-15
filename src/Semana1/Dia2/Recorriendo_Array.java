/*
Arrays:

Crea un array de 5 números enteros.
Recorre el array con un for y muestra cada número multiplicado por 2.
Luego crea un array sobre numeros con 6 posiciones de espacio y luego llenalo pidiendole al usuario por consola los numeros uno a uno
*/

/*
package Dia2;

public class Recorriendo_Array {
    public static void main(String[] args) {
        //Creamos un array con 5 numeros enteros
        int[] numeros = {12, 45, 23, 77, 14};

        //Recorremos el array y mostramos cada numero multiplicado x2
        System.out.println("Numeros multiplicados por 2: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i] + " x 2 = " + (numeros[i] * 2));
        }
    }
}
 */

/*

Parte 2:

Crea un array de 6 posiciones y pide al usuario que lo llene con números desde consola.
 */
import java.util.Scanner;

public class Recorriendo_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creamos el array de 6 posisiones
        int[] numeros = new int[6];

        System.out.println("Ingresa 6 numeros: ");

        //LLenamos el array con los numeros ingresados por el usuario
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        //Mostrar el array ingresado
        System.out.println("\nNumeros ingresados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posicion " + i + ": " + numeros[i]);
        }

        scanner.close();
    }
}