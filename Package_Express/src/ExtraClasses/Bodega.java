package ExtraClasses;
import static ExtraClasses.GenararPilas.COLARUTA;
import static Inicio.IniciarConeccion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Bodega {
 public LinkedList<Paquete> paquetes;
    public Bodega(){
        paquetes=new LinkedList();
 
 } 
public void ActualizarBodega(){
     try {
            PreparedStatement declaracion =connection.prepareStatement("SELECT * FROM paquete WHERE id_pc=?");
            declaracion.setInt(1, 0);
            ResultSet res=declaracion.executeQuery();
            while(res.next()){
            Paquete tmp=null;
            int codP=res.getInt("id_paquete");
            int peso=res.getInt("peso");
            int ruta=res.getInt("id_ruta");
            String stado=res.getString("estado");
            int precio=res.getInt("precio");
            String prioridad=res.getString("prioridad");
            int cui=res.getInt("cui");
            int PC=res.getInt("id_pc");
            tmp=new Paquete(codP,peso,ruta,stado,precio,prioridad,cui,PC);
            paquetes.add(tmp);
          }
        } catch (SQLException ex) {
        
        }
   
    RecorrerPaquetes();
       
}

public void RecorrerPaquetes(){
 
    for(int i=0; i<paquetes.size();i++){
    for(int j=0; j<COLARUTA.size();j++){
       if(paquetes.get(i).getId_ruta()==COLARUTA.get(j).getName()){
          LinkedList<Cola> cola=COLARUTA.get(j).getA();
          if(!cola.get(0).isFull()){
              int id=cola.get(0).getId();
              int idPaquete=paquetes.get(i).getId_paquete();
              paquetes.get(i).setId_pc(cola.get(0).getId());
              cola.get(0).push( paquetes.get(i));
              ActualizarTabla(id, idPaquete);
          }else{
          System.out.println("LLENA");
          }
       } 
    }
    }


}
public void ActualizarTabla(int id, int id2) {
        try {
            PreparedStatement actualizar;
            actualizar=connection.prepareStatement("UPDATE paquete SET id_pc=? WHERE id_paquete=?");
            actualizar.setInt(1,id);
            actualizar.setInt(2, id2);
            actualizar.executeUpdate();
                
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
            
             
    
    }
}
