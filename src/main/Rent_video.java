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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author lightway
 */
public class Rent_video extends javax.swing.JFrame {

    /**
     * Creates new form Rent_video
     */
    private DB DBconn = null;

    public Rent_video() {
        initComponents();
        DBconn = new DB();
        fillCustomers();
        fillVideo();
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

    private void fillVideo() {
        cmbVideo.removeAllItems();
        ArrayList dnameList = getvideoName();
        Iterator i = dnameList.iterator();

        while (i.hasNext()) {
            cmbVideo.addItem(i.next());
            
        }
    }

    public ArrayList getvideoName() {
        ArrayList cus = null;
        Connection dbConn = null;

        try {
            dbConn = DBconn.conect();
            Statement stmt = dbConn.createStatement();

            String query = "Select title FROM video where available=1 ";

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

            String query = "Select cus_name FROM video where title='"+cmbVideo.getSelectedItem().toString()+"' ";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                txtReserveCustomer.setText(rs.getString(1));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFrom = new javax.swing.JTextField();
        txtTo = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        btnRentVideo = new javax.swing.JButton();
        cmbCustomer = new javax.swing.JComboBox();
        cmbVideo = new javax.swing.JComboBox();
        txtReserveCustomer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGetReserveCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Rent Video");

        jLabel2.setText("Customer ");

        jLabel3.setText("Video");

        jLabel4.setText("From");

        jLabel5.setText("To");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnRentVideo.setText("Rent Video");
        btnRentVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentVideoActionPerformed(evt);
            }
        });

        cmbCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerItemStateChanged(evt);
            }
        });

        txtReserveCustomer.setEditable(false);

        jLabel6.setText("Reserved Customer");

        btnGetReserveCustomer.setText("Get Reserve Customer");
        btnGetReserveCustomer.setToolTipText("");
        btnGetReserveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetReserveCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbVideo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTo)
                            .addComponent(txtFrom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReserveCustomer)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnGetReserveCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(btnRentVideo)
                        .addGap(15, 15, 15)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReserveCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRentVideo)
                    .addComponent(btnClose)
                    .addComponent(btnGetReserveCustomer))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnRentVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentVideoActionPerformed
        // TODO add your handling code here:
        String From = txtFrom.getText();
        String To = txtTo.getText();
        String Cus = cmbCustomer.getSelectedItem().toString();
        String Video = cmbVideo.getSelectedItem().toString();

        int result1 = JOptionPane.showConfirmDialog(null, "Are you sure you "
                + "want to add this record to the system...? ", " Warning...!",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result1 == JOptionPane.YES_OPTION) {
            boolean result = false;
            Connection dbConn = null;
            try {
                dbConn = DBconn.conect();

                String query = "INSERT INTO `rent_video` (`customer`, `video`, `form_date`, `to_date`) VALUES(?,?,?,?)";

                PreparedStatement enrollStmt = dbConn.prepareStatement(query);
                enrollStmt.setString(1, Cus);
                enrollStmt.setString(2, Video);
                enrollStmt.setString(3, From);
                enrollStmt.setString(4, To);

                int val2 = enrollStmt.executeUpdate();
                if ((val2 == 1)) {

                    dbConn = DBconn.conect();

                    Statement stmt1 = dbConn.createStatement();
                    String query1 = "Update video set available=0 where title='" + Video + "' ";

                    stmt1.executeUpdate(query1);                 

                    JOptionPane.showMessageDialog(null, "The record Successfully added to the system");
                    txtFrom.setText("");
                    txtTo.setText("");
                    getvideoName();
                    
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
    }//GEN-LAST:event_btnRentVideoActionPerformed

    private void cmbCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerItemStateChanged

    private void btnGetReserveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetReserveCustomerActionPerformed
        // TODO add your handling code here:
        outstanding();
    }//GEN-LAST:event_btnGetReserveCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(Rent_video.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rent_video.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rent_video.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rent_video.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rent_video().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnGetReserveCustomer;
    private javax.swing.JButton btnRentVideo;
    private javax.swing.JComboBox cmbCustomer;
    private javax.swing.JComboBox cmbVideo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFrom;
    private javax.swing.JTextField txtReserveCustomer;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
