package Modelo;

public class Bodega {
    int id_bodega,stock,stock_min,usuario,perfil_bodega;
    String nombre_bodega,direccion_bodega;

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

    public int getStock_min() {
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getPerfil_bodega() {
        return perfil_bodega;
    }

    public void setPerfil_bodega(int perfil_bodega) {
        this.perfil_bodega = perfil_bodega;
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
