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
    public void guardaMueble(String nombre, String descripcion, double precio, EstadoMueble estadoMueble) {

        try {
            String query = "INSERT INTO Mueble (nombre, descripcion, precio, estado_mueble) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setString(4, String.valueOf(estadoMueble));
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

    @Override
    public Mueble getDetallesMueble(int id) {

        Mueble mueble = null;

        try {
            String query = "SELECT * FROM Mueble WHERE id = ?";
            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mueble = new Mueble(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        EstadoMueble.valueOf(rs.getString("estado_mueble"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mueble;
    }

//    @Override
//    public void actualizarMueble(int id, String nombre, String descripcion, double precio, EstadoMueble estadoMueble) {
//        try {
//            String query = """
//            UPDATE Mueble
//            SET nombre = ?, descripcion = ?, precio = ?, estado_mueble = ?
//            WHERE id = ?
//        """;
//            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
//            ps.setString(1, nombre);
//            ps.setString(2, descripcion);
//            ps.setDouble(3, precio);
//            ps.setString(4, estadoMueble.name());
//            ps.setInt(5, id);
//            ps.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    public List<Mueble> getMueblesConTienda() {
//        List<Mueble> muebles = new ArrayList<>();
//        try {
//            String query = """
//            SELECT
//                m.id,
//                m.nombre,
//                m.descripcion,
//                m.precio,
//                m.estado_mueble,
//                t.nombre_tienda
//            FROM Mueble m
//            LEFT JOIN MuebleTienda mt ON m.id = mt.fk_mueble_id
//            LEFT JOIN Tienda t ON mt.fk_nombre_tienda = t.nombre_tienda
//            ORDER BY m.id
//            """;
//            PreparedStatement ps = DBConnector.getInstance().prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Mueble mueble = new Mueble();
//                mueble.setId(rs.getInt("id"));
//                mueble.setNombre(rs.getString("nombre"));
//                mueble.setDescripcion(rs.getString("descripcion"));
//                mueble.setPrecio(rs.getDouble("precio"));
//                mueble.setEstadoMueble(EstadoMueble.valueOf(rs.getString("estado_mueble")));
//                mueble.setNombreTienda(rs.getString("nombre_tienda"));
//
//                muebles.add(mueble);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return muebles;
//    }


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
