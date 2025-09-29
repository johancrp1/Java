package Semana3.Dia1.Sistema_De_Usuarios_POO.security;

public interface Autenticable {
    boolean login(String email, String password);
}