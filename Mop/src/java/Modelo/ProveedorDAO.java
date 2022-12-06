package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    String Auto_ID = "SELECT COUNT(idProveedor) FROM proveedor";
    String insertar_proveedor = "INSERT INTO proveedor(idProveedor,rut_proveedor,nombre_proveedor,telefono_proveedor,direccion_proveedor) VALUES(?,?,?,?,?)";
    String lista_proveedores = "SELECT idProveedor,rut_proveedor,nombre_proveedor,telefono_proveedor,direccion_proveedor FROM proveedor";
    String busqueda_rut_proveedor = "SELECT * FROM proveedor WHERE rut_proveedor = (?)";
    
    Connection conexion;
    
    public ProveedorDAO(){
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
                id = rs.getInt("COUNT(idProveedor)");
            }
            ps.close();
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return id;
        } 
    }
    
    public boolean nuevoProveedor(Proveedor proveedor){
        PreparedStatement ps;
        int id = AutoID();
        try {
            ps = conexion.prepareStatement(insertar_proveedor);
            ps.setInt(1, id);
            ps.setString(2, proveedor.getRut_proveedor());
            ps.setString(3, proveedor.getNombre_proveedor());
            ps.setString(4, proveedor.getTelefono_proveedor());
            ps.setString(5, proveedor.getDireccion_proveedor());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List<Proveedor> listaProveedor(){
        PreparedStatement ps;
        ResultSet rs;
        List<Proveedor> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_proveedores);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idProveedor");
                String rut = rs.getString("rut_proveedor");
                String nombre = rs.getString("nombre_proveedor");
                String telefono = rs.getString("telefono_proveedor");
                String direccion = rs.getString("direccion_proveedor");
                Proveedor proveedor = new Proveedor(id, rut, nombre, telefono, direccion);
                lista.add(proveedor);
            }
            ps.close();
            rs.close();
            return lista;     
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Proveedor filtroProveedor(String rut){
        PreparedStatement ps;
        ResultSet rs;
        Proveedor proveedor = null;
        try {
            ps = conexion.prepareStatement(busqueda_rut_proveedor);
            ps.setString(1, rut);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String rut_proveedor = rs.getString(2);
                String nombre = rs.getString(3);
                String telefono = rs.getString(4);
                String direccion = rs.getString(5);
                proveedor = new Proveedor(id, rut_proveedor, nombre, telefono, direccion);
            }
            ps.close();
            rs.close();
            return proveedor;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
