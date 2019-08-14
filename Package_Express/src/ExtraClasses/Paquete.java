/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraClasses;


public class Paquete {
    private int id_paquete;
    private int peso;
    private int id_ruta;
    private String estado;
    private int precio;
    private String prioridad;
    private int cui;
    private int id_pc;
    public Paquete(int idp, int peso, int ruta, String state, int cost, String priori, int cui, int pc){
        this.id_paquete=idp;
        this.peso=peso;
        this.id_ruta=ruta;
        this.estado=state;
        this.precio=cost;
        this.prioridad=priori;
        this.cui=cui;
        this.id_pc=pc;
        
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public int getId_pc() {
        return id_pc;
    }

    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }
    
    public void ActualizarPaquete(Paquete tmp){
    
        
    }
}
