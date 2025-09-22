package Semana2.Dia2.Institucion_Educativa.Model;

public class Persona {
    private String name;
    private int edad;

    public Persona(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    public Persona() {

    }

    //Creo los Getter y Setter para el nombre
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter para edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) { // Validación básica
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa.");
        }
    }

    //Metodo para mostrar la informacion
    public void mostrarInfo() {
        System.out.println("Nombre: " + name + ", Edad: " + edad);
    }

}
