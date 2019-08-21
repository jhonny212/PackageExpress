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


/**
 *
 * @author jhonny
 */
public class PackageTable extends javax.swing.JInternalFrame {

public LinkedList<Paquete> paquetes;    
    public PackageTable() {
        initComponents();
        paquetes=new LinkedList();
        RegistrarDatos();
        llenarTabla();
    }

    public void RegistrarDatos(){
        try {
            PreparedStatement listado =connection.prepareStatement("SELECT paquete.id_paquete, paquete.cui, paquete.id_ruta FROM paquete WHERE estado=?");
            listado.setString(1, "destino");
            ResultSet res=listado.executeQuery();
    
        while(res.next()){
            Paquete tmp=new Paquete(res.getInt("id_paquete"),0,res.getInt("id_ruta"),null,0,null,res.getInt("cui"),0);
            paquetes.add(tmp);
        }
        } catch (SQLException ex) {
        
        }
    
    }
    public void llenarTabla(){
    String matris[][]=new String[paquetes.size()][3];
    for(int i=0; i<paquetes.size();i++){
    matris[i][0]=Integer.toString(paquetes.get(i).getId_paquete());
    matris[i][1]=Integer.toString(paquetes.get(i).getCui());
    matris[i][2]=Integer.toString(paquetes.get(i).getId_ruta());
 
    }
    
       
     tabla.setModel(new javax.swing.table.DefaultTableModel(
          matris,
            new String [] {
                "Cod_paquete", "Cui_client", "Ruta"
            }
        ));
     tabla.disable();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(222, 232, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(171, 171, 174));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 400, 30));

        jPanel3.setBackground(new java.awt.Color(196, 186, 186));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 350, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_paquete", "Cui_client", "Ruta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 400, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
