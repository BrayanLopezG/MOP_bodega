package Modelo;

import java.io.InputStream;

public class Producto extends Factura{
    int idproducto,facturaid,medida_id,bodegaid;
    String descripcion,cantidad,departamento,pnombre_bodega,pdireccion_bodega,pdescripcion_medida;

    public Producto(int idproducto, String descripcion, String cantidad, String pnombre_bodega, String pdescripcion_medida, String orden_compra) {
        super(orden_compra);
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pnombre_bodega = pnombre_bodega;
        this.pdescripcion_medida = pdescripcion_medida;
    }

    public Producto(int idproducto, String descripcion, String cantidad, String pnombre_bodega, String pdescripcion_medida) {
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pnombre_bodega = pnombre_bodega;
        this.pdescripcion_medida = pdescripcion_medida;
    }

    public Producto(String descripcion, String cantidad, String pnombre_bodega, String pdescripcion_medida) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pnombre_bodega = pnombre_bodega;
        this.pdescripcion_medida = pdescripcion_medida;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPnombre_bodega() {
        return pnombre_bodega;
    }

    public void setPnombre_bodega(String pnombre_bodega) {
        this.pnombre_bodega = pnombre_bodega;
    }

    public String getPdireccion_bodega() {
        return pdireccion_bodega;
    }

    public void setPdireccion_bodega(String pdireccion_bodega) {
        this.pdireccion_bodega = pdireccion_bodega;
    }

    public String getPdescripcion_medida() {
        return pdescripcion_medida;
    }

    public void setPdescripcion_medida(String pdescripcion_medida) {
        this.pdescripcion_medida = pdescripcion_medida;
    }

    public Producto() {
    }

    public Producto(int idproducto, int facturaid, int medida_id, int bodegaid, String descripcion, String cantidad, String departamento) {
        this.idproducto = idproducto;
        this.facturaid = facturaid;
        this.medida_id = medida_id;
        this.bodegaid = bodegaid;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.departamento = departamento;
    }

    public Producto(int idproducto, String descripcion, String cantidad, String departamento, String pnombre_bodega, String pdescripcion_medida, String orden_compra) {
        super(orden_compra);
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.departamento = departamento;
        this.pnombre_bodega = pnombre_bodega;
        this.pdescripcion_medida = pdescripcion_medida;
    }

    public Producto(int idproducto, String descripcion, String cantidad, String departamento, String pnombre_bodega, String pdireccion_bodega, String pdescripcion_medida, int id_proveedor, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String direccion_proveedor) {
        super(id_proveedor, rut_proveedor, nombre_proveedor, telefono_proveedor, direccion_proveedor);
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.departamento = departamento;
        this.pnombre_bodega = pnombre_bodega;
        this.pdireccion_bodega = pdireccion_bodega;
        this.pdescripcion_medida = pdescripcion_medida;
    }

    public Producto(int idproducto, String descripcion, String cantidad, String departamento, String pnombre_bodega, String pdireccion_bodega, String pdescripcion_medida, int id_factura, int proveedor_id, String nro_factura, String orden_compra, String fecha_factura) {
        super(id_factura, proveedor_id, nro_factura, orden_compra, fecha_factura);
        this.idproducto = idproducto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.departamento = departamento;
        this.pnombre_bodega = pnombre_bodega;
        this.pdireccion_bodega = pdireccion_bodega;
        this.pdescripcion_medida = pdescripcion_medida;
    }

}
