/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import edu.ncc.kiran.laptop_store_managent.models.OrderInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kiran
 */
public class LaptopManagment extends Database {

    private SupCtrl supCtr;

    public LaptopManagment() { // initializing default constructor
        supCtr = new SupCtrl();
    }

    public boolean addNewLaptop(LaptopInfo lapInfo) { // to add new laptop information
        boolean isLaptopExist = false;
        GetDbConnection();
        try {

            String sql = "insert into tbl_laptop (laptop_id, model_no, harddisk, ram, graphics, generation, "
                    + "processor, price, laptopbrand_id) "
                    + "values (null,?,?,?,?,?,?,?,?)";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, lapInfo.getModel_no());
            this.pstat.setString(2, lapInfo.getHarddisk());
            this.pstat.setString(3, lapInfo.getRam());
            this.pstat.setString(4, lapInfo.getGraphics());
            this.pstat.setString(5, lapInfo.getGeneration());
            this.pstat.setString(6, lapInfo.getProcessor());
            this.pstat.setDouble(7, lapInfo.getPrice());
            this.pstat.setInt(8, lapInfo.getLapBrandInfo().getLaptopbrand_id());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "please select laptop brand");
            System.out.println("ERROR : "+e);
        }try{
            int checkExist = this.pstat.executeUpdate();

            if (checkExist > 0) {
                isLaptopExist = true;
            }

        } catch (SQLException ex) {
            System.out.println("ERROR"+ex);
        }

        return isLaptopExist;
    }

    public ArrayList<LaptopInfo> listAllLaptops() { // to list all laptop information
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;

        ArrayList<LaptopInfo> objlaptopInfo = new ArrayList<LaptopInfo>();

        try {
            String query = "select * from tbl_laptop";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();

            while (rs.next()) {
                LaptopInfo objlaptop = new LaptopInfo();
                objlaptop.setLaptop_id(Integer.parseInt(this.rs.getString("laptop_id")));
                objlaptop.setModel_no(this.rs.getString("model_no"));
                objlaptop.setHarddisk(this.rs.getString("harddisk"));
                objlaptop.setRam(this.rs.getString("ram"));
                objlaptop.setGraphics(this.rs.getString("graphics"));
                objlaptop.setGeneration(this.rs.getString("generation"));
                objlaptop.setProcessor(this.rs.getString("processor"));
                objlaptop.setPrice(this.rs.getDouble("price"));

                int lapId = this.rs.getInt("laptopbrand_id");
                LaptopBrandInfo objlaptopBrandInfo = supCtr.findLaptopBrandById(lapId);
                objlaptop.setLapBrandInfo(objlaptopBrandInfo);

                objlaptopInfo.add(objlaptop);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objlaptopInfo;
    }

    public ArrayList<LaptopInfo> listAllLatestLaptops() { // to list latest laptop information
        Database db = new Database();
        db.GetDbConnection();
        conn = Database.conn;

        ArrayList<LaptopInfo> objlaptopInfo = new ArrayList<LaptopInfo>();

        try {
            String query = "select * from tbl_laptop order by laptop_id desc limit 2";
            this.pstat = this.conn.prepareStatement(query);
            this.rs = this.pstat.executeQuery();

            while (rs.next()) {
                LaptopInfo objlaptop = new LaptopInfo();
                objlaptop.setLaptop_id(Integer.parseInt(this.rs.getString("laptop_id")));
                objlaptop.setModel_no(this.rs.getString("model_no"));
                objlaptop.setHarddisk(this.rs.getString("harddisk"));
                objlaptop.setRam(this.rs.getString("ram"));
                objlaptop.setGraphics(this.rs.getString("graphics"));
                objlaptop.setGeneration(this.rs.getString("generation"));
                objlaptop.setProcessor(this.rs.getString("processor"));
                objlaptop.setPrice(this.rs.getDouble("price"));

                int lapId = this.rs.getInt("laptopbrand_id");
                LaptopBrandInfo objlaptopBrandInfo = supCtr.findLaptopBrandById(lapId);
                objlaptop.setLapBrandInfo(objlaptopBrandInfo);

                objlaptopInfo.add(objlaptop);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objlaptopInfo;
    }


    public boolean UpdateLaptop(LaptopInfo lapInfo) { // to update laptop information

        boolean res = false;
        try {
            GetDbConnection();
            String sql = "update tbl_laptop set model_no=?, harddisk=?, ram=?, graphics=?, generation=?, processor=?, price=?, laptopbrand_id=? where laptop_id=?";
            pstat = this.conn.prepareStatement(sql);
            pstat.setString(1, lapInfo.getModel_no());
            pstat.setString(2, lapInfo.getHarddisk());
            pstat.setString(3, lapInfo.getRam());
            pstat.setString(4, lapInfo.getGraphics());
            pstat.setString(5, lapInfo.getGeneration());
            pstat.setString(6, lapInfo.getProcessor());
            pstat.setDouble(7, lapInfo.getPrice());
            pstat.setInt(8, lapInfo.getLapBrandInfo().getLaptopbrand_id());
            pstat.setInt(9, lapInfo.getLaptop_id());

            pstat.executeUpdate();
            res = true;
        } catch (Exception ex) {
            res = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (res);
    }

    public boolean deleteLaptop(LaptopInfo laptop) { // to delete laptop information

        boolean res = false;

        String sql = "delete from tbl_laptop where laptop_id = ?";
        try {
            GetDbConnection();
            pstat = this.conn.prepareStatement(sql);
            pstat.setInt(1, laptop.getLaptop_id());

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
