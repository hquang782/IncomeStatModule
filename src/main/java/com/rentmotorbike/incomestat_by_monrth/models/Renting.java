/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

import java.util.*;
import java.util.Date;

/**
 *
 * @author Hạ Quang
 */
public class Renting {

    int ID;
    Date rentDay;
    String note;
    User user;
    float total,intoMoney;
    Client client;
    ArrayList<RentedMotorBike> rentedmotorbikes;
    ArrayList<Deposit> deposits;
    ArrayList<Insurance> insurances;

    public Renting() {
        rentedmotorbikes = new ArrayList<>();
        deposits = new ArrayList<>();
        insurances = new ArrayList<>();

    }

    public Renting(int ID, Date rentDay, String note, User user, Client client, ArrayList<RentedMotorBike> rentedmotorbikes, ArrayList<Deposit> deposits, ArrayList<Insurance> insurances) {
        this.ID = ID;
        this.rentDay = rentDay;
        this.note = note;
        this.user = user;
        this.client = client;
        this.rentedmotorbikes = rentedmotorbikes;
        this.deposits = deposits;
        this.insurances = insurances;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getRentDay() {
        return rentDay;
    }

    public void setRentDay(Date rentDay) {
        this.rentDay = rentDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getTotal() {

        return total;
    }

    public void setTotal(float total) {
        
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<RentedMotorBike> getRentedmotorbikes() {
        return rentedmotorbikes;
    }

    public void setRentedmotorbikes(ArrayList<RentedMotorBike> rentedmotorbikes) {
        this.rentedmotorbikes = rentedmotorbikes;
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public float getIntoMoney() {
        updateTotal();
        intoMoney = total;
        for (Deposit de : deposits) {
            intoMoney -= de.getValue();
        }
        return intoMoney;
    }

    public void setIntoMoney(float intoMoney) {
        this.intoMoney = intoMoney;
    }

    private void updateTotal() {
        if (rentedmotorbikes != null) {
            for (RentedMotorBike rb : rentedmotorbikes) {
                total += rb.getTotal();
            }
        }
    }
}
