/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import edu.ncc.kiran.laptop_store_managent.models.SupplierInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class SupplierManagement extends Database {

    public boolean addNewSupplier(SupplierInfo objSupInfo) { // to add new supplier information in table
        boolean isSupplierrNameExist = false;

        try {
            Database db = new Database();
            db.GetDbConnection();
            conn = db.conn;
            String sql = "insert into tbl_supplier (supplier_id, first_name, middle_name, last_name, contact_no, address, email) "
                    + "values (null,?,?,?,?,?,?)";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, objSupInfo.getFirst_name());
            this.pstat.setString(2, objSupInfo.getMiddle_name());
            this.pstat.setString(3, objSupInfo.getLast_name());
            this.pstat.setString(4, objSupInfo.getContact_no());
            this.pstat.setString(5, objSupInfo.getAddress());
            this.pstat.setString(6, objSupInfo.getEmail());
            int checkExist = this.pstat.executeUpdate();

            if (checkExist > 0) {
                isSupplierrNameExist = true;
            }

            //CloseDbConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierManagement.class.getName()).log(Level.SEVERE, null, ex);

        }

        return isSupplierrNameExist;
    }

    public boolean Update(SupplierInfo suppInfo) { // to update supplier information 
        String sql = "update tbl_supplier set first_name=?, middle_name=?, last_name=?, "
                + "contact_no=?, address=?, email=? where supplier_id=?";

        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, suppInfo.getFirst_name());
            pstat.setString(2, suppInfo.getMiddle_name());
            pstat.setString(3, suppInfo.getLast_name());
            pstat.setString(4, suppInfo.getContact_no());
            pstat.setString(5, suppInfo.getAddress());
            pstat.setString(6, suppInfo.getEmail());
            pstat.setInt(7, suppInfo.getSupplier_id());
            pstat.executeUpdate();
            pstat.close();
            CloseDbConnection();
            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }

    public boolean Delete(SupplierInfo supplier) { // to delete supplier information 
        String sql = "delete from tbl_supplier where supplier_id=?";
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, supplier.getSupplier_id());
            pstat.executeUpdate();
            pstat.close();
            CloseDbConnection();
            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }

    public ArrayList<SupplierInfo> listAllSuppliers() { // to list all suppliers information
        GetDbConnection();
        ArrayList<SupplierInfo> objCusInfo = new ArrayList<SupplierInfo>();
        try {
            String query = "SELECT * FROM tbl_supplier";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {

                SupplierInfo pg = new SupplierInfo();
                pg.setSupplier_id(this.rs.getInt("supplier_id"));
                pg.setFirst_name(this.rs.getString("first_name"));
                pg.setMiddle_name(this.rs.getString("middle_name"));
                pg.setLast_name(this.rs.getString("last_name"));
                pg.setContact_no(this.rs.getString("contact_no"));
                pg.setAddress(this.rs.getString("address"));
                pg.setEmail(this.rs.getString("email"));
                objCusInfo.add(pg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

    public ArrayList<SupplierInfo> listLatestSuppliers() { // to list latest suppliers information
        GetDbConnection();
        ArrayList<SupplierInfo> objCusInfo = new ArrayList<SupplierInfo>();
        try {
            String query = "SELECT * FROM tbl_supplier order by supplier_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {

                SupplierInfo pg = new SupplierInfo();
                pg.setSupplier_id(this.rs.getInt("supplier_id"));
                pg.setFirst_name(this.rs.getString("first_name"));
                pg.setMiddle_name(this.rs.getString("middle_name"));
                pg.setLast_name(this.rs.getString("last_name"));
                pg.setContact_no(this.rs.getString("contact_no"));
                pg.setAddress(this.rs.getString("address"));
                pg.setEmail(this.rs.getString("email"));
                objCusInfo.add(pg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

}
