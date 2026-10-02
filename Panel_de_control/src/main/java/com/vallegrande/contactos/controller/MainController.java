package com.vallegrande.contactos.controller;

import com.vallegrande.contactos.model.Contacto;
import com.vallegrande.contactos.model.ContactoDAO;

import java.util.List;

public class MainController {

    private final ContactoDAO contactoDAO;

    public MainController() {
        contactoDAO = new ContactoDAO();
    }

    public List<Contacto> obtenerContactos() {
        return contactoDAO.listarContactos();
    }
}