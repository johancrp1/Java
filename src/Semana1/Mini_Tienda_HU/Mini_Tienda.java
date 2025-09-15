package Mini_Tienda_HU;

//Aca importamos las clases nesesarias para usar interfaces graficas y estructuras de datos
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


//Creamos una clase principal para organizar el programa
public class Mini_Tienda {

    //Creamos un ArrayList para guardar los nombres de los productos
    private ArrayList<String> productos = new ArrayList<>();

    //Creamos un Array para precios, sincronizado con nombres.
    private double[] precios = new double[0];

    // Creamos un HashMap para el stock.
    private HashMap<String, Integer> stock = new HashMap<>();

    //Creamos una lista para guardar los productos comprados y mostrar el ticket final
    private ArrayList<String> ticketFinal = new ArrayList<>();

    public static void main(String[] args) {
        Mini_Tienda app = new Mini_Tienda();
        app.menuPrincipal();
    }

    //Aca Creamos el menu principal
    private void menuPrincipal() {
        String opcion;

        do {
            //Mostramos el menu con las opciones
            opcion = JOptionPane.showInputDialog(null,
                    """
                            MENU PRINCIPAL:
                            1. Agregar producto.
                            2. Listar inventario.
                            3. Comprar producto.
                            4. Mostrar estadisticas (Más barato y más caro)
                            5. Buscar producto por nombre.
                            6. Salir con ticket final.
                            """,
                            "Inventario", JOptionPane.QUESTION_MESSAGE);
            //Si El usuario cancela, se sale del menu
            if (opcion == null) break;

            //Aca ejecutamos la apcion que el usuario eligio en el menu principal
            switch (opcion) {
                case "1" -> agregarProducto();
                case "2" -> listarInventario();
                case "3" -> comprarProducto();
                case "4" -> mostrarEstadisticas();
                case "5" -> buscarProducto();
                case "6" -> mostrarTicketFinal();
                default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (!"6".equals(opcion));
    }

    //Creamos La Funcionalidad que permite al usuario agregar un nuevo producto al inventario
    private void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        if (nombre == null || nombre.isBlank()) return;

        //Aca verificamos si el producto ya existe
        if (productos.contains(nombre)) {
            JOptionPane.showMessageDialog(null, "El producto ya existe.");
            return;
        }

        try {
            //Aca pedimos el precio y la cantidad al usuario
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));

            //Aca agregamos esos datos que le pedimos al usuario a las estructuras correspondientes
            productos.add(nombre);
            precios = expandPrecios(precios, precio);
            stock.put(nombre, cantidad);

            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada invalida.");
        }
    }

    // Creamos un Metodo auxiliar para agregar un nuevo precio al arreglo de precios (Ya que los arrays son de tamaño fijo).
    private double[] expandPrecios(double[] original, double nuevoPrecio) {
        double[] nuevo = new double[original.length + 1];
        for (int i = 0; i < original.length; i++) {
            nuevo[i] = original[i];
        }
        nuevo[original.length] = nuevoPrecio;
        return nuevo;
    }

    //Aca Creamos la funcion de mostrar todos los productos en el inventario
    private void listarInventario() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inventario vacio.");
            return;
        }

        //Creamos el mensaje con todos los productos
        StringBuilder sb = new StringBuilder("INVENTARIO:\n");
        for (int i = 0; i < productos.size(); i++) {
            sb.append(String.format("%d. %s | $%.2f | Stock: %d\n",
                    i + 1, productos.get(i), precios[i], stock.get(productos.get(i))));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    //Aca permitimos al usuario comprar un producto del inventario
    private void comprarProducto() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para comprar.");
            return;
        }

        String producto = JOptionPane.showInputDialog("¿Que producto desea comprar?:");
        if (producto == null || producto.isBlank()) return;

        int index = indexOfNombre(producto);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        int stockDisponible = stock.get(producto);
        if (stockDisponible == 0) {
            JOptionPane.showMessageDialog(null, "No hay stock disponible.");
            return;
        }

        try {
            // Pedimos cantidad a comprar
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos deseas comprar?"));
            if (cantidad <= 0 || cantidad > stockDisponible) {
                JOptionPane.showMessageDialog(null, "Cantidad no válida.");
                return;
            }

            // Actualizamos el stock y agrega la compra al ticket
            stock.put(producto, stockDisponible - cantidad);
            double total = precios[index] * cantidad;
            ticketFinal.add(String.format(Locale.US, "%s x%d = $%.2f", producto, cantidad, total));
            JOptionPane.showMessageDialog(null, "Compra realizada. Total: $" + total);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }

    }

    //Aca creamos el Metodo auxiliar para obtener el índice de un producto por su nombre
    private int indexOfNombre(String nombre) {
        return productos.indexOf(nombre);
    }

    //Aca vamos a mostrar el producto mas caro y el mas barato
    private void mostrarEstadisticas() {
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos.");
            return;
        }

        int minIndex = 0;
        int maxIndex = 0;

        // Busca índices de precios mínimo y máximo
        for (int i = 1; i < precios.length; i++) {
            if (precios[i] < precios[minIndex]) minIndex = i;
            if (precios[i] > precios[maxIndex]) maxIndex = i;
        }

        // Muestra los productos con precio más bajo y más alto
        String mensaje = String.format("""
                Estadísticas:
                Producto más barato: %s ($%.2f)
                Producto más caro: %s ($%.2f)
                """,
                productos.get(minIndex), precios[minIndex],
                productos.get(maxIndex), precios[maxIndex]);

        JOptionPane.showMessageDialog(null, mensaje);
    }

    //Aca Permitimos buscar un producto por su nombre
    private void buscarProducto() {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del producto a buscar:");
        if (nombre == null || nombre.isBlank()) return;

        int index = indexOfNombre(nombre);
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        double precio = precios[index];
        int cantidad = stock.get(nombre);

        // Muestramos la  información del producto encontrado
        JOptionPane.showMessageDialog(null,
                String.format("🔍 %s:\nPrecio: $%.2f\nStock: %d", nombre, precio, cantidad));
    }

    // Muestramos el ticket final con todas las compras realizadas
    private void mostrarTicketFinal() {
        if (ticketFinal.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se realizaron compras.");
        } else {
            StringBuilder sb = new StringBuilder("TICKET FINAL:\n");
            double total = 0;

            // Recorre cada línea del ticket y suma el total
            for (String linea : ticketFinal) {
                sb.append(linea).append("\n");
                total += Double.parseDouble(linea.substring(linea.lastIndexOf("$") + 1));
            }
            sb.append(String.format("\nTotal pagado: $%.2f", total));
            JOptionPane.showMessageDialog(null, sb.toString());
        }

        // Despedida y cierre del programa
        JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema!");
        System.exit(0);
    }

}
