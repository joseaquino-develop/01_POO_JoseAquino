package vallegrande.edu.pe.miperfil.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class PerfilView {

    private Scene scene;

    public PerfilView() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/vallegrande/edu/pe/miperfil/hello-view.fxml"
                    )
            );

            Parent root = loader.load();

            scene = new Scene(root, 800, 650);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
