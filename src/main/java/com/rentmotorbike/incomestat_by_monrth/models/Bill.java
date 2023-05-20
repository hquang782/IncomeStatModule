/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

import java.util.Date;

/**
 *
 * @author Hạ Quang
 */
public class Bill {

    int ID;
    Date paymentDay;
    String paymentType;
    float Amount;
    private User creator;
    private Renting booking;
    String period;

    public Bill() {
    }

    public Bill(int ID, Date paymentDay, String paymentType, float Amount, User creator, Renting booking) {
        this.ID = ID;
        this.paymentDay = paymentDay;
        this.paymentType = paymentType;
        this.Amount = Amount;
        this.creator = creator;
        this.booking = booking;
        this.period = paymentDay.toString().substring(5);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Date paymentDay) {
        this.paymentDay = paymentDay;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Renting getBooking() {
        return booking;
    }

    public void setBooking(Renting booking) {
        this.booking = booking;
    }

    
}
