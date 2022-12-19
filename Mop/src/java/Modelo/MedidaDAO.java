package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedidaDAO {
    String Lista_Medida = "SELECT * FROM tipo_medida";
    Connection conexion;
    
    public MedidaDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Medida> listaMedida(){
        PreparedStatement ps;
        ResultSet rs;
        List<Medida> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(Lista_Medida);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                Medida medida = new Medida(id, descripcion);
                lista.add(medida);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
