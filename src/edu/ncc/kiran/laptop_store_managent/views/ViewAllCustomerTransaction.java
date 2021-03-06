/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.CustomerTransactionManagement;
import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.controllers.SupCtrl;
import edu.ncc.kiran.laptop_store_managent.models.CustomerInfo;
import edu.ncc.kiran.laptop_store_managent.models.CustomerTransactionInfo;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author kiran
 */
public class ViewAllCustomerTransaction extends javax.swing.JDialog {

    /**
     * Creates new form ViewAllCustomerTransaction
     */
    UserInfo loggedInUserInfo;
    CustomerTransactionManagement cusTransMgmt;
    DefaultTableModel customerTransTbl;
    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rs;
    Database db = new Database();

    public ViewAllCustomerTransaction(java.awt.Frame parent, boolean modal, UserInfo loggedInUserInfo) {
        super(parent, modal);
        initComponents();
        db.GetDbConnection();
        conn = db.conn;
        this.loggedInUserInfo = loggedInUserInfo;
        showAllCustomerTransaction();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDue = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalCost = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomerTransaction = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtCusTransId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerId = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnShowAllCustomerTransaction = new javax.swing.JButton();
        btnLatestCustomerTransaction = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        txtSrhDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSrhDate2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jToggleButtonSearch = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDueActionPerformed(evt);
            }
        });

        jLabel1.setText("Paid :");

        jLabel2.setText("Due :");

        jLabel3.setText("Total cost :");

        tblCustomerTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCustomerTransaction.setDragEnabled(true);
        tblCustomerTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerTransactionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomerTransaction);

        jLabel6.setText("Customer transaction Id :");

        txtCusTransId.setEditable(false);

        jLabel7.setText("Customer  Id :");

        txtCustomerId.setEditable(false);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Please, Select Customer Transaction To Update,Delete and View");

        btnShowAllCustomerTransaction.setText("Show all customer Transaction ");
        btnShowAllCustomerTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllCustomerTransactionActionPerformed(evt);
            }
        });

        btnLatestCustomerTransaction.setText("latest customer transaction");
        btnLatestCustomerTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLatestCustomerTransactionActionPerformed(evt);
            }
        });

        btnPrint.setText("Print Report");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        txtSrhDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSrhDateKeyReleased(evt);
            }
        });

        jLabel5.setText("Customer transaction date from:");

        txtSrhDate2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSrhDate2KeyReleased(evt);
            }
        });

        jLabel4.setText("to :");

        jToggleButtonSearch.setText("Search");
        jToggleButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(117, 117, 117)
                                    .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCusTransId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(btnUpdate))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtDue, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                .addComponent(txtTotalCost, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                .addComponent(txtCustomerId, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))))
                            .addComponent(jLabel7))
                        .addGap(136, 136, 136)
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtSrhDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnShowAllCustomerTransaction)
                                .addGap(18, 18, 18)
                                .addComponent(btnLatestCustomerTransaction))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSrhDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButtonSearch)
                                .addGap(69, 69, 69)
                                .addComponent(btnPrint))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint)
                    .addComponent(txtSrhDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSrhDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jToggleButtonSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnShowAllCustomerTransaction)
                        .addComponent(btnLatestCustomerTransaction))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCusTransId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDueActionPerformed

    public void showAllCustomerTransaction() {
        cusTransMgmt = new CustomerTransactionManagement();
        customerTransTbl = new DefaultTableModel();
        ArrayList<CustomerTransactionInfo> cusTransactions = cusTransMgmt.listAllCustomerTransaction();
        String[] columns = {"transaction_id",/* "user_id",*/
            "paid", "due", "total_cost", "date", "time", "customer_first_name"};
        customerTransTbl.setColumnIdentifiers(columns);
        for (CustomerTransactionInfo cusTransaction : cusTransactions) {
            customerTransTbl.addRow(new Object[]{cusTransaction.getCusTransId(),/*cusTransaction.getCusInfo().getUserInfo().getUser_id(),*/
                cusTransaction.getPaid(), cusTransaction.getDue(),
                cusTransaction.getTotal_cost(), cusTransaction.getDate(),
                cusTransaction.getTime(), cusTransaction.getCusInfo().getFirst_name()});
        }

        tblCustomerTransaction.setModel(customerTransTbl);
    }

    public void showAllCustomerLatestTransaction() {
        cusTransMgmt = new CustomerTransactionManagement();
        customerTransTbl = new DefaultTableModel();
        ArrayList<CustomerTransactionInfo> cusTransactions = cusTransMgmt.listAllCustomerLatestTransaction();
        String[] columns = {"transaction_id",/* "user_id",*/
            "paid", "due", "total_cost", "date", "time", "customer_first_name"};
        customerTransTbl.setColumnIdentifiers(columns);
        for (CustomerTransactionInfo cusTransaction : cusTransactions) {
            customerTransTbl.addRow(new Object[]{cusTransaction.getCusTransId(),/*cusTransaction.getCusInfo().getUserInfo().getUser_id(),*/
                cusTransaction.getPaid(), cusTransaction.getDue(),
                cusTransaction.getTotal_cost(), cusTransaction.getDate(),
                cusTransaction.getTime(), cusTransaction.getCusInfo().getFirst_name()});
        }

        tblCustomerTransaction.setModel(customerTransTbl);
    }
    private void tblCustomerTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerTransactionMouseClicked
        // TODO add your handling code here:
        try {

            int row = tblCustomerTransaction.getSelectedRow();
            String rowClick = (tblCustomerTransaction.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tbl_customer_transaction where customer_transaction_id='" + rowClick + "'";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if (rs.next()) {
                String cusTranID = rs.getString("customer_transaction_id");
                txtCusTransId.setText(cusTranID);
                String paid = rs.getString("paid");
                txtPaid.setText(paid);
                String due = rs.getString("due");
                txtDue.setText(due);
                String totalCost = rs.getString("total_cost");
                txtTotalCost.setText(totalCost);
                String cusID = rs.getString("customer_id");
                txtCustomerId.setText(cusID);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblCustomerTransactionMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String paid = txtPaid.getText();
        String total = txtTotalCost.getText();

        if (!Validate.checkEmpty(paid)) {
            if (!Validate.checkEmpty(total)) {
                CustomerTransactionInfo objcustomerTransactionInfo = new CustomerTransactionInfo();

                objcustomerTransactionInfo.setCusTransId(Integer.parseInt(this.txtCusTransId.getText()));
                objcustomerTransactionInfo.setPaid(this.txtPaid.getText());
                objcustomerTransactionInfo.setDue(this.txtDue.getText());
                objcustomerTransactionInfo.setTotal_cost(this.txtTotalCost.getText());
                objcustomerTransactionInfo.setUserInfo(loggedInUserInfo);

                CustomerTransactionManagement objcustomerTransactionManagement = new CustomerTransactionManagement();
                boolean res = objcustomerTransactionManagement.Update(objcustomerTransactionInfo);

                if (res) {
                    JOptionPane.showMessageDialog(null, "record update sucessfully");
                    showAllCustomerTransaction();
                } else {
                    JOptionPane.showMessageDialog(null, "Error to Update Record");
                }
            } else {
                JOptionPane.showMessageDialog(null, "total cost can not be empty");
            }
        } else {
            JOptionPane.showMessageDialog(null, "paid can not be empty");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        CustomerTransactionInfo objCustomerTransactionInfo = new CustomerTransactionInfo();
        CustomerTransactionManagement objCustomerTransManage = new CustomerTransactionManagement();

        objCustomerTransactionInfo.setCusTransId(Integer.parseInt(this.txtCusTransId.getText()));
        objCustomerTransactionInfo.setPaid(this.txtPaid.getText());
        objCustomerTransactionInfo.setDue(this.txtDue.getText());

        String cusId = txtCustomerId.getText();
        SupCtrl supCtrl = new SupCtrl();
        CustomerInfo objCustomerInfo = supCtrl.findCustomerInfoByName(cusId);
        objCustomerTransactionInfo.setCusInfo(objCustomerInfo);

        if (objCustomerTransManage.deleteCustomerTransaction(objCustomerTransactionInfo) == true) {

            JOptionPane.showMessageDialog(null, "Delete record sucessfully");
            showAllCustomerTransaction();
        } else {
            JOptionPane.showMessageDialog(null, "Error to Delete record");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowAllCustomerTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllCustomerTransactionActionPerformed
        // TODO add your handling code here:
        showAllCustomerTransaction();
    }//GEN-LAST:event_btnShowAllCustomerTransactionActionPerformed

    private void btnLatestCustomerTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLatestCustomerTransactionActionPerformed
        // TODO add your handling code here:
        showAllCustomerLatestTransaction();
    }//GEN-LAST:event_btnLatestCustomerTransactionActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Customer's Transaction Report");

        MessageFormat footer = new MessageFormat("Page{0,number,interger}");

        try {
            tblCustomerTransaction.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("cantnot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtSrhDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSrhDateKeyReleased
        // TODO add your handling code here:
//        try {
//            String query = "select * from tbl_customer_transaction where date LIKE '%" + txtSrhDate.getText() + "%'";
//            pstat = conn.prepareStatement(query);
//            rs = pstat.executeQuery();
//
//            tblCustomerTransaction.setModel(DbUtils.resultSetToTableModel(rs));
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//
//        int count = tblCustomerTransaction.getModel().getRowCount();
//        if (count == 0) {
//            JOptionPane.showMessageDialog(null, "search data not found");
//        }
    }//GEN-LAST:event_txtSrhDateKeyReleased

    private void txtSrhDate2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSrhDate2KeyReleased
        // TODO add your handling code here:
//        try {
//            String query = "select * from tbl_customer_transaction where date LIKE '%" + txtSrhDate2.getText() + "%'";
//            pstat = conn.prepareStatement(query);
//            rs = pstat.executeQuery();
//
//            tblCustomerTransaction.setModel(DbUtils.resultSetToTableModel(rs));
//
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//
//        int count = tblCustomerTransaction.getModel().getRowCount();
//        if (count == 0) {
//            JOptionPane.showMessageDialog(null, "search data not found");
//        }
    }//GEN-LAST:event_txtSrhDate2KeyReleased

    private void jToggleButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSearchActionPerformed
        // TODO add your handling code here:
        String from = txtSrhDate.getText();
        String to = txtSrhDate2.getText();

        if (!from.isEmpty()) {
            if (!to.isEmpty()) {
                try {
                    String query = "select tct.customer_transaction_id as transaction_id, tct.paid, tct.due, tct.total_cost, tct.date, tct.time, tc.first_name "
                            + "from tbl_customer_transaction tct inner join tbl_customer tc on tct.customer_id = tc.customer_id "
                            + "where tct.date between '" + txtSrhDate.getText() + "' and '" + txtSrhDate2.getText() + "'";
                    pstat = conn.prepareStatement(query);
                    rs = pstat.executeQuery();

                    tblCustomerTransaction.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                int count = tblCustomerTransaction.getModel().getRowCount();
                if (count == 0) {
                    JOptionPane.showMessageDialog(null, "search data not found");
                }
            } else {
                JOptionPane.showMessageDialog(null, "please enter end date in format of 'yyyy-mm-dd'");
            }
        } else {
            JOptionPane.showMessageDialog(null, "please enter begin date in format of 'yyyy-mm-dd'");
        }


    }//GEN-LAST:event_jToggleButtonSearchActionPerformed

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
//            java.util.logging.Logger.getLogger(ViewAllCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ViewAllCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ViewAllCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ViewAllCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ViewAllCustomerTransaction dialog = new ViewAllCustomerTransaction(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLatestCustomerTransaction;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnShowAllCustomerTransaction;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButtonSearch;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTable tblCustomerTransaction;
    private javax.swing.JTextField txtCusTransId;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtSrhDate;
    private javax.swing.JTextField txtSrhDate2;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
