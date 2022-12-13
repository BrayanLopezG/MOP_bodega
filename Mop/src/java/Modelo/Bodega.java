package Modelo;

public class Bodega extends Usuario{
    int id_bodega,stock,usuario;
    String nombre_bodega,direccion_bodega;

    public Bodega() {
    }

    public Bodega(int id_bodega, int stock, int usuario, String nombre_bodega, String direccion_bodega) {
        this.id_bodega = id_bodega;
        this.stock = stock;
        this.usuario = usuario;
        this.nombre_bodega = nombre_bodega;
        this.direccion_bodega = direccion_bodega;
    }

    public Bodega(int id_bodega, int stock,  int usuario, String nombre_bodega, String direccion_bodega, int idusuario, int perfil_id, String nombre_usuario, String contrasenha) {
        this.id_bodega = id_bodega;
        this.stock = stock;
        this.usuario = usuario;
        this.nombre_bodega = nombre_bodega;
        this.direccion_bodega = direccion_bodega;
    }

    public int getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getNombre_bodega() {
        return nombre_bodega;
    }

    public void setNombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public String getDireccion_bodega() {
        return direccion_bodega;
    }

    public void setDireccion_bodega(String direccion_bodega) {
        this.direccion_bodega = direccion_bodega;
    }
    
}
