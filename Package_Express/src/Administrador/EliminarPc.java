/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import static Inicio.IniciarConeccion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ExtraClasses.GenararPilas;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;

/**
 *
 * @author jhonny
 */
public class EliminarPc extends javax.swing.JInternalFrame {

    /**
     * Creates new form EliminarPc
     */
    public EliminarPc() {
        initComponents();
        combo.removeAllItems();
        combo2.removeAllItems();  
     
        llenarComboRuta();
       jButton2.disable();
    }

    public void llenarComboRuta(){
       try {
           
         PreparedStatement declaracion =connection.prepareStatement("SELECT ruta.direccion_rta, ruta.id_ruta FROM ruta WHERE estado=?" );
             declaracion.setString(1, "activo");
         ResultSet re=declaracion.executeQuery();
         while(re.next()){
         combo.addItem(re.getString("direccion_rta")+" "+"ID:"+re.getString("id_ruta"));
         }
         
         
        } catch (SQLException ex) {
        
        }
    
    
    }
    public void llenarPc(){
      combo2.removeAllItems();  
      String tmp="";
    
      tmp=obtenerLetra(tmp);   
      try {
         PreparedStatement declaracion =connection.prepareStatement("SELECT controlPoint.id_pc FROM controlPoint WHERE direccion_rta=? ");
    
         declaracion.setString(1, tmp);
      
         ResultSet re=declaracion.executeQuery();
         
         while(re.next()){
          
         combo2.addItem("ID:"+re.getString("id_pc"));
         
         }
         
         
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        } catch(NumberFormatException e){
        
        }
    
    
    }
    
    public String obtenerLetra(String letra){
     try{
     
     
     String tmp=combo.getSelectedItem().toString();
     String [] vect=tmp.split("");
     String numbers="1234567890";
     String [] vect2=numbers.split("");
     
     for(int i=0; i<tmp.length();i++){
       
     for(int j=0;j<numbers.length();j++){
         
     if(vect[i].equals(vect2[j]))
     {
        letra+=vect[i]; 
     
     break;
     }
     }
     }
    
        
       }catch(NullPointerException e){
     
     } 
        
    return letra;}
    
     public String obtenerLetra2(String letra){
         String tmp=combo2.getSelectedItem().toString();
     String [] vect=tmp.split("");
     String numbers="1234567890";
     String [] vect2=numbers.split("");
     
     for(int i=0; i<tmp.length();i++){
       
     for(int j=0;j<numbers.length();j++){
         
     if(vect[i].equals(vect2[j]))
     {
        letra+=vect[i]; 
     
     break;
     }
     }
     }
    
        
        
        
    return letra;}
    
    boolean validarPc;
    public void validarPC()
    {
       
    validarPc=true;
    int count=0;
   
        
        try {
            PreparedStatement declaracion =connection.prepareStatement("SELECT paquete.estado FROM paquete WHERE id_pc=? ");
            String tmp="";
            tmp=obtenerLetra2(tmp);
            declaracion.setInt(1, Integer.parseInt(tmp));
            ResultSet res=declaracion.executeQuery();
            while(res.next()){
              count++;
            }
            if(count>0){
            this.validarPc=false;
            }
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
     
    
    }
     
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        combo2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("SELECCIONAR RUTA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 130, -1));

        jButton1.setBackground(new java.awt.Color(135, 135, 116));
        jButton1.setForeground(new java.awt.Color(16, 6, 6));
        jButton1.setText("Buscar puntos de control");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 120, -1));

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 420, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           llenarPc();
        
    }//GEN-LAST:event_jButton1ActionPerformed
public boolean validar=true;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        validar=true;
        try{
        
        
             jButton2.enable();
        validarPC();
        
        if(validarPc){
        try {
            String tmp="";
            tmp=obtenerLetra2(tmp);
            
        PreparedStatement declaracion =connection.prepareStatement("DELETE FROM controlPoint WHERE id_pc=?");
        declaracion.setInt(1, Integer.parseInt(tmp));
        int rs=declaracion.executeUpdate();
        
        if(rs>0){
        JOptionPane.showMessageDialog(this,"Punto de control eliminada");
        validar=false;
        GenararPilas a=new GenararPilas();
        a.GeneratePilas();
       combo2.removeAllItems();  
       llenarPc();
        }
                } catch (SQLException ex) {
      
        }}
         
        }catch(NullPointerException ex){
        
        }
        
         
        
  if(validar){
  JOptionPane.showMessageDialog(this, "No se pudo borrar");
  
  }
  
      
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
