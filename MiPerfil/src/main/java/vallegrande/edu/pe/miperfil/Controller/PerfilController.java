package vallegrande.edu.pe.miperfil.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vallegrande.edu.pe.miperfil.model.Perfil;

public class PerfilController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCarrera;

    @FXML
    private ComboBox<String> cmbSemestre;

    @FXML
    private TextField txtDato;

    @FXML
    private Label lblMensaje;

    @FXML
    private Button btnConfirmar;


    @FXML
    public void initialize() {

        cmbSemestre.getItems().addAll(
                "I Semestre",
                "II Semestre",
                "III Semestre",
                "IV Semestre",
                "V Semestre",
                "VI Semestre",
                "VII Semestre",
                "VIII Semestre",
                "IX Semestre",
                "X Semestre"
        );
    }


    @FXML
    private void confirmarPerfil() {

        String nombre = txtNombre.getText().trim();
        String carrera = txtCarrera.getText().trim();
        String semestre = cmbSemestre.getValue();
        String dato = txtDato.getText().trim();


        // Validación de campos obligatorios

        if (nombre.isEmpty() ||
                carrera.isEmpty() ||
                semestre == null ||
                dato.isEmpty()) {

            lblMensaje.setText(
                    "⚠ Completa todos los campos obligatorios."
            );

            lblMensaje.getStyleClass().removeAll("mensaje-exito");
            lblMensaje.getStyleClass().add("mensaje-error");

            return;
        }


        // Crear objeto Perfil

        Perfil perfil = new Perfil(
                nombre,
                carrera,
                semestre,
                dato
        );


        // Mostrar información en consola

        perfil.mostrarPerfil();


        // Mostrar mensaje en pantalla

        lblMensaje.setText(
                "✓ ¡Perfil registrado correctamente, " + nombre + "!"
        );

        lblMensaje.getStyleClass().removeAll("mensaje-error");
        lblMensaje.getStyleClass().add("mensaje-exito");
    }
}