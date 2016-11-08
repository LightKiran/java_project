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
public class ViewAllOrder extends javax.swing.JDialog {

    /**
     * Creates new form ViewAllOrder
     */
    public Connection conn;
    public PreparedStatement pstat;
    public ResultSet rs;
    DefaultTableModel supplierOrderTbl;
    OrderManagement supOrderMgmt;
    Database db = new Database();

    public ViewAllOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        db.GetDbConnection();
        conn = db.conn;
        Fillcombomodel();
        Fillcombosupplier();
        showAllSupplierOrder();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLatestCustomer = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        btnShowAllOrder = new javax.swing.JButton();
        txtOrderId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox();
        cmbLapModel = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplierOrder = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        txtPieces = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnLatestCustomer.setText("Latest order");
        btnLatestCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLatestCustomerActionPerformed(evt);
            }
        });

        btnShowAllOrder.setText("Show all order");
        btnShowAllOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllOrderActionPerformed(evt);
            }
        });

        txtOrderId.setEditable(false);

        jLabel2.setText("Order Id :");

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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("Supplier id :");

        jLabel4.setText("Laptop model :");

        jLabel1.setText("Pieces :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Please, Select Order To Update,Delete and View");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPieces, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbLapModel, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnShowAllOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnLatestCustomer)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPieces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLapModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate)
                        .addComponent(btnDelete))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowAllOrder)
                    .addComponent(btnLatestCustomer))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Fillcombomodel() {

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

    private void btnLatestCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLatestCustomerActionPerformed
        // TODO add your handling code here:
        showLatestSupplierOrder();
    }//GEN-LAST:event_btnLatestCustomerActionPerformed

    private void btnShowAllOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllOrderActionPerformed
        // TODO add your handling code here:
        showAllSupplierOrder();
    }//GEN-LAST:event_btnShowAllOrderActionPerformed

    private void tblSupplierOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierOrderMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblSupplierOrder.getSelectedRow();
            String rowClick = (tblSupplierOrder.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tbl_order where order_id='" + rowClick + "'";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if (rs.next()) {
                String id = rs.getString("order_id");
                txtOrderId.setText(id);

                String mname = rs.getString("peices");
                txtPieces.setText(mname);

                cmbLapModel.setSelectedItem(tblSupplierOrder.getModel().getValueAt(row, 4).toString());
                cmbSupplier.setSelectedItem(tblSupplierOrder.getModel().getValueAt(row, 5).toString());

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblSupplierOrderMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String pieces = txtPieces.getText();

        OrderInfo order = new OrderInfo();
        if (!Validate.checkEmpty(pieces)) {
            OrderInfo objOrderInfo = new OrderInfo();
            OrderManagement objOrderManagement = new OrderManagement();

            objOrderInfo.setOrder_id(Integer.parseInt(this.txtOrderId.getText()));
            objOrderInfo.setPieces(this.txtPieces.getText());

            String model = (String) cmbLapModel.getSelectedItem();
            SupCtrl supCtrl = new SupCtrl();
            LaptopInfo laptopInfo = supCtrl.findLaptopInfoByModel(model);
            objOrderInfo.setLapInfo(laptopInfo);

            String supplier = (String) cmbSupplier.getSelectedItem();
            SupplierInfo supInfo = supCtrl.findSupplierInfoByName(supplier);
            objOrderInfo.setSupInfo(supInfo);

            if (objOrderManagement.UpdateOrder(objOrderInfo) == true) {
                JOptionPane.showMessageDialog(null, "Record Updated Sucessfully");
                showAllSupplierOrder();
            } else {
                JOptionPane.showMessageDialog(null, "Error to Update Record");
            }
        } else {
            JOptionPane.showMessageDialog(null, "pieces can not be empty.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        OrderInfo objOrderInfo = new OrderInfo();
        OrderManagement objCustomerManage = new OrderManagement();

        objOrderInfo.setOrder_id(Integer.parseInt(this.txtOrderId.getText()));

        if (objCustomerManage.deleteOrder(objOrderInfo) == true) {
            JOptionPane.showMessageDialog(null, "Delete Record Successfully");
//            reset();
        } else {
            JOptionPane.showMessageDialog(null, "Error to Delete Record");
        }
        showAllSupplierOrder();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void showAllSupplierOrder() {
        supOrderMgmt = new OrderManagement();
        supplierOrderTbl = new DefaultTableModel();
        ArrayList<OrderInfo> supOrders = supOrderMgmt.listAllOrder();
        String[] columns = {"order_id", "peices", "date", "time", "laptop_id", "supplier_first_name"};
        supplierOrderTbl.setColumnIdentifiers(columns);

        for (OrderInfo supOrder : supOrders) {
            supplierOrderTbl.addRow(new Object[]{supOrder.getOrder_id(),
                supOrder.getPieces(), supOrder.getDate(), supOrder.getTime(),
                supOrder.getLapInfo().getModel_no(), supOrder.getSupInfo().getFirst_name()});
        }

        tblSupplierOrder.setModel(supplierOrderTbl);
    }

    public void showLatestSupplierOrder() {
        supOrderMgmt = new OrderManagement();
        supplierOrderTbl = new DefaultTableModel();
        ArrayList<OrderInfo> supOrders = supOrderMgmt.listLatestlOrder();
        String[] columns = {"order_id", "peices", "date", "time", "laptop_id", "supplier_first_name"};
        supplierOrderTbl.setColumnIdentifiers(columns);

        for (OrderInfo supOrder : supOrders) {
            supplierOrderTbl.addRow(new Object[]{supOrder.getOrder_id(),
                supOrder.getPieces(), supOrder.getDate(), supOrder.getTime(),
                supOrder.getLapInfo().getModel_no(), supOrder.getSupInfo().getFirst_name()});
        }

        tblSupplierOrder.setModel(supplierOrderTbl);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLatestCustomer;
    private javax.swing.JButton btnShowAllOrder;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbLapModel;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTable tblSupplierOrder;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtPieces;
    // End of variables declaration//GEN-END:variables
}
