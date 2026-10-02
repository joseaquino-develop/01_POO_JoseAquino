package vallegrande.edu.pe.panel_de_control.model;

import java.sql.Timestamp;

public class Productor {

    private int idProductor;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private Timestamp fechaRegistro;

    public Productor(
            int idProductor,
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String direccion,
            Timestamp fechaRegistro
    ) {
        this.idProductor = idProductor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }

    public Productor(
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String direccion
    ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdProductor() {
        return idProductor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }
}