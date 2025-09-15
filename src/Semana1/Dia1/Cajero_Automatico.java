package Dia1;

import java.util.Scanner;

public class Cajero_Automatico {

    public static void main(String[] args) {
        //Creamos el objeto Scanner Para leer entradas desde el teclado
        Scanner scanner = new Scanner(System.in);

        //Definir el saldo inicial
        double saldo = 1000000;

        //Variable para almacenar la opcion del menu
        int opcion;

        //Ciclo que ejecuta el menu hasta que el usuario elija salir
        do {
            //Mostrar el menu
            System.out.println("\n*--- Menu Cajero Automatico ---*");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            //Leer la opcion seleccionada por el usuario
            opcion = scanner.nextInt();

            //Ejecutar la accion dependiendo de la opcion seleccionada
            switch (opcion) {
                case 1:
                    //Consultar el saldo
                    System.out.println("Tu Saldo actual es: $" + saldo);
                    break;

                case 2:
                    //Depositar dinero
                    System.out.print("Introduce el monto a depositar: $");
                    double deposito = scanner.nextDouble();
                    saldo += deposito; //Sumar al saldo
                    System.out.println("Has depositado $" + deposito +". Tu nuevo saldo es: $" + saldo);
                    break;
                case 3:
                    //Retirar dinero
                    System.out.print("Introduce el monto a retirar: $");
                    double retiro = scanner.nextDouble();

                    //Verificar si hay suficiente saldo
                    if (retiro <= saldo) {
                        saldo -= retiro; // Restar del saldo
                        System.out.println("Has retirado $" + retiro + ". Tu nuevo saldo es: $" + saldo);
                    } else {
                        System.out.println("No tienes suficiente saldo para realizar el retiro.");
                    }
                    break;

                case 4:
                    // Salir
                    System.out.println("¡Gracias por usar el cajero automático! ¡Hasta luego!");
                    break;

                default:
                    // Opción no válida
                    System.out.println("Opción inválida. Por favor, selecciona una opción del 1 al 4.");
            }
        } while(opcion != 4); // El ciclo se repite hasta que el usuario elija salir
    }
}
