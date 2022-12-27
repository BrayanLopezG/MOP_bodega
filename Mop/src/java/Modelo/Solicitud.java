package Modelo;

public class Solicitud {
    int idsolicitud,usuario,producto,provincia,cantidad;
    String nombre,run,fecha,nro_solicitud;
    String descripcionproducto,descripcionmedida,descripcionbodega,descripcionprovincia,nom_usuario;
    String usuario_nombre,usuario_apellido,usuario_run;

    public Solicitud(int idsolicitud,String nombre, String run, String fecha, String nro_solicitud, String descripcionbodega, String descripcionprovincia, String usuario_nombre, String usuario_apellido, String usuario_run) {
        this.idsolicitud = idsolicitud;
        this.nombre = nombre;
        this.run = run;
        this.fecha = fecha;
        this.nro_solicitud = nro_solicitud;
        this.descripcionbodega = descripcionbodega;
        this.descripcionprovincia = descripcionprovincia;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_run = usuario_run;
    }

    public Solicitud(int idsolicitud, int usuario, int producto, int provincia, int cantidad, String nombre, String run, String fecha, String nro_solicitud, String descripcionproducto, String descripcionmedida, String descripcionbodega, String descripcionprovincia, String nom_usuario, String usuario_nombre, String usuario_apellido, String usuario_run) {
        this.idsolicitud = idsolicitud;
        this.usuario = usuario;
        this.producto = producto;
        this.provincia = provincia;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.run = run;
        this.fecha = fecha;
        this.nro_solicitud = nro_solicitud;
        this.descripcionproducto = descripcionproducto;
        this.descripcionmedida = descripcionmedida;
        this.descripcionbodega = descripcionbodega;
        this.descripcionprovincia = descripcionprovincia;
        this.nom_usuario = nom_usuario;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_run = usuario_run;
    }

    public Solicitud(int cantidad, String descripcionproducto, String descripcionmedida) {
        this.cantidad = cantidad;
        this.descripcionproducto = descripcionproducto;
        this.descripcionmedida = descripcionmedida;
    }

    public Solicitud(int idsolicitud, String nombre, String run, String fecha, String nro_solicitud) {
        this.idsolicitud = idsolicitud;
        this.nombre = nombre;
        this.run = run;
        this.fecha = fecha;
        this.nro_solicitud = nro_solicitud;
    }

    public Solicitud() {
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_run() {
        return usuario_run;
    }

    public void setUsuario_run(String usuario_run) {
        this.usuario_run = usuario_run;
    }

    public int getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(int idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNro_solicitud() {
        return nro_solicitud;
    }

    public void setNro_solicitud(String nro_solicitud) {
        this.nro_solicitud = nro_solicitud;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public String getDescripcionmedida() {
        return descripcionmedida;
    }

    public void setDescripcionmedida(String descripcionmedida) {
        this.descripcionmedida = descripcionmedida;
    }

    public String getDescripcionbodega() {
        return descripcionbodega;
    }

    public void setDescripcionbodega(String descripcionbodega) {
        this.descripcionbodega = descripcionbodega;
    }

    public String getDescripcionprovincia() {
        return descripcionprovincia;
    }

    public void setDescripcionprovincia(String descripcionprovincia) {
        this.descripcionprovincia = descripcionprovincia;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

}
