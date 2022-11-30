package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerfilUsuarioDAO {
    String all_perfil = "SELECT idPerfil_usuario, descripcion_perfil FROM perfil_usuario";
    String perfil_por_id = "SELECT idPerfil_usuario,descripcion_perfil FROM perfil_usuario WHERE idPerfil_usuario = ?";
    String insertar_perfil = "INSERT INTO perfil_usuario (descripcion_perfil)VALUE(?)";
    
    Connection conexion;
    
    public PerfilUsuarioDAO(){
        Conexion con = new Conexion();
        con.getConexion();
}
    public List<PerfilUsuario> listarPerfil(){
        PreparedStatement ps;
        ResultSet rs;
        List<PerfilUsuario> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement(all_perfil);
            rs = ps.executeQuery();
            while (rs.next()){
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
    public PerfilUsuario Perfil(int id){
        PreparedStatement ps;
        ResultSet rs;
        PerfilUsuario pusuario = null;
        try {
            ps = conexion.prepareStatement(perfil_por_id);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int id_p = rs.getInt("idPerfil_usuario");
                String descipcion = rs.getString("descripcion_perfil");
                pusuario = new PerfilUsuario(id_p, descipcion);
            }
            return pusuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public boolean Insertar(PerfilUsuario pusuario){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(insertar_perfil);
            ps.setString(1,pusuario.getDesripcion_perfil());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
   
}
