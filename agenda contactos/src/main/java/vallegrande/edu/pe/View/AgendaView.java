package vallegrande.edu.pe.view;

import java.util.Scanner;
import vallegrande.edu.pe.model.Contacto;

public class AgendaView {

    private Scanner scanner;

    // Constructor
    public AgendaView() {
        scanner = new Scanner(System.in);
    }

    // Mostrar titulo
    public void mostrarTitulo() {
        System.out.println("---------------------------");
        System.out.println("AGENDA DE CONTACTOS");
        System.out.println("---------------------------");
    }

    // Mostrar mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Mostrar menu
    public int mostrarMenu() {

        System.out.println("\n===== MENU =====");
        System.out.println("1. Registrar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");

        return scanner.nextInt();
    }

    // Leer datos del contacto
    public Contacto leerContacto(int id) {

        scanner.nextLine();

        System.out.print("Ingrese nombres: ");
        String nombres = scanner.nextLine();

        System.out.print("Ingrese apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese telefono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        return new Contacto(
                id,
                nombres,
                apellidos,
                direccion,
                telefono,
                correo
        );
    }

    // Leer criterio para buscar
    public String leerCriterio() {

        scanner.nextLine();

        System.out.print("Ingrese nombre o apellido a buscar: ");

        return scanner.nextLine();
    }

    // Leer ID para eliminar
    public int leerId() {

        System.out.print("Ingrese el ID del contacto a eliminar: ");

        return scanner.nextInt();
    }
}