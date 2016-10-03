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
public class CustomerTransactionInfo {

    private int cusTransId;
    private CustomerInfo cusInfo;
    private LaptopInfo lapInfo;
    private String paid;
    private String due;
    private String total_cost;
    private Date date;
    private Time time;

    public int getCusTransId() {
        return cusTransId;
    }

    public void setCusTransId(int cusTransId) {
        this.cusTransId = cusTransId;
    }

    public CustomerInfo getCusInfo() {
        return cusInfo;
    }

    public void setCusInfo(CustomerInfo cusInfo) {
        this.cusInfo = cusInfo;
    }

    public LaptopInfo getLapInfo() {
        return lapInfo;
    }

    public void setLapInfo(LaptopInfo lapInfo) {
        this.lapInfo = lapInfo;
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
    
    
}
