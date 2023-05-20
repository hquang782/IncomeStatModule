/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 *
 * @author Hạ Quang
 */
public class RentedMotorBike {

    int ID;
    float price;
    Date receiveDay;
    Date returnDay;
    float saleOff;
    float total;
    boolean isTaken;
    private MotorBike motorbike;
    private ArrayList<CheckedError> checkederror;

    public RentedMotorBike(int ID, float price, Date receiveDay, Date returnDay, float saleOff, boolean isTaken) {
        this.ID = ID;
        this.price = price;
        this.receiveDay = receiveDay;
        this.returnDay = returnDay;
        this.saleOff = saleOff;
        this.isTaken = isTaken;
        this.motorbike = new MotorBike();
        checkederror = new ArrayList<>();
    }

    public RentedMotorBike() {
        checkederror = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getReceiveDay() {
        return receiveDay;
    }

    public void setReceiveDay(Date receiveDay) {
        this.receiveDay = receiveDay;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }

    public double getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(float saleOff) {
        this.saleOff = saleOff;
    }

    public boolean isIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public MotorBike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(MotorBike motorbike) {
        this.motorbike = motorbike;
    }

    public ArrayList<CheckedError> getCheckederror() {
        return checkederror;
    }

    public void setCheckederror(ArrayList<CheckedError> checkederror) {
        this.checkederror = checkederror;
    }

    public double getTotal() {
        updateTotal();
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    private void updateTotal() {
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDate date1 = LocalDate.parse(receiveDay.toString(), dtf);
        LocalDate date2 = LocalDate.parse(returnDay.toString(), dtf);
        total = ChronoUnit.DAYS.between(date1, date2) * price*(1-saleOff);
//        System.out.println(ChronoUnit.DAYS.between(date1, date2) );
        if (checkederror != null) {
//            System.out.println("abcxyx");
            for (CheckedError ce : checkederror) {
                total += (ce.getTotal()+motorbike.getMotorbikeValue()/10);
                System.out.println(ce.getTotal());
            }
        }
    }
}
