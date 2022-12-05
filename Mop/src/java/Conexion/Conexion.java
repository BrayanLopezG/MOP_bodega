package Conexion;

import java.sql.*;

public class Conexion {
    
    public static Connection getConexion() {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mop","root","");
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}