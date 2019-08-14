/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Inicio.IniciarConeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Inicio.IniciarConeccion.connection;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonny
 */
public class EliminarRuta extends javax.swing.JInternalFrame {

    /**
     * Creates new form EliminarRuta
     */
    public EliminarRuta() {
        initComponents();
        llenarCombo();
    }
public void llenarCombo(){
combo.removeAllItems();
        try {
         PreparedStatement declaracion =connection.prepareStatement("SELECT ruta.direccion_rta, ruta.id_ruta FROM ruta " );
         ResultSet re=declaracion.executeQuery();
         while(re.next()){
         combo.addItem(re.getString("direccion_rta")+" "+"ID:"+re.getString("id_ruta"));
         }
         
         
        } catch (SQLException ex) {
        
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

        jLabel1 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 116, 116));
        jLabel1.setText("SELECCIONA RUTA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 110, -1));

        jButton1.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 90, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 420, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
boolean validar=true;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validar=true;
        try {
            String tmp="";
            tmp=obtenerLetra(tmp);
            
        PreparedStatement declaracion =connection.prepareStatement("DELETE FROM ruta WHERE id_ruta=?");
        declaracion.setInt(1, Integer.parseInt(tmp));
        int rs=declaracion.executeUpdate();
        
        if(rs>0){
        JOptionPane.showMessageDialog(this,"Ruta eliminada");
        validar=false;
        
       
       llenarCombo();
        }
                } catch (SQLException ex) {
      
        }
        
  if(validar){
  JOptionPane.showMessageDialog(this, "No se pudo borrar");
  
  }
  
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public String obtenerLetra(String letra){
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
    
        
        
        
    return letra;}
    
    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
       
    }//GEN-LAST:event_comboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}