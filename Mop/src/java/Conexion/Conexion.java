package Conexion;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc://localhost:3306/mop/";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "";
    
    public static Connection getConexion(){
        try {
            Connection conexion = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            return conexion;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public static void Close(ResultSet rs){
        try {
            rs.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void Close(PreparedStatement stmnt){
        try {
            stmnt.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    public static void Close(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
