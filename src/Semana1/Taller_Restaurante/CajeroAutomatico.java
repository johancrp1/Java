package Taller;

import javax.swing.JOptionPane; // Importamos la clase JOptionPane para usar ventanas emergentes

public class CajeroAutomatico {
    public static void main(String[] args) {
        // Declaramos una variable para el saldo inicial de la cuenta
        double saldo = 1000.0;

        // Variable booleana que controlará cuándo salir del bucle
        boolean salir = false;

        // Mostramos un mensaje de bienvenida en una ventana emergente
        JOptionPane.showMessageDialog(null, "Bienvenido al Cajero Automático");

        // Usamos un bucle while para que el menú se repita hasta que el usuario decida salir
        while (!salir) {
            // Creamos un arreglo con las opciones que tendrá el menú
            String[] opciones = {"Consultar saldo", "Depositar", "Retirar", "Salir"};

            // Mostramos un cuadro de opciones (menú principal)
            // showOptionDialog devuelve un número entero (índice de la opción elegida)
            int opcion = JOptionPane.showOptionDialog(
                    null,                     // Componente padre (null = centrado en pantalla)
                    "Seleccione una opción:", // Mensaje en la ventana
                    "Menú Principal",         // Título de la ventana
                    JOptionPane.DEFAULT_OPTION, // Tipo de opción por defecto
                    JOptionPane.INFORMATION_MESSAGE, // Icono que se muestra
                    null,                     // Icono personalizado (null = ninguno)
                    opciones,                 // Arreglo con las opciones de botones
                    opciones[0]               // Opción seleccionada por defecto
            );

            // Evaluamos la opción seleccionada con un switch
            switch (opcion) {
                case 0: // Opción "Consultar saldo"
                    JOptionPane.showMessageDialog(null, "Tu saldo actual es: $" + saldo);
                    break;

                case 1: // Opción "Depositar"
                    // Pedimos al usuario que ingrese el monto a depositar
                    String depositoStr = JOptionPane.showInputDialog("Ingrese el monto a depositar:");

                    // Validamos que el usuario no haya cancelado (si cancela, devuelve null)
                    if (depositoStr != null) {
                        try {
                            // Convertimos el texto ingresado a número (double)
                            double deposito = Double.parseDouble(depositoStr);

                            // Validamos que sea un número positivo
                            if (deposito > 0) {
                                saldo += deposito; // Sumamos al saldo actual
                                JOptionPane.showMessageDialog(null,
                                        "Has depositado $" + deposito +
                                                "\nNuevo saldo: $" + saldo);
                            } else {
                                JOptionPane.showMessageDialog(null, "El monto debe ser positivo.");
                            }
                        } catch (NumberFormatException e) {
                            // Si el usuario escribe algo que no es un número, mostramos un error
                            JOptionPane.showMessageDialog(null, "Entrada inválida.");
                        }
                    }
                    break;

                case 2: // Opción "Retirar"
                    // Pedimos el monto a retirar
                    String retiroStr = JOptionPane.showInputDialog("Ingrese el monto a retirar:");

                    // Validamos que el usuario no haya cancelado
                    if (retiroStr != null) {
                        try {
                            // Convertimos a número
                            double retiro = Double.parseDouble(retiroStr);

                            // Verificamos que sea mayor a 0 y menor o igual al saldo disponible
                            if (retiro > 0 && retiro <= saldo) {
                                saldo -= retiro; // Restamos del saldo
                                JOptionPane.showMessageDialog(null,
                                        "Has retirado $" + retiro +
                                                "\nNuevo saldo: $" + saldo);
                            } else {
                                JOptionPane.showMessageDialog(null, "Monto inválido o saldo insuficiente.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida.");
                        }
                    }
                    break;

                case 3: // Opción "Salir"
                    // Mostramos un cuadro de confirmación para salir
                    int confirmar = JOptionPane.showConfirmDialog(
                            null,
                            "¿Seguro que deseas salir?",
                            "Confirmar salida",
                            JOptionPane.YES_NO_OPTION
                    );

                    // Si elige "Sí", terminamos el bucle
                    if (confirmar == JOptionPane.YES_OPTION) {
                        salir = true; // Cambiamos la bandera para salir del while
                        JOptionPane.showMessageDialog(null, "Gracias por usar el cajero automático.");
                    }
                    break;

                default:
                    // Si el usuario cierra la ventana del menú, salimos directamente
                    salir = true;
                    break;
            }
        }
    }
}