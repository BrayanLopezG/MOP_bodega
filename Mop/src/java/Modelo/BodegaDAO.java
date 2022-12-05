package Modelo;

import Conexion.Conexion;
import java.sql.Connection;

public class BodegaDAO {
    String Lista_bodega = "";
    String Filtro_bodega = "";
    Connection conexion;
    
    public BodegaDAO(){
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
}
