/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.models;

/**
 *
 * @author kiran
 */
public class LaptopBrandInfo {
    private int laptopbrand_id;
    private String brandname;
    private UserInfo userInfo;

    public int getLaptopbrand_id() {
        return laptopbrand_id;
    }

    public void setLaptopbrand_id(int laptopbrand_id) {
        this.laptopbrand_id = laptopbrand_id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    
    
}
