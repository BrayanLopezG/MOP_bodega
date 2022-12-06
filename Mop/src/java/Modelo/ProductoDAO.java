package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    String Auto_ID = "SELECT COUNT(idProducto) FROM producto";
    String lista_producto = "SELECT * FROM producto";
    String agregar_producto = "INSERT INTO producto(idProducto,descripcion,estado,fecha_ingreso,tipo_medida_id,factura_id,bodega_id) VALUES(?,?,?,?,?,?,?)";
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
    /* terminar funcion primero terminar el insertar */
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
    public boolean agregarProducto(Producto producto){
        PreparedStatement ps;
        int id = AutoID();
        try {
            ps = conexion.prepareStatement(agregar_producto);
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
