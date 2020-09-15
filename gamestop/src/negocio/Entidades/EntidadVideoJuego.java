/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Entidades;

/**
 *
 * @author copad
 */
public class EntidadVideoJuego {
    private int id;
    private String nombre;
    private int desarrolladoraID;
    private int rating;

    
    public EntidadVideoJuego(int id,String nombre,int desarrolladora,int rating){
        this.id=id;
        this.nombre=nombre;
        this.desarrolladoraID=desarrolladora;
        this.rating=rating;
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

    public int getDerarrolladoraID() {
        return desarrolladoraID;
    }

    public void setDerarrolladoraID(int derarrolladora) {
        this.desarrolladoraID = derarrolladora;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
}
