/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author copad
 */
public class Conexion {
   Connection conexionBaseDatos;

    public Connection getConexionBaseDatos() {
        return conexionBaseDatos;
    }

    public void setConexionBaseDatos(Connection conexionBaseDatos) {
        this.conexionBaseDatos = conexionBaseDatos;
    }
   
    
    public Conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionBaseDatos=DriverManager.getConnection("jdbc:mysql://localhost:3306/gameshop","root","");
        } catch (Exception e) {
            System.out.println("error"+" "+e);
        }
    }
    public static void main(String[] args) {
        Conexion cn=new Conexion();
        Statement statement;
        ResultSet retulset;
        try {
            
            
            statement=cn.conexionBaseDatos.createStatement();
            retulset=statement.executeQuery("select * from gameshop.compania");
            
            while(retulset.next()){
                System.out.println(retulset.getInt("id")+" "+retulset.getString("nombre"));
            }
        } catch (Exception e) {
        }
        
    }
}
