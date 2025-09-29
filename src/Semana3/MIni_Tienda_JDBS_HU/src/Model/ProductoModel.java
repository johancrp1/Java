package Model;

import Database.CRUD;
import Database.ConfigDB;
import Entity.Producto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        // Abrir conexion
        Connection objConnection = ConfigDB.openConnection();

        // convertir objeto abstracto en producto
        Producto objProducto = (Producto) obj;

        try {
            String sql = "INSERT INTO producto (nombre, precio , stock) VALUES (?,?,?)";

            // Preparar el statement para ingresar los datos, ademas agregar el return generated keys para que devuelva el id generado por la bd
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Asignar el valor a los ? ? ?
            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setBigDecimal(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getStock());

            // Ejecutar la query
            objPrepare.execute();
            // obtener resultado con los id generados
            ResultSet objRest = objPrepare.getGeneratedKeys();

            while (objRest.next()) {
                objProducto.setId(objRest.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "El producto fue agregado exitosamente");


        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }


        ConfigDB.closeConnection();
        // retornamos el producto creado (mira que la funcion tiene que retornar un producto por eso hay que hacer el return)
        return objProducto;
    }

    @Override
    public List<Object> findAll() {
        // para guardar los productos de la bd
        List<Object> listProductos = new ArrayList<>();
        // generadando la conexion a la bd
        Connection objConnection = ConfigDB.openConnection();
        try {
            // hacemos la sentencia sql
            String sql = "SELECT * FROM producto";
            // Usamos el preparedStatemend que me permite hacer la consulta
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // Ejecutamos el query y lo guardamos en una variable
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                // crear producto para poder agregarlo a lista
                Producto objProducto = new Producto();
                objProducto.setId(objResult.getInt("id"));
                objProducto.setNombre(objResult.getString("nombre"));
                objProducto.setPrecio(objResult.getBigDecimal("precio"));
                objProducto.setStock(objResult.getInt("stock"));
                // Lo agregamos cada producto a la lista de productos
                listProductos.add(objProducto);
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        ConfigDB.closeConnection();


        return listProductos;
    }

    @Override
    public boolean update(Object obj) {
        // Hacer la conexion con la bd
        Connection objConnection = ConfigDB.openConnection();
        // Convertir el objeto generico en un producto
        Producto objProducto = (Producto) obj;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE producto SET nombre = ?, precio = ?, stock = ? where id = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //Asignar el valor a los parametros de la query
            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setBigDecimal(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getStock());
            objPrepare.setInt(4, objProducto.getId());

            // Guardamos el resultado de la bd para verificar si si hubo modificaciones en las columnas
            int result = objPrepare.executeUpdate();

            //Si hubo mas de una columna modificada significa que fue exitoso
            if (result > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "El producto fue actualizado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        ConfigDB.closeConnection();
        // retornamos la varibale previamente definida para saber si fue true o false la actualizacion del producto
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        // Convertir el objeto en un producto
        Producto objProducto = (Producto) obj;

        Connection objConnection = ConfigDB.openConnection();
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM producto WHERE id = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            // Paso el id del producto que nos pasaroon por parametros para eliminarlo
            objPrepare.setInt(1, objProducto.getId());

            // Obtengo cuantas columunas fueron afectadas
            int result = objPrepare.executeUpdate();

            // si mas de una columna fue modificada (eliminada) eso significa que fue eliminado
            if (result > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        //Cerrar la conexion
        ConfigDB.closeConnection();

        return isDeleted;
    }

    public static Producto findById(int id) {
        // Iniciamos la conexion
        Connection objConnection = ConfigDB.openConnection();
        // Empezamos con el Producto null
        Producto objProducto = null;

        try {
            // Hacemos la sentencia que necesitamos
            String sql = "SELECT * FROM producto where id = ?;";
            // preparemos el statement y le pasamos la consulta
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            // ejecutamos la query y guardamos el resultado
            ResultSet objResult = objPrepare.executeQuery();

            // verificamos si hay resultados y empezamos a llenar nuestro producto para retornarlo
            if (objResult.next()) {
                objProducto = new Producto();
                objProducto.setId(objResult.getInt("id"));
                objProducto.setNombre(objResult.getString("nombre"));
                objProducto.setPrecio(objResult.getBigDecimal("precio"));
                objProducto.setStock(objResult.getInt("stock"));
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        ConfigDB.closeConnection();
        return objProducto;
    }

    // Metodo que busca productos en la base de datos por nombre (coincidencia parcial)
    public List<Producto> findByName(String nombre) {
        // Abrimos la conexión a la base de datos
        Connection objConnection = ConfigDB.openConnection();
        // Lista donde se almacenarán los productos encontrados
        List<Producto> listProductos = new ArrayList<>();

        try {
            // Consulta SQL con comodín para buscar coincidencias en el campo "nombre"
            String sql = "SELECT * FROM producto WHERE nombre LIKE ?";

            // Preparamos la consulta para evitar inyección SQL
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            // Insertamos el parámetro con el valor del nombre (se usan % para búsqueda parcial)
            objPrepare.setString(1, "%" + nombre + "%");

            // Ejecutamos la consulta y obtenemos los resultados
            ResultSet objResult = objPrepare.executeQuery();

            // Recorremos los resultados fila por fila
            while (objResult.next()) {
                // Creamos un nuevo objeto Producto y lo llenamos con los datos de la fila actual
                Producto objProducto = new Producto();
                objProducto.setId(objResult.getInt("id"));                  // ID del producto
                objProducto.setNombre(objResult.getString("nombre"));       // Nombre del producto
                objProducto.setPrecio(objResult.getBigDecimal("precio"));   // Precio del producto
                objProducto.setStock(objResult.getInt("stock"));            // Stock disponible

                // Agregamos el producto a la lista
                listProductos.add(objProducto);
            }

        } catch (SQLException error) {
            // Si ocurre un error en la consulta, se muestra un mensaje
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        // Cerramos la conexión a la base de datos
        ConfigDB.closeConnection();

        // Retornamos la lista de productos encontrados
        return listProductos;
    }

}
