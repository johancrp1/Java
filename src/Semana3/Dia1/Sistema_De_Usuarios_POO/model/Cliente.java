package Semana3.Dia1.Sistema_De_Usuarios_POO.model;

import javax.swing.JOptionPane;

public class Cliente extends Usuario {
    private String telefono;
    private String direccion;

    public Cliente(String nombre, String email, String password, String telefono, String direccion) {
        super(nombre, email, password, "CLIENTE");
        setTelefono(telefono);
        setDireccion(direccion);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        this.telefono = telefono.trim();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = direccion.trim();
    }

    @Override
    public void mostrarPerfil() {
        JOptionPane.showMessageDialog(null,
                "--- Perfil: Cliente ---\n" +
                        "ID: " + getId() + "\n" +
                        "Nombre: " + getNombre() + "\n" +
                        "Email: " + getEmail() + "\n" +
                        "Rol: " + getRol() + "\n" +
                        "Estado: " + (isActivo() ? "ACTIVO" : "BLOQUEADO") + "\n" +
                        "Teléfono: " + telefono + "\n" +
                        "Dirección: " + direccion);
    }
}
