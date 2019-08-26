/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import ExtraClasses.GenararPilas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static Inicio.IniciarConeccion.connection;
/**
 *
 * @author jhonny
 */
public class crearPC extends javax.swing.JInternalFrame {

    /**
     * Creates new form crearPC
     */
    public crearPC() {
        initComponents();
        llenarCombo();
    }
    
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
    
public void llenarCombo(){
   
        try {
         PreparedStatement declaracion =connection.prepareStatement("SELECT ruta.direccion_rta, ruta.id_ruta FROM ruta WHERE estado=? " );
         declaracion.setString(1, "activo" );
         ResultSet re=declaracion.executeQuery();
         while(re.next()){
         combo.addItem(re.getString("direccion_rta")+" "+"ID"+re.getString("id_ruta"));
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

        jPanel1 = new javax.swing.JPanel();
        precio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tamaño = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(157, 158, 167));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 90, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel1.setText("Precio");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel3.setText("Tamaño");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        jPanel1.add(tamaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, -1));

        jButton1.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jButton1.setText("Crear pc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 110, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jLabel4.setText("Ruta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean validar=true;
        if(validar()){
             String tmp="";
            tmp=obtenerLetra(tmp);
    try {
         PreparedStatement declaracion=null;
         IniciarConeccion a=new IniciarConeccion();
         Connection connection=null;
         connection=a.getConnection();
            declaracion=connection.prepareStatement("INSERT INTO controlPoint(precioPc, direccion_rta,estadoPc, tamaño) VALUES (?, ?, ?, ?)");
            declaracion.setInt(1, Integer.parseInt(precio.getText()));
            declaracion.setString(2,tmp );
            declaracion.setString(3, "Activo");
            declaracion.setInt(4, Integer.parseInt(tamaño.getText()));
              int  rs=declaracion.executeUpdate();
            if(rs>0){
                JOptionPane.showMessageDialog(this, "Punto de control creado correctamente");
              validar=false;
              GenararPilas abrir=new GenararPilas();
        abrir.GeneratePilas();
                }
        } catch (SQLException ex) {
        
        }       
        }else{
        JOptionPane.showMessageDialog(this, "Llene los datos");
        }
        
        if(validar){
           JOptionPane.showMessageDialog(this, "Error, no se puede crear");
             
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed
public boolean validar(){
if(precio.getText().equals("") || tamaño.getText().equals(""))
    return false;
else return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField tamaño;
    // End of variables declaration//GEN-END:variables
}
