package vallegrande.edu.pe.panel_de_control.controller;

import vallegrande.edu.pe.panel_de_control.model.Productor;
import vallegrande.edu.pe.panel_de_control.model.ProductorDAO;

import java.util.List;

public class MainController {

    private final ProductorDAO productorDAO;

    public MainController() {
        productorDAO = new ProductorDAO();
    }

    public List<Productor> obtenerProductores() {
        return productorDAO.listarProductores();
    }

    public boolean registrarProductor(
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String direccion
    ) {

        Productor productor = new Productor(
                nombre,
                apellido,
                dni,
                telefono,
                direccion
        );

        return productorDAO.registrarProductor(productor);
    }
}