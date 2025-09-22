package Semana2.Historia_De_Usuario.MiniTiendaPOO.Model;

public class Electrodomestico extends Producto {
    private int garantiaMeses;

    public Electrodomestico(String nombre, double precio, int garantiaMeses) {
        super(nombre, precio);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    // Sobrescritura de metodo abstracto
    @Override
    public String getDescripcion() {
        return " Electrodoméstico: " + getNombre() + " | Precio: $" + getPrecio() +
                " | Garantía: " + garantiaMeses + " meses";
    }
}