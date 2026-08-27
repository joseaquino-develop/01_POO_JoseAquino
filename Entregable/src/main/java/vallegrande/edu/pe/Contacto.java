package vallegrande.edu.pe;

public class Contacto {

    // Atributos
    private String nombre;
    private String telefono;
    private String correo;

    // Constructor
    public Contacto(String nombre, String telefono, String correo) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getter nombre
    public String getNombre() {
        return nombre;
    }

    // Getter telefono
    public String getTelefono() {
        return telefono;
    }

    // Getter correo
    public String getCorreo() {
        return correo;
    }

    // Método para mostrar datos
    public void mostrarDatos() {

        System.out.println("----------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("----------------------------");
    }
}