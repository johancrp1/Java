package Semana2.Dia2.Institucion_Educativa;

import Semana2.Dia2.Institucion_Educativa.Model.Alumno;
import Semana2.Dia2.Institucion_Educativa.service.AlumnoService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Se crea una instancia del servicio que manejará la lógica de los alumnos
        AlumnoService service = new AlumnoService();

        // Se pide al usuario, mediante un cuadro de diálogo, cuántos alumnos desea registrar
        int cantidadAlumnos = Integer.parseInt(
                JOptionPane.showInputDialog("¿Cuántos alumnos desea registrar?")
        );

        // Se crea un arreglo de objetos Alumno con la cantidad indicada
        Alumno[] alumnos = new Alumno[cantidadAlumnos];

        // Bucle para registrar a cada alumno
        for (int i = 0; i < cantidadAlumnos; i++) {
            // Se muestra un mensaje indicando el registro del alumno i+1
            JOptionPane.showMessageDialog(null, "=== Registro del Alumno " + (i + 1) + " ===");

            // Se llama al servicio para crear un alumno
            alumnos[i] = service.crearAlumno();
        }

        // Se arma un String (usando StringBuilder por eficiencia) con toda la información de los alumnos
        StringBuilder sb = new StringBuilder("===== INFORMACIÓN DE LOS ALUMNOS =====\n\n");

        // Recorre el arreglo de alumnos
        for (Alumno alumno : alumnos) {
            // Agrega los datos básicos de cada alumno
            sb.append("Alumno: ").append(alumno.getName())
                    .append(" | Edad: ").append(alumno.getEdad()).append("\n");

            // Si el promedio es 0, significa que no tiene asignaturas registradas
            if (alumno.calcularPromedio() == 0) {
                sb.append("No tiene asignaturas registradas.\n");
            } else {
                // Muestra todas las asignaturas del alumno
                alumno.getAsignaturas().forEach(a ->
                        sb.append("  - ").append(a).append("\n")
                );
                // Muestra el promedio con 2 decimales
                sb.append("Promedio: ").append(String.format("%.2f", alumno.calcularPromedio())).append("\n");
            }
            // Separador para diferenciar a los alumnos
            sb.append("----------------------------\n");
        }

        // Finalmente, se muestra toda la información recopilada en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
