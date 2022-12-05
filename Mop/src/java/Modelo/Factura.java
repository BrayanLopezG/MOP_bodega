package Modelo;

public class Factura extends Proveedor{
    int id_factura,valor,proveedor_id;
    String nro_factura,fecha_factura;

    public Factura() {
    }

    public Factura(int id_factura, int valor, int proveedor_id, String nro_factura, String fecha_factura) {
        this.id_factura = id_factura;
        this.valor = valor;
        this.proveedor_id = proveedor_id;
        this.nro_factura = nro_factura;
        this.fecha_factura = fecha_factura;
    }

    public Factura(int id_proveedor, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String direccion_proveedor) {
        super(id_proveedor, rut_proveedor, nombre_proveedor, telefono_proveedor, direccion_proveedor);
    }
    
    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }
    
}
