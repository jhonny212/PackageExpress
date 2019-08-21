/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraClasses;

import javax.swing.JOptionPane;

/**
 *
 * @author jhonny
 */
public class Cola {
    private int id;
    
    private int precio;
    private int ruta;
    private String estado;
    
    private int capacidad;
     Paquete paquete[];
//  int tamaño=0;
  int top = -1;
    int rear = 0;
    
    public Cola( int tamaño){

   this.capacidad=tamaño;
   paquete=new Paquete[tamaño];
    }

    public void push(Paquete tmp){
        System.out.println("hil");
        if(top<capacidad -1){
            top++;
            paquete[top]= tmp;
            System.out.println("Numero "+ tmp + " es ingresado a la cola!");
            
        }
        else{
            System.out.println("Cola sobrecargada");
        }
    }
    
      public boolean isFull()
    {
        return top==capacidad-1;
    }
     public int getDisponibilidad() {
        return (capacidad-1-top);
    }
     public Paquete pop(){
        if(top>=0){
            Paquete numero = paquete[0];
            System.out.println("Obtener "+numero);
            ordenar();
            top--;
            return numero;
        }
        else{
            setEstado("Llena");
          return null;
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    private void ordenar() {
        if(top>0){
            for(int i= 0; i<top; i++)
            {
                if(i<top){
                    paquete[i]= paquete[i+1];
                }
                if(i==top)
                    paquete[i]=null;
            }
        }
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

         public int getTamaño(){
         return top;
         }    
          

}
