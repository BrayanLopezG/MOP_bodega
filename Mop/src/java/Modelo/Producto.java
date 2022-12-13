package Modelo;

import java.io.InputStream;

public class Producto extends Factura{
    int idproducto,facturaid,medida_id,bodegaid;
    String descripcion,cantidad;

    public Producto(int idproducto, int facturaid, int medida_id, int bodegaid, String descripcion, String cantidad) {
        this.idproducto = idproducto;
        this.facturaid = facturaid;
        this.medida_id = medida_id;
        this.bodegaid = bodegaid;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(int idproducto, int facturaid, int medida_id, int bodegaid, String descripcion, String cantidad, int id_factura, int proveedor_id, String nro_factura, String orden_compra, String fecha_factura, InputStream facturapdf, byte[] factura, int id_proveedor, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String direccion_proveedor) {
        super(id_factura, proveedor_id, nro_factura, orden_compra, fecha_factura, facturapdf, factura, id_proveedor, rut_proveedor, nombre_proveedor, telefono_proveedor, direccion_proveedor);
        this.idproducto = idproducto;
        this.facturaid = facturaid;
        this.medida_id = medida_id;
        this.bodegaid = bodegaid;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(int id_factura, int proveedor_id, String nro_factura, String orden_compra, String fecha_factura, InputStream facturapdf, byte[] factura, int id_proveedor, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String direccion_proveedor) {
        super(id_factura, proveedor_id, nro_factura, orden_compra, fecha_factura, facturapdf, factura, id_proveedor, rut_proveedor, nombre_proveedor, telefono_proveedor, direccion_proveedor);
    }

    public Producto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(int facturaid) {
        this.facturaid = facturaid;
    }

    public int getMedida_id() {
        return medida_id;
    }

    public void setMedida_id(int medida_id) {
        this.medida_id = medida_id;
    }

    public int getBodegaid() {
        return bodegaid;
    }

    public void setBodegaid(int bodegaid) {
        this.bodegaid = bodegaid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
 
}
