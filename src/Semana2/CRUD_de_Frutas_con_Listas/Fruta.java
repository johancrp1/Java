package Semana2.CRUD_de_Frutas_con_Listas;


// Aunque se importa javax.swing.*, en esta clase no se utiliza.
// Podrías eliminar esta línea si no estás usando Swing en otra parte.

import javax.swing.*;

public class Fruta {

    // Variable estática que lleva un conteo automático de los IDs.
    // Se incrementa cada vez que se crea una nueva fruta.
    private static int contadorId = 1;

    // Atributos privados que definen las propiedades de cada fruta.
    private int id;
    private String name;
    private String color;
    private String sabor;
    private String origen;
    private double precio;
    private double peso;
    private boolean climaterico;
    private boolean perene;
    private boolean organica;

    /**
     * Constructor de la clase Fruta.
     * Recibe todos los datos de la fruta excepto el ID, que se genera automáticamente.
     */
    public Fruta(boolean organica, boolean perene, boolean climaterico, double peso, double precio, String origen, String sabor, String color, String name) {
        this.organica = organica;
        this.perene = perene;
        this.climaterico = climaterico;
        this.peso = peso;
        this.precio = precio;
        this.origen = origen;
        this.sabor = sabor;
        this.color = color;
        this.name = name;

        // Asigna un ID único automáticamente y lo incrementa para la siguiente fruta.
        this.id = contadorId++;
    }


    /**
     *
     * Metodo toString sobreescrito para mostrar la información de la fruta
     * de forma clara y legible en varias líneas.
     */
    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Fruta: " + name + "\n" +
                "Color: " + color + "\n" +
                "Sabor: " + sabor + "\n" +
                "Origen: " + origen + "\n" +
                "Precio: " + precio + "\n" +
                "Peso: " + peso + "\n" +
                (climaterico ? ", fruto climaterico" : ", no es climaterico") + "\n" +
                (perene ? ", es perene" : ", no es perene") + "\n" +
                (organica ? ", es organica" : ", no es organica");
    }

    /**
     * Metodo para obtener el ID de la fruta.
     * Útil cuando se quiere buscar, editar o eliminar una fruta por su ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para actualizar todos los datos de una fruta (execepto el ID)
     * Se puede usar para editar una fruta ya existente.
     */
    public void actualizarDatos(boolean organica, boolean perene, boolean climaterico, double peso, double precio, String origen, String sabor, String color, String name) {
        this.organica = organica;
        this.perene = perene;
        this.climaterico = climaterico;
        this.peso = peso;
        this.precio = precio;
        this.origen = origen;
        this.sabor = sabor;
        this.color = color;
        this.name = name;
    }


}