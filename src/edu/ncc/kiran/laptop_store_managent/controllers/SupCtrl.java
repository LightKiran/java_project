/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import edu.ncc.kiran.laptop_store_managent.models.CustomerInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class SupCtrl extends Database {

    public CustomerInfo findCustomerInfoById(int id) {
        CustomerInfo objCusInfo = null;
        try {
            String query = "SELECT * FROM tbl_customer WHERE customer_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objCusInfo = new CustomerInfo();
                objCusInfo.setCustomer_id(this.rs.getInt("customer_id"));
                objCusInfo.setFirst_name(this.rs.getString("first_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

    public CustomerInfo findCustomerInfoByName(String name) {
        CustomerInfo objCusInfo = null;
        try {
            String query = "SELECT * FROM tbl_customer WHERE first_name = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, name);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objCusInfo = new CustomerInfo();
                objCusInfo.setCustomer_id(this.rs.getInt("customer_id"));
                objCusInfo.setFirst_name(this.rs.getString("first_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

    public LaptopInfo findLaptopInfoById(int id) {
        LaptopInfo objLapInfo = null;
        try {
            String query = "SELECT * FROM tbl_laptop WHERE laptop_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objLapInfo = new LaptopInfo();
                objLapInfo.setLaptop_id(this.rs.getInt("laptop_id"));
                objLapInfo.setModel_no(this.rs.getString("model_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objLapInfo;
    }

    public LaptopInfo findLaptopInfoByModel(String model) {
        LaptopInfo objLapInfo = null;
        try {
            String query = "SELECT * FROM tbl_laptop WHERE model_no = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, model);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objLapInfo = new LaptopInfo();
                objLapInfo.setLaptop_id(this.rs.getInt("laptop_id"));
                objLapInfo.setModel_no(this.rs.getString("model_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objLapInfo;
    }

}
