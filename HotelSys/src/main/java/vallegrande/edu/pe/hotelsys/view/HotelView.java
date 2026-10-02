package vallegrande.edu.pe.hotelsys.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import vallegrande.edu.pe.hotelsys.controller.HotelController;

public class HotelView {

    private final HotelController controller;

    public HotelView() {
        controller = new HotelController();
    }

    public void mostrar(Stage stage) {

        // Logo sin imagen
        Label logo = new Label("🏨");
        logo.getStyleClass().add("logo");

        // Nombre de la aplicación
        Label nombreApp = new Label("HotelSys");
        nombreApp.getStyleClass().add("nombre-app");

        // Título
        Label titulo = new Label("BIENVENIDO A\nHOTELSYS");
        titulo.getStyleClass().add("titulo");
        titulo.setTextAlignment(TextAlignment.CENTER);
        titulo.setAlignment(Pos.CENTER);
        titulo.setPrefWidth(280);
        titulo.setMaxWidth(280);

        // Descripción
        Label descripcion = new Label(
                "Gestiona las reservas de\n" +
                        "manera sencilla y eficiente\n" +
                        "para la gestión hotelera."
        );

        descripcion.getStyleClass().add("descripcion");
        descripcion.setTextAlignment(TextAlignment.CENTER);
        descripcion.setAlignment(Pos.CENTER);

        // Botones
        Button btnNuevaReserva = new Button("NUEVA RESERVA");
        btnNuevaReserva.getStyleClass().add("boton");

        Button btnVerReservas = new Button("VER RESERVAS");
        btnVerReservas.getStyleClass().add("boton");

        // Eventos
        btnNuevaReserva.setOnAction(
                e -> controller.nuevaReserva()
        );

        btnVerReservas.setOnAction(
                e -> controller.verReservas()
        );

        // Pie
        Label footer = new Label("Gestión Hotelera");
        footer.getStyleClass().add("footer");

        // Tarjeta
        VBox tarjeta = new VBox(
                8,
                logo,
                nombreApp,
                titulo,
                descripcion,
                btnNuevaReserva,
                btnVerReservas,
                footer
        );

        tarjeta.setAlignment(Pos.CENTER);
        tarjeta.setPadding(new Insets(25));
        tarjeta.getStyleClass().add("tarjeta");

        // Fondo
        VBox root = new VBox(tarjeta);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getStyleClass().add("root");

        // Escena
        Scene scene = new Scene(root, 350, 540);

        scene.getStylesheets().add(
                getClass()
                        .getResource(
                                "/vallegrande/edu/pe/hotelsys/css/styles.css"
                        )
                        .toExternalForm()
        );

        stage.setTitle("HotelSys");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}