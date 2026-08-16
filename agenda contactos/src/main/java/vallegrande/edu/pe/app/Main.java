package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AgendaView;
public class Main {
    public static void main(String[] args) {

        // Crear los componentes
        AgendaController controller = new AgendaController();
        AgendaView view = new AgendaView();

        // Mostrar titulo
        view.mostrarTitulo();
        // ==========================
        // CREAR 5 CONTACTOS
        // ==========================
        Contacto contacto1 = new Contacto(
                1,
                "Ana",
                "Torres",
                "Cañete",
                "983745656",
                "ana@gmail.com"
        );
        Contacto contacto2 = new Contacto(
                2,
                "Carlos",
                "Perez",
                "Imperial",
                "951264456",
                "carlos@gmail.com"
        );
        Contacto contacto3 = new Contacto(
                3,
                "Jose",
                "Garcia",
                "Lima",
                "987654321",
                "jose@gmail.com"
        );
        Contacto contacto4 = new Contacto(
                4,
                "Maria",
                "Lopez",
                "Chincha",
                "976543210",
                "maria@gmail.com"
        );
        Contacto contacto5 = new Contacto(
                5,
                "Luis",
                "Ramirez",
                "Ica",
                "965432187",
                "luis@gmail.com"
        );
        // Agregar los 5 contactos
        controller.agregarContacto(contacto1);
        controller.agregarContacto(contacto2);
        controller.agregarContacto(contacto3);
        controller.agregarContacto(contacto4);
        controller.agregarContacto(contacto5);

        // MENU PRINCIPAL
        int opcion;
        int siguienteId = 6;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    // Registrar
                    Contacto nuevoContacto = view.leerContacto(siguienteId);
                    controller.agregarContacto(nuevoContacto);
                    siguienteId++;
                    break;
                case 2:
                    // Listar
                    controller.listarContactos();
                    break;
                case 3:
                    // Buscar
                    String criterio = view.leerCriterio();
                    controller.buscarContacto(criterio);
                    break;
                case 4:
                    // Eliminar
                    int id = view.leerId();
                    controller.eliminarContacto(id);
                    break;
                case 5:
                    // Salir
                    view.mostrarMensaje("Gracias por utilizar la Agenda de Contactos.");
                    break;
                default:
                    view.mostrarMensaje("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}

