package Semana2.Historia_De_Usuario.MiniTiendaPOO.Model;

import Semana2.Historia_De_Usuario.MiniTiendaPOO.Interfaces.InterfaceProducto;

public abstract class Producto implements InterfaceProducto {
    // Encapsulamiento: atributos privados
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Metodo abstracto (obligará a las subclases a implementarlo)
    public abstract String getDescripcion();
}
