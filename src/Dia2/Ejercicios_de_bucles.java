import java.util.Random;
import java.util.Scanner;

public class Ejercicios_de_bucles {

    /*
    1. Crea una aplicación que pida un número y calcule su factorial (El factorial de un número es el producto de todos los
    enteros entre 1 y el propio número y se representa por el número seguido de un signo de exclamación.
    Por ejemplo 5! = 1x2x3x4x5=120),
    */

    public static void Factorial(){
        Scanner scanner = new Scanner(System.in);

        //Pedimos al usuario un numero
        System.out.print("Ingresa un numero entero positivo: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("El factorial no esta definido para numero negativos.");
        } else {
            long factorial = 1;

            // Calcular el factorial con un bucle for
            for (int i = 1; i <= numero; i++) {
                factorial *= i;
            }

            //Mostramos el resultado
            System.out.println("El factorial de " + numero + " es: " + factorial );
        }
        scanner.close();
    }

    /*
    2. Crea una aplicación que permita adivinar un número. La aplicación genera un número aleatorio del 1 al 100.
    A continuación va pidiendo números y va respondiendo si el número a adivinar es mayor o menor que el introducido,
    a demás de los intentos que te quedan (tienes 10 intentos para acertarlo). El programa termina cuando se acierta
    el número (además te dice en cuantos intentos lo has acertado), si se llega al limite de intentos te muestra el número
    que había generado.
     */

    public static void AdivinarNumero() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Generamos un numero aleatorio entre 1 y 100
        int numeroSecreto = random.nextInt(100) + 1;
        int intentosMaximos = 10;
        int intentos = 0;
        boolean acertado = false;

        System.out.println("¡Bienvenido al juego de adivinar el numero!");
        System.out.println("Tienes 10 intentos para adivinar un numero entre 1 y 100.");

        // Bucle de intentos
        while (intentos < intentosMaximos && !acertado) {
            System.out.print("\nIntento " + (intentos + 1) + ": Ingresa tu numero: ");
            int numeroUsuario = scanner.nextInt();
            intentos++;

            if (numeroUsuario == numeroSecreto) {
                acertado = true;
                System.out.println("¡Correcto! Has adivinado el numero en " + intentos + " intento(s).");
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El numero secreto es **Mayor**.");
            } else {
                System.out.println("El numero secreto es **Menor**.");
            }

            //Mostramos intentos restantes si aun no ah acertado
            if (!acertado && intentos < intentosMaximos) {
                System.out.println("Te Quedan " + (intentosMaximos - intentos) + " intento(s).");
            }
        }

        // Si no lo acerto en los 10 intentos
        if (!acertado) {
            System.out.println("\n Has agotado todos los intentos.");
            System.out.println("El numero secreto era: " + numeroSecreto);
        }
        scanner.close();
    }
    public static void main(String[] args) {
        AdivinarNumero();
        //Factorial();
    }
}


