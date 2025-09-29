package Semana3.Dia1.Sistema_De_Usuarios_POO.app;

import Semana3.Dia1.Sistema_De_Usuarios_POO.interfaces.UsuarioInterface;
import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Administrador;
import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Cliente;
import Semana3.Dia1.Sistema_De_Usuarios_POO.model.Usuario;
import Semana3.Dia1.Sistema_De_Usuarios_POO.service.UsuarioService;

import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    private static final UsuarioInterface servicio = new UsuarioService();

    public static void main(String[] args) {
        try {
            servicio.registrarAdministrador("Admin Principal", "admin@plataforma.com", "admin123");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creando admeessaain por defecto: " + e.getMessage());
        }

        boolean salir = false;
        while (!salir) {
            String opt = JOptionPane.showInputDialog(null,
                    "=== Mini Sistema de Usuarios ===\n" +
                            "1. Registrar usuario\n" +
                            "2. Iniciar sesión\n" +
                            "3. Ver listado de usuarios (rol & estado)\n" +
                            "0. Salir\n" +
                            "Elige una opción:");
            if (opt == null) break;
            switch (opt) {
                case "1" -> registrarUsuarioMenu();
                case "2" -> loginMenu();
                case "3" -> listarUsuarios();
                case "0" -> salir = true;
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    private static void registrarUsuarioMenu() {
        // Definimos las opciones como botones
        String[] opciones = {"Administrador", "Cliente"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona el tipo de usuario:",
                "Registro de Usuario",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0] // opción por defecto
        );

        // Si el usuario cierra la ventana o cancela
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro cancelado.");
            return;
        }

        boolean registrado = false;

        while (!registrado) {
            try {
                if (seleccion == 0) { // Administrador
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String pass = JOptionPane.showInputDialog("Password:");

                    servicio.registrarAdministrador(nombre, email, pass);
                    JOptionPane.showMessageDialog(null, "Administrador registrado correctamente.");
                    registrado = true;

                } else if (seleccion == 1) { // Cliente
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String pass = JOptionPane.showInputDialog("Password:");
                    String tel = JOptionPane.showInputDialog("Teléfono:");
                    String dir = JOptionPane.showInputDialog("Dirección:");

                    servicio.registrarCliente(nombre, email, pass, tel, dir);
                    JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
                    registrado = true;
                }

            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null,
                        "Error al registrar: " + e.getMessage() + "\nInténtalo de nuevo.");
            }
        }
    }

    private static void loginMenu() {
        String email = JOptionPane.showInputDialog("Email:");
        String pass = JOptionPane.showInputDialog("Password:");
        Usuario u = servicio.login(email, pass);
        if (u == null) {
            JOptionPane.showMessageDialog(null, "Credenciales inválidas o usuario bloqueado.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Bienvenido, " + u.getNombre() + " (" + u.getRol() + ")");
        u.mostrarPerfil();

        if (u instanceof Administrador) {
            adminMenu((Administrador) u);
        } else if (u instanceof Cliente) {
            clienteMenu((Cliente) u);
        }
    }

    private static void adminMenu(Administrador admin) {
        boolean volver = false;
        while (!volver) {
            String opt = JOptionPane.showInputDialog(null,
                    "--- Menú Administrador ---\n" +
                            "1. Ver listado de todos los usuarios\n" +
                            "2. Bloquear usuario por email\n" +
                            "3. Desbloquear usuario por email\n" +
                            "0. Cerrar sesión\n" +
                            "Elige:");
            if (opt == null) break;
            switch (opt) {
                case "1" -> listarUsuarios();
                case "2" -> {
                    String email = JOptionPane.showInputDialog("Email a bloquear:");
                    servicio.bloquearUsuario(email, admin);
                }
                case "3" -> {
                    String email = JOptionPane.showInputDialog("Email a desbloquear:");
                    servicio.desbloquearUsuario(email, admin);
                }
                case "0" -> volver = true;
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    private static void clienteMenu(Cliente cliente) {
        boolean volver = false;
        while (!volver) {
            String opt = JOptionPane.showInputDialog(null,
                    "--- Menú Cliente ---\n" +
                            "1. Ver perfil\n" +
                            "2. Actualizar contacto (tel y dirección)\n" +
                            "3. Ver listado de clientes\n" +
                            "0. Cerrar sesión\n" +
                            "Elige:");
            if (opt == null) break;
            switch (opt) {
                case "1" -> cliente.mostrarPerfil();
                case "2" -> {
                    String tel = JOptionPane.showInputDialog("Nuevo teléfono:");
                    String dir = JOptionPane.showInputDialog("Nueva dirección:");
                    boolean ok = servicio.actualizarContactoCliente(cliente.getEmail(), tel, dir);
                    if (ok) JOptionPane.showMessageDialog(null, "Contacto actualizado.");
                    else JOptionPane.showMessageDialog(null, "No se pudo actualizar el contacto.");
                }
                case "3" -> listarClientes();
                case "0" -> volver = true;
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    private static void listarUsuarios() {
        List<Usuario> todos = servicio.listarTodos();
        StringBuilder sb = new StringBuilder("--- Lista de usuarios ---\n");
        for (Usuario u : todos) {
            sb.append("ID:").append(u.getId())
                    .append(" | Nombre:").append(u.getNombre())
                    .append(" | Rol:").append(u.getRol())
                    .append(" | Estado:").append(u.isActivo() ? "ACTIVO" : "BLOQUEADO")
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void listarClientes() {
        List<Usuario> clientes = servicio.listarClientes();
        StringBuilder sb = new StringBuilder("--- Lista de clientes ---");
        for (Usuario u : clientes) {
            sb.append("ID:").append(u.getId())
                    .append(" | Nombre:").append(u.getNombre())
                    .append(" | Email:").append(u.getEmail())
                    .append(" | Estado:").append(u.isActivo() ? "ACTIVO" : "BLOQUEADO")
                    .append(" ");
        }
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        } else {
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}