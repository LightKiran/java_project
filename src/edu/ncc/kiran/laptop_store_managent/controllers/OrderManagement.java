/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import edu.ncc.kiran.laptop_store_managent.models.SupplierInfo;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
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
public class OrderManagement extends Database {

    private SupCtrl supCtr;
    private SupplierManagement supMgmt;

    public OrderManagement() { // initializing default constructor
        supCtr = new SupCtrl();
        supMgmt = new SupplierManagement();
    }
    int orderMaxID, insert, supId;

    public boolean addNewOrder(OrderInfo order) { // to add new order
        boolean isOrderCreated = false;

        try {
            String query = "INSERT INTO tbl_order VALUES(null,?,CURDATE(),CURTIME(),?)";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, order.getPieces());
            this.pstat.setInt(2, order.getLapInfo().getLaptop_id());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please select laptop model");
            return isOrderCreated;
        }
        try {
            insert = this.pstat.executeUpdate();

            supId = order.getSupInfo().getSupplier_id();
            System.out.println("supp" + supId);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please select supplier name");
            return isOrderCreated;

        }
        try {
            ResultSet rs = conn.createStatement().executeQuery("select MAX(order_id) from tbl_order");

            if (rs.next()) {
                orderMaxID = rs.getInt(1);
                System.out.println("Recent input value of pk is  " + orderMaxID);
            }

            String sql3 = "insert into tbl_order_supplier(order_id, supplier_id) "
                    + "values(" + orderMaxID + "," + supId + ")";

            pstat = conn.prepareStatement(sql3);
            int insert2 = this.pstat.executeUpdate();

            if (insert > 0 || insert2 > 0) {
                isOrderCreated = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.pstat.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return isOrderCreated;
    }

    public ArrayList<OrderInfo> listAllOrder() { // to list all order
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
        ArrayList<OrderInfo> objOrderInfo = new ArrayList<OrderInfo>();
        try {
            String query = "select tbo.order_id, tbo.peices, tbo.date, tbo.time, tbo.laptop_id, tos.supplier_id "
                    + "from tbl_order tbo left join tbl_order_supplier tos "
                    + "on tbo.order_id = tos.order_id";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                OrderInfo objSupTrans = new OrderInfo();
                objSupTrans.setOrder_id(this.rs.getInt("order_id"));
                objSupTrans.setPieces(this.rs.getString("peices"));
                objSupTrans.setDate(this.rs.getDate("date"));
                objSupTrans.setTime(this.rs.getTime("time"));

                int laptopBrandId = this.rs.getInt("laptop_id");
                LaptopInfo laptopInfo = supCtr.findLaptopInfoById(laptopBrandId);
                objSupTrans.setLapInfo(laptopInfo);

                int supplierId = this.rs.getInt("supplier_id");
                SupplierInfo supplierInfo = supCtr.findSupplierInfoById(supplierId);
                objSupTrans.setSupInfo(supplierInfo);

                objOrderInfo.add(objSupTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objOrderInfo;
    }

    public ArrayList<OrderInfo> listLatestlOrder() { // to list latest order
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;
        ArrayList<OrderInfo> objOrderInfo = new ArrayList<OrderInfo>();
        try {
            String query = "select tbo.order_id, tbo.peices, tbo.date, tbo.time, tbo.laptop_id, tos.supplier_id "
                    + "from tbl_order tbo left join tbl_order_supplier tos "
                    + "on tbo.order_id = tos.order_id order by tbo.order_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();
            while (rs.next()) {
                OrderInfo objSupTrans = new OrderInfo();
                objSupTrans.setOrder_id(this.rs.getInt("order_id"));
                objSupTrans.setPieces(this.rs.getString("peices"));
                objSupTrans.setDate(this.rs.getDate("date"));
                objSupTrans.setTime(this.rs.getTime("time"));

                int laptopBrandId = this.rs.getInt("laptop_id");
                LaptopInfo laptopInfo = supCtr.findLaptopInfoById(laptopBrandId);
                objSupTrans.setLapInfo(laptopInfo);

                int supplierId = this.rs.getInt("supplier_id");
                SupplierInfo supplierInfo = supCtr.findSupplierInfoById(supplierId);
                objSupTrans.setSupInfo(supplierInfo);

                objOrderInfo.add(objSupTrans);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objOrderInfo;
    }

    public boolean UpdateOrder(OrderInfo orderInfo) { // to update order

        boolean res = false;
        try {
            GetDbConnection();
            String sql = "update tbl_order tbo inner join tbl_order_supplier tos "
                    + "on tbo.order_id = tos.order_id set tbo.peices=?, tbo.date=CURDATE(), tbo.time=CURTIME(), tbo.laptop_id=?, "
                    + "tos.supplier_id=? where tbo.order_id=?";
            pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, orderInfo.getPieces());
            pstat.setInt(2, orderInfo.getLapInfo().getLaptop_id());
            pstat.setInt(3, orderInfo.getSupInfo().getSupplier_id());
            pstat.setInt(4, orderInfo.getOrder_id());

            pstat.executeUpdate();
            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }

    public boolean deleteOrder(OrderInfo order) { // to delete order

        boolean res = false;

        String sql = "delete from tbl_order where order_id = ?";
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, order.getOrder_id());

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
