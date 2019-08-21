
package ExtraClasses;
import static Inicio.IniciarConeccion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Objects;
import java.lang.IndexOutOfBoundsException;


public class GenararPilas {

    
    public static LinkedList <ColaRuta> COLARUTA;
    
    public GenararPilas(){
    COLARUTA=new LinkedList();
    }
  
    public void GeneratePilas(){
         LinkedList <Integer> Ruta=null;  
         LinkedList <Integer> Pc=null;
         Ruta=new LinkedList();
         Pc=new LinkedList();
        try {
        PreparedStatement declaracion =connection.prepareStatement("SELECT ruta.id_ruta FROM ruta WHERE estado=? ");
        declaracion.setString(1, "activo");
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
        LinkedList <Cola> COLA=null;
        COLA=new LinkedList();
  
        while(res.next()){
             id=res.getInt("id_pc");
           
           Cola cola=null;
           cola=new Cola(res.getInt("tamaño"));
           cola.setEstado("Vacia");
           cola.setId(res.getInt("id_pc"));
           cola.setPrecio(res.getInt("precioPc"));
           cola.setRuta(res.getInt("direccion_rta"));
           
           
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
  
     LlenarPilas();

      
    }
    
      public void RecorrerColas(){
    
    int a=0;
    for(int i=0; i<COLARUTA.size();i++){
        if(2==COLARUTA.get(i).getName()){
        a=i;
        }
    
    }
       LinkedList<Cola> c=COLARUTA.get(a).getA();
     
     
       
  try{
   
  }catch(IndexOutOfBoundsException e){

  }
       
    
    }
    public void LlenarPilas(){

        try {
            PreparedStatement llenar =connection.prepareStatement("SELECT * FROM paquete ");
            ResultSet res=llenar.executeQuery();
            while(res.next()){
            int codP=res.getInt("id_paquete");
            int peso=res.getInt("peso");
            int ruta=res.getInt("id_ruta");
            String stado=res.getString("estado");
            int precio=res.getInt("precio");
            String prioridad=res.getString("prioridad");
            int cui=res.getInt("cui");
            int PC=res.getInt("id_pc");
            Paquete tmp=new Paquete(codP,peso,ruta,stado,precio,prioridad,cui,PC);
          
    int a=0;
    for(int i=0; i<COLARUTA.size();i++){
        if(ruta==COLARUTA.get(i).getName()){
        a=i;
        }
    
    }
    try{
          LinkedList<Cola> c=COLARUTA.get(a).getA();
                for(int i=0; i<c.size();i++){
                    if(c.get(i).getId()==PC){
                        c.get(i).push(tmp);
                    }
                }
    }catch(IndexOutOfBoundsException e){
    
    }
   
            }
            
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    
    }



 

   
}
