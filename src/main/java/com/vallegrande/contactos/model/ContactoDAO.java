package com.vallegrande.contactos.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    public List<Contacto> listarContactos() {

        List<Contacto> contactos = new ArrayList<>();

        String sql = "SELECT * FROM contactos";

        try (
                Connection conexion = Conexion.conectar();
                PreparedStatement statement = conexion.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery()
        ) {

            while (resultado.next()) {

                Contacto contacto = new Contacto(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("email"),
                        resultado.getString("asunto"),
                        resultado.getString("mensaje"),
                        resultado.getTimestamp("creado_en")
                );

                contactos.add(contacto);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los contactos.");
            System.out.println(e.getMessage());
        }

        return contactos;
    }
}