/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

/**
 *
 * @author Hạ Quang
 */
public class MotorBike {
    int ID;
    String name, type,numberplate,company,des;

    float price,motorbikeValue;

    public MotorBike(int ID, String name, String type, String numberplate, String company, float price, String des,float motorbikeValue) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.numberplate = numberplate;
        this.company = company;
        this.price = price;
        this.des = des;
        this.motorbikeValue = motorbikeValue;
    }

    public float getMotorbikeValue() {
        return motorbikeValue;
    }

    public void setMotorbikeValue(float motorbikeValue) {
        this.motorbikeValue = motorbikeValue;
    }

    public MotorBike() {
        super();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
}
