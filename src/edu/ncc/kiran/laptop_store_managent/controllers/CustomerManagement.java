/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.CustomerInfo;
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
public class CustomerManagement extends Database {

    CustomerInfo objCusInfo = new CustomerInfo();
    private SupCtrl supCtr;

    public CustomerManagement() {
        supCtr = new SupCtrl();
    }

    private int customerMaxID, lapModel;

    public boolean addNewCustomer(CustomerInfo objCusInfo) {
        boolean isCustomerNameExist = false;
        GetDbConnection();
        try {

            String sql = "insert into tbl_customer (customer_id, first_name, middle_name,"
                    + " last_name, contact_no, address, email) "
                    + "values (null,?,?,?,?,?,?)";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, objCusInfo.getFirst_name());
            this.pstat.setString(2, objCusInfo.getMiddle_name());
            this.pstat.setString(3, objCusInfo.getLast_name());
            this.pstat.setString(4, objCusInfo.getContact_no());
            this.pstat.setString(5, objCusInfo.getAddress());
            this.pstat.setString(6, objCusInfo.getEmail());
//            pstat.setInt(7, objCusInfo.getUserInfo().getUser_id());

            int checkExist = this.pstat.executeUpdate();

            ResultSet rs = conn.createStatement().executeQuery("select MAX(customer_id) from tbl_customer");

            if (rs.next()) {
                customerMaxID = rs.getInt(1);
                System.out.println("Recent input value of pk is  " + customerMaxID);
            }

            lapModel = objCusInfo.getLapInfo().getLaptop_id();
            System.out.println("lap" + lapModel);

            String sql3 = "insert into tbl_customer_laptop(customer_id, laptop_id) "
                    + "values(" + customerMaxID + "," + lapModel + ")";

            pstat = conn.prepareStatement(sql3);
            int checkExist2 = this.pstat.executeUpdate();

            if (checkExist > 0 || checkExist2 > 0) {
                isCustomerNameExist = true;
            }

            //CloseDbConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);

        }

        return isCustomerNameExist;
    }

    public ArrayList<CustomerInfo> listAllCustomers() {
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
        //GetDbConnection();

        ArrayList<CustomerInfo> objCusInfo = new ArrayList<CustomerInfo>();

        try {
            String query = "select tc.customer_id, tc.first_name, tcp.laptop_id "
                    + "from tbl_customer tc inner join tbl_customer_laptop tcp "
                    + "on tc.customer_id = tcp.customer_id";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();

            while (rs.next()) {
                CustomerInfo pg = new CustomerInfo();
                pg.setCustomer_id(this.rs.getInt("customer_id"));
                pg.setFirst_name(this.rs.getString("first_name"));
//                pg.setMiddle_name(this.rs.getString("middle_name"));
//                pg.setLast_name(this.rs.getString("last_name"));
//                pg.setContact_no(this.rs.getString("contact_no"));
//                pg.setAddress(this.rs.getString("address"));
//                pg.setEmail(this.rs.getString("email

                int lapId = this.rs.getInt("laptop_id");
                LaptopInfo objlaptopInfo = supCtr.findLaptopInfoById(lapId);
                pg.setLapInfo(objlaptopInfo);
                //pg.setLapInfo(this.rs.getInt(""));

                objCusInfo.add(pg);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objCusInfo;
    }

    public ArrayList<CustomerInfo> listLatestCustomers() {
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
        //GetDbConnection();
        ArrayList<CustomerInfo> objCusInfo = new ArrayList<CustomerInfo>();
        try {
            String query = "SELECT * FROM tbl_customer order by customer_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
//            String query2 = "SELECT * FROM tbl_customer order by customer_id desc limit 1";
//            this.pstat = this.conn.prepareStatement(query2);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                CustomerInfo pg = new CustomerInfo();
                pg.setCustomer_id(this.rs.getInt("customer_id"));
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

    public boolean deleteCustomer(CustomerInfo customer) {
        String sql = "delete from tbl_customer where customer_id=?";
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, customer.getCustomer_id());
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

    public CustomerInfo searchCustomer(int custId) {

        String sql = "select * from tbl_customer where customer_id=?";
        //select name from emp where name like 'ravi%'
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, custId);
            rs = pstat.executeQuery();//search
            while (rs.next()) {
                objCusInfo.setCustomer_id(this.rs.getInt("customer_id"));
                objCusInfo.setFirst_name(this.rs.getString("first_name"));
                objCusInfo.setMiddle_name(this.rs.getString("middle_name"));
                objCusInfo.setLast_name(this.rs.getString("last_name"));
                objCusInfo.setContact_no(this.rs.getString("contact_no"));
                objCusInfo.setAddress(this.rs.getString("address"));
                objCusInfo.setEmail(this.rs.getString("email"));
            }
            rs.close();
            CloseDbConnection();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return (objCusInfo);
    }

    public boolean Update(CustomerInfo custInfo) {
//        String sql2 = "update tbl_customer set first_name=?, middle_name=?, last_name=?, "
//                + "contact_no=?, address=?, email=? where customer_id=?";

        String sql = "update tbl_customer tc inner join tbl_customer_laptop tcp "
                + "on tc.customer_id = tcp.customer_id "
                + "set tc.first_name=?, tc.middle_name=?, tc.last_name=?, "
                + "tc.contact_no=?, tc.address=?, tc.email=?, tcp.laptop_id=? "
                + "where tc.customer_id = ?";
        /*xamp update tbl_customer tc inner join tbl_customer_laptop tcp on tc.customer_id and tcp.customer_id set tc.first_name='hari', tc.middle_name='hey', tc.last_name='rai', tc.contact_no=9841, tc.address='boudha', tc.email='harilla', tcp.laptop_id=2 where tc.customer_id = 4*/
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, custInfo.getFirst_name());
            pstat.setString(2, custInfo.getMiddle_name());
            pstat.setString(3, custInfo.getLast_name());
            pstat.setString(4, custInfo.getContact_no());
            pstat.setString(5, custInfo.getAddress());
            pstat.setString(6, custInfo.getEmail());
            pstat.setInt(7, custInfo.getLapInfo().getLaptop_id());
            pstat.setInt(8, custInfo.getCustomer_id());

//            String brand = (String) cmbLapModel.getSelectedItem();
//            SupCtrl supCtrl = new SupCtrl();
//            LaptopInfo laptopInfo = supCtrl.findLaptopInfoByModel(brand);
//            objCustomerInfo.setLapInfo(laptopInfo);
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
