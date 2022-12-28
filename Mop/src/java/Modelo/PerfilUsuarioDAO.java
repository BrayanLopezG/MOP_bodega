package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerfilUsuarioDAO {
    String Auto_ID = "SELECT COUNT(idPerfil_usuario) FROM perfil_usuario";
    String all_perfil = "SELECT idPerfil_usuario, descripcion_perfil FROM perfil_usuario";
    String perfil_por_id = "SELECT descripcion_perfil FROM perfil_usuario WHERE idPerfil_usuario = ?";
    String insertar_perfil = "INSERT INTO perfil_usuario (idPerfil_usuario,descripcion_perfil)VALUES(?,?)";
    String producto_admin_depto = "SELECT descripcion_perfil FROM perfil_usuario WHERE idPerfil_usuario > 0";
    String producto_depto = "SELECT descripcion_perfil FROM perfil_usuario WHERE idPerfil_usuario = ?";

    Connection conexion;

    public PerfilUsuarioDAO() {
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

    public List<PerfilUsuario> listarPerfil() {
        PreparedStatement ps;
        ResultSet rs;
        List<PerfilUsuario> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(all_perfil);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idPerfil_usuario");
                String descripcion = rs.getString("descripcion_perfil");
                PerfilUsuario pusuario = new PerfilUsuario(id, descripcion);
                lista.add(pusuario);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public List<PerfilUsuario> perfilproductoAdmin(){
        PreparedStatement ps;
        ResultSet rs;
        List<PerfilUsuario> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(producto_admin_depto);
            rs = ps.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString(1);
                PerfilUsuario pusuario = new PerfilUsuario(descripcion);
                lista.add(pusuario);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public List<PerfilUsuario> perfilproductoDepto(int idperfil){
        PreparedStatement ps;
        ResultSet rs;
        List<PerfilUsuario> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(producto_depto);
            ps.setInt(1, idperfil);
            rs = ps.executeQuery();
            while (rs.next()) {
                String descripcion = rs.getString(1);
                PerfilUsuario pusuario = new PerfilUsuario(descripcion);
                lista.add(pusuario);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public String Perfil(int id) {
        PreparedStatement ps;
        ResultSet rs;
        String perfil = "";
        try {
            ps = conexion.prepareStatement(perfil_por_id);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                perfil = rs.getString(1);
            }
            return perfil;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean Insertar(PerfilUsuario pusuario) {
        PreparedStatement ps;
        int id = AutoID() + 1;
        try {
            ps = conexion.prepareStatement(insertar_perfil);
            ps.setInt(1,id);
            ps.setString(2, pusuario.getDescripcion_perfil());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
}
