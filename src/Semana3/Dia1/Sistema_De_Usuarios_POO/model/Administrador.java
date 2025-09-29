package Semana3.Dia1.Sistema_De_Usuarios_POO.model;

import javax.swing.*;
import java.util.Objects;

public class Administrador extends Usuario {

    public Administrador(String nombre, String email, String password) {
        super(nombre, email, password, "ADMIN");
    }

    @Override
    public void mostrarPerfil() {
        JOptionPane.showMessageDialog(null,
                "--- Perfil: Administrador ---\n" +
                        "ID: " + getId() + "\n" +
                        "Nombre: " + getNombre() + "\n" +
                        "Email: " + getEmail() + "\n" +
                        "Rol: " + getRol() + "\n" +
                        "Estado: " + (isActivo() ? "ACTIVO" : "BLOQUEADO") + "\n" +
                        "Permisos: puede bloquear/desbloquear usuarios y ver listados.");
    }

    public void bloquearUsuario(Usuario u) {
        Objects.requireNonNull(u);
        if (!u.isActivo()) {
            JOptionPane.showMessageDialog(null, "El usuario ya está bloqueado.");
            return;
        }
        u.setActivo(false);
        JOptionPane.showMessageDialog(null, "Usuario " + u.getNombre() + " ha sido bloqueado.");
    }

    public void desbloquearUsuario(Usuario u) {
        Objects.requireNonNull(u);
        if (u.isActivo()) {
            JOptionPane.showMessageDialog(null, "El usuario ya está activo.");
            return;
        }
        u.setActivo(true);
        JOptionPane.showMessageDialog(null, "Usuario " + u.getNombre() + " ha sido desbloqueado.");
    }
}
