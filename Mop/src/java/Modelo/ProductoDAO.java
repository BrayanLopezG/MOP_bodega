package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    String Auto_ID = "SELECT COUNT(idProducto) FROM producto";
    String lista_producto = "SELECT * FROM producto";
    String producto_factura = "SELECT producto.idProducto, producto.descripcion, producto.cantidad, producto.departamento, factura.orden_compra, bodega.nombre_bodega, tipo_medida.descripcion_medida FROM producto JOIN factura ON producto.factura_id = factura.idFactura JOIN bodega ON producto.bodega_id = bodega.idBodega JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida WHERE factura_id = ?";
    String agregar_producto = "INSERT INTO producto(idProducto,descripcion,cantidad,departamento,factura_id,bodega_id,tipo_medida_id) VALUES(?,?,?,?,?,?,?)";
    String borrar_producto = "DELETE FROM producto WHERE idProducto = ?";
    String productos_departamentos = "SELECT producto.descripcion, tipo_medida.descripcion_medida,sum(producto.cantidad),bodega.nombre_bodega FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega WHERE producto.departamento = ? GROUP BY producto.descripcion,tipo_medida.descripcion_medida,bodega.nombre_bodega";
    String productos_admin = "SELECT producto.descripcion, tipo_medida.descripcion_medida,sum(producto.cantidad),bodega.nombre_bodega FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega GROUP BY producto.descripcion,tipo_medida.descripcion_medida,bodega.nombre_bodega";
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
    public List<Producto> productosDepto(String depto){
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(productos_departamentos);
            ps.setString(1, depto);
            rs = ps.executeQuery();
            while(rs.next()){
                String descripcion = rs.getString(1);
                String medida = rs.getString(2);
                String cantidad = rs.getString(3);
                String bodega = rs.getString(4);
                Producto producto = new Producto(descripcion, cantidad, bodega, medida);
                lista.add(producto);
            }
            return lista;
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
                System.out.println(rs);
                int idpro = rs.getInt(1);
                String descripcion = rs.getString(2);
                String cantidad = rs.getString(3);
                String departamento = rs.getString(4);
                String bodega = rs.getString(5);
                String medida = rs.getString(6);
                String ordencompra = rs.getString(7);
                Producto producto = new Producto(idpro, descripcion, cantidad, bodega, medida, departamento, ordencompra);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public List<Producto> productosAdmin(){
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(productos_admin);
            rs = ps.executeQuery();
            while(rs.next()){
                String descripcion = rs.getString(1);
                String medida = rs.getString(2);
                String cantidad = rs.getString(3);
                String bodega = rs.getString(4);
                Producto producto = new Producto(descripcion, cantidad, bodega, medida);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean agregarProducto(Producto producto){
        PreparedStatement ps;
        int id = AutoID() + 1;
        try {
            ps = conexion.prepareStatement(agregar_producto);
            ps.setInt(1,id);
            ps.setString(2,producto.getDescripcion());
            ps.setString(3,producto.getCantidad());
            ps.setString(4,producto.getDepartamento());
            ps.setInt(5,producto.getFacturaid());
            ps.setInt(6,producto.getBodegaid());
            ps.setInt(7,producto.getMedida_id());
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
