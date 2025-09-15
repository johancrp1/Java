package Semana2.FrutasPOO;

import javax.swing.*;

public class Fruta {
    String name;
    String color;
    String sabor;
    double peso;
    boolean climaterico;
    boolean perene;

    public Fruta(String nameFruta,String colorFruta, String saborFruta, double peso, boolean climaterico, boolean perene) {
        this.name = nameFruta;
        this.color = colorFruta;
        this.sabor = saborFruta;
        this.peso = peso;
        this.climaterico = climaterico;
        this.perene = perene;
    }

    public void madurar() {
        if (climaterico){
            JOptionPane.showMessageDialog(null, "Usted esta madurando su fruta "+ name);
        } else {
            JOptionPane.showMessageDialog(null, "La fruta" + name + "no se puede madurar");
        }
    }

    public void mostrarInfoFruta() {
        String mensaje = "Su fruta es " + name + ",el color es " + color + ",su sabor es " + sabor + ",el peso es " + peso +
                (climaterico ? "Si es climaterico " : "No es climaterico ") + (perene ? "Si es perene ":"No es perene ");
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
