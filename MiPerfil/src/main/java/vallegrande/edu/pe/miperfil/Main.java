package vallegrande.edu.pe.miperfil;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                Main.class.getResource(
                        "/vallegrande/edu/pe/miperfil/hello-view.fxml"
                )
        );

        Scene scene = new Scene(fxmlLoader.load(), 800, 650);

        stage.setTitle("Mi Perfil - POO con Java");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
