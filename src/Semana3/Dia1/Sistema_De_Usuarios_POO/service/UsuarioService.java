package Semana3.Dia1.Sistema_De_Usuarios_POO.service;

import Semana3.Dia1.Sistema_De_Usuarios_POO.interfaces.UsuarioInterface;
import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Administrador;
import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Cliente;
import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Usuario;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService implements UsuarioInterface {
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario registrarAdministrador(String nombre, String email, String password) {
        Administrador a = new Administrador(nombre, email, password);
        usuarios.add(a);
        return a;
    }

    @Override
    public Usuario registrarCliente(String nombre, String email, String password, String telefono, String direccion) {
        Cliente c = new Cliente(nombre, email, password, telefono, direccion);
        usuarios.add(c);
        return c;
    }

    @Override
    public Usuario login(String email, String password) {
        Usuario u = buscarPorEmail(email);
        if (u == null) return null;
        if (!u.login(email, password)) return null;
        return u;
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public List<Usuario> listarClientes() {
        List<Usuario> res = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u instanceof Cliente) res.add(u);
        }
        return res;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        if (email == null) return null;
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email.trim())) return u;
        }
        return null;
    }

    @Override
    public boolean bloquearUsuario(String email, Usuario administrando) {
        if (!(administrando instanceof Administrador)) {
            JOptionPane.showMessageDialog(null, "Sólo administradores pueden bloquear usuarios.");
            return false;
        }
        Usuario target = buscarPorEmail(email);
        if (target == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado: " + email);
            return false;
        }
        ((Administrador) administrando).bloquearUsuario(target);
        return true;
    }

    @Override
    public boolean desbloquearUsuario(String email, Usuario administrando) {
        if (!(administrando instanceof Administrador)) {
            JOptionPane.showMessageDialog(null, "Sólo administradores pueden desbloquear usuarios.");
            return false;
        }
        Usuario target = buscarPorEmail(email);
        if (target == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado: " + email);
            return false;
        }
        ((Administrador) administrando).desbloquearUsuario(target);
        return true;
    }

    @Override
    public boolean actualizarContactoCliente(String emailCliente, String telefono, String direccion) {
        Usuario u = buscarPorEmail(emailCliente);
        if (u == null) return false;
        if (!(u instanceof Cliente)) return false;
        Cliente c = (Cliente) u;
        try {
            c.setTelefono(telefono);
            c.setDireccion(direccion);
            return true;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando: " + e.getMessage());
            return false;
        }
    }
}
