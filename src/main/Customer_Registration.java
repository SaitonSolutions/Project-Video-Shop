/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author lightway
 */
public class Customer_Registration extends javax.swing.JFrame {

    /**
     * Creates new form Register_video
     */
    private DB DBconn = null;

    public Customer_Registration() {
        initComponents();
        DBconn = new DB();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Customer Registration");

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Mobile");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        btnSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(52, 52, 52)
                        .addComponent(txtMobile))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        String Name = txtName.getText();
        String Address = txtAddress.getText();
        String Mobile = txtMobile.getText();

        int result1 = JOptionPane.showConfirmDialog(null, "Are you sure you "
                + "want to add this record to the system...? ", " Warning...!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result1 == JOptionPane.YES_OPTION) {
            boolean result = false;
            Connection dbConn = null;
            try {
                dbConn = DBconn.conect();

                String query = "INSERT INTO cus_reg (name,address,mobile) VALUES(?,?,?)";

                PreparedStatement enrollStmt = dbConn.prepareStatement(query);
                enrollStmt.setString(1, Name);
                enrollStmt.setString(2, Address);
                enrollStmt.setString(3, Mobile);

                int val2 = enrollStmt.executeUpdate();
                if ((val2 == 1)) {
                    JOptionPane.showMessageDialog(null, "The record Successfully added to the system");
                    txtName.setText("");
                    txtAddress.setText("");
                    txtMobile.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Inserting record fail");
                }

            } catch (Exception sQLException) {
                System.out.println(sQLException + "Insert query failed");
                result = false;
            } finally {
                DBconn.con_close(dbConn);
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int result1 = JOptionPane.showConfirmDialog(null, "Are you sure you "
                + "want to delete this record from the system...? ", " Warning...!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result1 == JOptionPane.YES_OPTION) {
            boolean result = false;
            Connection dbConn = null;

            try {
                dbConn = DBconn.conect();
                Statement stmt = dbConn.createStatement();

                String query = "delete From cus_reg WHERE name = '" + txtName.getText() + "'";

                System.out.println(query);

                int val = stmt.executeUpdate(query);

                if (val == 1) {
                    JOptionPane.showMessageDialog(null, "The record deleted successfully");
                    txtName.setText("");
                    txtAddress.setText("");
                    txtMobile.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "The record delete fail");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + "The record delete fail");
                result = false;
            } finally {
                DBconn.close();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Connection dbConn = null;
        boolean result=false;

        try {
            dbConn = DBconn.conect();
            Statement stmt = dbConn.createStatement();

            String query = "SELECT name,address,mobile from cus_reg where name Like '" + txtName.getText() + "%' ";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                txtName.setText(rs.getString(1));
                txtAddress.setText(rs.getString(2));
                txtMobile.setText(rs.getString(3));
                result=true;
            }
            
            if(result == false){
                JOptionPane.showMessageDialog(null, "No Record Found..!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "cstomer search fail");
        } finally {
            DBconn.con_close(dbConn);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchKeyReleased

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
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_Registration.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
