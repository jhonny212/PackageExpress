/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operator;

import static Inicio.IniciarConeccion.connection;
import static Inicio.Welcome.USER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select extends javax.swing.JFrame {

    /**
     * Creates new form Select
     */
    public Select() {
        initComponents();
        this.setLocationRelativeTo(this);
        ComboRuta();
       
    }
    
 public void ComboRuta(){
 ComboRutas.removeAllItems();
 
   try {
         PreparedStatement declaracion =connection.prepareStatement("SELECT ruta.direccion_rta, ruta.id_ruta FROM ruta WHERE estado=?" );
         declaracion.setString(1, "activo");
         ResultSet re=declaracion.executeQuery();
         while(re.next()){
         ComboRutas.addItem(re.getString("direccion_rta")+" "+"ID:"+re.getString("id_ruta"));
         }
         
         
        } catch (SQLException ex) {
        
        }
 }   
    
public void ActualizarCombo(){
  PC.removeAllItems();
  System.out.println("aaaaa"); 
  try {
          PreparedStatement declaracion =connection.prepareStatement("SELECT controlPoint.id_pc, controlPoint.estadoPc FROM controlPoint WHERE estadoPc=? && direccion_rta=? ");
          declaracion.setString(1, "Activo");
          declaracion.setInt(2,codigoRuta);
           ResultSet res=declaracion.executeQuery();
            while(res.next()){
    this.PC.addItem(res.getString("id_pc"));
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

        jPanel1 = new javax.swing.JPanel();
        PC = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Asignar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ComboRutas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(168, 160, 151));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCActionPerformed(evt);
            }
        });
        jPanel1.add(PC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 110, -1));

        jLabel1.setFont(new java.awt.Font("Uroob", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Puntos de control libre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, -1));

        Asignar.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        Asignar.setText("Asignar");
        Asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarActionPerformed(evt);
            }
        });
        jPanel1.add(Asignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Back.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 30));

        jButton3.setText("Buscar ruta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 110, -1));

        ComboRutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(ComboRutas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -3, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarActionPerformed
     
        int ID=0;
        if(PC.getSelectedItem()!=null){
        ID=Integer.parseInt(PC.getSelectedItem().toString());
        
      try {
          PreparedStatement declaracion;
          declaracion=connection.prepareStatement("UPDATE controlPoint SET estadoPc=? WHERE id_pc=?");
          declaracion.setString(1, USER);
          declaracion.setInt(2, ID);
          declaracion.executeUpdate();
     
          
      } catch (SQLException ex) {
      
      }}

      ActualizarCombo();
    }//GEN-LAST:event_AsignarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        operator a=new operator();
        a.show();
        dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PCActionPerformed
int codigoRuta;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(!ComboRutas.getSelectedItem().toString().equals("")){
       codigoRuta=Integer.parseInt(obtenerLetra());
       ActualizarCombo(); 
       }
       
       
    }//GEN-LAST:event_jButton3ActionPerformed
 public String obtenerLetra(){
     String letra="";
       String tmp=ComboRutas.getSelectedItem().toString();
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
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Select.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Select().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Asignar;
    private javax.swing.JComboBox<String> ComboRutas;
    private javax.swing.JComboBox<String> PC;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
