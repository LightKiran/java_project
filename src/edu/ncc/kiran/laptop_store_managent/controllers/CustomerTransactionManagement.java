/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.CustomerInfo;
import edu.ncc.kiran.laptop_store_managent.models.CustomerTransactionInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class CustomerTransactionManagement extends Database {

    private SupCtrl supCtr;
//    private CustomerManagement cusMgmt;
//    private LaptopManagment lapMgmt;
//    private LaptopBrandManagement lapBrndMgmt;
//

    public CustomerTransactionManagement() {
        supCtr = new SupCtrl();
//        cusMgmt = new CustomerManagement();
//        lapMgmt = new LaptopManagment();
//        lapBrndMgmt = new LaptopBrandManagement();
    }

    CustomerTransactionInfo objCusTransInfo = new CustomerTransactionInfo();

    //int checkExist;
    int customerMaxTransID;
    int hey2;

    public boolean addNewCustomerTransaction(CustomerTransactionInfo objCusTransInfo) {
        boolean isCustomerTransExist = false;
        GetDbConnection();

        try {

            String sql = "insert into tbl_customer_transaction (customer_transaction_id, "
                    + "paid, due, total_cost, date, time, customer_id) "
                    + "values (null,?,?,?,CURDATE(),CURTIME(),?)";
            this.pstat = this.conn.prepareStatement(sql);
            // this.pstat.setInt(2, objCusTransInfo.getLapInfo().getLaptop_id());
            this.pstat.setString(1, objCusTransInfo.getPaid());
            this.pstat.setString(2, objCusTransInfo.getDue());
            this.pstat.setString(3, objCusTransInfo.getTotal_cost());
            this.pstat.setInt(4, objCusTransInfo.getCusInfo().getCustomer_id());

            int hey = objCusTransInfo.getUserInfo().getUser_id();
            System.out.println("loggin" + hey);

            int checkExist = this.pstat.executeUpdate();

            hey2 = objCusTransInfo.getUserInfo().getUser_id();
            System.out.println("loggin kiran" + hey2);

            ResultSet rs = conn.createStatement().executeQuery("select MAX(customer_transaction_id) from tbl_customer_transaction");

            if (rs.next()) {
                customerMaxTransID = rs.getInt(1);
                System.out.println("Recent input value of pk is  " + customerMaxTransID);

            }

            //String sql3 = "insert into customerservice(CustomerID,ServiceID) values(" + customerID + "," + serviceID + ");";
            String sql3 = "insert into tbl_user_customer_transaction(user_id,customer_transaction_id) "
                    + "values(" + hey2 + "," + customerMaxTransID + ")";
//            String sql3 = "insert into tbl_user_customer_transaction(user_id,customer_transaction_id) "
//                    + "values(?,?)";

//            this.pstat.setInt(1, hey2);
//            this.pstat.setInt(2, customerMaxTransID);

            pstat = conn.prepareStatement(sql3);
            int checkExist2 = this.pstat.executeUpdate();

            if (checkExist > 0 || checkExist2 > 0) {
                isCustomerTransExist = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);

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

                int customerId = this.rs.getInt("customer_id");
                //-  CustomerInfo customerInfo = supCtr.findCustomerInfoById(customerId);
                CustomerInfo customerInfo = supCtr.findCustomerInfoById(customerId);
                objCusTrans.setCusInfo(customerInfo);

                int laptopId = this.rs.getInt("laptop_id");
                LaptopInfo laptopInfo = supCtr.findLaptopInfoById(laptopId);
                objCusTrans.setLapInfo(laptopInfo);

                objCusTrans.setPaid(this.rs.getString("paid"));
                objCusTrans.setDue(this.rs.getString("due"));
                objCusTrans.setTotal_cost(this.rs.getString("total_cost"));
                objCusTrans.setDate(this.rs.getDate("date"));
                objCusTrans.setTime(this.rs.getTime("time"));

                // objCusInfo.add(objCusTrans);
                objCusInfo.add(objCusTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

//    public CustomerInfo findCustomerInfoById(int id) {
//        CustomerInfo objCusInfo = null;
//        try {
//            String query = "SELECT * FROM tbl_customer WHERE customer_id = ?";
//            this.pstat = this.conn.prepareStatement(query);
//            this.pstat.setInt(1, id);
//            this.rs = this.pstat.executeQuery();
//            while (this.rs.next()) {
//                objCusInfo = new CustomerInfo();
//                objCusInfo.setCustomer_id(this.rs.getInt("customer_id"));
//                objCusInfo.setFirst_name(this.rs.getString("first_name"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return objCusInfo;
//    }
//
//    public CustomerInfo findCustomerInfoByName(String name) {
//        CustomerInfo objCusInfo = null;
//        try {
//            String query = "SELECT * FROM tbl_customer WHERE first_name = ?";
//            this.pstat = this.conn.prepareStatement(query);
//            this.pstat.setString(1, name);
//            this.rs = this.pstat.executeQuery();
//            while (this.rs.next()) {
//                objCusInfo = new CustomerInfo();
//                objCusInfo.setCustomer_id(this.rs.getInt("customer_id"));
//                objCusInfo.setFirst_name(this.rs.getString("first_name"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return objCusInfo;
//    }
//    public LaptopInfo findLaptopInfoById(int id) {
//        LaptopInfo objLapInfo = null;
//        try {
//            String query = "SELECT * FROM tbl_laptop WHERE laptop_id = ?";
//            this.pstat = this.conn.prepareStatement(query);
//            this.pstat.setInt(1, id);
//            this.rs = this.pstat.executeQuery();
//            while (this.rs.next()) {
//                objLapInfo = new LaptopInfo();
//                objLapInfo.setLaptop_id(this.rs.getInt("laptop_id"));
//                objLapInfo.setModel_no(this.rs.getString("model_no"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return objLapInfo;
//    }
//
//    public LaptopInfo findLaptopInfoByModel(String model) {
//        LaptopInfo objLapInfo = null;
//        try {
//            String query = "SELECT * FROM tbl_laptop WHERE model_no = ?";
//            this.pstat = this.conn.prepareStatement(query);
//            this.pstat.setString(1, model);
//            this.rs = this.pstat.executeQuery();
//            while (this.rs.next()) {
//                objLapInfo = new LaptopInfo();
//                objLapInfo.setLaptop_id(this.rs.getInt("laptop_id"));
//                objLapInfo.setModel_no(this.rs.getString("model_no"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return objLapInfo;
//    }
}
