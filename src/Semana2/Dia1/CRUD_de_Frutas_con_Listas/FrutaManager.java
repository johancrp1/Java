package Semana2.Dia1.CRUD_de_Frutas_con_Listas;

import java.util.ArrayList;
import java.util.List;

public class FrutaManager {

    private List<Fruta> frutas;

    public FrutaManager() {
        frutas = new ArrayList<>();
    }

    // Crear fruta y agregar a la lista
    public void crearFruta(Fruta fruta) {
        frutas.add(fruta);
        System.out.println("Fruta creada con ID: " + fruta.getId());
    }

    // Listar todas las frutas
    public void listarFrutas() {
        if (frutas.isEmpty()) {
            System.out.println("No hay frutas registradas.");
            return;
        }
        for (Fruta f : frutas) {
            System.out.println(f);
            System.out.println("--------------------");
        }
    }

    // Buscar por ID
    public Fruta buscarPorId(int id) {
        for (Fruta f : frutas) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    // Buscar por nombre parcial (case insensitive)
    public List<Fruta> buscarPorNombreParcial(String texto) {
        List<Fruta> resultado = new ArrayList<>();
        for (Fruta f : frutas) {
            if (f.getName().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    // Actualizar fruta por ID
    public boolean actualizarFruta(int id, Fruta frutaActualizada) {
        Fruta fruta = buscarPorId(id);
        if (fruta != null) {
            fruta.actualizarDatos(
                    frutaActualizada.isOrganica(),
                    frutaActualizada.isPerene(),
                    frutaActualizada.isClimaterico(),
                    frutaActualizada.getPeso(),
                    frutaActualizada.getPrecio(),
                    frutaActualizada.getOrigen(),
                    frutaActualizada.getSabor(),
                    frutaActualizada.getColor(),
                    frutaActualizada.getName()
            );
            return true;
        }
        return false;
    }

    // Eliminar fruta por ID
    public boolean eliminarFruta(int id) {
        Fruta fruta = buscarPorId(id);
        if (fruta != null) {
            frutas.remove(fruta);
            return true;
        }
        return false;
    }
}
