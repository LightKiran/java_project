/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.controllers.OrderManagement;
import edu.ncc.kiran.laptop_store_managent.controllers.SupCtrl;
import edu.ncc.kiran.laptop_store_managent.controllers.SupplierManagement;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierInfo;
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
public class AddNewOrder extends javax.swing.JFrame {

    /**
     * Creates new form AddNewOrder
     */
    public Connection conn;
    public PreparedStatement pstat;
    public ResultSet rs;
    DefaultTableModel supplierOrderTbl;
    OrderManagement supOrderMgmt;
    Database db = new Database();

    public AddNewOrder() {
        initComponents();
        db.GetDbConnection();
        conn = db.conn;
        showAllSupplierOrder2();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplierOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPieces = new javax.swing.JTextField();
        cmbLapbrand = new javax.swing.JComboBox();
        cmbSupplier = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSupplierOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSupplierOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupplierOrder);

        jLabel1.setText("Pieces :");

        jLabel4.setText("Laptop model :");

        jLabel5.setText("Supplier id :");

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
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPieces, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbLapbrand, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(btnSave)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLapbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSupplier)
                        .addComponent(btnSave))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
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

                cmbLapbrand.addItem(cusId);

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
        OrderInfo order = new OrderInfo();
        
        order.setPieces(txtPieces.getText());

        String brand = (String) cmbLapbrand.getSelectedItem();
        SupCtrl supCtrl = new SupCtrl();
        LaptopInfo brandInfo = supCtrl.findLaptopInfoByModel(brand);
        order.setLapInfo(brandInfo);

        String supplier = (String) cmbSupplier.getSelectedItem();
        // SupCtrl supCtrl2 = new SupCtrl();
       // SupplierManagement supMgmtCtrl = new SupplierManagement();
        SupplierInfo supInfo = supCtrl.findSupplierInfoByName(supplier);
        order.setSupInfo(supInfo);

        OrderManagement orderMgmt = new OrderManagement();
        boolean isOrderCreated = orderMgmt.createorder(order);
        if (isOrderCreated) {
          //  showAllSupplierOrder2();
            JOptionPane.showMessageDialog(null, "order created sucessfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, order creation Failed!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblSupplierOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierOrderMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblSupplierOrder.getSelectedRow();
            String rowClick = (tblSupplierOrder.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tbl_order where order_id='" + rowClick + "'";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if (rs.next()) {
//                String id = rs.getString("customer_id");
//                txtCustomerId.setText(id);

                String mname = rs.getString("peices");
                txtPieces.setText(mname);

                cmbLapbrand.setSelectedItem(tblSupplierOrder.getModel().getValueAt(row, 2).toString());
                cmbSupplier.setSelectedItem(tblSupplierOrder.getModel().getValueAt(row, 3).toString());

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblSupplierOrderMouseClicked

    /**
     * @param args the command line arguments
     */
    public void showAllSupplierOrder2() {
        supOrderMgmt = new OrderManagement();
        supplierOrderTbl = new DefaultTableModel();
        ArrayList<OrderInfo> supOrders = supOrderMgmt.listAllOrder();
        String[] columns = {"order_id", 
            "peices",  "laptop_id", "supplier_id"};
        supplierOrderTbl.setColumnIdentifiers(columns);

        for (OrderInfo supOrder : supOrders) {
            supplierOrderTbl.addRow(new Object[]{supOrder.getOrder_id(),
                supOrder.getPieces(),  
                supOrder.getLapInfo().getModel_no(), supOrder.getSupInfo().getFirst_name()});
        }

        tblSupplierOrder.setModel(supplierOrderTbl);
    }

    public void showAllSupplierOrder() {
        try {
            String query = "select * from tbl_order";
            //-- String query = "select * from tbl_customer_transaction where due=?";
            pstat = conn.prepareStatement(query);
            //--  pstat.setString(1, txtSrhDate.getText());
            rs = pstat.executeQuery();

            tblSupplierOrder.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        int count = tblSupplierOrder.getModel().getRowCount();
        if (count == 0) {
            // JOptionPane.showMessageDialog(null, "search data not found");
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbLapbrand;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSupplierOrder;
    private javax.swing.JTextField txtPieces;
    // End of variables declaration//GEN-END:variables
}
