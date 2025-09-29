package Semana3.Dia1.Sistema_De_Usuarios_POO.interfaces;

import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Usuario;

import java.util.List;

public interface UsuarioInterface {
    Usuario registrarAdministrador(String nombre, String email, String password);
    Usuario registrarCliente(String nombre, String email, String password, String telefono, String direccion);
    Usuario login(String email, String password);
    List<Usuario> listarTodos();
    List<Usuario> listarClientes();
    Usuario buscarPorEmail(String email);
    boolean bloquearUsuario(String email, Usuario administrando);
    boolean desbloquearUsuario(String email, Usuario administrando);
    boolean actualizarContactoCliente(String emailCliente, String telefono, String direccion);
}
