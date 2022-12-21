package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDAO {
    String provincias = "SELECT idProvincia,nombre_provincia FROM provincia";
    Connection conexion;
    
    public ProvinciaDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
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
}
