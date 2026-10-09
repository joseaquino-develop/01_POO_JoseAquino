package vallegrande.edu.pe.panel_control.controller;

import vallegrande.edu.pe.panel_control.model.Productor;
import vallegrande.edu.pe.panel_control.model.ProductorDAO;

import java.util.List;

public class MainController {

    private final ProductorDAO productorDAO;

    public MainController() {

        productorDAO = new ProductorDAO();
    }


    // =========================
    // LISTAR
    // =========================

    public List<Productor> obtenerProductores() {

        return productorDAO.listarProductores();
    }


    // =========================
    // REGISTRAR
    // =========================

    public boolean registrarProductor(
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String direccion
    ) {

        Productor productor =
                new Productor(
                        nombre,
                        apellido,
                        dni,
                        telefono,
                        direccion
                );

        return productorDAO.registrarProductor(
                productor
        );
    }


    // =========================
    // ACTUALIZAR
    // =========================

    public boolean actualizarProductor(
            int id,
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String direccion
    ) {

        return productorDAO.actualizarProductor(
                id,
                nombre,
                apellido,
                dni,
                telefono,
                direccion
        );
    }


    // =========================
    // ELIMINAR
    // =========================

    public boolean eliminarProductor(int id) {

        return productorDAO.eliminarProductor(
                id
        );
    }
}