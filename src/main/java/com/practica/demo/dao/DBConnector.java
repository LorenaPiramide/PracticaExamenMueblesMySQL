package com.practica.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection;

    public DBConnector() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://coches-prueba.cx0imquaojhi.us-east-1.rds.amazonaws.com:3306/Actividad1",
                        "admin", "QTSiGwgBkgPb94");
                System.out.println("Conexión correcta");
            } catch (SQLException e) {
                System.out.println("Conexión fallida.");
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
