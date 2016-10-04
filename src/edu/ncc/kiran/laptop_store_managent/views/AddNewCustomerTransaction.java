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
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kiran
 */
public class AddNewCustomerTransaction extends javax.swing.JDialog {

    /**
     * Creates new form AddNewCustomerTransaction
     */
    UserInfo loggedInUserInfo;
    CustomerTransactionManagement cusTransMgmt;
    DefaultTableModel customerTransTbl;
    public Connection conn;
    public PreparedStatement pstat;
    public ResultSet rs;
    Database db = new Database();

    public AddNewCustomerTransaction(java.awt.Frame parent, boolean modal, UserInfo loggedInUserInfo) {
        super(parent, modal);
        initComponents();
        db.GetDbConnection();
        conn = db.conn;
        this.loggedInUserInfo = loggedInUserInfo;
//        showAllCustomerTransaction();
        fillComboCusName();
//        fillComboLapModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSrhDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnLoadTable = new javax.swing.JButton();
        txtSrhDue = new javax.swing.JTextField();
        cmbFillDate = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomerTransaction = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbCustomerName = new javax.swing.JComboBox();
        txtTotalCost = new javax.swing.JTextField();
        txtDue = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtSrhDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSrhDateKeyReleased(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnLoadTable.setText("Load Table");
        btnLoadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTableActionPerformed(evt);
            }
        });

        txtSrhDue.setText("with key due key relase srh");
        txtSrhDue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSrhDueKeyReleased(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd MMMMM yyyy", "dd.MM.yy", "MM/dd/yy", "yyyy.MM.dd G 'at' hh:mm:ss z", "EEE MMM d ''yy", "h:mm a", "H:mm:ss:SSS", "K:mm az", "yyyy.MMMMM.dd GGG hh:mm aaa" }));

        tblCustomerTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCustomerTransaction.setDragEnabled(true);
        jScrollPane1.setViewportView(tblCustomerTransaction);

        jLabel2.setText("Due :");

        btnPrint.setText("Print Report");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel1.setText("Paid :");

        cmbCustomerName.setEditable(true);
        cmbCustomerName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "plz select customer id" }));
        cmbCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerNameActionPerformed(evt);
            }
        });

        txtDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDueActionPerformed(evt);
            }
        });

        jLabel3.setText("Total cost :");

        jLabel5.setText("Customer Id :");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtDue, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(162, 162, 162)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLoadTable)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSave)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnSearch)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnPrint))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(152, Short.MAX_VALUE)
                        .addComponent(txtSrhDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSrhDue, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(cmbFillDate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFillDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSrhDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSrhDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadTable)
                    .addComponent(btnSave)
                    .addComponent(btnSearch)
                    .addComponent(btnPrint))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showAllCustomerTransaction() {
        cusTransMgmt = new CustomerTransactionManagement();
        customerTransTbl = new DefaultTableModel();
        ArrayList<CustomerTransactionInfo> cusTransactions = cusTransMgmt.listAllCustomerTransaction();
        String[] columns = {"customer_transaction_id", "customer_id",/* "user_id",*/ "laptop_id",
            "paid", "due", "total_cost", "date", "time", "user_id"};
        customerTransTbl.setColumnIdentifiers(columns);
        for (CustomerTransactionInfo cusTransaction : cusTransactions) {
            customerTransTbl.addRow(new Object[]{cusTransaction.getCusTransId(), 
                cusTransaction.getCusInfo().getFirst_name(), /*cusTransaction.getCusInfo().getUserInfo().getUser_id(),*/ cusTransaction.getLapInfo().getModel_no(),
                cusTransaction.getPaid(), cusTransaction.getDue(),
                cusTransaction.getTotal_cost(), cusTransaction.getDate(),
                cusTransaction.getTime()});
        }

        tblCustomerTransaction.setModel(customerTransTbl);
    }

    private void txtSrhDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSrhDateKeyReleased
        // TODO add your handling code here:
        try {
            String query = "select * from tbl_customer_transaction where date LIKE '%" + txtSrhDate.getText() + "%'";
            //-- String query = "select * from tbl_customer_transaction where due=?";
            pstat = conn.prepareStatement(query);
            //--  pstat.setString(1, txtSrhDate.getText());
            rs = pstat.executeQuery();

            tblCustomerTransaction.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        int count = tblCustomerTransaction.getModel().getRowCount();
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "search data not found");
        }
    }//GEN-LAST:event_txtSrhDateKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        //        findCustomersTransactions();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTableActionPerformed
        // TODO add your handling code here:
        showAllCustomerTransaction();
    }//GEN-LAST:event_btnLoadTableActionPerformed

    private void txtSrhDueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSrhDueKeyReleased
        // TODO add your handling code here:
        try {
            String query = "select * from tbl_customer_transaction where due LIKE '%" + txtSrhDue.getText() + "%'";
            //-- String query = "select * from tbl_customer_transaction where due=?";
            pstat = conn.prepareStatement(query);
            //--  pstat.setString(1, txtSrhDate.getText());
            rs = pstat.executeQuery();

            tblCustomerTransaction.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        int count = tblCustomerTransaction.getModel().getRowCount();
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "search data not found");
        }
    }//GEN-LAST:event_txtSrhDueKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Transaction Report");

        MessageFormat footer = new MessageFormat("Page{0,number,interger}");

        try {
            tblCustomerTransaction.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("cantnot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void cmbCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCustomerNameActionPerformed

    private void txtDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDueActionPerformed

    private void fillComboCusName() {
        try {
            String sql = "select first_name from tbl_customer";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();

            while (rs.next()) {
                String cusName = rs.getString("first_name");
                cmbCustomerName.addItem(cusName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error = " + e);
        }
    }

   /* private void fillComboLapModel() {
        try {
            String sql = "select model_no from tbl_laptop";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();

            while (rs.next()) {
                String lapModel = rs.getString("model_no");
                cmbLapModel.addItem(lapModel);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error = " + e);
        }
    }*/

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        CustomerTransactionInfo cusTransInfo = new CustomerTransactionInfo();
        SupCtrl supCtrl = new SupCtrl();

        String cusName = (String) cmbCustomerName.getSelectedItem();
        CustomerInfo objcusTransInfo = supCtrl.findCustomerInfoByName(cusName);
        cusTransInfo.setCusInfo(objcusTransInfo);

//        String lapModel = (String) cmbLapModel.getSelectedItem();
//        LaptopInfo objLaptopInfo = supCtrl.findLaptopInfoByModel(lapModel);
//        cusTransInfo.setLapInfo(objLaptopInfo);

        cusTransInfo.setPaid(txtPaid.getText());
        cusTransInfo.setDue(txtDue.getText());
        cusTransInfo.setTotal_cost(txtTotalCost.getText());
        cusTransInfo.setUserInfo(loggedInUserInfo);
        //System.out.println(cusTransInfo.setUserInfo(loggedInUserInfo));

        CustomerTransactionManagement cusTransMgmt = new CustomerTransactionManagement();

        boolean isCustomerTransExist = cusTransMgmt.addNewCustomerTransaction(cusTransInfo);
        if (isCustomerTransExist) {
            //   showAllCustomerTransaction();
            JOptionPane.showMessageDialog(null, "New customer transaction details added sucessfully!");
            //reset();
        } else {
            JOptionPane.showMessageDialog(null, "Error to create customer transaction details");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
//            java.util.logging.Logger.getLogger(AddNewCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddNewCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddNewCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddNewCustomerTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AddNewCustomerTransaction dialog = new AddNewCustomerTransaction(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLoadTable;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbCustomerName;
    private javax.swing.JComboBox cmbFillDate;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomerTransaction;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtSrhDate;
    private javax.swing.JTextField txtSrhDue;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
