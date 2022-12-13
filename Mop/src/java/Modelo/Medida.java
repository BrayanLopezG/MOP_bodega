package Modelo;

public class Medida {
   int id_medida;
   String descripcion;

    public Medida(int id_medida, String descripcion) {
        this.id_medida = id_medida;
        this.descripcion = descripcion;
    }

    public Medida() {
    }

    public int getId_medida() {
        return id_medida;
    }

    public void setId_medida(int id_medida) {
        this.id_medida = id_medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
