package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicionDAO {
    String Lista_Medicion = "SELECT * FROM tipo_medida"; 
    Connection conexion;
    
    public MedicionDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Medicion> listaMedicion(){
        PreparedStatement ps;
        ResultSet rs;
        List<Medicion> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(Lista_Medicion);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                Medicion medicion = new Medicion(id, descripcion);
                lista.add(medicion);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
