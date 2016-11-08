/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.controllers.SupCtrl;
import edu.ncc.kiran.laptop_store_managent.controllers.SupplierTransactionManagement;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierTransactionInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author kiran
 */
public class ViewAllSupplierTransaction extends javax.swing.JDialog {

    /**
     * Creates new form AddNewSupplierTransaction
     */
    public Connection conn;
    public PreparedStatement pstat;
    public ResultSet rs;
    DefaultTableModel supplierTransTbl;
    SupplierTransactionManagement supTransMgmt;
    Database db = new Database();

    public ViewAllSupplierTransaction(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db.GetDbConnection();
        conn = db.conn;
        fillComboSupplierId();
        showAllSupplierOrderTransaction();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplierTransaction = new javax.swing.JTable();
        cmbOrderId = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtDue = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        txtPaid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSuppTransId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnShowAllSupplier = new javax.swing.JButton();
        btnShowLatestSupplier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblSupplierTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSupplierTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierTransactionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupplierTransaction);

        jLabel4.setText("Order pieces:");

        txtDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDueActionPerformed(evt);
            }
        });

        jLabel1.setText("Paid :");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel3.setText("Total cost :");

        jLabel2.setText("Due :");

        jLabel5.setText("Supplier transaction id :");

        txtSuppTransId.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Please, Select Supplier Transaction To Update,Delete and View");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnShowAllSupplier.setText("Show all supplier transaction");
        btnShowAllSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllSupplierActionPerformed(evt);
            }
        });

        btnShowLatestSupplier.setText("Show latest supplier transaction");
        btnShowLatestSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowLatestSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel3)))
                            .addComponent(btnUpdate))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPaid)
                            .addComponent(txtDue)
                            .addComponent(txtTotalCost)
                            .addComponent(cmbOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSuppTransId)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(21, 21, 21)
                        .addComponent(btnShowAllSupplier)
                        .addGap(18, 18, 18)
                        .addComponent(btnShowLatestSupplier))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtSuppTransId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnShowAllSupplier)
                        .addComponent(btnShowLatestSupplier))
                    .addComponent(btnDelete))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDueActionPerformed

    public void showAllSupplierOrderTransaction() {
        supTransMgmt = new SupplierTransactionManagement();
        supplierTransTbl = new DefaultTableModel();
        ArrayList<SupplierTransactionInfo> supTransactions = supTransMgmt.listAllSupplierTransaction();
        String[] columns = {"supplier_transaction_id", "paid", "due",
            "total_cost", "date", "time", "order_pieces"};
        supplierTransTbl.setColumnIdentifiers(columns);

        for (SupplierTransactionInfo supTransaction : supTransactions) {
            supplierTransTbl.addRow(new Object[]{supTransaction.getSupTransId(), supTransaction.getPaid(),
                supTransaction.getDue(), supTransaction.getTotal_cost(), supTransaction.getDate(),
                supTransaction.getTime(), supTransaction.getOrderInfo().getPieces()});
        }

        tblSupplierTransaction.setModel(supplierTransTbl);
    }

    public void showLatestSupplierOrderTransaction() {
        supTransMgmt = new SupplierTransactionManagement();
        supplierTransTbl = new DefaultTableModel();
        ArrayList<SupplierTransactionInfo> supTransactions = supTransMgmt.listLatestSupplierTransaction();
        String[] columns = {"supplier_transaction_id", "paid", "due",
            "total_cost", "date", "time", "order_pieces"};
        supplierTransTbl.setColumnIdentifiers(columns);

        for (SupplierTransactionInfo supTransaction : supTransactions) {
            supplierTransTbl.addRow(new Object[]{supTransaction.getSupTransId(), supTransaction.getPaid(),
                supTransaction.getDue(), supTransaction.getTotal_cost(), supTransaction.getDate(),
                supTransaction.getTime(), supTransaction.getOrderInfo().getPieces()});
        }

        tblSupplierTransaction.setModel(supplierTransTbl);
    }

    private void fillComboSupplierId() {

        try {
            String sql = "select peices from tbl_order";
            pstat = conn.prepareStatement(sql);//fk_tbl_supplier_transaction_tbl_supplier1
            rs = pstat.executeQuery();

            while (rs.next()) {
                String supId = rs.getString("peices");

                cmbOrderId.addItem(supId /*+" "+cusFname + " "+ mname+ " " + lname*/);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error = " + e);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String paid = txtPaid.getText();
        String total = txtTotalCost.getText();

        if (!Validate.checkEmpty(paid)) {
            if (!Validate.checkEmpty(total)) {
                SupplierTransactionInfo supTransInfo = new SupplierTransactionInfo();

                supTransInfo.setSupTransId(Integer.parseInt(txtSuppTransId.getText()));
                supTransInfo.setPaid(txtPaid.getText());
                supTransInfo.setDue(txtDue.getText());
                supTransInfo.setTotal_cost(txtTotalCost.getText());

                SupCtrl supCtrl = new SupCtrl();

                String lapModel = (String) cmbOrderId.getSelectedItem();
                OrderInfo objsupplierInfo = supCtrl.findOrderLaptopInfoByModel(lapModel);
                supTransInfo.setOrderInfo(objsupplierInfo);

                SupplierTransactionManagement supTransMgmt = new SupplierTransactionManagement();

                if (supTransMgmt.updateSupplierTransaction(supTransInfo) == true) {
                    showAllSupplierOrderTransaction();
                    JOptionPane.showMessageDialog(null, "New supplier order transaction details updated sucessfully!");
                    //reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Error to update supplier order transaction details");
                }
            } else {
                JOptionPane.showMessageDialog(null, "total cost not be empty");
            }
        } else {
            JOptionPane.showMessageDialog(null, "paid can not be empty");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblSupplierTransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierTransactionMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblSupplierTransaction.getSelectedRow();
            String rowClick = (tblSupplierTransaction.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tbl_order_transaction where supplier_transaction_id='" + rowClick + "'";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if (rs.next()) {
                String id = rs.getString("supplier_transaction_id");
                txtSuppTransId.setText(id);

                String paid = rs.getString("paid");
                txtPaid.setText(paid);

                String due = rs.getString("due");
                txtDue.setText(due);

                String total = rs.getString("total_cost");
                txtTotalCost.setText(total);

                cmbOrderId.setSelectedItem(tblSupplierTransaction.getModel().getValueAt(row, 6).toString());

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblSupplierTransactionMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        SupplierTransactionInfo objSupplierTransactionInfo = new SupplierTransactionInfo();
        SupplierTransactionManagement objSupplierTransactionManagement = new SupplierTransactionManagement();

        objSupplierTransactionInfo.setSupTransId(Integer.parseInt(this.txtSuppTransId.getText()));
        objSupplierTransactionInfo.setPaid(this.txtPaid.getText());
        objSupplierTransactionInfo.setMiddle_name(this.txtDue.getText());
        objSupplierTransactionInfo.setLast_name(this.txtTotalCost.getText());

        if (objSupplierTransactionManagement.deleteSupplierTransaction(objSupplierTransactionInfo) == true) {
            JOptionPane.showMessageDialog(null, "Record Deleted Sucessfully");
            showAllSupplierOrderTransaction();
        } else {
            JOptionPane.showMessageDialog(null, "Error to Deleted Record");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowAllSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllSupplierActionPerformed
        // TODO add your handling code here:
        showAllSupplierOrderTransaction();
    }//GEN-LAST:event_btnShowAllSupplierActionPerformed

    private void btnShowLatestSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowLatestSupplierActionPerformed
        // TODO add your handling code here:
        showLatestSupplierOrderTransaction();
    }//GEN-LAST:event_btnShowLatestSupplierActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnShowAllSupplier;
    private javax.swing.JButton btnShowLatestSupplier;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbOrderId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSupplierTransaction;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtSuppTransId;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}