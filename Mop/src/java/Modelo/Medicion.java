package Modelo;

public class Medicion{
    int id_medicion;
    String descripcion_medicion;

    public Medicion(int id_medicion, String descripcion_medicion) {
        this.id_medicion = id_medicion;
        this.descripcion_medicion = descripcion_medicion;
    }

    public Medicion() {
    }

    public int getId_medicion() {
        return id_medicion;
    }

    public void setId_medicion(int id_medicion) {
        this.id_medicion = id_medicion;
    }

    public String getDescripcion_medicion() {
        return descripcion_medicion;
    }

    public void setDescripcion_medicion(String descripcion_medicion) {
        this.descripcion_medicion = descripcion_medicion;
    }

}
