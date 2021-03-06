/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.controllers.OrderManagement;
import edu.ncc.kiran.laptop_store_managent.controllers.SupCtrl;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kiran
 */
public class AddNewOrder extends javax.swing.JDialog {

    /**
     * Creates new form AddNewOrder2
     */
    public Connection conn;
    public PreparedStatement pstat;
    public ResultSet rs;
    DefaultTableModel supplierOrderTbl;
    OrderManagement supOrderMgmt;
    Database db = new Database();

    public AddNewOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        db.GetDbConnection();
        conn = db.conn;
        Fillcombobrand();
        Fillcombosupplier();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        cmbLapModel = new javax.swing.JComboBox();
        cmbSupplier = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPieces = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCancel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cmbLapModel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "please select" }));

        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "please select" }));

        jLabel5.setText("Supplier name :");

        jLabel4.setText("Laptop model :");

        jLabel1.setText("Pieces :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Add New Order");

        btnCancel1.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel1.setText("Cancel");
        btnCancel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(42, 42, 42))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLapModel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPieces, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(387, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLapModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel1))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Fillcombobrand() {

        try {
            String sql = "select model_no from tbl_laptop";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();

            while (rs.next()) {

                String cusId = rs.getString("model_no");

                cmbLapModel.addItem(cusId);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error = " + e);
        }
    }

    private void Fillcombosupplier() {

        try {
            String sql = "select first_name from tbl_supplier";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();

            while (rs.next()) {

                String cusId = rs.getString("first_name");

                cmbSupplier.addItem(cusId);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error = " + e);
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        String pieces = txtPieces.getText();

        OrderInfo order = new OrderInfo();
        if (!Validate.checkEmpty(pieces)) {

            order.setPieces(txtPieces.getText());

            String brand = (String) cmbLapModel.getSelectedItem();
            SupCtrl supCtrl = new SupCtrl();
            LaptopInfo brandInfo = supCtrl.findLaptopInfoByModel(brand);
            order.setLapInfo(brandInfo);

            String supplier = (String) cmbSupplier.getSelectedItem();
            SupplierInfo supInfo = supCtrl.findSupplierInfoByName(supplier);
            order.setSupInfo(supInfo);

            OrderManagement orderMgmt = new OrderManagement();
            boolean isOrderCreated = orderMgmt.addNewOrder(order);
            if (isOrderCreated) {
                JOptionPane.showMessageDialog(null, "order created sucessfully!");
                this.dispose();
                AddNewSupplierTransaction objAddNewSupplierTransaction = new AddNewSupplierTransaction(null, isOrderCreated);
                objAddNewSupplierTransaction.setVisible(isOrderCreated);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, order creation Failed!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "pieces can not be empty.");
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancel1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbLapModel;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtPieces;
    // End of variables declaration//GEN-END:variables
}
