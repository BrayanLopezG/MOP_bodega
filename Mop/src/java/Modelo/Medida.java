package Modelo;

public class Medida extends Medicion{
   int id_medida,medicion;
   String descripcion;

    public Medida(int id_medida, int medicion, String descripcion) {
        this.id_medida = id_medida;
        this.medicion = medicion;
        this.descripcion = descripcion;
    }

    public Medida(int id_medicion, String descripcion_medicion) {
        super(id_medicion, descripcion_medicion);
    }

    public Medida() {
    }

    public Medida(int id_medida, int medicion, String descripcion, int id_medicion, String descripcion_medicion) {
        super(id_medicion, descripcion_medicion);
        this.id_medida = id_medida;
        this.medicion = medicion;
        this.descripcion = descripcion;
    }

    public int getId_medida() {
        return id_medida;
    }

    public void setId_medida(int id_medida) {
        this.id_medida = id_medida;
    }

    public int getMedicion() {
        return medicion;
    }

    public void setMedicion(int medicion) {
        this.medicion = medicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
