/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import Inicio.IniciarConeccion;
import static Inicio.IniciarConeccion.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.lang.NullPointerException;

/**
 *
 * @author jhonny
 */
public class AsiganarPrecio extends javax.swing.JInternalFrame {

    /**
     * Creates new form AsiganarPrecio
     */
    public AsiganarPrecio() {
        initComponents();
        llenarCombo();
    }
   public void llenarCombo(){
combo.removeAllItems();

        try {
            
         PreparedStatement declaracion =connection.prepareStatement("SELECT controlPoint.id_pc FROM controlPoint " );
         declaracion.setString(1, "activo");
         ResultSet re=declaracion.executeQuery();
         while(re.next()){
         combo.addItem("ID:"+re.getString("id_pc"));
         }
         
         
        } catch (SQLException ex) {
        
        }

}
   public int obtenerLetra(){
       String letra="0";
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
        
        
        int a=Integer.parseInt(letra);
    return a;
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
        combo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        precio = new javax.swing.JTextField();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(223, 199, 175));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(precio.getText().equals("0")){
           int cost=0;
            try {
                PreparedStatement declaracion=null;
                  PreparedStatement G =connection.prepareStatement("SELECT datos.precioEnvio FROM datos ");
           
            ResultSet Gs=G.executeQuery();
            while(Gs.next()){
              cost=Gs.getInt("precioEnvio");
            }
            
                declaracion=connection.prepareStatement("UPDATE controlPoint SET precioPc=? WHERE id_pc=?");
                declaracion.setInt(1, cost);
              
                 int  rs=declaracion.executeUpdate();
            
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }catch(NullPointerException s){
            }
       
       }else{
          try {
                PreparedStatement declaracion=null;
                IniciarConeccion a=new IniciarConeccion();
                Connection connection=null;
                connection=a.getConnection();
                declaracion=connection.prepareStatement("UPDATE controlPoint SET precioPc=? WHERE id_pc=?");
                declaracion.setInt(1, Integer.parseInt(precio.getText()));
                declaracion.setInt(2, obtenerLetra());
                 int  rs=declaracion.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(this, "Dato actualizado correctamente");
            
                }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }catch(NullPointerException s){
            }
       }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}