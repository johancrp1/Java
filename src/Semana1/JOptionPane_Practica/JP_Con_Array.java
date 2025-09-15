package JOptionPane_Practica;

import javax.swing.JOptionPane;

public class JP_Con_Array {
    public static void main(String[] args) {
        // Creamos un array de opciones
        String[] opciones = {"Manzana", "Banana", "Naranja", "Uva"};

        // Mostramos el cuadro de diálogo con las opciones del array
        String seleccion = (String) JOptionPane.showInputDialog(
                null,                                   // Componente padre
                "Selecciona una fruta:",                // Mensaje
                "Ejemplo con Array",                    // Título del diálogo
                JOptionPane.QUESTION_MESSAGE,           // Tipo de mensaje
                null,                                   // Icono personalizado (null para usar el predeterminado)
                opciones,                               // Opciones (array)
                opciones[0]                             // Valor inicial seleccionado
        );

        // Mostramos lo que seleccionó el usuario
        if (seleccion != null) {
            JOptionPane.showMessageDialog(null, "Seleccionaste: " + seleccion);
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción.");
        }
    }
}
