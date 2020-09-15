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

/**
 *
 * @author copad
 */
public class CRUD_Desarrolladora {
    


    public boolean incertar(EntidadDesarrolladora juego) {
        boolean incertoDato = false;
        Conexion conexion = new Conexion();
        
        try {
            PreparedStatement pps = conexion.getConexionBaseDatos().prepareStatement("insert into desarrolladora (id,nombre) values (?,?);");
            pps.setInt(1, 0);
            pps.setString(2, juego.getNombre());

            pps.executeUpdate();

            conexion.getConexionBaseDatos().close();

        } catch (Exception e) {
            System.out.println("error sql" + " " + e);
            return false;
        } finally {
            return true;
        }

    }
    public boolean eliminar(EntidadDesarrolladora desarrolladora){
        Conexion conexion=new Conexion();
      
        
        try {
           
            
            PreparedStatement pps=conexion.getConexionBaseDatos().prepareStatement("delete from desarrolladora where id=?;");
            pps.setInt(1, desarrolladora.getId());
            pps.executeUpdate();
            
            conexion.getConexionBaseDatos().close();
        } catch (Exception e) {
            System.out.println("error"+" "+e);
        }finally{
            return true;
        }
        
    }
    public boolean modificar(EntidadDesarrolladora desarrolladora){
        Conexion conexion=new Conexion();
        
        try {
            PreparedStatement pps=conexion.getConexionBaseDatos().prepareStatement("update desarrolladora set nombre=? where id=?;");
            pps.setString(1, desarrolladora.getNombre());
            pps.setInt(2, desarrolladora.getId());
            System.out.println(desarrolladora.getNombre());
            pps.executeUpdate();
            
            pps.close();
            
        } catch (Exception e) {
            System.out.println("error"+" "+e);
        }
        return false;
    }
}
