package vallegrande.edu.pe.panel_control.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/chavalina_db" +
                    "?useSSL=false" +
                    "&allowPublicKeyRetrieval=true" +
                    "&serverTimezone=America/Lima";

    private static final String USUARIO = "root";

    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    public static Connection conectar() {

        try {

            Connection conexion = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    PASSWORD
            );

            System.out.println(
                    "Conectado correctamente a chavalina_db"
            );

            return conexion;

        } catch (SQLException e) {

            System.out.println(
                    "Error al conectar con MySQL:"
            );

            System.out.println(e.getMessage());

            return null;
        }
    }
}