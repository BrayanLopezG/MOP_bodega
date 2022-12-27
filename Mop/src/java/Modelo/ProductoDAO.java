package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    String Auto_ID = "SELECT COUNT(idProducto) FROM producto";
    String buscar_producto = "SELECT * FROM producto WHERE idProducto = ?";
    String actualizar_stock = "UPDATE producto set cantidad = ? WHERE idProducto = ?";
    String producto_factura = "SELECT producto.idProducto, producto.descripcion, producto.cantidad, producto.departamento, factura.orden_compra, bodega.nombre_bodega, tipo_medida.descripcion_medida FROM producto JOIN factura ON producto.factura_id = factura.idFactura JOIN bodega ON producto.bodega_id = bodega.idBodega JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida WHERE factura_id = ?";
    String agregar_producto = "INSERT INTO producto(idProducto,descripcion,cantidad,departamento,factura_id,bodega_id,tipo_medida_id) VALUES(?,?,?,?,?,?,?)";
    String borrar_producto = "DELETE FROM producto WHERE idProducto = ?";
    String productos_departamentos = "SELECT producto.descripcion, tipo_medida.descripcion_medida,sum(producto.cantidad),bodega.nombre_bodega FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega WHERE producto.departamento = ? GROUP BY producto.descripcion,tipo_medida.descripcion_medida,bodega.nombre_bodega";
    String productos_admin = "SELECT producto.descripcion, tipo_medida.descripcion_medida,sum(producto.cantidad),bodega.nombre_bodega FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega GROUP BY producto.descripcion,tipo_medida.descripcion_medida,bodega.nombre_bodega";
    String lista_producto_departamento = "SELECT producto.idProducto, producto.descripcion, tipo_medida.descripcion_medida, producto.cantidad,bodega.nombre_bodega,factura.orden_compra FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega JOIN factura ON producto.factura_id = factura.idFactura WHERE producto.departamento = ?";
    String lista_producto_admin = "SELECT producto.idProducto, producto.descripcion, tipo_medida.descripcion_medida, producto.cantidad,bodega.nombre_bodega,factura.orden_compra FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega JOIN factura ON producto.factura_id = factura.idFactura";
    String lista_producto_id = "SELECT producto.idProducto, producto.descripcion, tipo_medida.descripcion_medida, producto.cantidad,bodega.nombre_bodega FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega WHERE producto.idProducto = ?";
    Connection conexion;

    public ProductoDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

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

    public List<Producto> productosDepto(String depto) {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(productos_departamentos);
            ps.setString(1, depto);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public List listaproductofactura(int idfactura) {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(producto_factura);
            ps.setInt(1, idfactura);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public List<Producto> productosAdmin() {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(productos_admin);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public List<Producto> listaproductoDepto(String depto) {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_producto_departamento);
            ps.setString(1, depto);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom_producto = rs.getString(2);
                String medida = rs.getString(3);
                String cantidad = rs.getString(4);
                String bodega = rs.getString(5);
                String orden_compra = rs.getString(6);
                Producto producto = new Producto(id, nom_producto, cantidad, bodega, medida, orden_compra);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<Producto> listaproductoAdmin() {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_producto_admin);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom_producto = rs.getString(2);
                String medida = rs.getString(3);
                String cantidad = rs.getString(4);
                String bodega = rs.getString(5);
                String orden_compra = rs.getString(6);
                Producto producto = new Producto(id, nom_producto, cantidad, bodega, medida, orden_compra);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<Producto> buscarproductoAdmin(String filtro) {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement("SELECT producto.idProducto, producto.descripcion, tipo_medida.descripcion_medida, producto.cantidad,bodega.nombre_bodega, factura.orden_compra FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega JOIN factura ON producto.factura_id = factura.idFactura WHERE producto.descripcion LIKE '%" + filtro + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom_producto = rs.getString(2);
                String medida = rs.getString(3);
                String cantidad = rs.getString(4);
                String bodega = rs.getString(5);
                String orden_compra = rs.getString(6);
                Producto producto = new Producto(id, nom_producto, cantidad, bodega, medida,orden_compra);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public List<Producto> buscarproductoDepto(String filtro, String depto) {
        PreparedStatement ps;
        ResultSet rs;
        List<Producto> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement("SELECT producto.idProducto, producto.descripcion, tipo_medida.descripcion_medida, producto.cantidad,bodega.nombre_bodega, factura.orden_compra FROM producto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida JOIN bodega ON producto.bodega_id = bodega.idBodega JOIN factura ON producto.factura_id = factura.idFactura WHERE producto.departamento = ? AND producto.descripcion LIKE '%" + filtro + "%'");
            ps.setString(1, depto);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom_producto = rs.getString(2);
                String medida = rs.getString(3);
                String cantidad = rs.getString(4);
                String bodega = rs.getString(5);
                String orden_compra = rs.getString(6);
                Producto producto = new Producto(id, nom_producto, cantidad, bodega, medida, orden_compra);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Producto productoSeleccionado(int idproducto){
        PreparedStatement ps;
        ResultSet rs;
        Producto producto = null;
        try {
            ps = conexion.prepareStatement(lista_producto_id);
            ps.setInt(1, idproducto);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                String medida = rs.getString(3);
                String cantidad = rs.getString(4);
                String bodega = rs.getString(5);
                producto = new Producto(id, descripcion, cantidad, bodega, medida);
            }
            return producto;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean agregarProducto(Producto producto) {
        PreparedStatement ps;
        int id = AutoID() + 1;
        try {
            ps = conexion.prepareStatement(agregar_producto);
            ps.setInt(1, id);
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCantidad());
            ps.setString(4, producto.getDepartamento());
            ps.setInt(5, producto.getFacturaid());
            ps.setInt(6, producto.getBodegaid());
            ps.setInt(7, producto.getMedida_id());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void eliminarProducto(int idproducto) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(borrar_producto);
            ps.setInt(1, idproducto);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public Producto buscar(int id){
        PreparedStatement ps;
        ResultSet rs;
        Producto producto = null;
        try {
            ps = conexion.prepareStatement(buscar_producto);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int idproducto = rs.getInt(1);
                String nombre = rs.getString(2);
                String cantidad =  rs.getString(3);
                String departamento = rs.getString(4);
                int medida = rs.getInt(5);
                int factura = rs.getInt(6);
                int bodega = rs.getInt(7);
                producto = new Producto(idproducto, factura, medida, bodega, departamento, cantidad, departamento);
            }
            ps.close();
            rs.close();
            return producto;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public int actualizarStock(int id, int cantidad){
        PreparedStatement ps;
        int ac = 0;
        try {
            ps = conexion.prepareStatement(actualizar_stock);
            ps.setInt(1, cantidad);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            return ac;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return ac;
        }
    }
}
