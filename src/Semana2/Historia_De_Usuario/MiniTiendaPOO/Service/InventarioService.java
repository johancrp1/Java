package Semana2.Historia_De_Usuario.MiniTiendaPOO.Service;

import Semana2.Historia_De_Usuario.MiniTiendaPOO.Interfaces.InterfaceInventario;
import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Inventario;
import Semana2.Historia_De_Usuario.MiniTiendaPOO.Model.Producto;

public class InventarioService implements InterfaceInventario {
    private Inventario inventario;

    public InventarioService() {
        this.inventario = new Inventario();
    }

    @Override
    public boolean agregarProducto(Producto p, int cantidad) {
        return inventario.agregarProducto(p, cantidad);
    }

    @Override
    public String listarInventario() {
        return inventario.listarInventario();
    }

    @Override
    public String comprarProducto(String nombre, int cantidad) {
        return inventario.comprarProducto(nombre, cantidad);
    }

    @Override
    public String estadisticas() {
        return inventario.estadisticas();
    }

    @Override
    public String buscarProducto(String texto) {
        return inventario.buscarProducto(texto);
    }

    @Override
    public double getTotalCompras() {
        return inventario.getTotalCompras();
    }
}
