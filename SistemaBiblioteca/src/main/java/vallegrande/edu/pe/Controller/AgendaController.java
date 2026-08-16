package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;

public class AgendaController {

    // Lista de contactos
    private ArrayList<Contacto> contactos;

    // Constructor
    public AgendaController() {
        contactos = new ArrayList<>();
    }

    // Agregar contacto
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto agregado correctamente.");
    }

    // Listar contactos
    public void listarContactos() {

        System.out.println("\n===== LISTA DE CONTACTOS =====");

        for (Contacto contacto : contactos) {
            contacto.mostrarContacto();
        }
    }

    // Buscar contacto
    public void buscarContacto(String criterio) {

        boolean encontrado = false;

        for (Contacto contacto : contactos) {

            if (contacto.getNombres().toLowerCase().contains(criterio.toLowerCase())
                    || contacto.getApellidos().toLowerCase().contains(criterio.toLowerCase())) {

                contacto.mostrarContacto();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro ningun contacto.");
        }
    }

    // Eliminar contacto
    public void eliminarContacto(int id) {

        boolean eliminado = false;

        for (int i = 0; i < contactos.size(); i++) {

            if (contactos.get(i).getId() == id) {

                contactos.remove(i);
                System.out.println("Contacto eliminado correctamente.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontro un contacto con ese ID.");
        }
    }
}