/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierTransactionInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class SupplierTransactionManagement extends Database {

    private SupCtrl supCtr;

    public SupplierTransactionManagement() {  // initializing default constructor
        supCtr = new SupCtrl();
    }

    public boolean addNewSupplierTransaction(SupplierTransactionInfo objSupTransInfo) { // to add new supplier transaction

        boolean isSupplierTransExist = false;

        try {
            GetDbConnection();

            String sql = "insert into tbl_order_transaction(supplier_transaction_id, paid, due, total_cost, date, time, order_id) "
                    + "values (null,?,?,?,CURDATE(),CURTIME(),?)";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, objSupTransInfo.getPaid());
            this.pstat.setString(2, objSupTransInfo.getDue());
            this.pstat.setString(3, objSupTransInfo.getTotal_cost());
            this.pstat.setInt(4, objSupTransInfo.getOrderInfo().getOrder_id());
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please select no of order pieces");
            return isSupplierTransExist;
        }
        try {

            int checkExist = this.pstat.executeUpdate();

            if (checkExist > 0) {
                isSupplierTransExist = true;
            }

            //CloseDbConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);

        }

        return isSupplierTransExist;
    }

    public boolean updateSupplierTransaction(SupplierTransactionInfo objSupTransInfo) { // to update supplier transaction

        boolean isSupplierTransExist = false;

        try {
            GetDbConnection();
            String sql = "update tbl_order_transaction set paid=?, due=?, total_cost=?, date=CURDATE(), time=CURTIME(), order_id=? where supplier_transaction_id=? ";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, objSupTransInfo.getPaid());
            this.pstat.setString(2, objSupTransInfo.getDue());
            this.pstat.setString(3, objSupTransInfo.getTotal_cost());
            this.pstat.setInt(4, objSupTransInfo.getOrderInfo().getOrder_id());
            this.pstat.setInt(5, objSupTransInfo.getSupTransId());

            this.pstat.executeUpdate();

            isSupplierTransExist = true;
        } catch (SQLException ex) {
            isSupplierTransExist = false;
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);

        }

        return isSupplierTransExist;
    }

    public SupplierInfo findSupplierInfoById(int id) {
        SupplierInfo role = null;
        try {
            String query = "SELECT * FROM tbl_supplier WHERE supplier_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                role = new SupplierInfo();
                role.setSupplier_id(this.rs.getInt("supplier_id"));
                role.setFirst_name(this.rs.getString("first_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupplierTransactionManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return role;
    }

    public ArrayList<SupplierTransactionInfo> listAllSupplierTransaction() { // to list all supplier transaction from table
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;

        ArrayList<SupplierTransactionInfo> objSupInfo = new ArrayList<SupplierTransactionInfo>();
        try {
            String query = "SELECT * FROM tbl_order_transaction";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                SupplierTransactionInfo objSupTrans = new SupplierTransactionInfo();
                objSupTrans.setSupTransId(this.rs.getInt("supplier_transaction_id"));
                objSupTrans.setPaid(this.rs.getString("paid"));
                objSupTrans.setDue(this.rs.getString("due"));
                objSupTrans.setTotal_cost(this.rs.getString("total_cost"));
                objSupTrans.setDate(this.rs.getDate("date"));
                objSupTrans.setTime(this.rs.getTime("time"));

                int orderId = this.rs.getInt("order_id");
                OrderInfo orderInfo = supCtr.findOrderInfoById(orderId);
                objSupTrans.setOrderInfo(orderInfo);

                objSupInfo.add(objSupTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objSupInfo;
    }

    public ArrayList<SupplierTransactionInfo> listLatestSupplierTransaction() { // to list latest supplier transaction from table
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;

        ArrayList<SupplierTransactionInfo> objSupInfo = new ArrayList<SupplierTransactionInfo>();
        try {
            String query = "SELECT * FROM tbl_order_transaction order by supplier_transaction_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                SupplierTransactionInfo objSupTrans = new SupplierTransactionInfo();
                objSupTrans.setSupTransId(this.rs.getInt("supplier_transaction_id"));
                objSupTrans.setPaid(this.rs.getString("paid"));
                objSupTrans.setDue(this.rs.getString("due"));
                objSupTrans.setTotal_cost(this.rs.getString("total_cost"));
                objSupTrans.setDate(this.rs.getDate("date"));
                objSupTrans.setTime(this.rs.getTime("time"));

                int orderId = this.rs.getInt("order_id");
                OrderInfo orderInfo = supCtr.findOrderInfoById(orderId);
                objSupTrans.setOrderInfo(orderInfo);

                objSupInfo.add(objSupTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objSupInfo;
    }

    public boolean deleteSupplierTransaction(SupplierTransactionInfo supplierTransactionInfo) { // to delete supplier transaction from table

        String sql = "delete from tbl_order_transaction where supplier_transaction_id = ?";
        boolean res = false;
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, supplierTransactionInfo.getSupTransId());

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
