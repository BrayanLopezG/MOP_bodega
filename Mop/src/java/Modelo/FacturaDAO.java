package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    String Auto_ID = "SELECT COUNT(idFactura) FROM factura";
    String ID_provedor = "SELECT idProveedor FROM proveedor WHERE rut_proveedor = ?";
    String nueva_factura = "INSERT INTO factura (idFactura,nro_factura,orden_compra,fecha_factura,archivo_factura,proveedor_id) VALUES(?,?,?,?,?,?)";
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
                int proveedor = rs.getInt(5);
                String archivo_factura = rs.getString(6);
                Factura factura = new Factura(id, proveedor, nro_factura, orden_compra, fecha, archivo_factura);
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
                String orden_compra = rs.getString(3);
                String fecha = rs.getString(4);
                int proveedor = rs.getInt(5);
                String archivo_factura = rs.getString(6);
                factura = new Factura(id, proveedor, nro_factura, orden_compra,fecha,archivo_factura);
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
        int id = AutoID();
        int id_proveedor = ID_proveedor(rut);
        try {
            ps = conexion.prepareStatement(nueva_factura);
            ps.setInt(1, id);
            ps.setString(2, factura.getNro_factura());
            ps.setString(3, factura.getOrden_compra());
            ps.setString(4, factura.getFecha_factura());
            ps.setString(5, factura.getArchivo_factura());
            ps.setInt(6, id_proveedor);
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
