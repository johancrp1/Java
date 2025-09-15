package JOptionPane_Practica;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JOptionPane;

public class JOptionPane_Ejercicios {

    /*
    1. Mostrar un mensaje simple:
     */

    public static void Saludar() {

        //Usamos JOptionPane.showMessageDialog para mostrar un mensaje en un cuadro de diálogo.
        JOptionPane.showMessageDialog(null, "¡Bienvenido al programa!");
    }

    /*
    2. Pedir un nombre y saludar al usuario:
     */

    public static void PedirNombreYSaludar() {

        // Perdir al usuario su nombre Usamos JOptionPane.showInputDialog para obtener datos del usuario.

        String nombre = JOptionPane.showInputDialog("¿Cual es tu nombre?");

        //Mostramos un saludo con el nombre
        JOptionPane.showMessageDialog(null, "hola, " + nombre + "!");
    }

    /*
    3. Confirmar una acción (Sí/No):
     */

    public static void ConfirmarUnaAccion() {

        //Preguntar si el usuario quiere salir
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas salir?", "confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "¡Adios!");
        } else {
            JOptionPane.showMessageDialog(null, "¡Seguimos trabajando!");
        }
    }

    /*
    4. Seleccionar una opción de un menú (opciones predeterminadas):
     */

    public static void SeleccionaUnaOpcion() {

        //Mostrar un menu con opciones predefinidas
        String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3"};

        //Creamos una variable de tipo int y creamos el metodo showOptionDialog
        int seleccion = JOptionPane.showOptionDialog(
                null,               // 1. Componente padre (parent component)
                "Elige una opción:", // 2. Mensaje que se muestra
                "Menú de opciones", // 3. Título de la ventana
                JOptionPane.DEFAULT_OPTION,      // 4. Tipo de opciones (default, yes/no, etc.)
                JOptionPane.INFORMATION_MESSAGE, // 5. Tipo de mensaje (información, error, advertencia...)
                null,                // 6. Icono personalizado (null = icono por defecto según tipo de mensaje)
                opciones,            // 7. Opciones (array de objetos que serán botones)
                opciones[0]          // 8. Valor inicial seleccionado (por defecto la primera opción)
        );
        JOptionPane.showMessageDialog(null, "Has seleccionado: " + opciones[seleccion]);
    }

    public static void main(String[] args) {
        //Saludar();
        //PedirNombreYSaludar();
        //ConfirmarUnaAccion();
        SeleccionaUnaOpcion();
    }
}
