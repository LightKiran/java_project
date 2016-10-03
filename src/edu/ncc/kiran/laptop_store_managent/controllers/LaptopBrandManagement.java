/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import static edu.ncc.kiran.laptop_store_managent.controllers.Database.conn;
import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class LaptopBrandManagement extends Database {

    public boolean CreateNewLaptopBrand(LaptopBrandInfo objLapBrand) {
        String sql = "insert into tbl_laptopbrand (laptopbrand_id, brandname, user_id)"
                + " values (null,?,?)";
        boolean isLaptopBrandExist = false;
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, objLapBrand.getBrandname());
            pstat.setInt(2, objLapBrand.getUserInfo().getUser_id());
            pstat.executeUpdate();
            pstat.close();
            CloseDbConnection();
            isLaptopBrandExist = true;
        } catch (Exception ex) {
            isLaptopBrandExist = false;
            System.out.println("Error: " + ex.getMessage());
        }
        return (isLaptopBrandExist);
    }

    public LaptopBrandInfo searchLaptopBrandById(int id) {
        LaptopBrandInfo lapbrand = null;
        try {
            String query = "SELECT * FROM tbl_laptopbrand WHERE laptopbrand_id = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setInt(1, id);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                lapbrand = new LaptopBrandInfo();
                lapbrand.setLaptopbrand_id(this.rs.getInt("laptopbrand_id"));
                lapbrand.setBrandname(this.rs.getString("brandname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaptopBrandManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.rs.close();
                this.pstat.close();
            } catch (SQLException ex) {
                Logger.getLogger(LaptopBrandManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lapbrand;
    }

    public LaptopBrandInfo searchLaptopBrandByName(String name) {
        LaptopBrandInfo lapbrand = null;
        try {
            String query = "SELECT * FROM tbl_laptopbrand WHERE brandname = ?";
            this.pstat = this.conn.prepareStatement(query);
            this.pstat.setString(1, name);
            this.rs = this.pstat.executeQuery();
            while (this.rs.next()) {
                lapbrand = new LaptopBrandInfo();
                lapbrand.setLaptopbrand_id(this.rs.getInt("laptopbrand_id"));
                lapbrand.setBrandname(this.rs.getString("brandname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaptopBrandManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.rs.close();
                this.pstat.close();
            } catch (SQLException ex) {
                Logger.getLogger(LaptopBrandManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lapbrand;
    }
}
