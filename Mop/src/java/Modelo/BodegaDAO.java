package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BodegaDAO {

    String Auto_ID = "SELECT COUNT(idBodega) FROM bodega";
    String Lista_bodega = "SELECT idBodega,nombre_bodega,direccion_bodega FROM bodega";
    String agregar_bodega = "INSERT INTO bodega (idBodega,nombre_bodega,direccion_bodega) VALUES(?,?,?)";
    Connection conexion;

    public BodegaDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    /* Genera el auto incremetable del producto
     */
    public int AutoID() {
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = conexion.prepareStatement(Auto_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
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
    /* Funcion para listar las bodegas 
    */

    public List<Bodega> listaBodega() {
        PreparedStatement ps;
        ResultSet rs;
        List<Bodega> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(Lista_bodega);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                Bodega bodega = new Bodega(id, nombre, direccion);
                lista.add(bodega);
            }
            ps.close();
            rs.close();
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    /* Funcion para agregar una nueva bodega
    */
    public boolean Insertar(Bodega bodega) {
        PreparedStatement ps;
        int id = AutoID() + 1;
        try {
            ps = conexion.prepareStatement(agregar_bodega);
            ps.setInt(1, id);
            ps.setString(2, bodega.getNombre_bodega());
            ps.setString(3, bodega.getDireccion_bodega());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
