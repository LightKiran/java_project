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
public class OrderInfo {

    private int order_id;

    private String pieces;
    private Date date;
    private Time time;
    private LaptopInfo lapInfo;
    private SupplierInfo supInfo;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
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

    public LaptopInfo getLapInfo() {
        return lapInfo;
    }

    public void setLapInfo(LaptopInfo lapInfo) {
        this.lapInfo = lapInfo;
    }

    public SupplierInfo getSupInfo() {
        return supInfo;
    }

    public void setSupInfo(SupplierInfo supInfo) {
        this.supInfo = supInfo;
    }

}
