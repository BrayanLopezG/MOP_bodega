package Modelo;

public class Provincia {
    int provinciaid;
    String nom_provincia;

    public Provincia(int provinciaid, String nom_provincia) {
        this.provinciaid = provinciaid;
        this.nom_provincia = nom_provincia;
    }

    public Provincia() {
    }

    public int getProvinciaid() {
        return provinciaid;
    }

    public void setProvinciaid(int provinciaid) {
        this.provinciaid = provinciaid;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }
}
