package vallegrande.edu.pe.hotelsys.controller;

import javafx.scene.control.Alert;

public class HotelController {

    public void nuevaReserva() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("HotelSys");
        alerta.setHeaderText("Nueva Reserva");
        alerta.setContentText(
                "Aquí podrás registrar una nueva reserva."
        );

        alerta.showAndWait();
    }

    public void verReservas() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("HotelSys");
        alerta.setHeaderText("Ver Reservas");
        alerta.setContentText(
                "Aquí podrás visualizar las reservas registradas."
        );

        alerta.showAndWait();
    }
}