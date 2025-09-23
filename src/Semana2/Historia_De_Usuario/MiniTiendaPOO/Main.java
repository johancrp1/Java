package Semana2.Historia_De_Usuario.MiniTiendaPOO;

import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Alimento;
import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Electrodomestico;
import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Inventario;
import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Producto;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "---- MENÚ PRINCIPAL ----\n" +
                            "1. Agregar producto\n" +
                            "2. Listar inventario\n" +
                            "3. Comprar producto\n" +
                            "4. Estadísticas\n" +
                            "5. Buscar producto\n" +
                            "6. Salir\n" +
                            "Elige una opción:"
            );

            if (opcion == null) break; // Cancelar cierra

            switch (opcion) {
                case "1": // Agregar
                    String[] tipos = {"Alimento", "Electrodoméstico"};
                    int seleccion = JOptionPane.showOptionDialog(
                            null,
                            "Selecciona el tipo de producto:",
                            "Agregar producto",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            tipos,
                            tipos[0]
                    );

                    if (seleccion == JOptionPane.CLOSED_OPTION) break; // Si cierra la ventana, salir del case

                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
                    int stock = Integer.parseInt(JOptionPane.showInputDialog("Stock inicial:"));

                    Producto nuevo = null;
                    if (seleccion == 0) { // Alimento
                        String fecha = JOptionPane.showInputDialog("Fecha de vencimiento:");
                        nuevo = new Alimento(nombre, precio, fecha);
                    } else if (seleccion == 1) { // Electrodoméstico
                        int garantia = Integer.parseInt(JOptionPane.showInputDialog("Garantía (meses):"));
                        nuevo = new Electrodomestico(nombre, precio, garantia);
                    }

                    if (nuevo != null) {
                        boolean agregado = inv.agregarProducto(nuevo, stock);
                        JOptionPane.showMessageDialog(null,
                                agregado ? " Producto agregado." : " Ya existe un producto con ese nombre.");
                    }
                    break;

                case "2": // Listar
                    JOptionPane.showMessageDialog(null, inv.listarInventario());
                    break;

                case "3": // Comprar
                    String compraNombre = JOptionPane.showInputDialog("Nombre del producto a comprar:");
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
                    JOptionPane.showMessageDialog(null, inv.comprarProducto(compraNombre, cantidad));
                    break;

                case "4": // Estadísticas
                    JOptionPane.showMessageDialog(null, inv.estadisticas());
                    break;

                case "5": // Buscar
                    String buscar = JOptionPane.showInputDialog("Texto a buscar:");
                    JOptionPane.showMessageDialog(null, inv.buscarProducto(buscar));
                    break;

                case "6": // Salir
                    JOptionPane.showMessageDialog(null, " Total de compras: $" + inv.getTotalCompras());
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, " Opción inválida.");
            }
        }
    }
}