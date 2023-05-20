/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

/**
 *
 * @author Hạ Quang
 */
public class Error {
    int ID;
    String name;
    double fine;
    String note;

    public Error() {
        super();
    }

    public Error(int ID, String name, double fine, String note) {
        this.ID = ID;
        this.name = name;
        this.fine = fine;
        this.note = note;
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

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
