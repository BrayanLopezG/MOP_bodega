package Modelo;

import java.io.InputStream;

public class Factura extends Proveedor{
    int id_factura,proveedor_id;
    String nro_factura,orden_compra,fecha_factura;
    InputStream facturapdf;
    private byte[] factura;
    InputStream orden_comprapdf;
    private byte[] orden_comprafactura;

    public Factura() {
    }

    public Factura(int id_factura, String nro_factura, String orden_compra) {
        this.id_factura = id_factura;
        this.nro_factura = nro_factura;
        this.orden_compra = orden_compra;
    }

    public Factura(String orden_compra) {
        this.orden_compra = orden_compra;
    }

    public Factura(int id_proveedor, String rut_proveedor, String nombre_proveedor, String telefono_proveedor, String direccion_proveedor) {
        super(id_proveedor, rut_proveedor, nombre_proveedor, telefono_proveedor, direccion_proveedor);
    }

    public Factura(int id_factura, int proveedor_id, String nro_factura, String orden_compra, String fecha_factura, byte[] factura, byte[] orden_comprafactura) {
        this.id_factura = id_factura;
        this.proveedor_id = proveedor_id;
        this.nro_factura = nro_factura;
        this.orden_compra = orden_compra;
        this.fecha_factura = fecha_factura;
        this.factura = factura;
        this.orden_comprafactura = orden_comprafactura;
    }

    public Factura(int id_factura, int proveedor_id, String nro_factura, String orden_compra, String fecha_factura, InputStream facturapdf, InputStream orden_comprapdf) {
        this.id_factura = id_factura;
        this.proveedor_id = proveedor_id;
        this.nro_factura = nro_factura;
        this.orden_compra = orden_compra;
        this.fecha_factura = fecha_factura;
        this.facturapdf = facturapdf;
        this.orden_comprapdf = orden_comprapdf;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
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

    public String getOrden_compra() {
        return orden_compra;
    }

    public void setOrden_compra(String orden_compra) {
        this.orden_compra = orden_compra;
    }

    public String getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(String fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public InputStream getFacturapdf() {
        return facturapdf;
    }

    public void setFacturapdf(InputStream facturapdf) {
        this.facturapdf = facturapdf;
    }

    public byte[] getFactura() {
        return factura;
    }

    public void setFactura(byte[] factura) {
        this.factura = factura;
    }

    public InputStream getOrden_comprapdf() {
        return orden_comprapdf;
    }

    public void setOrden_comprapdf(InputStream orden_comprapdf) {
        this.orden_comprapdf = orden_comprapdf;
    }

    public byte[] getOrden_comprafactura() {
        return orden_comprafactura;
    }

    public void setOrden_comprafactura(byte[] orden_comprafactura) {
        this.orden_comprafactura = orden_comprafactura;
    }
}