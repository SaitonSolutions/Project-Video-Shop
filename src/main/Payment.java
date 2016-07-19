/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import DB.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author lightway
 */
public class Payment extends javax.swing.JFrame {

    /**
     * Creates new form Payment
     */
    private DB DBconn = null;
    public Payment() {
        initComponents();
        DBconn = new DB();
        fillCustomers();
    }
    
    private void fillCustomers() {
        cmbCustomer.removeAllItems();
        ArrayList dnameList = getCusName();
        Iterator i = dnameList.iterator();

        while (i.hasNext()) {
            cmbCustomer.addItem(i.next());
        }
    }
    
    public ArrayList getCusName() {
        ArrayList cus = null;
        Connection dbConn = null;

        try {
            dbConn = DBconn.conect();
            Statement stmt = dbConn.createStatement();

            String query = "Select name FROM cus_reg";

            ResultSet rs = stmt.executeQuery(query);
            cus = new ArrayList();

            while (rs.next()) {
                String Name = rs.getString(1);
                cus.add(Name);

            }
        } catch (SQLException s) {
            System.out.println(s + "DBError");
        } finally {
            DBconn.con_close(dbConn);
        }
        return cus;
    }
    
    public void outstanding(){
        Connection dbConn = null;
        try {
            dbConn = DBconn.conect();
            Statement stmt = dbConn.createStatement();

            String query = "Select outstanding FROM cus_reg where name='"+cmbCustomer.getSelectedItem().toString()+"'";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                txtOuststanding.setText(rs.getString(1));
            }
        } catch (SQLException s) {
            System.out.println(s + "DBError");
        } finally {
            DBconn.con_close(dbConn);
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

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOuststanding = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPayment = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        cmbCustomer = new javax.swing.JComboBox();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Payment");

        jLabel2.setText("Customer ");

        jLabel4.setText("Outstanding Amount");

        txtOuststanding.setEditable(false);

        jLabel5.setText("Payment");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnPlay.setText("Pay");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        cmbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOuststanding, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(txtPayment)
                            .addComponent(cmbCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtOuststanding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(btnPlay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cmbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerItemStateChanged
        // TODO add your handling code here:
        outstanding();
    }//GEN-LAST:event_cmbCustomerItemStateChanged

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        String Name = cmbCustomer.getSelectedItem().toString();
        double outstanding = Double.parseDouble(txtOuststanding.getText());
        double payment = Double.parseDouble(txtPayment.getText());
        
        double value=outstanding-payment;

        int result1 = JOptionPane.showConfirmDialog(null, "Are you sure you "
                + "want to pay...? ", " Warning...!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result1 == JOptionPane.YES_OPTION) {
            Connection dbConn = null;
            try {
                dbConn = DBconn.conect();

                Statement stmt = dbConn.createStatement();
                String query = "Update cus_reg set outstanding='"+value+"' where name='"+Name+"' ";

                int val2 = stmt.executeUpdate(query);

                if ((val2 == 1)) {
                    JOptionPane.showMessageDialog(null, "The payment sucessfully made");
                    outstanding();
                    txtPayment.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Payment fail");
                }

            } catch (Exception sQLException) {
                System.out.println(sQLException + "Payment query failed");
            } finally {
                DBconn.con_close(dbConn);
            }
        }
    }//GEN-LAST:event_btnPlayActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPlay;
    private javax.swing.JComboBox cmbCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtOuststanding;
    private javax.swing.JTextField txtPayment;
    // End of variables declaration//GEN-END:variables
}
