/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.models;

/**
 *
 * @author Hạ Quang
 */
public class MotorBikeError {
    int ID;
    String note;
    Error error;

    public MotorBikeError() {
    }
    

    public MotorBikeError(int ID, String note, Error error) {
        this.ID = ID;
        this.note = note;
        this.error = error;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
    
}
