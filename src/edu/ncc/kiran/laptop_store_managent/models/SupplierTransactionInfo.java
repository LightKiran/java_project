/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncc.kiran.laptop_store_managent.models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author kiran
 */
public class SupplierTransactionInfo extends SupplierInfo {

    private int supTransId;  
    private String paid;
    private String due;
    private String total_cost;
    private Date date;
    private Time time;
    private SupplierInfo supInfo;
    private LaptopInfo laptopInfo;
    private OrderInfo orderInfo;

    public int getSupTransId() {
        return supTransId;
    }

    public void setSupTransId(int supTransId) {
        this.supTransId = supTransId;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(String total_cost) {
        this.total_cost = total_cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    public SupplierInfo getSupInfo() {
        return supInfo;
    }

    public void setSupInfo(SupplierInfo supInfo) {
        this.supInfo = supInfo;
    }

    public LaptopInfo getLaptopInfo() {
        return laptopInfo;
    }

    public void setLaptopInfo(LaptopInfo laptopInfo) {
        this.laptopInfo = laptopInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

}
