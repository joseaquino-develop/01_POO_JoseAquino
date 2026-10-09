package vallegrande.edu.pe.panel_control.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import vallegrande.edu.pe.panel_control.controller.MainController;
import vallegrande.edu.pe.panel_control.model.Productor;

import java.sql.Timestamp;

public class MainView {

    private final MainController controller;

    private final TableView<Productor> tabla;
    private final ObservableList<Productor> datos;

    private final TextField txtNombre;
    private final TextField txtApellido;
    private final TextField txtDni;
    private final TextField txtTelefono;
    private final TextField txtDireccion;

    private final Label mensaje;
    private final Label total;

    // Productor seleccionado
    private Productor productorSeleccionado;

    public MainView() {

        controller = new MainController();

        tabla = new TableView<>();
        datos = FXCollections.observableArrayList();

        txtNombre = new TextField();
        txtApellido = new TextField();
        txtDni = new TextField();
        txtTelefono = new TextField();
        txtDireccion = new TextField();

        mensaje = new Label();
        total = new Label();

        productorSeleccionado = null;
    }

    public void mostrar(Stage stage) {

        // =========================
        // MENÚ LATERAL
        // =========================

        Label logo = new Label("CHAVALINA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;"
        );

        Button btnInicio = new Button("Inicio");
        Button btnProductores = new Button("Productores");

        btnInicio.setPrefWidth(160);
        btnProductores.setPrefWidth(160);

        String estiloBoton =
                "-fx-background-color: white;" +
                        "-fx-text-fill: #333333;" +
                        "-fx-font-size: 14px;" +
                        "-fx-padding: 12px;";

        btnInicio.setStyle(estiloBoton);
        btnProductores.setStyle(estiloBoton);

        VBox menu = new VBox(
                25,
                logo,
                btnInicio,
                btnProductores
        );

        menu.setPadding(
                new Insets(30, 20, 20, 20)
        );

        menu.setPrefWidth(210);

        menu.setStyle(
                "-fx-background-color: #2563EB;"
        );


        // =========================
        // TÍTULO
        // =========================

        Label titulo =
                new Label("GESTIÓN DE PRODUCTORES");

        titulo.setStyle(
                "-fx-font-size: 26px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #333333;"
        );

        Label descripcion =
                new Label(
                        "Productores registrados en Chavalina"
                );

        descripcion.setStyle(
                "-fx-text-fill: #666666;"
        );


        // =========================
        // FORMULARIO
        // =========================

        txtNombre.setPromptText("Nombre");
        txtApellido.setPromptText("Apellido");
        txtDni.setPromptText("DNI");
        txtTelefono.setPromptText("Teléfono");
        txtDireccion.setPromptText("Dirección");

        txtNombre.setPrefWidth(140);
        txtApellido.setPrefWidth(140);
        txtDni.setPrefWidth(100);
        txtTelefono.setPrefWidth(130);
        txtDireccion.setPrefWidth(200);


        // BOTÓN REGISTRAR

        Button btnRegistrar =
                new Button("Registrar");

        btnRegistrar.setStyle(
                "-fx-background-color: #16A34A;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8px 18px;"
        );

        btnRegistrar.setOnAction(
                event -> registrarProductor()
        );


        // BOTÓN ACTUALIZAR

        Button btnActualizar =
                new Button("Actualizar");

        btnActualizar.setStyle(
                "-fx-background-color: #2563EB;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8px 18px;"
        );

        btnActualizar.setOnAction(
                event -> actualizarProductor()
        );


        // BOTÓN ELIMINAR

        Button btnEliminar =
                new Button("Eliminar");

        btnEliminar.setStyle(
                "-fx-background-color: #DC2626;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8px 18px;"
        );

        btnEliminar.setOnAction(
                event -> eliminarProductor()
        );


        HBox formulario = new HBox(
                10,
                txtNombre,
                txtApellido,
                txtDni,
                txtTelefono,
                txtDireccion,
                btnRegistrar,
                btnActualizar,
                btnEliminar
        );

        formulario.setAlignment(
                Pos.CENTER_LEFT
        );


        // =========================
        // TABLA
        // =========================

        configurarTabla();

        cargarProductores();


        // =========================
        // CONTENIDO
        // =========================

        VBox contenido = new VBox(
                18,
                titulo,
                descripcion,
                formulario,
                mensaje,
                tabla,
                total
        );

        contenido.setPadding(
                new Insets(30)
        );

        VBox.setVgrow(
                tabla,
                Priority.ALWAYS
        );


        // =========================
        // PANEL PRINCIPAL
        // =========================

        BorderPane principal =
                new BorderPane();

        principal.setLeft(menu);
        principal.setCenter(contenido);

        principal.setStyle(
                "-fx-background-color: #F8FAFC;"
        );


        // =========================
        // VENTANA
        // =========================

        Scene scene =
                new Scene(
                        principal,
                        1450,
                        700
                );

        stage.setTitle(
                "Chavalina - Panel de Control"
        );

        stage.setScene(scene);
        stage.show();
    }


