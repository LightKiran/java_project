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
public class CustomerInfo {

    private int customer_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String contact_no;
    private String address;
    private String email;
    private LaptopInfo lapInfo;

    public CustomerInfo(int customer_id, String first_name, String middle_name,
            String last_name, String contact_no, String address, String email, UserInfo userInfo) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.address = address;
        this.email = email;
        this.lapInfo = lapInfo;
    }

    public CustomerInfo() {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.address = address;
        this.email = email;
        this.lapInfo = lapInfo;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LaptopInfo getLapInfo() {
        return lapInfo;
    }

    public void setLapInfo(LaptopInfo lapInfo) {
        this.lapInfo = lapInfo;
    }

    
}
