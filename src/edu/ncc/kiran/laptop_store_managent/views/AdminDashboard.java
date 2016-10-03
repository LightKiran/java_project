/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;

/**
 *
 * @author kiran
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    UserInfo loggedInUserInfo;
    Database db = new Database();

    public AdminDashboard(UserInfo loggedInUserInfo) {
        initComponents();
        setLocationRelativeTo(null);
        db.GetDbConnection();
        // conn = Database.conn;
        this.loggedInUserInfo = loggedInUserInfo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAdd = new javax.swing.JMenu();
        jMenuItemUser = new javax.swing.JMenuItem();
        jMenuItemLaptopBrand = new javax.swing.JMenuItem();
        jMenuItemLaptop = new javax.swing.JMenuItem();
        jMenuItemCustomer = new javax.swing.JMenuItem();
        jMenuItemCustomerTransaction = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");

        jLayeredPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 102), 1, true));
        jLayeredPane1.setForeground(new java.awt.Color(51, 0, 255));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuAdd.setText("Add");

        jMenuItemUser.setText("User");
        jMenuItemUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUserActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemUser);

        jMenuItemLaptopBrand.setText("Laptop brand");
        jMenuItemLaptopBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLaptopBrandActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemLaptopBrand);

        jMenuItemLaptop.setText("Laptop");
        jMenuItemLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLaptopActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemLaptop);

        jMenuItemCustomer.setText("Customer");
        jMenuItemCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustomerActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemCustomer);

        jMenuItemCustomerTransaction.setText("Customer Transaction");
        jMenuItemCustomerTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCustomerTransactionActionPerformed(evt);
            }
        });
        jMenuAdd.add(jMenuItemCustomerTransaction);

        jMenuBar1.add(jMenuAdd);

        jMenu5.setText("Edit");
        jMenuBar1.add(jMenu5);

        jMenu7.setText("jMenu7");
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(477, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUserActionPerformed
        // TODO add your handling code here:
        AddNewUserPanel users = new AddNewUserPanel(loggedInUserInfo);
        this.setContentPane(users);
        this.validate();
    }//GEN-LAST:event_jMenuItemUserActionPerformed

    private void jMenuItemLaptopBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLaptopBrandActionPerformed
        // TODO add your handling code here:
        final AddNewLaptopBrand objaddAddNewLaptopBrand = new AddNewLaptopBrand(new javax.swing.JFrame(), true, loggedInUserInfo);
        objaddAddNewLaptopBrand.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                objaddAddNewLaptopBrand.dispose();
            }
        });
        objaddAddNewLaptopBrand.setLocationRelativeTo(this);
        objaddAddNewLaptopBrand.setVisible(true);
        this.validate();
    }//GEN-LAST:event_jMenuItemLaptopBrandActionPerformed

    private void jMenuItemLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLaptopActionPerformed
        // TODO add your handling code here:
        final AddNewLaptop objaddAddNewLaptop = new AddNewLaptop(new javax.swing.JFrame(), true, loggedInUserInfo);
        objaddAddNewLaptop.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                objaddAddNewLaptop.dispose();
            }
        });
        objaddAddNewLaptop.setLocationRelativeTo(this);
        objaddAddNewLaptop.setVisible(true);
        this.validate();
    }//GEN-LAST:event_jMenuItemLaptopActionPerformed

    private void jMenuItemCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustomerActionPerformed
        // TODO add your handling code here:
        final AddNewCustomer objaddAddNewCustomer = new AddNewCustomer(new javax.swing.JFrame(), true, loggedInUserInfo);
        objaddAddNewCustomer.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                objaddAddNewCustomer.dispose();
            }
        });
        objaddAddNewCustomer.setLocationRelativeTo(this);
        objaddAddNewCustomer.setVisible(true);
        this.validate();
    }//GEN-LAST:event_jMenuItemCustomerActionPerformed

    private void jMenuItemCustomerTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCustomerTransactionActionPerformed
        // TODO add your handling code here:
        final AddNewCustomerTransaction objaddAddNewCustomerTransaction = new AddNewCustomerTransaction(new javax.swing.JFrame(), true);
        objaddAddNewCustomerTransaction.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                objaddAddNewCustomerTransaction.dispose();
            }
        });
        objaddAddNewCustomerTransaction.setLocationRelativeTo(this);
        objaddAddNewCustomerTransaction.setVisible(true);
        this.validate();
    }//GEN-LAST:event_jMenuItemCustomerTransactionActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminDashboard().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenuAdd;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCustomer;
    private javax.swing.JMenuItem jMenuItemCustomerTransaction;
    private javax.swing.JMenuItem jMenuItemLaptop;
    private javax.swing.JMenuItem jMenuItemLaptopBrand;
    private javax.swing.JMenuItem jMenuItemUser;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
