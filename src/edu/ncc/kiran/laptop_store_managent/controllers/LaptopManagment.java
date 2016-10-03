/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;
import edu.ncc.kiran.laptop_store_managent.models.LaptopInfo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kiran
 */
public class LaptopManagment extends Database {

//    public boolean CreateNewLaptopBrand(LaptopBrandInfo objLapBrand) {
//        String sql = "insert into tbl_laptopbrand (laptopbrand_id, brandname, user_id)"
//                + " values (null,?,?)";
//        boolean isLaptopBrandExist = false;
//        try {
//            pstat = conn.prepareStatement(sql);
//            pstat.setString(1, objLapBrand.getBrandname());
//            pstat.setInt(2, objLapBrand.getUserInfo().getUser_id());
//            pstat.executeUpdate();
//            pstat.close();
//            CloseDbConnection();
//            isLaptopBrandExist = true;
//        } catch (Exception ex) {
//            isLaptopBrandExist = false;
//            System.out.println("Error: " + ex.getMessage());
//        }
//        return (isLaptopBrandExist);
//    }

    public boolean addNewLaptop(LaptopInfo lapInfo) {
        boolean isLaptopExist = false;
        GetDbConnection();
        try {

            String sql = "insert into tbl_laptop (laptop_id, model_no, harddisk, ram, graphics, generation, "
                    + "processor, price, laptopbrand_id, user_id) "
                    + "values (null,?,?,?,?,?,?,?,?,?)";
            this.pstat = this.conn.prepareStatement(sql);
            this.pstat.setString(1, lapInfo.getModel_no());
            this.pstat.setString(2, lapInfo.getHarddisk());
            this.pstat.setString(3, lapInfo.getRam());
            this.pstat.setString(4, lapInfo.getGraphics());
            this.pstat.setString(5, lapInfo.getGeneration());
            this.pstat.setString(6, lapInfo.getProcessor());
            this.pstat.setDouble(7, lapInfo.getPrice());
            this.pstat.setInt(8, lapInfo.getLapBrandInfo().getLaptopbrand_id());
            this.pstat.setInt(9, lapInfo.getUserInfo().getUser_id());
//--            this.pstat.setInt(7, lapInfo.getLaptopbrand());

            int checkExist = this.pstat.executeUpdate();

            if (checkExist > 0) {
                isLaptopExist = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LaptopManagment.class.getName()).log(Level.SEVERE, null, ex);

        }

        return isLaptopExist;
    }
}
