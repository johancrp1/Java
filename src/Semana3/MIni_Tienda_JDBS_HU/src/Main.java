//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Controller.ProductoController;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de gestión de productos");
        // aqui en el main solo llamamos al controller para pedir los datos
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    1. Crear producto
                    2. Mostrar todos los productos
                    3. Buscar producto por nombre
                    4. Actualizar producto
                    5. Eliminar producto
                    6. Salir
                    """);
            switch (option){
                case "1":
                    ProductoController.create();
                    break;
                case "2":
                    ProductoController.getAll();
                    break;
                case "3":
                    ProductoController.findByName();
                    break;
                case "4":
                    ProductoController.update();
                    break;
                case "5":
                    ProductoController.delete();
            }
        }while (!option.equals("6"));
        JOptionPane.showMessageDialog(null, "Hasta luego :D");
    }
}