package vallegrande.edu.pe.mitarea.controller;

import vallegrande.edu.pe.mitarea.view.mainView;

public class MainController {

    private final mainView view;

    public MainController(mainView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnInicio().setOnAction(
                event -> view.mostrarInicio()
        );

        view.getBtnUsuarios().setOnAction(
                event -> view.mostrarUsuarios()
        );

        view.getBtnProductos().setOnAction(
                event -> view.mostrarProductos()
        );

        view.getBtnVentas().setOnAction(
                event -> view.mostrarVentas()
        );

        view.getBtnReportes().setOnAction(
                event -> view.mostrarReportes()
        );

        view.getBtnConfiguracion().setOnAction(
                event -> view.mostrarConfiguracion()
        );
    }
}