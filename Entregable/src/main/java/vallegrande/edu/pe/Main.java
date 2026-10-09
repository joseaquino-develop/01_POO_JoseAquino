package vallegrande.edu.pe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda();

        int opcion;

        do {

            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Ingrese correo: ");
                    String correo = scanner.nextLine();

                    Contacto nuevoContacto =
                            new Contacto(nombre, telefono, correo);

                    agenda.registrarContacto(nuevoContacto);

                    break;

                case 2:

                    agenda.mostrarContactos();

                    break;

                case 3:

                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    agenda.buscarContacto(nombreBuscar);

                    break;

                case 4:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}