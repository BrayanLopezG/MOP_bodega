package Modelo;
public class Usuario extends PerfilUsuario{
    int idusuario,perfil_id;
    String nombre_usuario,contrasenha;

    public Usuario() {
    }
    

    public Usuario(int idperfil, String descripcion_perfil) {
        super(idperfil, descripcion_perfil);
    }

    public Usuario(int idusuario, int perfil_id, String nombre_usuario, String contrasenha, int idperfil, String descripcion_perfil) {
        super(idperfil, descripcion_perfil);
        this.idusuario = idusuario;
        this.perfil_id = perfil_id;
        this.nombre_usuario = nombre_usuario;
        this.contrasenha = contrasenha;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

}
