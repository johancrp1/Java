package Semana2.Dia2.Institucion_Educativa.Model;

public class Asignatura {
    private String nombre;
    private double nota;

    public Asignatura(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if (nota >= 0.0 && nota <= 5.0) {
            this.nota = nota;
        } else {
            System.out.println("La nota debe estar entre 0.0 y 5.0");
        }
    }

    // Metodo que devuelve si aprobó o reprobó
    public String getEstado() {
        return (nota >= 3.5) ? "Aprobada" : "Reprobada";
    }

    @Override
    public String toString() {
        return "Asignatura: " + nombre + " | Nota: " + nota + " | Estado: " + getEstado();
    }
}

