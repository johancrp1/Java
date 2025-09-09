import java.util.Scanner;

public class Main {
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