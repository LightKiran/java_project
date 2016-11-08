/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import edu.ncc.kiran.laptop_store_managent.models.CustomerInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import edu.ncc.kiran.laptop_store_managent.models.RoleInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierInfo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class SupCtrl extends Database {

    public CustomerInfo findCustomerInfoById(int id) { // to find customer by customer id
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

    public CustomerInfo findCustomerInfoByName(String name) {  // to find customer by first name
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

    public LaptopBrandInfo findLaptopBrandById(int id) {  // to find laptop brand by laptopbrand_id
        LaptopBrandInfo objLapBrandInfo = null;
        try {
            String query = "SELECT * FROM tbl_laptopbrand WHERE laptopbrand_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objLapBrandInfo = new LaptopBrandInfo();
                objLapBrandInfo.setLaptopbrand_id(this.rs.getInt("laptopbrand_id"));
                objLapBrandInfo.setBrandname(this.rs.getString("brandname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objLapBrandInfo;
    }

    public LaptopBrandInfo findLaptopByBrand(String brand) { // to find laptop brand by brandname
        LaptopBrandInfo objLapBrandInfo = null;
        try {
            String query = "SELECT * FROM tbl_laptopbrand WHERE brandname = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, brand);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objLapBrandInfo = new LaptopBrandInfo();
                objLapBrandInfo.setLaptopbrand_id(this.rs.getInt("laptopbrand_id"));
                objLapBrandInfo.setBrandname(this.rs.getString("brandname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objLapBrandInfo;
    }

    public LaptopInfo findLaptopInfoById(int id) { // to find laptop by laptop_id
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

    public LaptopInfo findLaptopInfoByModel(String model) { // to find laptop by model_no
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

    public OrderInfo findOrderLaptopInfoById(int id) { // to find order laptop information by order_id
        OrderInfo objorderInfo = null;
        try {
            String query = "SELECT * FROM tbl_order WHERE order_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objorderInfo = new OrderInfo();
                objorderInfo.setOrder_id(this.rs.getInt("order_id"));
                objorderInfo.setPieces(this.rs.getString("peices"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objorderInfo;
    }

    public OrderInfo findOrderLaptopInfoByModel(String pieces) { // to find order laptop information by peices
        OrderInfo objorderInfo = null;
        try {
            String query = "SELECT * FROM tbl_order WHERE peices = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, pieces);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objorderInfo = new OrderInfo();
                objorderInfo.setOrder_id(this.rs.getInt("order_id"));
                objorderInfo.setPieces(this.rs.getString("peices"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objorderInfo;
    }

    public SupplierInfo findSupplierInfoById(int id) { // to find supplier information by supplier_id
        SupplierInfo objSupInfo = null;
        try {
            String query = "SELECT * FROM tbl_supplier WHERE supplier_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objSupInfo = new SupplierInfo();
                objSupInfo.setSupplier_id(this.rs.getInt("supplier_id"));
                objSupInfo.setFirst_name(this.rs.getString("first_name"));
                objSupInfo.setContact_no(this.rs.getString("contact_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objSupInfo;
    }

    public SupplierInfo findSupplierInfoByName(String name) { // to find supplier information by first name
        SupplierInfo objSupInfo = null;
        try {
            String query = "SELECT * FROM tbl_supplier WHERE first_name = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, name);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objSupInfo = new SupplierInfo();
                objSupInfo.setSupplier_id(this.rs.getInt("supplier_id"));
                objSupInfo.setFirst_name(this.rs.getString("first_name"));
                objSupInfo.setContact_no(this.rs.getString("contact_no"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objSupInfo;
    }

    public OrderInfo findOrderInfoById(int id) { // to find order information by order id
        OrderInfo objOrderInfo = null;
        try {
            String query = "SELECT * FROM tbl_order WHERE order_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objOrderInfo = new OrderInfo();
                objOrderInfo.setOrder_id(this.rs.getInt("order_id"));
                objOrderInfo.setPieces(this.rs.getString("peices"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objOrderInfo;
    }

    public OrderInfo findOrderInfoByPieces(String id) { // to find order information by peices
        OrderInfo objOrderInfo = null;
        try {
            String query = "SELECT * FROM tbl_order WHERE peices = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                objOrderInfo = new OrderInfo();
                objOrderInfo.setOrder_id(this.rs.getInt("order_id"));
                objOrderInfo.setPieces(this.rs.getString("peices"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objOrderInfo;
    }

    public RoleInfo searchRoleById(int id) { // to find role by role_id
        RoleInfo role = null;
        try {
            String sql = "SELECT * FROM tbl_role WHERE role_id = ?";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                role = new RoleInfo();
                role.setRole_id(this.rs.getInt("role_id"));
                role.setRole_type(this.rs.getString("role_type"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SupCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    public RoleInfo searchRoleByRoleType(String roleType) { // to find role by role_type
        RoleInfo role = null;
        try {
            String sql = "SELECT * FROM tbl_role WHERE role_type = ?";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, roleType);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                role = new RoleInfo();
                role.setRole_id(this.rs.getInt("role_id"));
                role.setRole_type(this.rs.getString("role_type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

}
