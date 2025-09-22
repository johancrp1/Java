package Semana2.Historia_De_Usuario.MiniTiendaPOO.Model;


import java.util.ArrayList;
import java.util.HashMap;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();
    private HashMap<String, Integer> stock = new HashMap<>();
    private ArrayList<Double> precios = new ArrayList<>();
    private double totalCompras = 0;

    // Agregar producto
    public boolean agregarProducto(Producto p, int cantidad) {
        for (Producto prod : productos) {
            if (prod.getNombre().equalsIgnoreCase(p.getNombre())) {
                return false; // duplicado
            }
        }
        productos.add(p);
        stock.put(p.getNombre(), cantidad);
        precios.add(p.getPrecio());
        return true;
    }

    // Listar inventario
    public String listarInventario() {
        if (productos.isEmpty()) return "No hay productos en el inventario.";
        StringBuilder sb = new StringBuilder(" INVENTARIO:\n");
        for (Producto p : productos) {
            sb.append(p.getDescripcion())
                    .append(" | Stock: ").append(stock.get(p.getNombre()))
                    .append("\n");
        }
        return sb.toString();
    }

    // Comprar producto
    public String comprarProducto(String nombre, int cantidad) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                int disponible = stock.get(p.getNombre());
                if (cantidad <= disponible) {
                    stock.put(p.getNombre(), disponible - cantidad);
                    double subtotal = p.getPrecio() * cantidad;
                    totalCompras += subtotal;
                    return "Compra realizada:\n" +
                            cantidad + " x " + p.getNombre() +
                            " = $" + subtotal;
                } else {
                    return "Stock insuficiente.";
                }
            }
        }
        return "Producto no encontrado.";
    }

    // Estadísticas: más caro y más barato
    public String estadisticas() {
        if (productos.isEmpty()) return "No hay productos.";
        Producto caro = productos.get(0);
        Producto barato = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() > caro.getPrecio()) caro = p;
            if (p.getPrecio() < barato.getPrecio()) barato = p;
        }
        return "Estadísticas:\n" +
                "Más caro: " + caro.getDescripcion() + "\n" +
                "Más barato: " + barato.getDescripcion();
    }

    // Buscar producto por coincidencia parcial
    public String buscarProducto(String texto) {
        StringBuilder sb = new StringBuilder("Resultados de búsqueda:\n");
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                sb.append(p.getDescripcion())
                        .append(" | Stock: ").append(stock.get(p.getNombre()))
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public double getTotalCompras() { return totalCompras; }
}
