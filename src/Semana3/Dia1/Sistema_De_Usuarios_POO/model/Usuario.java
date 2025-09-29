package Semana3.Dia1.Sistema_De_Usuarios_POO.model;

public abstract class Usuario {
    private static int contadorId = 1;

    private final int id;
    private String nombre;
    private String email;
    private String password;
    private boolean activo; // true = activo, false = bloqueado
    private String rol;

    public Usuario(String nombre, String email, String password, String rol) {
        this.id = contadorId++;
        setNombre(nombre);
        setEmail(email);
        setPassword(password);
        this.activo = true; // por defecto activo
        this.rol = rol;
    }

    // Encapsulamiento: getters/setters con validación
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
        }
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    private boolean validarEmail(String email) {
        if (email == null) return false;
        email = email.trim();
        int at = email.indexOf('@');
        if (at <= 0 || at == email.length() - 1) return false;
        int dot = email.indexOf('.', at);
        return dot > at + 1 && dot < email.length() - 1;
    }

    public boolean login(String email, String password) {
        if (!isActivo()) return false;
        return this.email.equalsIgnoreCase(email.trim()) && this.password.equals(password);
    }

    public abstract void mostrarPerfil();

    @Override
    public String toString() {
        return String.format("[%d] %s - %s - %s", id, nombre, email, (activo ? "ACTIVO" : "BLOQUEADO"));
    }
}