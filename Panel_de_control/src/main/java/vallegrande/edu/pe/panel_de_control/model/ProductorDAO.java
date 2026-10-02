package vallegrande.edu.pe.panel_de_control.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductorDAO {

    public List<Productor> listarProductores() {

        List<Productor> lista = new ArrayList<>();

        String sql =
                "SELECT id_producer, first_name, last_name, dni, " +
                        "phone, address, created_at " +
                        "FROM producers ORDER BY id_producer";

        Connection conexion = Conexion.conectar();

        if (conexion == null) {
            return lista;
        }

        try {

            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            ResultSet resultado =
                    statement.executeQuery();

            while (resultado.next()) {

                Productor productor = new Productor(
                        resultado.getInt("id_producer"),
                        resultado.getString("first_name"),
                        resultado.getString("last_name"),
                        resultado.getString("dni"),
                        resultado.getString("phone"),
                        resultado.getString("address"),
                        resultado.getTimestamp("created_at")
                );

                lista.add(productor);
            }

            resultado.close();
            statement.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println(
                    "Error al consultar productores:"
            );

            System.out.println(e.getMessage());
        }

        return lista;
    }


    public boolean registrarProductor(Productor productor) {

        String sql =
                "INSERT INTO producers " +
                        "(first_name, last_name, dni, phone, address) " +
                        "VALUES (?, ?, ?, ?, ?)";

        Connection conexion = Conexion.conectar();

        if (conexion == null) {
            return false;
        }

        try {

            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            statement.setString(
                    1,
                    productor.getNombre()
            );

            statement.setString(
                    2,
                    productor.getApellido()
            );

            statement.setString(
                    3,
                    productor.getDni()
            );

            statement.setString(
                    4,
                    productor.getTelefono()
            );

            statement.setString(
                    5,
                    productor.getDireccion()
            );

            int filas = statement.executeUpdate();

            statement.close();
            conexion.close();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar productor:"
            );

            System.out.println(e.getMessage());

            return false;
        }
    }
}