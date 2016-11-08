/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.controllers.SupplierManagement;
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
public class ViewAllSupplier extends javax.swing.JDialog {

    /**
     * Creates new form AddNewSupplier
     */
    SupplierManagement supMgmt;
    DefaultTableModel defCustomerTbl;
    private PreparedStatement pstat = null;
    private ResultSet rs = null;
    private Connection conn;
    Database db = new Database();

    public ViewAllSupplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db.GetDbConnection();
        conn = db.conn;
        showAllSupplier();
    }

    public void showAllSupplier() {
        supMgmt = new SupplierManagement();
        defCustomerTbl = new DefaultTableModel();
        ArrayList<SupplierInfo> suppliers = supMgmt.listAllSuppliers();
        String[] columns = {"supplier_id", "first_name", "middle_name",
            "last_name", "contact_no", "address", "email"};
        defCustomerTbl.setColumnIdentifiers(columns);
        for (SupplierInfo supplier : suppliers) {
            defCustomerTbl.addRow(new Object[]{supplier.getSupplier_id(), supplier.getFirst_name(), supplier.getMiddle_name(), supplier.getLast_name(), supplier.getContact_no(), supplier.getAddress(), supplier.getEmail()});
        }

        supplierTable.setModel(defCustomerTbl);
    }

    public void showAllLatestSupplier() {
        supMgmt = new SupplierManagement();
        defCustomerTbl = new DefaultTableModel();
        ArrayList<SupplierInfo> suppliers = supMgmt.listLatestSuppliers();
        String[] columns = {"supplier_id", "first_name", "middle_name",
            "last_name", "contact_no", "address", "email"};
        defCustomerTbl.setColumnIdentifiers(columns);
        for (SupplierInfo supplier : suppliers) {
            defCustomerTbl.addRow(new Object[]{supplier.getSupplier_id(), supplier.getFirst_name(), supplier.getMiddle_name(), supplier.getLast_name(), supplier.getContact_no(), supplier.getAddress(), supplier.getEmail()});
        }

        supplierTable.setModel(defCustomerTbl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContactNo = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        btnShowAllSupplier = new javax.swing.JButton();
        lblAddress = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtMiddleName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        lblMessage = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtSupplierId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnShowLatestSupplier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblContactNo.setText("Contact No :");

        lblFirstname.setText("First Name :");

        lblLastName.setText("Last Name :");

        btnShowAllSupplier.setText("Show all supplier");
        btnShowAllSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllSupplierActionPerformed(evt);
            }
        });

        lblAddress.setText("Address :");

        lblEmail.setText("Email :");

        lblMiddleName.setText("Middle Name :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Please, Select Supplier To Update,Delete and View");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        supplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(supplierTable);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtSupplierId.setEditable(false);

        jLabel1.setText("Supplier Id :");

        btnShowLatestSupplier.setText("Show latest supplier");
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
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnUpdate)
                                        .addGap(34, 34, 34)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnShowAllSupplier)
                                .addGap(18, 18, 18)
                                .addComponent(btnShowLatestSupplier))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnShowAllSupplier)
                            .addComponent(btnShowLatestSupplier))))
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowAllSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllSupplierActionPerformed
        // TODO add your handling code here:
        showAllSupplier();
    }//GEN-LAST:event_btnShowAllSupplierActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        SupplierInfo objSuppInfo = new SupplierInfo();
        SupplierManagement objSuppManage = new SupplierManagement();

        objSuppInfo.setSupplier_id(Integer.parseInt(this.txtSupplierId.getText()));
        objSuppInfo.setFirst_name(this.txtFirstName.getText());
        objSuppInfo.setMiddle_name(this.txtMiddleName.getText());
        objSuppInfo.setLast_name(this.txtLastName.getText());
        objSuppInfo.setContact_no(this.txtContactNo.getText());
        objSuppInfo.setAddress(this.txtAddress.getText());
        objSuppInfo.setEmail(this.txtEmail.getText());
        if (objSuppManage.Delete(objSuppInfo) == true) {
            JOptionPane.showMessageDialog(null, "Delete Record Sucessfully!");
            reset();
            this.txtSupplierId.requestFocusInWindow();
            // showAllSupplier();
        } else {
            JOptionPane.showMessageDialog(null, "Error to Delete Record");
        }
        showAllSupplier();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void reset() {
        txtFirstName.setText("");
        txtMiddleName.setText("");
        txtLastName.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        //this.txtFirstName.requestFocusInWindow();
    }

    private void supplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierTableMouseClicked
        // TODO add your handling code here:
        try {
            Database db = new Database();
            db.GetDbConnection();
            conn = db.conn;
            //   db.GetDbConnection();
            int row = supplierTable.getSelectedRow();
            String rowClick = (supplierTable.getModel().getValueAt(row, 0).toString());
            String sql = "select * from tbl_supplier where supplier_id='" + rowClick + "'";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if (rs.next()) {
                String id = rs.getString("supplier_id");
                txtSupplierId.setText(id);
                String fname2 = rs.getString("first_name");
                txtFirstName.setText(fname2);
                String mname = rs.getString("middle_name");
                txtMiddleName.setText(mname);
                String lname = rs.getString("last_name");
                txtLastName.setText(lname);
                String contact = rs.getString("contact_no");
                txtContactNo.setText(contact);
                String address = rs.getString("address");
                txtAddress.setText(address);
                String email = rs.getString("email");
                txtEmail.setText(email);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_supplierTableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String fname = txtFirstName.getText();
        String lname = txtLastName.getText();
        String contact = txtContactNo.getText();
        String address = txtAddress.getText();
        String Email = txtEmail.getText();

        if (!Validate.checkEmpty(fname)) {
            if (!Validate.checkEmpty(lname)) {
                if (!Validate.checkEmpty(contact)) {
                    if (!Validate.checkEmpty(address)) {
                        if (!Validate.checkEmpty(Email)) {
                            if (!Validate.checkLength(fname)) {
                                if (!Validate.checkLength(lname)) {
                                    if (!Validate.checkContactLength(contact)) {
                                        if (!Validate.checkAdressLength(address)) {
                                            if (!Validate.checkEmailLength(Email)) {

                                                SupplierInfo objSuppInfo = new SupplierInfo();
                                                SupplierManagement objSuppManage = new SupplierManagement();

                                                objSuppInfo.setSupplier_id(Integer.parseInt(this.txtSupplierId.getText()));
                                                objSuppInfo.setFirst_name(this.txtFirstName.getText());
                                                objSuppInfo.setMiddle_name(this.txtMiddleName.getText());
                                                objSuppInfo.setLast_name(this.txtLastName.getText());
                                                objSuppInfo.setContact_no(this.txtContactNo.getText());
                                                objSuppInfo.setAddress(this.txtAddress.getText());
                                                objSuppInfo.setEmail(this.txtEmail.getText());
                                                if (objSuppManage.Update(objSuppInfo) == true) {
                                                    showAllSupplier();
                                                    JOptionPane.showMessageDialog(null, "Record updated Sucessfully!");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Error to updated Record");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "email length should be greater than 10");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "address length should be between 5-50");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "contact length should be 10 digit");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "last name should be between 3-15");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "first name should be between 3-15");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "email can not be empty");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "address can not be empty");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "contact can not be empty");
                }
            } else {
                JOptionPane.showMessageDialog(null, "last name can not be empty");
            }
        } else {
            JOptionPane.showMessageDialog(null, "first name can not be empty");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnShowLatestSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowLatestSupplierActionPerformed
        // TODO add your handling code here:
        showAllLatestSupplier();
    }//GEN-LAST:event_btnShowLatestSupplierActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnShowAllSupplier;
    private javax.swing.JButton btnShowLatestSupplier;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JTable supplierTable;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtSupplierId;
    // End of variables declaration//GEN-END:variables
}