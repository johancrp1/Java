/*
ACTIVIDAD 2:

Crea un programa que:

1.Declare dos números enteros (a y b).
2.Calcule y muestre:

-Suma
-Resta
-Multiplicación
-División
-Módulo
*/

import java.util.Scanner;

public class Operadores_en_Java {
    public static void main(String[] args) {

        //Declaracion de las variables 'a' y 'b' de tipo entero
        int a = 10; //Primer numero entero
        int b = 5; //Segundo numero entero

        //Suma
        int suma = a + b;
        System.out.println("Suma: " + suma);

        //Resta
        int resta = a - b;
        System.out.println("Resta: " + resta);

        //Multiplicacion
        int multiplicacion = a * b;
        System.out.println("Multiplicacion: " + multiplicacion);

        // División
        // Es importante asegurarse de que 'b' no sea cero, ya que la división por cero causa un error
        int division = a / b;
        System.out.println("Division:" + division);

        //Modulo (resto de la division)
        int modulo = a % b;
        System.out.println("Modulo: " + modulo);
    }
}

/*
ACTIVIDAD 3
Pide al usuario su edad e imprime:

true si es mayor o igual a 18.
false si es menor.


import java.util.Scanner;

public class Operadores_en_Java {
    public static void main(String[] args) {
        //Crear un objeto Scanner para leer la entrada del usuarios
        Scanner scanner = new Scanner(System.in);

        //Pedir al usuario que ingrese su edad
        System.out.println("Por favor, ingresa tu edad: ");
        int edad = scanner.nextInt(); // Leer la edad como un numero entero

        //Verificar si la edad es mayor o igual a 18
        if (edad >= 18) {
            System.out.println(true); //Si es mayor o igual a 18, imprime true
        } else {
            System.out.println(false); // Si es menor a 18, imprime false
        }

        //Cerrar el objeto Scanner
        scanner.close();
    }
}
*/

/*
ACTIVIDAD 4
Pide dos números enteros y verifica con operadores lógicos si:

- Ambos son positivos (&&).
- Al menos uno es mayor que 100 (||).
- El primero no es igual al segundo (!).


import java.util.Scanner;

public class Operadores_en_Java {
    public static void main(String[] args) {
        //Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Pedir al usuario que ingrese dos numeros enteros
        System.out.print("Ingresa el primer numero: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingresa el sugundo numero: ");
        int num2 = scanner.nextInt();

        //Verificar si ambos numeros son positivos (&&)

        if (num1 > 0 && num2 > 0) {
            System.out.println("Ambos numeros son positivos.");
        } else {
            System.out.println("Al menos uno de los numeros no es positivo. ");
        }

        //Verificar si al menos uno es mayor que 100 (||)
        if (num1 > 100 || num2 > 100) {
            System.out.println("Al menos uno de los numeros es mayor a 100".);
        } else {
            System.out.println("Ningun numero es mayor que 100.");
        }

        //Verificar si el primero no es igual al segundo (!)
        if (num1 != num2) {
            System.out.println("El primero numero no es igual al segundo.");
        } else {
            System.out.println("El primer numero es igual al segundo.");
        }

        //Cerrar el objeto Scanner
        scanner.close();

    }
}
 */