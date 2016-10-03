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
public class LaptopInfo {

    private int laptop_id;
    private String model_no;
    private String harddisk;
    private String ram;
    private String graphics;
    private String generation;
    private String processor;
    private Double price;
    private LaptopBrandInfo lapBrandInfo;
    private UserInfo  userInfo;

    public int getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(int laptop_id) {
        this.laptop_id = laptop_id;
    }

    public String getModel_no() {
        return model_no;
    }

    public void setModel_no(String model_no) {
        this.model_no = model_no;
    }

    public String getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk = harddisk;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LaptopBrandInfo getLapBrandInfo() {
        return lapBrandInfo;
    }

    public void setLapBrandInfo(LaptopBrandInfo lapBrandInfo) {
        this.lapBrandInfo = lapBrandInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    

}
