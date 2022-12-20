package Modelo;

import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    String insertar_usuario = "INSERT INTO usuario(idUsuario,nombre_usuario,contrasenha,nombre,apellido,run,bodegaid,perfil_id) VALUES(?,?,?,?,?,?,?,?)";
    String validar_usuario = "SELECT usuario.idUsuario,usuario.nombre,usuario.apellido,usuario.run,usuario.nombre_usuario, usuario.contrasenha, perfil_usuario.descripcion_perfil, bodega.nombre_bodega FROM usuario JOIN perfil_usuario ON perfil_usuario.idPerfil_usuario = usuario.perfil_id JOIN bodega ON usuario.bodegaid = bodega.idBodega WHERE usuario.nombre_usuario = ? and usuario.contrasenha = ?" ;
    String lista_usuario = "SELECT usuario.idUsuario,usuario.nombre,usuario.apellido,usuario.run,usuario.nombre_usuario, perfil_usuario.descripcion_perfil, bodega.nombre_bodega FROM usuario JOIN perfil_usuario ON perfil_usuario.idPerfil_usuario = usuario.perfil_id JOIN bodega ON usuario.bodegaid = bodega.idBodega";
    String filtro_usuario = "SELECT idUsuario, nombre, apellido, run, nombre_usuario, contrasenha,bodegaid,perfil_id FROM usuario WHERE usuario.idUsuario = ?";
    String filtro_id_usuario = "SELECT idUsuario, nombre, apellido, run, nombre_usuario,bodegaid,perfil_id from usuario WHERE nombre_usuario = ?";
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
            ps = conexion.prepareStatement(lista_usuario);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("usuario.idUsuario");
                String nombre = rs.getString("usuario.nombre");
                String apellido = rs.getString("usuario.apellido");
                String rut = rs.getString("usuario.run");
                String nombre_usuario = rs.getString("usuario.nombre_usuario");
                String cargo = rs.getString("perfil_usuario.descripcion_perfil");
                String bodega = rs.getString("bodega.nombre_bodega");
                Usuario usuario = new Usuario(id, nombre, apellido, rut, nombre_usuario, bodega, cargo);
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
        int id = AutoID()+1;
        try {
            ps = conexion.prepareStatement(insertar_usuario);
            ps.setInt(1,id);
            ps.setString(2,usuario.getNombre_usuario());
            ps.setString(3,usuario.getContrasenha());
            ps.setString(4,usuario.getNombre());
            ps.setString(5,usuario.getApellido());
            ps.setString(6,usuario.getRut());
            ps.setInt(7, usuario.getBodega_id());
            ps.setInt(8, usuario.getPerfil_id());
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
                usuario.setIdusuario(rs.getInt("usuario.idUsuario"));
                usuario.setNombre(rs.getString("usuario.nombre"));
                usuario.setApellido(rs.getString("usuario.apellido"));
                usuario.setRut(rs.getString("usuario.run"));
                usuario.setNombre_usuario(rs.getString("usuario.nombre_usuario"));
                usuario.setContrasenha(rs.getString("usuario.contrasenha"));
                usuario.setDescripcion_perfil(rs.getString("perfil_usuario.descripcion_perfil"));
                usuario.setUnombre_bodega(rs.getString("bodega.nombre_bodega"));
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Usuario filtroUsuario(int idu){
        PreparedStatement ps;
        ResultSet rs;
        Usuario usuario = null;
        try {
            ps = conexion.prepareStatement(filtro_usuario);
            ps.setInt(1, idu);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String run = rs.getString(4);
                String nombre_usuario = rs.getString(5);
                String contra = rs.getString(6);
                int bodega = rs.getInt(7);
                int perfil = rs.getInt(8);
                usuario = new Usuario(id, bodega, perfil, nombre, apellido, run, nombre_usuario, contra);
            }
            ps.close();
            rs.close();
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Usuario filtroUsuario(String nom_usuario){
        PreparedStatement ps;
        ResultSet rs;
        Usuario usuario = null;
        try {
            ps = conexion.prepareStatement(filtro_usuario);
            ps.setString(1, nom_usuario);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String run = rs.getString(4);
                String nombre_usuario = rs.getString(5);
                int bodega = rs.getInt(6);
                int perfil = rs.getInt(7);
                usuario = new Usuario(id, bodega, perfil, nombre, apellido, run, nombre_usuario);
            }
            ps.close();
            rs.close();
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
}
