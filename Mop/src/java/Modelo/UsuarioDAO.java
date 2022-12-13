package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    String insertar_usuario = "INSERT INTO usuario(idUsuario,nombre_usuario,contrasenha,perfil_id) VALUES(?,?,?,?)";
    String validar_usuario = "SELECT usuario.nombre,usuario.apellido,usuario.rut,usuario.nombre_usuario, usuario.contrasenha, perfil_usuario.descripcion_perfil FROM usuario JOIN perfil_usuario ON perfil_usuario.idPerfil_usuario = usuario.perfil_id WHERE usuario.nombre_usuario = ? and usuario.contrasenha = ?" ;
    String id_usuario = "SELECT COUNT(idUsuario) FROM usuario";
    Connection conexion;
    
    public UsuarioDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Usuario> listaUsuario(){
        PreparedStatement ps;
        ResultSet rs;
        List<Usuario> lista = new ArrayList();
        try {
            ps = conexion.prepareStatement("SELECT usuario.idUsuario,usuario.nombre,usuario.apellido,usuario.rut,usuario.nombre_usuario, usuario.contrasenha, usuario.perfil_id, perfil_usuario.descripcion_perfil FROM usuario JOIN perfil_usuario ON perfil_usuario.idPerfil_usuario = usuario.perfil_id");
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("usuario.idUsuario");
                String nombre = rs.getString("usuario.nombre");
                String apellido = rs.getString("usuario.apellido");
                String rut = rs.getString("usaurio.rut");
                String nombre_usuario = rs.getString("usuario.nombre_usuario");
                String contrasenha = rs.getString("usuario.contrasenha");
                int perfil = rs.getInt("usuario.perfil_id");
                int perfil_id = rs.getInt("usuario.perfil_id");
                String cargo = rs.getString("perfil_usuario.descripcion_perfil");
                Usuario usuario = new Usuario(id, perfil, nombre, apellido, rut, nombre_usuario, contrasenha, perfil_id, cargo);
                lista.add(usuario); 
            }
            ps.close();
            rs.close();
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public int AutoID(){
        PreparedStatement ps;
        ResultSet rs;
        int id = 0;
        try {
            ps = conexion.prepareStatement(id_usuario);
            rs = ps.executeQuery();
            while (rs.next()){
                id = rs.getInt("COUNT(idUsuario)");
            }
            ps.close();
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return id;
        } 
    }
    
    public boolean insertarUsuario(Usuario usuario){
        PreparedStatement ps;
        int id = AutoID();
        try {
            ps = conexion.prepareStatement(insertar_usuario);
            ps.setInt(1,id);
            ps.setString(2,usuario.getNombre_usuario());
            ps.setString(3,usuario.getContrasenha());
            ps.setInt(4, usuario.getPerfil_id());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    public Usuario validar(String user, String pass){
        Usuario usuario = new Usuario();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(validar_usuario);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario.setNombre(rs.getString("usuario.nombre"));
                usuario.setApellido(rs.getString("usuario.apellido"));
                usuario.setRut(rs.getString("usuario.rut"));
                usuario.setNombre_usuario(rs.getString("usuario.nombre_usuario"));
                usuario.setContrasenha(rs.getString("usuario.contrasenha"));
                usuario.setDescripcion_perfil(rs.getString("perfil_usuario.descripcion_perfil"));
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        
    }
}
