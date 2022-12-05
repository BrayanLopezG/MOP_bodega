package Modelo;

public class PerfilUsuario {
    int idperfil;
    String descripcion_perfil;

    public PerfilUsuario(int idperfil, String descripcion_perfil) {
        this.idperfil = idperfil;
        this.descripcion_perfil = descripcion_perfil;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getDescripcion_perfil() {
        return descripcion_perfil;
    }

    public void setDescripcion_perfil(String descripcion_perfil) {
        this.descripcion_perfil = descripcion_perfil;
    }
}
