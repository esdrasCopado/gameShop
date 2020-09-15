/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Entidades;

/**
 *entidad desarrolladora de videojuegos
 * @author copad
 */
public class EntidadDesarrolladora {
    
    private int id=0;
    private String nombre;

    public EntidadDesarrolladora(int id,String nombre){
        this.id=id;
        this.nombre=nombre;
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
