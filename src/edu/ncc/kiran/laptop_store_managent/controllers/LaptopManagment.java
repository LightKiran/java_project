/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.controllers;

import edu.ncc.kiran.laptop_store_managent.models.LaptopBrandInfo;

/**
 *
 * @author kiran
 */
public class LaptopManagment extends Database {

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
}
