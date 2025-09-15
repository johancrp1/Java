/*
ACTIVIDAD 5 – If - Else
Haz un programa que reciba un número entero e imprima:

"Es positivo" si el número es mayor que 0.
"Es negativo" si es menor que 0.
"Es cero" si es exactamente 0.

import java.util.Scanner;

public class Condicionales_en_Java {
    public static void main(String[] args) {
        //Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //SOlicitar al usuario que ingrese un numero entero
        System.out.print("Ingresa un numero entero: ");
        int numero = scanner.nextInt();

        //EStructura de control if-else para determinar si el numero es positivo, negativo o cero

        if (numero > 0) {
            System.out.println("Es positivo");
        } else if (numero < 0) {
            System.out.println("Es negativo");
        } else {
            System.out.println("Es cero");
        }

        scanner.close();
    }
}
 */

/*
ACTIVIDAD 6 – If - Else If
Pide al usuario su edad y muestra:

"Niño" si tiene menos de 12.
"Adolescente" si tiene entre 12 y 17.
"Adulto" si tiene 18 o más.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese su edad
        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        // Estructura de control if-else if-else para determinar la categoría de edad
        if (edad < 12) {
            System.out.println("Niño");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Adolescente");
        } else {
            System.out.println("Adulto");
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}

 */

/*
ACTIVIDAD 7 – Switch
Crea un programa que pida un número del 1 al 7 y muestre el día de la semana:

- 1 → Lunes
- 2 → Martes
- 3 → Miércoles
  …
- 7 → Domingo

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número entre 1 y 7
        System.out.print("Ingresa un número del 1 al 7: ");
        int dia = scanner.nextInt();

        // Usar la estructura switch para determinar el día de la semana
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:DEFAULT_OPTION
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Número inválido. Por favor, ingresa un número entre 1 y 7.");
                break;
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}


 */
