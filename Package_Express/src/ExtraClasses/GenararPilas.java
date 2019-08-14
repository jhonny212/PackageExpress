/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraClasses;
import static Inicio.IniciarConeccion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
public class GenararPilas {

    /**
     *
     */
    
    public LinkedList <ColaRuta> COLARUTA =new LinkedList();
    
    public GenararPilas(){
    
    }
  
    public void GeneratePilas(){
         LinkedList <Integer> Ruta=null;  
         LinkedList <Integer> Pc=null;
         Ruta=new LinkedList();
         Pc=new LinkedList();
        try {
        PreparedStatement declaracion =connection.prepareStatement("SELECT ruta.id_ruta FROM ruta ");
        ResultSet res=declaracion.executeQuery();
        while(res.next()){
        Ruta.add(res.getInt("id_ruta"));
        
        }
        
        } catch (SQLException ex) {
        }
        
          try {
        PreparedStatement declaracion =connection.prepareStatement("SELECT controlPoint.direccion_rta FROM controlPoint ");
        ResultSet res=declaracion.executeQuery();
        while(res.next()){
        Pc.add(res.getInt("direccion_rta"));
        }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
      
        for(int i=0;i<Ruta.size();i++){
        for(int j=0;j<Pc.size();j++){
        if(Objects.equals(Ruta.get(i), Pc.get(j))){
  
               
            try {
        PreparedStatement declaracion =connection.prepareStatement("SELECT * FROM controlPoint WHERE direccion_rta=?");
        declaracion.setInt(1,Pc.get(j));
        ResultSet res=declaracion.executeQuery();
        int id=0;
        LinkedList <Cola[]> COLA=null;
        COLA=new LinkedList();
  
        while(res.next()){
             id=res.getInt("id_pc");
           
           Cola [] cola=new Cola[res.getInt("tamaño")];

           //cola[1]=new Cola(null);//res.getInt("id_pc"),res.getInt("precioPc"),res.getInt("direccion_rta"),res.getString("estadoPc"),res.getInt("tamaño"));
           
           COLA.add(cola);
       
        
        }
        
       ColaRuta c=null;
       c=new ColaRuta(COLA,Pc.get(j));
      
      COLARUTA.add(c);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
           break; 
        }
        
        }
        }  
  
       RecorrerColas();
    }
    
    public void RecorrerColas(){
     System.out.println(COLARUTA.size());
    int a=0;
    for(int i=0; i<COLARUTA.size();i++){
        if(1==COLARUTA.get(i).getName()){
        a=i;
        }
    
    }
     LinkedList<Cola[]> c=COLARUTA.get(a).getA();
       for(int i=0;i<c.size();i++){
           Cola ass[]=c.get(i);
           
       System.out.println(ass.getClass());
       }
    
      
   
    }
    
    
}
