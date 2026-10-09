package vallegrande.edu.pe.panel_control.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductorDAO {

    // =========================
    // LISTAR PRODUCTORES
    // =========================

    public List<Productor> listarProductores() {

        List<Productor> lista =
                new ArrayList<>();

        String sql =
                "SELECT id_producer, first_name, last_name, dni, " +
                        "phone, address, created_at " +
                        "FROM producers ORDER BY id_producer";

        Connection conexion =
                Conexion.conectar();

        if (conexion == null) {
            return lista;
        }

        try {

            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            ResultSet resultado =
                    statement.executeQuery();

            while (resultado.next()) {

                Productor productor =
                        new Productor(
                                resultado.getInt(
                                        "id_producer"
                                ),
                                resultado.getString(
                                        "first_name"
                                ),
                                resultado.getString(
                                        "last_name"
                                ),
                                resultado.getString(
                                        "dni"
                                ),
                                resultado.getString(
                                        "phone"
                                ),
                                resultado.getString(
                                        "address"
                                ),
                                resultado.getTimestamp(
                                        "created_at"
                                )
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

            System.out.println(
                    e.getMessage()
            );
        }

        return lista;
    }


    // =========================
    // REGISTRAR PRODUCTOR
    // =========================

    public boolean registrarProductor(
            Productor productor
    ) {

        String sql =
                "INSERT INTO producers " +
                        "(first_name, last_name, dni, phone, address) " +
                        "VALUES (?, ?, ?, ?, ?)";

        Connection conexion =
                Conexion.conectar();

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

            int filas =
                    statement.executeUpdate();

            statement.close();
            conexion.close();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar productor:"
            );

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }


    // =========================
    // ACTUALIZAR PRODUCTOR
    // =========================

    public boolean actualizarProductor(
            int id,
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String direccion
    ) {

        String sql =
                "UPDATE producers SET " +
                        "first_name = ?, " +
                        "last_name = ?, " +
                        "dni = ?, " +
                        "phone = ?, " +
                        "address = ? " +
                        "WHERE id_producer = ?";

        Connection conexion =
                Conexion.conectar();

        if (conexion == null) {
            return false;
        }

        try {

            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            statement.setString(
                    1,
                    nombre
            );

            statement.setString(
                    2,
                    apellido
            );

            statement.setString(
                    3,
                    dni
            );

            statement.setString(
                    4,
                    telefono
            );

            statement.setString(
                    5,
                    direccion
            );

            statement.setInt(
                    6,
                    id
            );

            int filas =
                    statement.executeUpdate();

            statement.close();
            conexion.close();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al actualizar productor:"
            );

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }


    // =========================
    // ELIMINAR PRODUCTOR
    // =========================

    public boolean eliminarProductor(
            int id
    ) {

        String sql =
                "DELETE FROM producers " +
                        "WHERE id_producer = ?";

        Connection conexion =
                Conexion.conectar();

        if (conexion == null) {
            return false;
        }

        try {

            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            statement.setInt(
                    1,
                    id
            );

            int filas =
                    statement.executeUpdate();

            statement.close();
            conexion.close();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al eliminar productor:"
            );

            System.out.println(
                    e.getMessage()
            );

            return false;
        }
    }
}