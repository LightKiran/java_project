/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.Database;
import edu.ncc.kiran.laptop_store_managent.controllers.SupCtrl;
import edu.ncc.kiran.laptop_store_managent.controllers.UserManagement;
import edu.ncc.kiran.laptop_store_managent.models.RoleInfo;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;
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
public class ViewAllUser extends javax.swing.JDialog {

    /**
     * Creates new form ViewAllUser
     */
    UserManagement userMgmt;
    DefaultTableModel userTbl;
    private PreparedStatement pstat;
    private ResultSet rs;
    private Connection conn;
    Database db = new Database();

    public ViewAllUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db.GetDbConnection();
        conn = Database.conn;
        showAllUser();
        Fillcomborole();
    }

    private void Fillcomborole() {

        try {
            String sql = "select role_type from tbl_role";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();

            while (rs.next()) {

                String cusId = rs.getString("role_type");

                cmbrole.addItem(cusId);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error = " + e);
        }
    }

    public final void showAllUser() {
        userMgmt = new UserManagement();
        userTbl = new DefaultTableModel();
        ArrayList<UserInfo> users = userMgmt.listAllUsers();
        String[] columns = {"user_id", "first_name", /*"middle_name",
             "last_name", "contact_no", "address", "email"*/ "role_type"};
        userTbl.setColumnIdentifiers(columns);
        for (UserInfo user : users) {
            userTbl.addRow(new Object[]{user.getUser_id(), user.getFirst_name(), /*user.getMiddle_name(),
                 user.getLast_name(), user.getContact_no(), user.getAddress(), user.getEmail()*/
                user.getRoleInfo().getRole_type()});
        }

        userTable.setModel(userTbl);
    }

    public final void showLatestUser() {
        userMgmt = new UserManagement();
        userTbl = new DefaultTableModel();
        ArrayList<UserInfo> users = userMgmt.listLatestUsers();
        String[] columns = {"user_id", "first_name", /*"middle_name",
             "last_name", "contact_no", "address", "email"*/ "role_type"};
        userTbl.setColumnIdentifiers(columns);
        for (UserInfo user : users) {
            userTbl.addRow(new Object[]{user.getUser_id(), user.getFirst_name(), /*user.getMiddle_name(),
                 user.getLast_name(), user.getContact_no(), user.getAddress(), user.getEmail()*/
                user.getRoleInfo().getRole_type()});
        }

        userTable.setModel(userTbl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtContactNo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        lblEmail2 = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        lblEmail3 = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        cmbrole = new javax.swing.JComboBox();
        txtFirstName = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtLastName = new javax.swing.JTextField();
        lblFirstname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblContactNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        txtCusId = new javax.swing.JTextField();
        lblFirstname1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnShowAllCustomer = new javax.swing.JButton();
        btnLatestCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEmail2.setText("Login password :");

        lblEmail1.setText("Login name :");

        lblMiddleName.setText("Middle Name :");

        lblEmail3.setText("Role type: ");

        cmbrole.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "select role" }));

        lblFirstname.setText("First Name :");

        lblEmail.setText("Email :");

        lblLastName.setText("Last Name :");

        lblAddress.setText("Address :");

        lblContactNo.setText("Contact No :");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        txtCusId.setEditable(false);

        lblFirstname1.setText("User Id :");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Please, Select User To Update,Delete and View");

        btnShowAllCustomer.setText("Show all user ");
        btnShowAllCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowAllCustomerActionPerformed(evt);
            }
        });

        btnLatestCustomer.setText("View latest user");
        btnLatestCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLatestCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblFirstname1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtAddress)
                                        .addComponent(txtContactNo)
                                        .addComponent(txtLastName)
                                        .addComponent(txtMiddleName)
                                        .addComponent(txtFirstName)
                                        .addComponent(txtCusId, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnUpdate))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 39, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbrole, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                        .addComponent(txtPass)
                                        .addComponent(btnDelete))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnShowAllCustomer)
                            .addGap(18, 18, 18)
                            .addComponent(btnLatestCustomer))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstname1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnShowAllCustomer)
                        .addComponent(btnLatestCustomer))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        // TODO add your handling code here:
        try {
            int row = userTable.getSelectedRow();
            String rowClick = (userTable.getModel().getValueAt(row, 0).toString());
            //  String sql = "select * from tbl_customer where customer_id='" + rowClick + "'";
            String sql = "select * from tbl_user where user_id = '" + rowClick + "'";
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if (rs.next()) {
                String id = rs.getString("user_id");
                txtCusId.setText(id);
                String fname = rs.getString("first_name");
                txtFirstName.setText(fname);
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
                String loginname = rs.getString("login_name");
                txtUser.setText(loginname);
                String loginpass = rs.getString("login_password");
                txtPass.setText(loginpass);
                cmbrole.setSelectedItem(userTable.getModel().getValueAt(row, 2).toString());

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_userTableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String fname = txtFirstName.getText();
        String lname = txtLastName.getText();
        String contact = txtContactNo.getText();
        String address = txtAddress.getText();
        String Email = txtEmail.getText();
        String login_name = txtUser.getText();
        String login_password = txtPass.getText();

        if (!Validate.checkEmpty(fname)) {
            if (!Validate.checkEmpty(lname)) {
                if (!Validate.checkEmpty(contact)) {
                    if (!Validate.checkEmpty(address)) {
                        if (!Validate.checkEmpty(Email)) {
                            if (!Validate.checkEmpty(login_name)) {
                                if (!Validate.checkEmpty(login_password)) {
                                    if (!Validate.checkLength(fname)) {
                                        if (!Validate.checkLength(lname)) {
                                            if (!Validate.checkContactLength(contact)) {
                                                if (!Validate.checkAdressLength(address)) {
                                                    if (!Validate.checkEmailLength(Email)) {
                                                        if (!Validate.checkLength(login_name)) {
                                                            if (!Validate.checkPasswordLength(login_password)) {
                                                                UserInfo objCustomerInfo = new UserInfo();
                                                                UserManagement objCustomerManage = new UserManagement();

                                                                objCustomerInfo.setUser_id(Integer.parseInt(this.txtCusId.getText()));
                                                                objCustomerInfo.setFirst_name(this.txtFirstName.getText());
                                                                objCustomerInfo.setMiddle_name(this.txtMiddleName.getText());
                                                                objCustomerInfo.setLast_name(this.txtLastName.getText());
                                                                objCustomerInfo.setContact_no(this.txtContactNo.getText());
                                                                objCustomerInfo.setAddress(this.txtAddress.getText());
                                                                objCustomerInfo.setEmail(this.txtEmail.getText());
                                                                objCustomerInfo.setLogin_name(this.txtUser.getText());
                                                                objCustomerInfo.setLogin_password(this.txtPass.getText());

                                                                String role = (String) cmbrole.getSelectedItem();
                                                                SupCtrl supCtrl = new SupCtrl();
                                                                RoleInfo roleInfo = supCtrl.searchRoleByRoleType(role);
                                                                objCustomerInfo.setRoleInfo(roleInfo);

                                                                if (objCustomerManage.updateUser(objCustomerInfo) == true) {
                                                                    JOptionPane.showMessageDialog(null, "Record Update Sucessfully");
                                                                    showAllUser();
                                                                } else {
                                                                    JOptionPane.showMessageDialog(null, "Error to Update Record");
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "password length must be between 5-15");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "login name length should be between 3-50");
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
                                    JOptionPane.showMessageDialog(null, "login password can not be empty");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "login name can not be empty");
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        UserInfo objCustomerInfo = new UserInfo();
        UserManagement objCustomerManage = new UserManagement();

        objCustomerInfo.setUser_id(Integer.parseInt(this.txtCusId.getText()));
        objCustomerInfo.setFirst_name(this.txtFirstName.getText());
        objCustomerInfo.setMiddle_name(this.txtMiddleName.getText());
        objCustomerInfo.setLast_name(this.txtLastName.getText());
        objCustomerInfo.setContact_no(this.txtContactNo.getText());
        objCustomerInfo.setAddress(this.txtAddress.getText());
        objCustomerInfo.setEmail(this.txtEmail.getText());
        objCustomerInfo.setLogin_name(this.txtUser.getText());
        objCustomerInfo.setLogin_password(this.txtPass.getText());

        String role = (String) cmbrole.getSelectedItem();
        SupCtrl supCtrl = new SupCtrl();
        RoleInfo roleInfo = supCtrl.searchRoleByRoleType(role);
        objCustomerInfo.setRoleInfo(roleInfo);

        if (objCustomerManage.deleteUser(objCustomerInfo) == true) {
            JOptionPane.showMessageDialog(null, "Record Deleted Sucessfully");
            showAllUser();
        } else {
            JOptionPane.showMessageDialog(null, "Error to Deleted Record");
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnShowAllCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowAllCustomerActionPerformed
        // TODO add your handling code here:
        showAllUser();
    }//GEN-LAST:event_btnShowAllCustomerActionPerformed

    private void btnLatestCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLatestCustomerActionPerformed
        // TODO add your handling code here:
        showLatestUser();
    }//GEN-LAST:event_btnLatestCustomerActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLatestCustomer;
    private javax.swing.JButton btnShowAllCustomer;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cmbrole;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblEmail3;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblFirstname1;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtCusId;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}