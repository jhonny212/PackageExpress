/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object_Classes;

/**
 *
 * @author jhonny
 */
public class Cliente {
    private String Name;
    private int cui;
    private int nit;
    private String direccion;
    public Cliente(String name, int cui, int nit,String direccion){
    this.Name=name;
    this.cui=cui;
    this.nit=nit;
    this.direccion=direccion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCui() {
        return cui;
    }

    public void setCui(int cui) {
        this.cui = cui;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }



}
