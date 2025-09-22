package Semana2.Dia2.Institucion_Educativa.Model;

import java.util.ArrayList;

// La clase Alumno hereda de Persona
public class Alumno extends Persona {
    // Lista de asignaturas que tiene el alumno
    private ArrayList<Asignatura> asignaturas;

    // Constructor vacío: inicializa el alumno llamando al constructor de Persona
    // y crea la lista vacía de asignaturas
    public Alumno() {
        super();
        asignaturas = new ArrayList<>();
    }

    // Constructor con parámetros (nombre y edad): inicializa un alumno con datos
    public Alumno(String name, int edad) {
        super(name, edad);
        asignaturas = new ArrayList<>();
    }

    // Metodo para agregar una asignatura al alumno
    public void agregarAsignatura(Asignatura asignatura) {
        // Regla 1: un alumno no puede tener más de 4 asignaturas
        if (asignaturas.size() >= 4) {
            System.out.println("El alumno ya tiene el máximo de 4 asignaturas.");
            return;
        }
        // Regla 2: no se pueden repetir asignaturas con el mismo nombre
        for (Asignatura a : asignaturas) {
            if (a.getNombre().equalsIgnoreCase(asignatura.getNombre())) {
                System.out.println("La asignatura '" + asignatura.getNombre() + "' ya está registrada.");
                return;
            }
        }
        // Si pasa las validaciones, se agrega la asignatura
        asignaturas.add(asignatura);
    }

    // Devuelve la lista de asignaturas del alumno
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    // Calcula el promedio de notas del alumno
    public double calcularPromedio() {
        if (asignaturas.isEmpty()) return 0.0; // Si no tiene asignaturas, promedio = 0
        double suma = 0;
        for (Asignatura a : asignaturas) {
            suma += a.getNota(); // Acumula todas las notas
        }
        return suma / asignaturas.size(); // Promedio = suma de notas / cantidad de asignaturas
    }

    // Sobrescribe el metodo mostrarInfo() de Persona
    @Override
    public void mostrarInfo() {
        // Imprime nombre y edad
        System.out.println("Alumno: " + getName() + " | Edad: " + getEdad());

        // Si no tiene asignaturas, lo indica
        if (asignaturas.isEmpty()) {
            System.out.println("No tiene asignaturas registradas.");
        } else {
            // Si tiene asignaturas, las muestra una por una
            for (Asignatura a : asignaturas) {
                System.out.println("  - " + a); // usa toString() de Asignatura
            }
            // Muestra el promedio con 2 decimales
            System.out.printf("Promedio: %.2f%n", calcularPromedio());
        }
        // Línea separadora
        System.out.println("----------------------------");
    }
}
