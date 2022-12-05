package Modelo;

public class Producto extends Factura{
    int idproducto,tipo_medida,facturaid,bodegaid;
    String descripcion,estado,fecha_ingreso;
    

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getTipo_medida() {
        return tipo_medida;
    }

    public void setTipo_medida(int tipo_medida) {
        this.tipo_medida = tipo_medida;
    }

    public int getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(int facturaid) {
        this.facturaid = facturaid;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
}
