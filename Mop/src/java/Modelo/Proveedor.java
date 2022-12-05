package Modelo;

public class Proveedor {
    int id_proveedor;
    String rut_proveedor,nombre_proveedor,telefono_proveedor,direccion_proveedor;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String direccion_proveedor) {
        this.id_proveedor = id_proveedor;
        this.rut_proveedor = rut_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.direccion_proveedor = direccion_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRut_proveedor() {
        return rut_proveedor;
    }

    public void setRut_proveedor(String rut_proveedor) {
        this.rut_proveedor = rut_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", rut_proveedor=" + rut_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", telefono_proveedor=" + telefono_proveedor + ", direccion_proveedor=" + direccion_proveedor + '}';
    }
    
    
}
