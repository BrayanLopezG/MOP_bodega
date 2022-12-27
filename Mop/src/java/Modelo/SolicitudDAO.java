package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAO {
    String Auto_ID_S = "SELECT COUNT(idSolicitud) FROM solicitud";
    String Auto_ID_D = "SELECT COUNT(idDetalle_solicitud) FROM detalle_solicitud";
    String guardar_producto = "INSERT INTO solicitud(idSolicitud,nro_solicitud,nombre,run,fecha_solicitud,provincia_id,usuario_id) VALUES(?,?,?,?,?,?,?)";
    String guardar_detalle = "INSERT INTO detalle_solicitud(idDetalle_solicitud,productoid,solicitudid,cantidad) VALUES(?,?,?,?)";
    String lista_solicitud_admin = "SELECT idSolicitud, nro_solicitud, nombre, run, fecha_solicitud FROM solicitud";
    String lista_solicitud_depto = "SELECT DISTINCT idSolicitud, nro_solicitud, nombre, run, fecha_solicitud FROM solicitud JOIN detalle_solicitud ON solicitud.idSolicitud = detalle_solicitud.solicitudid JOIN producto ON detalle_solicitud.productoid = producto.idProducto WHERE producto.departamento = ?";
    String detalle_soli = "SELECT producto.descripcion, detalle_solicitud.cantidad, tipo_medida.descripcion_medida FROM detalle_solicitud JOIN producto ON detalle_solicitud.productoid = producto.idProducto JOIN tipo_medida ON producto.tipo_medida_id = tipo_medida.idTipo_medida WHERE solicitudid = ?";
    String detalle_soli_participante = "SELECT solicitud.idSolicitud, solicitud.nro_solicitud,solicitud.nombre, solicitud.run, solicitud.fecha_solicitud, provincia.nombre_provincia, usuario.nombre, usuario.apellido, usuario.run, bodega.nombre_bodega FROM solicitud JOIN provincia ON provincia.idProvincia = solicitud.provincia_id JOIN usuario ON usuario.idUsuario = solicitud.usuario_id JOIN bodega ON usuario.bodegaid = bodega.idBodega WHERE solicitud.idSolicitud = ?";
    Connection conexion;

    public SolicitudDAO() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public int Auto_ID_S() {
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = conexion.prepareStatement(Auto_ID_S);
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

    public int Auto_ID_D() {
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = conexion.prepareStatement(Auto_ID_D);
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

    public int guardarSolicitud(Solicitud solicitud) {
        PreparedStatement ps;
        int id = Auto_ID_S() + 1;
        try {
            ps = conexion.prepareStatement(guardar_producto);
            ps.setInt(1, id);
            ps.setString(2, solicitud.getNro_solicitud());
            ps.setString(3, solicitud.getNombre());
            ps.setString(4, solicitud.getRun());
            ps.setString(5, solicitud.getFecha());
            ps.setInt(6, solicitud.getProvincia());
            ps.setInt(7, solicitud.getUsuario());
            ps.execute();
            ps.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return id;
        }
    }

    public int guardarDetallesolicitud(Solicitud solicitud) {
        PreparedStatement ps;
        int id = Auto_ID_D() + 1;
        try {
            ps = conexion.prepareStatement(guardar_detalle);
            ps.setInt(1, id);
            ps.setInt(2, solicitud.getProducto());
            ps.setInt(3, solicitud.getIdsolicitud());
            ps.setInt(4, solicitud.getCantidad());
            ps.execute();
            ps.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return id;
        }
    }
    public List<Solicitud> listasolicitudAdmin(){
        PreparedStatement ps;
        ResultSet rs;
        List<Solicitud> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_solicitud_admin);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String nro_solicitud = rs.getString(2);
                String nombre = rs.getString(3);
                String run = rs.getString(4);
                String fecha = rs.getString(5);
                Solicitud soli = new Solicitud(id, nombre, run, fecha, nro_solicitud);
                lista.add(soli);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public List<Solicitud> listasolicitudDepto(String depto){
        PreparedStatement ps;
        ResultSet rs;
        List<Solicitud> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(lista_solicitud_depto);
            ps.setString(1, depto);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String nro_solicitud = rs.getString(2);
                String nombre = rs.getString(3);
                String run = rs.getString(4);
                String fecha = rs.getString(5);
                Solicitud soli = new Solicitud(id, nombre, run, fecha, nro_solicitud);
                lista.add(soli);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public List<Solicitud> detalleSolicitud(int idsoli){
        PreparedStatement ps;
        ResultSet rs;
        List<Solicitud> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(detalle_soli);
            ps.setInt(1, idsoli);
            rs = ps.executeQuery();
            while (rs.next()){
                String producto = rs.getString(1);
                int cantidad = rs.getInt(2);
                String medida = rs.getString(3);
                Solicitud solicitud = new Solicitud(cantidad, producto, medida);
                lista.add(solicitud);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Solicitud detalleSolicitudParticipante(int idsolicitud){
        PreparedStatement ps;
        ResultSet rs;
        Solicitud detallesoli = new Solicitud();
        try {
            ps = conexion.prepareStatement(detalle_soli_participante);
            ps.setInt(1, idsolicitud);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String solicitud = rs.getString(2);
                String nombre = rs.getString(3);
                String run = rs.getString(4);
                String fecha = rs.getString(5);
                String provincia = rs.getString(6);
                String nombre_usuario = rs.getString(7);
                String apellido_usuario = rs.getString(8);
                String run_usuario = rs.getString(9);
                String bodega = rs.getString(10);
                detallesoli = new Solicitud(id,nombre, run, fecha, solicitud, bodega, provincia, nombre_usuario, apellido_usuario, run_usuario);
            }
            return detallesoli;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}

