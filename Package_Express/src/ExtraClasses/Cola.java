/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraClasses;

/**
 *
 * @author jhonny
 */
public class Cola {
    private int id;
    private int precio;
    private int ruta;
    private String estado;
    private int tamaño;
    
    public Cola(int id, int precio, int ruta, String estado, int tamaño){
    this.id=id;
    this.precio=precio;
    this.ruta=ruta;
    this.estado=estado;
            this.tamaño=tamaño;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}