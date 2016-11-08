/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.views;

import edu.ncc.kiran.laptop_store_managent.controllers.LaptopBrandManagement;
import edu.ncc.kiran.laptop_store_managent.controllers.LaptopManagment;
import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import edu.ncc.kiran.laptop_store_managent.models.UserInfo;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class AddNewLaptopBrand extends javax.swing.JDialog {

    /**
     * Creates new form AddNewLaptopBrand
     */
    UserInfo loggedInUserInfo;

    public AddNewLaptopBrand(java.awt.Frame parent, boolean modal, UserInfo loggedInUserInfo) {
        super(parent, modal);
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        txtLapBrand = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Laptop brand :");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnSave))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel1)
                    .addComponent(txtLapBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLapBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String brand = txtLapBrand.getText();

        if (!Validate.checkEmpty(brand)) {
            if (!Validate.checkLengthModel(brand)) {
                LaptopBrandInfo objLaptopBrandInfo = new LaptopBrandInfo();

                objLaptopBrandInfo.setBrandname(txtLapBrand.getText());

                LaptopBrandManagement objLaptopBrandManagment = new LaptopBrandManagement();

                boolean isLaptopBrandExist = objLaptopBrandManagment.CreateNewLaptopBrand(objLaptopBrandInfo);

                if (isLaptopBrandExist) {
                    JOptionPane.showMessageDialog(null, "New laptop brand added sucessfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error!! New laptop brand added");
                }
            } else {
                JOptionPane.showMessageDialog(null, "brand lenght should between 2-15");
            }

        } else {
            JOptionPane.showMessageDialog(null, "brand can be empty");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtLapBrand;
    // End of variables declaration//GEN-END:variables
}
