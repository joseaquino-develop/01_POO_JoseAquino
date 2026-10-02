package com.vallegrande.contactos.view;

import com.vallegrande.contactos.controller.MainController;
import com.vallegrande.contactos.model.Contacto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Timestamp;
import java.util.List;

public class MainView {

    private final MainController controller;

    public MainView() {
        controller = new MainController();
    }

    public void mostrar(Stage stage) {

        Label titulo = new Label("Lista de Contactos");
        titulo.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;"
        );

        Label descripcion = new Label(
                "Contactos registrados en la base de datos cotizaciones_db"
        );

        TableView<Contacto> tabla = new TableView<>();

        TableColumn<Contacto, Integer> columnaId =
                new TableColumn<>("ID");

        columnaId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        TableColumn<Contacto, String> columnaNombre =
                new TableColumn<>("Nombre");

        columnaNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        TableColumn<Contacto, String> columnaEmail =
                new TableColumn<>("Email");

        columnaEmail.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );

        TableColumn<Contacto, String> columnaAsunto =
                new TableColumn<>("Asunto");

        columnaAsunto.setCellValueFactory(
                new PropertyValueFactory<>("asunto")
        );

        TableColumn<Contacto, String> columnaMensaje =
                new TableColumn<>("Mensaje");

        columnaMensaje.setCellValueFactory(
                new PropertyValueFactory<>("mensaje")
        );

        TableColumn<Contacto, Timestamp> columnaFecha =
                new TableColumn<>("Fecha");

        columnaFecha.setCellValueFactory(
                new PropertyValueFactory<>("creadoEn")
        );

        tabla.getColumns().addAll(
                columnaId,
                columnaNombre,
                columnaEmail,
                columnaAsunto,
                columnaMensaje,
                columnaFecha
        );

        columnaId.setPrefWidth(50);
        columnaNombre.setPrefWidth(110);
        columnaEmail.setPrefWidth(230);
        columnaAsunto.setPrefWidth(170);
        columnaMensaje.setPrefWidth(250);
        columnaFecha.setPrefWidth(170);

        List<Contacto> listaContactos =
                controller.obtenerContactos();

        ObservableList<Contacto> datos =
                FXCollections.observableArrayList(listaContactos);

        tabla.setItems(datos);

        Label total = new Label(
                "Total de contactos: " + datos.size()
        );

        VBox contenedor = new VBox(
                15,
                titulo,
                descripcion,
                tabla,
                total
        );

        contenedor.setPadding(new Insets(20));

        Scene scene = new Scene(
                contenedor,
                1050,
                600
        );

        stage.setTitle("Sistema de Contactos - JavaFX");
        stage.setScene(scene);
        stage.show();
    }
}