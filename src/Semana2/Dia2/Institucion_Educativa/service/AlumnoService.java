package Semana2.Dia2.Institucion_Educativa.service;

import Semana2.Dia2.Institucion_Educativa.Model.Alumno;
import Semana2.Dia2.Institucion_Educativa.Model.Asignatura;

import javax.swing.*;

public class AlumnoService {

    // Metodo que crea un alumno a partir de los datos ingresados por el usuario
    public Alumno crearAlumno() {
        // Se pide el nombre del alumno
        String nombre = JOptionPane.showInputDialog("Nombre del alumno:");

        // Se pide la edad del alumno y se convierte a entero
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del alumno:"));

        // Se crea un nuevo objeto Alumno con esos datos
        Alumno alumno = new Alumno(nombre, edad);

        // Se pregunta cuántas asignaturas quiere agregar (máximo 4)
        int cantidadAsignaturas = Integer.parseInt(
                JOptionPane.showInputDialog("¿Cuántas asignaturas desea agregar? (máximo 4):")
        );

        // Bucle para registrar cada asignatura
        // Se asegura de no permitir más de 4
        for (int j = 0; j < cantidadAsignaturas && j < 4; j++) {
            // Se pide el nombre de la asignatura
            String nombreAsignatura = JOptionPane.showInputDialog("Nombre de la asignatura " + (j + 1) + ":");

            // Se pide la nota de esa asignatura y se convierte a número decimal (double)
            double nota = Double.parseDouble(
                    JOptionPane.showInputDialog("Nota de " + nombreAsignatura + " (0.0 - 5.0):")
            );

            // Se crea un objeto Asignatura y se agrega al alumno
            alumno.agregarAsignatura(new Asignatura(nombreAsignatura, nota));
        }

        // Se devuelve el alumno ya creado con sus asignaturas
        return alumno;
    }
}
