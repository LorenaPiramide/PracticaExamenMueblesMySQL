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
    public void guardaMueble(Mueble mueble) {

        try {
            String query = "INSERT INTO Mueble (nombre, descripcion, precio, estado_mueble) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, mueble.getNombre());
            ps.setString(2, mueble.getDescripcion());
            ps.setDouble(3, mueble.getPrecio());
            ps.setString(4, String.valueOf(mueble.getEstadoMueble()));
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
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        EstadoMueble.valueOf(rs.getString("estado_mueble")) //.toUpperCase()
                );
                muebles.add(mueble);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return muebles;
    }
//
//    @Override
//    public List<Mueble> getMuebleTienda() {
//        return List.of();
//    }
//
//    @Override
//    public List<Mueble> filtrarPorTienda(String nombreTienda) {
//        return List.of();
//    }
//
//    @Override
//    public List<Mueble> filtrarPorEstado(EstadoMueble estadoMueble) {
//        return List.of();
//    }
//
//    @Override
//    public List<Mueble> ordenarPorPrecio(double precio) {
//        return List.of();
//    }

    // Consulta con JOIN ejemplo (N:M mostrar tod0)
    // SELECT
    //  e.nombre AS Estudiante,
    //  a.nombre AS Asignatura
    //FROM Matriculas m
    //JOIN Estudiantes e ON m.id_estudiante = e.id_estudiante
    //JOIN Asignaturas a ON m.id_asignatura = a.id_asignatura;
}
