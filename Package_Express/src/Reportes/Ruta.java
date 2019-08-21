/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author jhonny
 */
public class Ruta {
    private int EnRuta;
    private int Entregado;
    private int idRuta;
    public Ruta(int ER, int E){
    this.EnRuta=ER;
    
    this.Entregado=E;
    }

    public int getEnRuta() {
        return EnRuta;
    }

    public void setEnRuta(int EnRuta) {
        this.EnRuta = EnRuta;
    }

    public int getEntregado() {
        return Entregado;
    }

    public void setEntregado(int Entregado) {
        this.Entregado = Entregado;
    }

}
