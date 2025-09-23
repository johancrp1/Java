package Semana2.Historia_De_Usuario.MiniTiendaPOO.Interfaces;

import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Producto;

public interface InterfaceInventario {
    boolean agregarProducto(Producto p, int cantidad);
    String listarInventario();
    String comprarProducto(String nombre, int cantidad);
    String estadisticas();
    String buscarProducto(String texto);
    double getTotalCompras();
}
