/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.CRUDS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import negocio.Conexion.Conexion;
import negocio.Entidades.EntidadDesarrolladora;
import negocio.Entidades.EntidadVideoJuego;

/**
 *
 * @author copad
 */
public class CRUD_Videojuegos {

    public boolean incertar(EntidadVideoJuego juego) {

        Conexion conexion = new Conexion();

        try {
            PreparedStatement pps = conexion.getConexionBaseDatos().prepareStatement("insert into videojuego (idVideojuego,desarrolladora_id,nombre,rating) values(?,?,?,?);");
            pps.setInt(1, 0);
            pps.setInt(2, juego.getDerarrolladoraID());
            pps.setString(3, juego.getNombre());
            pps.setInt(4, juego.getRating());

            pps.executeUpdate();

            conexion.getConexionBaseDatos().close();

        } catch (Exception e) {
            System.out.println("error sql" + " " + e);
            return false;
        } finally {
            return true;
        }

    }

    public boolean eliminar(EntidadVideoJuego videojuego) {
        Conexion conexion = new Conexion();

        try {

            PreparedStatement pps = conexion.getConexionBaseDatos().prepareStatement("delete from videojuego where idVideojuego=?;");
            pps.setInt(1, videojuego.getId());
            pps.executeUpdate();

            conexion.getConexionBaseDatos().close();
        } catch (Exception e) {
            System.out.println("error" + " " + e);
        } finally {
            return true;
        }

    }

    public boolean modificar(EntidadVideoJuego juego) {
        Conexion conexion = new Conexion();

        try {
            PreparedStatement pps = conexion.getConexionBaseDatos().prepareStatement("update videojuego set nombre=?,rating=?,desarrolladora_id=? where idVideojuego=?;");
            pps.setString(1, juego.getNombre());
            pps.setInt(2, juego.getRating());
            pps.setInt(3, juego.getDerarrolladoraID());
            pps.setInt(4, juego.getId());
            
            pps.executeUpdate();

            pps.close();

        } catch (Exception e) {
            System.out.println("error" + " " + e);
        }
        return false;
    }
      
}
