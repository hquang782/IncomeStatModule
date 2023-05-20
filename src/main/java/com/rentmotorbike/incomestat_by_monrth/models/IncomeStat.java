/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

/**
 * @author Hạ Quang
 */
public class IncomeStat {
    String period;
    float revenue;
    Client client;

    public IncomeStat() {
    }

    public IncomeStat(String period, float revenue, Client client) {
        this.period = period;
        this.revenue = revenue;
        this.client = client;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getRevenue() {

        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public Client getClientID() {
        return client;
    }

    public void setClientID(Client client) {
        this.client = client;
    }


}