    // =========================
    // CONFIGURAR TABLA
    // =========================

    private void configurarTabla() {

        TableColumn<Productor, Integer> colId =
                new TableColumn<>("ID");

        colId.setCellValueFactory(
                new PropertyValueFactory<>(
                        "idProductor"
                )
        );


        TableColumn<Productor, String> colNombre =
                new TableColumn<>("Nombre");

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>(
                        "nombre"
                )
        );


        TableColumn<Productor, String> colApellido =
                new TableColumn<>("Apellido");

        colApellido.setCellValueFactory(
                new PropertyValueFactory<>(
                        "apellido"
                )
        );


        TableColumn<Productor, String> colDni =
                new TableColumn<>("DNI");

        colDni.setCellValueFactory(
                new PropertyValueFactory<>(
                        "dni"
                )
        );


        TableColumn<Productor, String> colTelefono =
                new TableColumn<>("Teléfono");

        colTelefono.setCellValueFactory(
                new PropertyValueFactory<>(
                        "telefono"
                )
        );


        TableColumn<Productor, String> colDireccion =
                new TableColumn<>("Dirección");

        colDireccion.setCellValueFactory(
                new PropertyValueFactory<>(
                        "direccion"
                )
        );


        TableColumn<Productor, Timestamp> colFecha =
                new TableColumn<>("Fecha");

        colFecha.setCellValueFactory(
                new PropertyValueFactory<>(
                        "fechaRegistro"
                )
        );


        tabla.getColumns().addAll(
                colId,
                colNombre,
                colApellido,
                colDni,
                colTelefono,
                colDireccion,
                colFecha
        );

        tabla.setItems(datos);

