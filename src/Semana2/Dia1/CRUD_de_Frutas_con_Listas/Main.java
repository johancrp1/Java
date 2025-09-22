package Semana2.Dia1.CRUD_de_Frutas_con_Listas;

import javax.swing.*;
import java.util.List;

public class Main {

    private static FrutaManager manager = new FrutaManager();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            String menu = "MENÚ DE FRUTAS\n\n" +
                    "1. Crear fruta\n" +
                    "2. Listar todas las frutas\n" +
                    "3. Buscar fruta (por ID o nombre parcial)\n" +
                    "4. Actualizar fruta\n" +
                    "5. Eliminar fruta\n" +
                    "6. Salir";

            String opcionStr = JOptionPane.showInputDialog(null, menu, "CRUD de Frutas", JOptionPane.QUESTION_MESSAGE);
            if (opcionStr == null) { // Usuario presionó cancelar o cerró la ventana
                salir = true;
                continue;
            }

            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1:
                    crearFruta();
                    break;
                case 2:
                    listarFrutas();
                    break;
                case 3:
                    buscarFruta();
                    break;
                case 4:
                    actualizarFruta();
                    break;
                case 5:
                    eliminarFruta();
                    break;
                case 6:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void crearFruta() {
        try {
            boolean organica = leerBoolean("¿Es orgánica? (true/false):");
            boolean perene = leerBoolean("¿Es perenne? (true/false):");
            boolean climaterico = leerBoolean("¿Es climaterica? (true/false):");
            double peso = leerDouble("Peso (>0):");
            double precio = leerDouble("Precio (>=0):");
            String origen = leerString("Origen:");
            String sabor = leerString("Sabor:");
            String color = leerString("Color:");
            String name = leerString("Nombre:");

            Fruta fruta = new Fruta(organica, perene, climaterico, peso, precio, origen, sabor, color, name);
            manager.crearFruta(fruta);
            JOptionPane.showMessageDialog(null, "Fruta creada con ID: " + fruta.getId());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error al crear fruta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarFrutas() {
        if (manager == null) {
            JOptionPane.showMessageDialog(null, "No hay frutas registradas.");
            return;
        }

        List<Fruta> frutas = manager.buscarPorNombreParcial(""); // Todas las frutas

        if (frutas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay frutas registradas.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Fruta f : frutas) {
            sb.append(f).append("\n----------------------\n");
        }
        mostrarTextoEnVentana("Listado de frutas", sb.toString());
    }

    private static void buscarFruta() {
        String[] opciones = {"Por ID", "Por nombre parcial"};
        int opcion = JOptionPane.showOptionDialog(null,
                "Buscar fruta por:",
                "Buscar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (opcion == 0) { // Buscar por ID
            int id = leerEntero("Ingrese ID:");
            Fruta f = manager.buscarPorId(id);
            if (f != null) {
                mostrarTextoEnVentana("Fruta encontrada", f.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró fruta con ID " + id);
            }
        } else if (opcion == 1) { // Buscar por nombre parcial
            String texto = leerString("Ingrese texto para buscar en nombre:");
            List<Fruta> resultado = manager.buscarPorNombreParcial(texto);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron frutas con ese texto.");
            } else {
                StringBuilder sb = new StringBuilder();
                for (Fruta f : resultado) {
                    sb.append(f).append("\n----------------------\n");
                }
                mostrarTextoEnVentana("Resultados de búsqueda", sb.toString());
            }
        }
    }

    private static void actualizarFruta() {
        int id = leerEntero("Ingrese ID de la fruta a actualizar:");
        Fruta frutaExistente = manager.buscarPorId(id);

        if (frutaExistente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró fruta con ID " + id);
            return;
        }

        try {
            String organicaStr = leerStringOpcional("¿Es orgánica? (true/false) [" + frutaExistente.isOrganica() + "]:");
            boolean organica = organicaStr.isEmpty() ? frutaExistente.isOrganica() : Boolean.parseBoolean(organicaStr);

            String pereneStr = leerStringOpcional("¿Es perenne? (true/false) [" + frutaExistente.isPerene() + "]:");
            boolean perene = pereneStr.isEmpty() ? frutaExistente.isPerene() : Boolean.parseBoolean(pereneStr);

            String climatericoStr = leerStringOpcional("¿Es climaterica? (true/false) [" + frutaExistente.isClimaterico() + "]:");
            boolean climaterico = climatericoStr.isEmpty() ? frutaExistente.isClimaterico() : Boolean.parseBoolean(climatericoStr);

            String pesoStr = leerStringOpcional("Peso (>0) [" + frutaExistente.getPeso() + "]:");
            double peso = pesoStr.isEmpty() ? frutaExistente.getPeso() : Double.parseDouble(pesoStr);

            String precioStr = leerStringOpcional("Precio (>=0) [" + frutaExistente.getPrecio() + "]:");
            double precio = precioStr.isEmpty() ? frutaExistente.getPrecio() : Double.parseDouble(precioStr);

            String origen = leerStringOpcional("Origen [" + frutaExistente.getOrigen() + "]:");
            if (origen.isEmpty()) origen = frutaExistente.getOrigen();

            String sabor = leerStringOpcional("Sabor [" + frutaExistente.getSabor() + "]:");
            if (sabor.isEmpty()) sabor = frutaExistente.getSabor();

            String color = leerStringOpcional("Color [" + frutaExistente.getColor() + "]:");
            if (color.isEmpty()) color = frutaExistente.getColor();

            String name = leerStringOpcional("Nombre [" + frutaExistente.getName() + "]:");
            if (name.isEmpty()) name = frutaExistente.getName();

            Fruta frutaActualizada = new Fruta(organica, perene, climaterico, peso, precio, origen, sabor, color, name);

            boolean exito = manager.actualizarFruta(id, frutaActualizada);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Fruta actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar fruta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void eliminarFruta() {
        int id = leerEntero("Ingrese ID de la fruta a eliminar:");
        boolean eliminado = manager.eliminarFruta(id);
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Fruta eliminada.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró fruta con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Métodos auxiliares para entrada de datos con JOptionPane

    private static int leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if (entrada == null) {
                throw new RuntimeException("Operación cancelada");
            }
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if (entrada == null) {
                throw new RuntimeException("Operación cancelada");
            }
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número decimal válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean leerBoolean(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            if (entrada == null) {
                throw new RuntimeException("Operación cancelada");
            }
            if (entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(entrada);
            }
            JOptionPane.showMessageDialog(null, "Debe ingresar 'true' o 'false'.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static String leerString(String mensaje) {
        String entrada = JOptionPane.showInputDialog(null, mensaje);
        if (entrada == null) {
            throw new RuntimeException("Operación cancelada");
        }
        return entrada.trim();
    }

    private static String leerStringOpcional(String mensaje) {
        String entrada = JOptionPane.showInputDialog(null, mensaje);
        if (entrada == null) {
            return ""; // En cancel devolver cadena vacía para mantener valor actual
        }
        return entrada.trim();
    }

    private static void mostrarTextoEnVentana(String titulo, String texto) {
        JTextArea textArea = new JTextArea(texto);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}

