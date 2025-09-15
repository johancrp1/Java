package Taller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaRestaurante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú con clave (nombre del plato) y valor (precio) uso de LinkedHashMap para manejar un orden
        LinkedHashMap<String, Integer> menu = new LinkedHashMap<>();
        menu.put("Bandeja Paisa", 15000);
        menu.put("Sancocho de Gallina", 18000);
        menu.put("Lechona", 16000);

        // Registro de clientes
        String[] clientes = new String[100];
        int totalClientes = 0;

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Registrar nuevo cliente ---");

            System.out.print("Nombre del cliente: ");
            String nombre = scanner.nextLine();

            System.out.println("Menú del día:");
            int index = 1;
            String[] platos = new String[menu.size()]; // Para seleccionar por número
            for (Map.Entry<String, Integer> entrada : menu.entrySet()) {
                System.out.println(index + ". " + entrada.getKey() + " - " + entrada.getValue());
                platos[index - 1] = entrada.getKey();
                index++;
            }

            System.out.print("Opción elegida (1-" + menu.size() + "): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            String platoSeleccionado = platos[opcion - 1];
            int precio = menu.get(platoSeleccionado);
            System.out.println("Precio del almuerzo: " + precio);

            System.out.print("Monto pagado por el cliente: ");
            int pago = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            // Validación: si el monto pagado es menor que el precio del plato
            if (pago < precio) {
                System.out.println("Error: El monto pagado es menor que el precio del plato. Intente de nuevo.");
                continue; // Reinicia el bucle y pide los datos del cliente nuevamente
            } else {
                int cambio = pago - precio;
                System.out.println("Cambio que debe entregarse: " + cambio);
                System.out.println("El cliente " + nombre + " puede recibir su almuerzo.");
            }

            clientes[totalClientes] = nombre;
            totalClientes++;

            System.out.print("¿Registrar otro cliente? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }

        // Resumen al final del día
        System.out.println("\n--- Resumen del día ---");
        System.out.println("Total clientes atendidos: " + totalClientes);
        for (int i = 0; i < totalClientes; i++) {
            System.out.println("- " + clientes[i]);
        }

        System.out.println("Fin del registro.");
        scanner.close();
    }
}
