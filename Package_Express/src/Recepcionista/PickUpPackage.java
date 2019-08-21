/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recepcionista;

import ExtraClasses.Paquete;
import static Inicio.IniciarConeccion.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonny
 */
public class PickUpPackage extends javax.swing.JFrame {

    /**
     * Creates new form PickUpPackage
     */
    public PickUpPackage() {
        initComponents();
         this.setLocationRelativeTo(this);
         pickup.disable();
         paquete=new LinkedList(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cui = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        CUI = new javax.swing.JLabel();
        pickup = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(189, 178, 168));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Uroob", 1, 36)); // NOI18N
        jLabel2.setText("RECOGER PAQUETES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 240, 40));

        cui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuiKeyTyped(evt);
            }
        });
        jPanel1.add(cui, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 120, -1));

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        jPanel1.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 50, -1));

        CUI.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        CUI.setText("CUI");
        jPanel1.add(CUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        pickup.setText("Recoger paquetes");
        pickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickupActionPerformed(evt);
            }
        });
        jPanel1.add(pickup, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, 40));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id paquete", "Cui", "Ruta", "Peso"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 410, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/client.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents
LinkedList <Paquete> paquete;   
    
    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
    if(!cui.getText().equals("")){
    pickup.enable();
    llenarTabla();
     
       }else{
       pickup.disable();
       }
    }//GEN-LAST:event_okActionPerformed
public void llenarTabla(){
    
    try {
   
    PreparedStatement actualizar =connection.prepareStatement("SELECT paquete.peso, paquete.id_ruta"
            + ", paquete.id_paquete FROM paquete WHERE cui=? && estado=?");
    
    actualizar.setInt(1, Integer.parseInt(cui.getText()));
    actualizar.setString(2,"destino");
    ResultSet res=actualizar.executeQuery();
    while(res.next()){
         Paquete tmp=new Paquete(res.getInt("id_paquete"),res.getInt("peso"),res.getInt("id_ruta"),null,0,null,Integer.parseInt(cui.getText()),0);
         paquete.add(tmp);
    }
    
     String matris[][]=new String[paquete.size()][4];
    for(int i=0; i<paquete.size();i++){
    matris[i][0]=Integer.toString(paquete.get(i).getId_paquete());
    matris[i][1]=Integer.toString(paquete.get(i).getCui());
    matris[i][2]=Integer.toString(paquete.get(i).getId_ruta());
    matris[i][3]=Integer.toString(paquete.get(i).getPeso());
    }
    
         tabla.setModel(new javax.swing.table.DefaultTableModel(
          matris,
           new String [] {
                "Id paquete", "Cui", "Ruta", "Peso"
            }
        ));
     tabla.disable();
    
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"No hay paquetes");
        }
    
    
}
    private void cuiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuiKeyTyped
       char c=evt.getKeyChar();
         if(Character.isDigit(c) ){   
       
        }else{
          getToolkit().beep();
        evt.consume();
         }
    }//GEN-LAST:event_cuiKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Recepcionist a=new Recepcionist();
        a.show();
        dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickupActionPerformed
     for(int i=0; i<paquete.size();i++){
     
         try {
             PreparedStatement update=connection.prepareStatement("UPDATE paquete SET estado=?, id_pc=? WHERE id_paquete=?");
             update.setString(1,"entregado");
             update.setInt(2, -2);
             update.setInt(3, paquete.get(i).getId_paquete());
             update.executeUpdate();
             tabla.removeAll();
             llenarTabla();
             } 
              catch (SQLException ex) {
             }
                
                               
     }   
        
    }//GEN-LAST:event_pickupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PickUpPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PickUpPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PickUpPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PickUpPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PickUpPackage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CUI;
    private javax.swing.JTextField cui;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JButton pickup;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
