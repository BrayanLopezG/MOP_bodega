package Modelo;

import Conexion.Conexion;
import java.sql.*;

public class SolicitudDAO {

    String Auto_ID_S = "SELECT COUNT(idSolicitud) FROM solicitud";
    String Auto_ID_D = "SELECT COUNT(idDetalle_solicitud) FROM detalle_solicitud";
    String guardar_producto = "INSERT INTO solicitud(idSolicitud,nro_solicitud,nombre,run,fecha_solicitud,provincia_id,usuario_id) VALUES(?,?,?,?,?,?,?)";
    String guardar_detalle = "INSERT INTO detalle_solicitud(idDetalle_solicitud,productoid,solicitudid,cantidad) VALUES(?,?,?,?)";
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
    
}

