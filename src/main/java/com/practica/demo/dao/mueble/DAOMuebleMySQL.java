package com.practica.demo.dao.mueble;

import com.practica.demo.dao.DBConnector;
import com.practica.demo.entidades.EstadoMueble;
import com.practica.demo.entidades.Mueble;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMuebleMySQL implements DAOMueble {
    @Override
    public void addMueble(String nombre, double precio) {

        try {
            String query = "INSERT INTO Mueble (nombre, precio, estado_mueble) VALUES (?, ?)";
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Mueble> getMuebles() {
        List<Mueble> muebles = new ArrayList<>();

        try {
            String query = "SELECT * FROM Mueble";
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mueble mueble = new Mueble(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        EstadoMueble.valueOf(rs.getString("estado_mueble").toUpperCase())
                );
                muebles.add(mueble);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return muebles;
    }
}
