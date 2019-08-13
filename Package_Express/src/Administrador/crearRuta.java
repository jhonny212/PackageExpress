/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Inicio.IniciarConeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonny
 */
public class crearRuta extends javax.swing.JInternalFrame {

    /**
     * Creates new form crearRuta
     */
    public crearRuta() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(21, 9, 9));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Precio ruta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Direccion ruta");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel1.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 110, -1));
        jPanel1.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 110, -1));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 80, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruta.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        PreparedStatement declaracion=null;
        boolean validar=true;
        if(validar()){
           
        try {
            // TODO add your handling code here:
         IniciarConeccion a=new IniciarConeccion();
         Connection connection=null;
         connection=a.getConnection();
             declaracion=connection.prepareStatement("INSERT INTO ruta(precio_rta, direccion_rta) VALUES (?, ?)");
            declaracion.setInt(1, Integer.parseInt(precio.getText()));
            declaracion.setString(2,direccion.getText() );
              int  rs=declaracion.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(this, "Ruta creada correctamente");
                validar=false;
                }
        } catch (SQLException ex) {
        
        }
        }else{
        JOptionPane.showMessageDialog(this,"LLene los datos");
        }        
        
        precio.setText(null);
        direccion.setText(null);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean validar(){
    
    if(direccion.getText().equals("") || precio.getText().equals("") )
        return false;
    else return true;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}
