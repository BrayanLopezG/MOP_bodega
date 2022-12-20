package Modelo;
public class Usuario extends PerfilUsuario{
    int idusuario,bodega_id,perfil_id;
    String nombre,apellido,rut,nombre_usuario,contrasenha,unombre_bodega;

    public Usuario(int idusuario, int bodega_id, int perfil_id, String nombre, String apellido, String rut, String nombre_usuario, String contrasenha) {
        this.idusuario = idusuario;
        this.bodega_id = bodega_id;
        this.perfil_id = perfil_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nombre_usuario = nombre_usuario;
        this.contrasenha = contrasenha;
    }

    public Usuario(int idusuario, String nombre, String apellido, String rut, String nombre_usuario, String unombre_bodega, String descripcion_perfil) {
        super(descripcion_perfil);
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nombre_usuario = nombre_usuario;
        this.unombre_bodega = unombre_bodega;
    }

    public Usuario(int idusuario, String nombre, String apellido, String rut, String nombre_usuario, String contrasenha, String unombre_bodega, String descripcion_perfil) {
        super(descripcion_perfil);
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nombre_usuario = nombre_usuario;
        this.contrasenha = contrasenha;
        this.unombre_bodega = unombre_bodega;
    }

    public Usuario(int idusuario, int bodega_id, int perfil_id, String nombre, String apellido, String rut, String nombre_usuario, String contrasenha, String unombre_bodega) {
        this.idusuario = idusuario;
        this.bodega_id = bodega_id;
        this.perfil_id = perfil_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nombre_usuario = nombre_usuario;
        this.contrasenha = contrasenha;
        this.unombre_bodega = unombre_bodega;
    }

    public Usuario(int idperfil, String descripcion_perfil) {
        super(idperfil, descripcion_perfil);
    }

    public Usuario() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getBodega_id() {
        return bodega_id;
    }

    public void setBodega_id(int bodega_id) {
        this.bodega_id = bodega_id;
    }

    public int getPerfil_id() {
        return perfil_id;
    }

    public void setPerfil_id(int perfil_id) {
        this.perfil_id = perfil_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getUnombre_bodega() {
        return unombre_bodega;
    }

    public void setUnombre_bodega(String unombre_bodega) {
        this.unombre_bodega = unombre_bodega;
    }

    
}
