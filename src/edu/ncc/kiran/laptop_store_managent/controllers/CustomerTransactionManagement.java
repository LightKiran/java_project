/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.CustomerInfo;
import edu.ncc.kiran.laptop_store_managent.models.CustomerTransactionInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class CustomerTransactionManagement extends Database {

    private SupCtrl supCtr;

    public CustomerTransactionManagement() { // initializing default constructor
        supCtr = new SupCtrl();
    }

    CustomerTransactionInfo objCusTransInfo = new CustomerTransactionInfo();

    int customerMaxTransID;
    int hey2;

    public boolean addNewCustomerTransaction(CustomerTransactionInfo objCusTransInfo) { // to add new customer transaction information
        boolean isCustomerTransExist = false;
        GetDbConnection();
        try {
            String sql = "insert into tbl_customer_transaction (customer_transaction_id, "
                    + "paid, due, total_cost, date, time, customer_id) "
                    + "values (null,?,?,?,CURDATE(),CURTIME(),?)";

            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, objCusTransInfo.getPaid());
            this.pstat.setString(2, objCusTransInfo.getDue());
            this.pstat.setString(3, objCusTransInfo.getTotal_cost());
            this.pstat.setInt(4, objCusTransInfo.getCusInfo().getCustomer_id());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "please select customer");
        }try{
            int checkExist = this.pstat.executeUpdate();
            
            int hey = objCusTransInfo.getUserInfo().getUser_id();
            System.out.println("loggin id" + hey);

            int cusId = objCusTransInfo.getCusInfo().getCustomer_id();
            System.out.println("Customer id" + cusId);

            hey2 = objCusTransInfo.getUserInfo().getUser_id();
            System.out.println("loggin kiran" + hey2);

            ResultSet rs = conn.createStatement().executeQuery("select MAX(customer_transaction_id) from tbl_customer_transaction");

            if (rs.next()) {
                customerMaxTransID = rs.getInt(1);
                System.out.println("Recent input value of pk is  " + customerMaxTransID);
            }

            int cusId2 = objCusTransInfo.getCusInfo().getCustomer_id();
            System.out.println("Customer id2" + cusId2);

            String sql3 = "insert into tbl_user_customer_transaction(user_id,customer_transaction_id,customer_id) "
                    + "values(" + hey2 + "," + customerMaxTransID + "," + cusId2 + ")";

            pstat = conn.prepareStatement(sql3);
            int checkExist2 = this.pstat.executeUpdate();

            if (checkExist > 0 || checkExist2 > 0) {
                isCustomerTransExist = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }

        return isCustomerTransExist;
    }

    CustomerInfo objCus = new CustomerInfo();

    public ArrayList<CustomerTransactionInfo> listAllCustomerTransaction() {
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
        //GetDbConnection();
        ArrayList<CustomerTransactionInfo> objCusInfo = new ArrayList<CustomerTransactionInfo>();
        try {
            String query = "SELECT * FROM tbl_customer_transaction";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                CustomerTransactionInfo objCusTrans = new CustomerTransactionInfo();
                objCusTrans.setCusTransId(this.rs.getInt("customer_transaction_id"));

//                int laptopId = this.rs.getInt("laptop_id");
//                LaptopInfo laptopInfo = supCtr.findLaptopInfoById(laptopId);
//                objCusTrans.setLapInfo(laptopInfo);
                objCusTrans.setPaid(this.rs.getString("paid"));
                objCusTrans.setDue(this.rs.getString("due"));
                objCusTrans.setTotal_cost(this.rs.getString("total_cost"));
                objCusTrans.setDate(this.rs.getDate("date"));
                objCusTrans.setTime(this.rs.getTime("time"));

                int customerId = this.rs.getInt("customer_id");
                //-  CustomerInfo customerInfo = supCtr.findCustomerInfoById(customerId);
                CustomerInfo customerInfo = supCtr.findCustomerInfoById(customerId);
                objCusTrans.setCusInfo(customerInfo);

                // objCusInfo.add(objCusTrans);
                objCusInfo.add(objCusTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

    public ArrayList<CustomerTransactionInfo> listAllCustomerLatestTransaction() {
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
        //GetDbConnection();
        ArrayList<CustomerTransactionInfo> objCusInfo = new ArrayList<CustomerTransactionInfo>();
        try {
            String query = "SELECT * FROM tbl_customer_transaction order by customer_transaction_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                CustomerTransactionInfo objCusTrans = new CustomerTransactionInfo();
                objCusTrans.setCusTransId(this.rs.getInt("customer_transaction_id"));

//                int laptopId = this.rs.getInt("laptop_id");
//                LaptopInfo laptopInfo = supCtr.findLaptopInfoById(laptopId);
//                objCusTrans.setLapInfo(laptopInfo);
                objCusTrans.setPaid(this.rs.getString("paid"));
                objCusTrans.setDue(this.rs.getString("due"));
                objCusTrans.setTotal_cost(this.rs.getString("total_cost"));
                objCusTrans.setDate(this.rs.getDate("date"));
                objCusTrans.setTime(this.rs.getTime("time"));

                int customerId = this.rs.getInt("customer_id");
                //-  CustomerInfo customerInfo = supCtr.findCustomerInfoById(customerId);
                CustomerInfo customerInfo = supCtr.findCustomerInfoById(customerId);
                objCusTrans.setCusInfo(customerInfo);

                // objCusInfo.add(objCusTrans);
                objCusInfo.add(objCusTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

    public boolean Update(CustomerTransactionInfo customerTransactionInfo) { // to update customer transaction information
        String sql = "update tbl_customer_transaction tc inner join tbl_user_customer_transaction tcp "
                + "on tc.customer_transaction_id = tcp.customer_transaction_id "
                + "set tc.paid=?, tc.due=?, tc.total_cost=?, tcp.user_id=?, tc.date=CURDATE(), tc.time=CURTIME()"
                + "where tc.customer_transaction_id = ?";
        
        boolean res = false;
        GetDbConnection();
        try {
            pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, customerTransactionInfo.getPaid());
            pstat.setString(2, customerTransactionInfo.getDue());
            pstat.setString(3, customerTransactionInfo.getTotal_cost());
            String tt = customerTransactionInfo.getTotal_cost();
            System.out.println("tt" + tt);

            pstat.setInt(4, customerTransactionInfo.getUserInfo().getUser_id());
            int uu = customerTransactionInfo.getUserInfo().getUser_id();
            System.out.println("tyry" + uu);

            pstat.setInt(5, customerTransactionInfo.getCusTransId());

            pstat.executeUpdate();

            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }

    public boolean deleteCustomerTransaction(CustomerTransactionInfo customerTrans) { // to delete customer transaction information

        String sql = "delete tct, tuct from tbl_customer_transaction tct inner join tbl_user_customer_transaction tuct on tct.customer_transaction_id = tct.customer_transaction_id where tct.customer_transaction_id = ?";

        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, customerTrans.getCusTransId());

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
}
