package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    String Auto_ID = "SELECT COUNT(idProducto) FROM producto";
    String lista_producto = "SELECT * FROM producto";
    String producto_factura = "SELECT * FROM producto WHERE factura_id = ?";
    String agregar_producto = "INSERT INTO producto(idProducto,descripcion,cantidad,factura_id,bodega_id,medida_id) VALUES(?,?,?,?,?,?)";
    String borrar_producto = "DELETE FROM producto WHERE idProducto = ?";
    BodegaDAO bodega;
    Connection conexion;
    
    public ProductoDAO(){
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
    public List<Producto> listaProducto (){
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> producto = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_producto);
            return producto;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public List listaproductofactura(int idfactura){
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(producto_factura);
            ps.setInt(1,idfactura);
            rs = ps.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdproducto(rs.getInt(1));
                producto.setDescripcion(rs.getString(2));
                producto.setCantidad(rs.getString(3));
                producto.setFacturaid(rs.getInt(4));
                producto.setBodegaid(rs.getInt(5));
                producto.setMedida_id(rs.getInt(6));
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return lista;
    }
    
    public boolean agregarProducto(Producto producto){
        PreparedStatement ps;
        ResultSet rs;
        int id = AutoID();
        try {
            ps = conexion.prepareStatement(agregar_producto);
            ps.setInt(1,id);
            ps.setString(2,producto.getDescripcion());
            ps.setString(3,producto.getCantidad());
            ps.setInt(4,producto.getFacturaid());
            ps.setInt(5,producto.getBodegaid());
            ps.setInt(6,producto.getMedida_id());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    public void eliminarProducto(int idproducto){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(borrar_producto);
            ps.setInt(1, idproducto);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }   
    }
}
