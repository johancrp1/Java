package Semana2.CRUD_de_Frutas_con_Listas;

import javax.swing.*;

public class Fruta {
    private static int contadorId = 1;
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


    public Fruta(boolean organica, boolean perene, boolean climaterico, double peso, double precio, String origen, String sabor, String color, String name, int id) {
        this.organica = organica;
        this.perene = perene;
        this.climaterico = climaterico;
        this.peso = peso;
        this.precio = precio;
        this.origen = origen;
        this.sabor = sabor;
        this.color = color;
        this.name = name;
        this.id = contadorId++;
    }

    @Override
    public String toString() {
        return "Id: "+id+"Fruta: "+name+" Color: "+color+"Sabor: "+sabor+"Origen: "+origen+"Precio: "+precio+"Peso: "
                +peso+(climaterico ? ", fruto climaterico": ", no es climaterico")+(perene ? ", es perene" : ", no es perene")+(organica ? ", es organica" : ", no es organica");
    }

    public int getId() {
        return id;
    }

    public void actulizarDatos(boolean organica, boolean perene, boolean climaterico, double peso, double precio, String origen, String sabor, String color, String name) {
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