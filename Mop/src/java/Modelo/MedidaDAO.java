package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedidaDAO {
    String Auto_ID = "SELECT COUNT(idTipo_medida) FROM tipo_medida";
    String Lista_Medida = "SELECT * FROM tipo_medida";
    String nueva_medida = "INSERT INTO tipo_medida(idTipo_medida,descripcion_medida) VALUES(?,?)";
    Connection conexion;
    
    public MedidaDAO(){
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
    public boolean Insertar(Medida medida) {
        PreparedStatement ps;
        int id = AutoID() + 1;
        try {
            ps = conexion.prepareStatement(nueva_medida);
            ps.setInt(1,id);
            ps.setString(2, medida.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