        tabla.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );


        // =========================
        // SELECCIONAR PRODUCTOR
        // =========================

        tabla.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, anterior, seleccionado) -> {

                            if (seleccionado != null) {

                                productorSeleccionado =
                                        seleccionado;

                                txtNombre.setText(
                                        seleccionado.getNombre()
                                );

                                txtApellido.setText(
                                        seleccionado.getApellido()
                                );

                                txtDni.setText(
                                        seleccionado.getDni()
                                );

                                txtTelefono.setText(
                                        seleccionado.getTelefono()
                                );

                                txtDireccion.setText(
                                        seleccionado.getDireccion()
                                );

                                mensaje.setText(
                                        "Productor seleccionado: ID "
                                                + seleccionado.getIdProductor()
                                );

                                mensaje.setStyle(
                                        "-fx-text-fill: #2563EB;" +
                                                "-fx-font-weight: bold;"
                                );
                            }
                        }
                );
    }


    // =========================
    // REGISTRAR
    // =========================

    private void registrarProductor() {

        mensaje.setText("");

        String nombre =
                txtNombre.getText().trim();

        String apellido =
                txtApellido.getText().trim();

        String dni =
                txtDni.getText().trim();

        String telefono =
                txtTelefono.getText().trim();

        String direccion =
                txtDireccion.getText().trim();


        if (nombre.isEmpty()
                || apellido.isEmpty()
                || dni.isEmpty()
                || direccion.isEmpty()) {

            mostrarError(
                    "Complete los campos obligatorios."
            );

            return;
        }


        if (!dni.matches("\\d{8}")) {

            mostrarError(
                    "El DNI debe tener 8 dígitos."
            );

            return;
        }


        if (!telefono.isEmpty()
                && !telefono.matches("\\d{9}")) {

            mostrarError(
                    "El teléfono debe tener 9 dígitos."
            );

            return;
        }


        boolean registrado =
                controller.registrarProductor(
                        nombre,
                        apellido,
                        dni,
                        telefono,
                        direccion
                );


        if (registrado) {

            mensaje.setText(
                    "Productor registrado correctamente."
            );

            mensaje.setStyle(
                    "-fx-text-fill: #16A34A;" +
                            "-fx-font-weight: bold;"
            );

            limpiarCampos();

            cargarProductores();

        } else {

            mostrarError(
                    "No se pudo registrar. El DNI puede estar repetido."
            );
        }
    }


    // =========================
    // ACTUALIZAR
    // =========================

    private void actualizarProductor() {

        if (productorSeleccionado == null) {

            mostrarError(
                    "Seleccione un productor de la tabla."
            );

            return;
        }


        String nombre =
                txtNombre.getText().trim();

        String apellido =
                txtApellido.getText().trim();

        String dni =
                txtDni.getText().trim();

        String telefono =
                txtTelefono.getText().trim();

        String direccion =
                txtDireccion.getText().trim();


        if (nombre.isEmpty()
                || apellido.isEmpty()
                || dni.isEmpty()
                || direccion.isEmpty()) {

            mostrarError(
                    "Complete los campos obligatorios."
            );

            return;
        }


        if (!dni.matches("\\d{8}")) {

            mostrarError(
                    "El DNI debe tener 8 dígitos."
            );

            return;
        }


        if (!telefono.isEmpty()
                && !telefono.matches("\\d{9}")) {

            mostrarError(
                    "El teléfono debe tener 9 dígitos."
            );

            return;
        }


        boolean actualizado =
                controller.actualizarProductor(
                        productorSeleccionado.getIdProductor(),
                        nombre,
                        apellido,
                        dni,
                        telefono,
                        direccion
                );


        if (actualizado) {

            mensaje.setText(
                    "Productor actualizado correctamente."
            );

            mensaje.setStyle(
                    "-fx-text-fill: #2563EB;" +
                            "-fx-font-weight: bold;"
            );

            limpiarCampos();

            cargarProductores();

            productorSeleccionado = null;

            tabla.getSelectionModel().clearSelection();

        } else {

            mostrarError(
                    "No se pudo actualizar el productor."
            );
        }
    }


    // =========================
    // ELIMINAR
    // =========================

    private void eliminarProductor() {

        if (productorSeleccionado == null) {

            mostrarError(
                    "Seleccione un productor de la tabla."
            );

            return;
        }


        Alert confirmacion =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        confirmacion.setTitle(
                "Confirmar eliminación"
        );

        confirmacion.setHeaderText(
                "Eliminar productor"
        );

        confirmacion.setContentText(
                "¿Está seguro de eliminar al productor "
                        + productorSeleccionado.getNombre()
                        + " "
                        + productorSeleccionado.getApellido()
                        + "?"
        );


        ButtonType respuesta =
                confirmacion.showAndWait()
                        .orElse(ButtonType.CANCEL);


        if (respuesta == ButtonType.OK) {

            boolean eliminado =
                    controller.eliminarProductor(
                            productorSeleccionado.getIdProductor()
                    );


            if (eliminado) {

                mensaje.setText(
                        "Productor eliminado correctamente."
                );

                mensaje.setStyle(
                        "-fx-text-fill: #DC2626;" +
                                "-fx-font-weight: bold;"
                );

                limpiarCampos();

                cargarProductores();

                productorSeleccionado = null;

                tabla.getSelectionModel()
                        .clearSelection();

            } else {

                mostrarError(
                        "No se pudo eliminar el productor."
                );
            }
        }
    }


    // =========================
    // CARGAR PRODUCTORES
    // =========================

    private void cargarProductores() {

        datos.setAll(
                controller.obtenerProductores()
        );

        total.setText(
                "Total de productores: "
                        + datos.size()
        );
    }


    // =========================
    // LIMPIAR CAMPOS
    // =========================

    private void limpiarCampos() {

        txtNombre.clear();
        txtApellido.clear();
        txtDni.clear();
        txtTelefono.clear();
        txtDireccion.clear();

        txtNombre.requestFocus();
    }


    // =========================
    // MOSTRAR ERROR
    // =========================

    private void mostrarError(String texto) {

        mensaje.setText(texto);

        mensaje.setStyle(
                "-fx-text-fill: #DC2626;" +
                        "-fx-font-weight: bold;"
        );
    }
}