package Modelo;

public class PerfilUsuario {
    int idperfil;
    String desripcion_perfil;

    public PerfilUsuario(int idperfil, String desripcion_perfil) {
        this.idperfil = idperfil;
        this.desripcion_perfil = desripcion_perfil;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getDesripcion_perfil() {
        return desripcion_perfil;
    }

    public void setDesripcion_perfil(String desripcion_perfil) {
        this.desripcion_perfil = desripcion_perfil;
    }
}
