package Controller;

import Entity.Producto;
import Model.ProductoModel;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

public class ProductoController {

    public static void create(){
        // Usamos el modelo
        ProductoModel objProductoModel = new ProductoModel();

        // Pedir los datos al usuario
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre");
        BigDecimal precio = new BigDecimal(JOptionPane.showInputDialog("Ingresa el precio"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el stock"));

        // Creamos el Producto para asignarle los datos y luego pasarlo a la funcion
        Producto objProducto = new Producto();

        //Vamos llenando con los datos que tenemos (recordemos que el id se lo pone la bd en la logica del model)
        objProducto.setNombre(nombre);
        objProducto.setPrecio(precio);
        objProducto.setStock(stock);

        // el insert devuelve un objeto generico y por eso lo casteamos para que sea tipo producto y objProducto quede con un Producto y no con un objeto generico
        objProducto = (Producto) objProductoModel.insert(objProducto);

        //Mostramos el producto creado
        JOptionPane.showMessageDialog(null, objProducto.toString());

    }
    public static void getAll(){
        // Llamamos al modelo para acceder a los metodos
        ProductoModel productoModel = new ProductoModel();

        // Creamos como un titulo para mostrar todos los Productos
        String listProductos = "Lista de productos \n";

        // Recorremos todos los Productos
        for (Object i : productoModel.findAll()){
            // Convertimos cada objeto a producto(recordemos que el findAll me devulve una lista generica y por eso la tengoo que castear a producto)
            Producto objProducto = (Producto) i;
            // Concatenamos el titulo con los toString de los productos que nos permite ver la info
            listProductos += objProducto.toString() + "\n";
        }
        // ya luego del for la lista debe de tener todos los productos y la mostramos
        JOptionPane.showMessageDialog(null, listProductos);
    }

    public static void delete(){
        // Llamamos al modelo para acceder a los metodos
        ProductoModel productoModel = new ProductoModel();

        // Llamamos la funcion getall para traer todos los productos antes de pedir el id
        getAll();

        //Pedimos el id del producto que queremos eliminar
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto"));

        // Le pasamos el id a la funcion findById para encontrar el producto
        Producto objProducto = ProductoModel.findById(idDelete);

        // Verificamos si el producto existe
        if (objProducto == null){
            JOptionPane.showMessageDialog(null, "Producto no encontrado");
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Estas seguro?");
            if (confirm == 0) productoModel.delete(objProducto);
        }

    }
    public static void update(){
        // Llamamos al modelo para acceder a los metodos
        ProductoModel productoModel = new ProductoModel();

        // Llamamos la funcion getall para traer todos los productos antes de pedir el id
        getAll();

        //Pedimos el id del producto al usuario
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Dame el id del producto que deseas eliminar"));

        // Con el id recibido buscamos el producto
        Producto objProducto = productoModel.findById(idUpdate);
        // condicional para verificar si existe
        if (objProducto == null){
            JOptionPane.showMessageDialog(null, "¡Producto no encontrado!");
        }else{
            // Pedir los nuevos datos al usuario para la modificacion
            objProducto.setNombre(JOptionPane.showInputDialog("Dame el nuevo nombre", objProducto.getNombre()));
            objProducto.setPrecio(new BigDecimal(JOptionPane.showInputDialog("Dame el nuevo precio", objProducto.getPrecio())));
            objProducto.setStock(Integer.parseInt(JOptionPane.showInputDialog("Dame el nuevo stock", objProducto.getStock())));

            // Pasamos el producto con la nueva informacion al metodo update
            productoModel.update(objProducto);

        }
    }

    // Metodo estático que permite buscar productos por nombre e imprimirlos en un cuadro de diálogo
    public static void findByName() {
        // Creamos una instancia del modelo que maneja los productos
        ProductoModel productoModel = new ProductoModel();

        // Solicitamos al usuario el nombre del producto a buscar
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto a buscar:");

        // Llamamos al metodo findByName del modelo para obtener la lista de productos
        List<Producto> productos = productoModel.findByName(nombre);

        // Verificamos si la lista está vacía (no se encontraron coincidencias)
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron productos con ese nombre.");
        } else {
            // Si hay productos, construimos un String con la información de cada uno
            StringBuilder lista = new StringBuilder("Productos encontrados:\n");

            // Recorremos la lista de productos encontrados
            for (Producto p : productos) {
                lista.append("ID: ").append(p.getId())              // Mostramos el ID
                        .append(" | Nombre: ").append(p.getNombre())   // Mostramos el nombre
                        .append(" | Precio: ").append(p.getPrecio())   // Mostramos el precio
                        .append(" | Stock: ").append(p.getStock())     // Mostramos el stock
                        .append("\n");                                 // Salto de línea
            }

            // Mostramos la lista construida en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }
}
