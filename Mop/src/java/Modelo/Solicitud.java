package Modelo;

public class Solicitud {
    int idsolicitud,usuario,producto,provincia;
    String run,nombre,descripcion_solicitud,cantidad,nro_solicitud;
    String descipcionproducto,descripcionmedida,descripcionbodega,descripcionprovincia;

    public Solicitud() {
    }

    public Solicitud(int idsolicitud, int usuario, int producto, int provincia, String run, String nombre, String descripcion_solicitud, String cantidad, String nro_solicitud, String descipcionproducto, String descripcionmedida, String descripcionbodega, String descripcionprovincia) {
        this.idsolicitud = idsolicitud;
        this.usuario = usuario;
        this.producto = producto;
        this.provincia = provincia;
        this.run = run;
        this.nombre = nombre;
        this.descripcion_solicitud = descripcion_solicitud;
        this.cantidad = cantidad;
        this.nro_solicitud = nro_solicitud;
        this.descipcionproducto = descipcionproducto;
        this.descripcionmedida = descripcionmedida;
        this.descripcionbodega = descripcionbodega;
        this.descripcionprovincia = descripcionprovincia;
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

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_solicitud() {
        return descripcion_solicitud;
    }

    public void setDescripcion_solicitud(String descripcion_solicitud) {
        this.descripcion_solicitud = descripcion_solicitud;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNro_solicitud() {
        return nro_solicitud;
    }

    public void setNro_solicitud(String nro_solicitud) {
        this.nro_solicitud = nro_solicitud;
    }

    public String getDescipcionproducto() {
        return descipcionproducto;
    }

    public void setDescipcionproducto(String descipcionproducto) {
        this.descipcionproducto = descipcionproducto;
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
}
