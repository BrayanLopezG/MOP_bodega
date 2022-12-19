package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    String Auto_ID = "SELECT COUNT(idFactura) FROM factura";
    String ID_provedor = "SELECT idProveedor FROM proveedor WHERE rut_proveedor = ?";
    String nueva_factura = "INSERT INTO factura (idFactura,nro_factura,orden_compra,fecha_factura,archivo_factura,proveedor_id) VALUES(?,?,?,?,?,?)";
    String filtro_factura = "SELECT idFactura, nro_factura, orden_compra FROM factura WHERE orden_compra = ?";
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
    public int ID_proveedor(String rut){
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = conexion.prepareStatement(ID_provedor);
            ps.setString(1,rut);
            rs = ps.executeQuery();
            while(rs.next()){
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
                String orden_compra = rs.getString(3);
                String fecha = rs.getString(4);
                byte[] archivo_factura = rs.getBytes(5);
                byte[] archivo_orden = rs.getBytes(6);
                int proveedor = rs.getInt(7);
                Factura factura = new Factura(id, proveedor, nro_factura, orden_compra, fecha, archivo_factura,archivo_orden);
                lista.add(factura);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Factura filtroFactura(String ordencompra){
        PreparedStatement ps;
        ResultSet rs;
        Factura factura = null;
        try {
            ps = conexion.prepareStatement(filtro_factura);
            ps.setString(1, ordencompra);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idFactura");
                String nro_factura = rs.getString("nro_factura");
                String orden_compra = rs.getString("orden_compra");
                factura = new Factura(id, nro_factura, orden_compra);
            }
            ps.close();
            rs.close();
            return factura;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public boolean nuevaFactura(Factura factura, String rut){
        PreparedStatement ps;
        int id = AutoID() + 1;
        int id_proveedor = ID_proveedor(rut);
        try {
            ps = conexion.prepareStatement(nueva_factura);
            ps.setInt(1, id);
            ps.setString(2, factura.getNro_factura());
            ps.setString(3, factura.getOrden_compra());
            ps.setString(4, factura.getFecha_factura());
            ps.setBlob(5, factura.getFacturapdf());
            ps.setBlob(6, factura.getOrden_comprapdf());
            ps.setInt(7, id_proveedor);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
