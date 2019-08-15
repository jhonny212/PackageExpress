/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraClasses;

import java.util.LinkedList;

/**
 *
 * @author jhonny
 */
public class ColaRuta {
    private LinkedList <Cola> a;
    private int name;

    ColaRuta(LinkedList<Cola> COLA, int Name) {
        this.a=COLA;
        this.name=Name;
    }

  



    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public LinkedList<Cola> getA() {
        return a;
    }

    public void setA(LinkedList<Cola> a) {
        this.a = a;
    }


  
}
