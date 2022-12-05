package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    String Auto_ID = "SELECT COUNT(idFactura) FROM factura";
    String nueva_factura = "INSERT INTO factura (idFactura,nro_factura,cantidad,fecha_factura,proveedor_id) VALUES(?,?,?,?,?)";
    String filtro_factura = "SELECT * FROM factura WHERE nro_factura = ?";
    String lista_factura = "SELECT * FROM factura";

    Connection conexion;
    
    public FacturaDAO(){
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
                id = rs.getInt("COUNT(idFactura)");
            }
            ps.close();
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return id;
        } 
    }
    public List<Factura> listaFactura(){
        PreparedStatement ps;
        ResultSet rs;
        List<Factura> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_factura);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nro_factura = rs.getString(2);
                int cantidad = rs.getInt(3);
                String fecha = rs.getString(4);
                int proveedor = rs.getInt(5);
                Factura factura = new Factura(id, cantidad, proveedor, nro_factura,fecha);
                lista.add(factura);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Factura filtroFactura(String filtro_facturas){
        PreparedStatement ps;
        ResultSet rs;
        Factura factura = null;
        try {
            ps = conexion.prepareStatement(filtro_factura);
            ps.setString(1,filtro_facturas);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nro_factura = rs.getString(2);
                int cantidad = rs.getInt(3);
                String fecha = rs.getString(4);
                int proveedor = rs.getInt(5);
                factura = new Factura(id, cantidad, proveedor, nro_factura,fecha);
            }
            ps.close();
            rs.close();
            return factura;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public boolean nuevaFactura(Factura factura){
        PreparedStatement ps;
        int id = AutoID();
        try {
            ps = conexion.prepareStatement(nueva_factura);
            ps.setInt(1, id);
            ps.setString(2, factura.getNro_factura());
            ps.setInt(3, factura.getValor());
            ps.setString(4, factura.getFecha_factura());
            ps.setInt(5, factura.getProveedor_id());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
