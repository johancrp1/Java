package Semana2.FrutasPOO;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Fruta> canasta = new ArrayList<>();


        String nameFruta = JOptionPane.showInputDialog(null, "Introduzca el nombre de una fruta:");
        String colorFruta = JOptionPane.showInputDialog(null, "Introduzca el color de la fruta:");
        String saborFruta = JOptionPane.showInputDialog(null, "Introduzca el sabor de la fruta:");
        String pesoFrutaStr = JOptionPane.showInputDialog(null, "Introduzca el peso de la fruta:");
        double pesoFruta = Double.parseDouble(pesoFrutaStr);

        boolean climaterico;
        int climatericoONo = JOptionPane.showConfirmDialog(
                null,
                "Es climaterico?",
                "Climaterico o no",
                JOptionPane.YES_NO_OPTION
        );
        if (climatericoONo == JOptionPane.YES_OPTION) {
            climaterico = true;
        } else {
            climaterico = false;
        }

        boolean perene;
        int pereneONo = JOptionPane.showConfirmDialog(
                null,
                "Es perene?",
                "Perene o no",
                JOptionPane.YES_NO_OPTION
        );
        perene = (pereneONo == JOptionPane.YES_OPTION);

        canasta.add(new Fruta(nameFruta, colorFruta, saborFruta, pesoFruta, climaterico, perene));
        for (Fruta fruta: canasta) {
            fruta.mostrarInfoFruta();
        }
    }
}
