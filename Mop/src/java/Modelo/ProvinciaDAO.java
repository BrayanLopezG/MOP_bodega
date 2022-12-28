package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDAO {
    String Auto_ID = "SELECT COUNT(idProvincia) FROM provincia";
    String provincias = "SELECT idProvincia,nombre_provincia FROM provincia";
    String nueva_provincia = "INSERT INTO provincia(idProvincia,nombre_provincia) VALUES(?,?)";
    Connection conexion;
    
    public ProvinciaDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    public int AutoID(){
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = conexion.prepareStatement(Auto_ID);
            rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }
            ps.close();
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return id;
        }
    }
    public List<Provincia> provincias(){
        PreparedStatement ps;
        ResultSet rs;
        List<Provincia> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(provincias);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                Provincia provincia = new Provincia(id, nombre);
                lista.add(provincia);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public boolean Insertar(Provincia provincia) {
        PreparedStatement ps;
        int id = AutoID() + 1;
        try {
            ps = conexion.prepareStatement(nueva_provincia);
            ps.setInt(1,id);
            ps.setString(2, provincia.getNom_provincia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
