package vallegrande.edu.pe.mitarea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.mitarea.controller.MainController;
import vallegrande.edu.pe.mitarea.view.mainView;

public class main extends Application {

    @Override
    public void start(Stage stage) {

        mainView view = new mainView();

        new MainController(view);

        Scene scene = new Scene(view, 1200, 720);

        stage.setTitle("Sistema Empresarial");

        stage.setScene(scene);

        stage.setMinWidth(1050);
        stage.setMinHeight(650);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}