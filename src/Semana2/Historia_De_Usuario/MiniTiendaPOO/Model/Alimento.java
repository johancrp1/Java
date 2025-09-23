package Semana2.Historia_De_Usuario.MiniTiendaPOO.Model;

public class Alimento extends Producto {
    private String fechaVencimiento;

    public Alimento(String nombre, double precio, String fechaVencimiento) {
        super(nombre, precio);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    // Sobrescritura de metodo abstracto
    @Override
    public String getDescripcion() {
        return "Alimento: " + getNombre() + " | Precio: $" + getPrecio() +
                " | Vence: " + fechaVencimiento;
    }
}
