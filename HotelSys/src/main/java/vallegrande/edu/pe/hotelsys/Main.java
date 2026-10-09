package vallegrande.edu.pe.hotelsys;

import javafx.application.Application;
import javafx.stage.Stage;
import vallegrande.edu.pe.hotelsys.view.HotelView;

public class Main {

    public static void main(String[] args) {
        Application.launch(HotelApp.class, args);
    }

    public static class HotelApp extends Application {

        @Override
        public void start(Stage primaryStage) {

            HotelView hotelView = new HotelView();

            hotelView.mostrar(primaryStage);
        }
    }
}