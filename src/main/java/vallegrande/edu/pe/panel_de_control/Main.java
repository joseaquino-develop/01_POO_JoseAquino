package vallegrande.edu.pe.panel_de_control;

import javafx.application.Application;
import javafx.stage.Stage;

import vallegrande.edu.pe.panel_de_control.view.MainView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        MainView view = new MainView();

        view.mostrar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}