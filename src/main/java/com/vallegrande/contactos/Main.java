package com.vallegrande.contactos;

import com.vallegrande.contactos.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

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