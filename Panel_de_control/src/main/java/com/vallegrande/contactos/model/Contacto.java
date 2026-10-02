package com.vallegrande.contactos.model;

import java.sql.Timestamp;

public class Contacto {

    private int id;
    private String nombre;
    private String email;
    private String asunto;
    private String mensaje;
    private Timestamp creadoEn;

    public Contacto(
            int id,
            String nombre,
            String email,
            String asunto,
            String mensaje,
            Timestamp creadoEn
    ) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.creadoEn = creadoEn;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Timestamp getCreadoEn() {
        return creadoEn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setCreadoEn(Timestamp creadoEn) {
        this.creadoEn = creadoEn;
    }
}