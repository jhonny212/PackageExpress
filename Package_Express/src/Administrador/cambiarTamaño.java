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

/**
 *
 * @author jhonny
 */
public class cambiarTamaño extends javax.swing.JInternalFrame {

    /**
     * Creates new form cambiarTamaño
     */
    public cambiarTamaño() {
        initComponents();
        llenarCombo();
    }
public void llenarCombo(){
combo.removeAllItems();
        try {
         PreparedStatement declaracion =connection.prepareStatement("SELECT controlPoint.id_pc FROM controlPoint " );
         ResultSet re=declaracion.executeQuery();
         while(re.next()){
         combo.addItem(re.getString("id_pc"));
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

        combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tamaño = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 130, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel2.setText("SELECCIONAR PUNTO DE CONTROL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        tamaño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tamañoKeyTyped(evt);
            }
        });
        getContentPane().add(tamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 110, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel3.setText("tamaño");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, 30));

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 110, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jLabel4.setText("ID punto de control");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tamañoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tamañoKeyTyped
        // TODO add your handling code here:
        
                    char validar=evt.getKeyChar();
          if(Character.isLetter(validar) ){   
        getToolkit().beep();
        evt.consume();
        }
        
        
    }//GEN-LAST:event_tamañoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    boolean validar=true;
        if(validar()){
                try {
                PreparedStatement declaracion=null;
                declaracion=connection.prepareStatement("UPDATE controlPoint SET tamaño=? WHERE id_pc=?");
                declaracion.setInt(1, Integer.parseInt(tamaño.getText()));
                declaracion.setString(2, combo.getSelectedItem().toString());
                 int  rs=declaracion.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(this, "Dato actualizado correctamente");
              validar=false;
                }
            } catch (SQLException ex) {
            
            }
            
        
        }else{
        JOptionPane.showMessageDialog(this,"Llene los datos");
        }
        if(validar){
          JOptionPane.showMessageDialog(this, "Llene el dato");
              
        }    
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

 public boolean validar(){
    if(tamaño.getText().equals(""))
        return false;
    else return true;
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tamaño;
    // End of variables declaration//GEN-END:variables
}
