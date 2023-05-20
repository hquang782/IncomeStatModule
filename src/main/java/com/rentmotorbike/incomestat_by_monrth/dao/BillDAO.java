/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.dao;

import com.rentmotorbike.incomestat_by_monrth.models.*;
import com.rentmotorbike.incomestat_by_monrth.models.Error;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Hạ Quang
 */
public class BillDAO extends DAO {
    public BillDAO() {
        super();
    }


    ArrayList<Error> errors = getError();
    ArrayList<CheckedError> checkedErrors = getCheckedError();

    ArrayList<Bill> bills = getBill();

    public ArrayList<Bill> getBillByMonth(String time) {
        ArrayList<Bill> result = new ArrayList<>();
        String stmt = "SELECT ID,paymentDay,rentingID FROM bill WHERE YEAR(paymentDay) =? AND MONTH(paymentDay) = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(stmt);
            ps.setString(1, time.substring(3));
            ps.setString(2, time.substring(0, 2));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill temp = new Bill();
                temp.setID(rs.getInt("ID"));
                temp.setPaymentDay(rs.getDate("paymentDay"));
                temp.setBooking(getRenting(rs.getInt("rentingID")));
                temp.setAmount(getRenting(rs.getInt("rentingID")).getTotal());
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Renting getRenting(int i) {
        Renting result = new Renting();
        String stmt = "SELECT ID,rentDay,clientID FROM renting WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, String.valueOf(i));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setID(rs.getInt("ID"));
                result.setRentDay(rs.getDate("rentDay"));
                result.setClient(getClient(rs.getInt("clientID")));
                result.setRentedmotorbikes(getRentedMotorBike(rs.getInt("ID")));
                result.setDeposits(getDeposit(rs.getInt("ID")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //    public ArrayList<Bill> getBillbyMonth(String time) {
//        ArrayList<Bill> result = new ArrayList<>();
//
//        String stmt = "SELECT bill.ID, client.fullname, rentedmotorbike.reveiveDay, rentedmotorbike.returnDay, rentedmotorbike.price " +
//                "FROM bill " +
//                "JOIN renting ON bill.rentingID = renting.ID " +
//                "JOIN rentedmotorbike ON renting.ID = rentedmotorbike.rentingID " +
//                "JOIN client ON renting.clientID = client.ID " +
//                "WHERE YEAR(returnDay) =? AND MONTH(returnDay) = ?";
//
//
//        try {
//            PreparedStatement ps = con.prepareStatement(stmt);
//            ps.setString(1, time.substring(3));
//            ps.setString(2, time.substring(0, 2));
//            ResultSet rs = ps.executeQuery();
////            int i = 0;
//            while (rs.next()) {
//                ArrayList<String> temp = new ArrayList<>();
//                temp.add(String.valueOf(rs.getInt("id")));
//                temp.add(rs.getString("fullname"));
//                temp.add(rs.getString("reveiveDay"));
//                temp.add(rs.getString("returnDay"));
//                temp.add(String.valueOf(rs.getFloat("price")));
//                temp.add(String.valueOf(deposit.get(rs.getInt("id") - 1).getValue()));
//                temp.add(String.valueOf((rentedMotorBikes.get(rs.getInt("id") - 1).getTotal() - deposit.get(rs.getInt("id") - 1).getValue())));
//                temp.add(String.valueOf(rentedMotorBikes.get(rs.getInt("id") - 1).getTotal()));
//
//                result.add(temp);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//
//    }
    public Client getClient(int i) {
        Client result = new Client();
        String stmt = "SELECT fullname FROM client WHERE ID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, String.valueOf(i));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setFullname(rs.getString("fullname"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<Deposit> getDeposit(int i) {
        ArrayList<Deposit> result = new ArrayList<>();
        String stmt = "SELECT * FROM deposit where rentingID = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(stmt);
            ps.setString(1, String.valueOf(i));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Deposit temp = new Deposit();
                temp.setID(rs.getInt("ID"));
                temp.setValue(rs.getFloat("value"));
                temp.setNote(rs.getString("note"));
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<RentedMotorBike> getRentedMotorBike(int i) {
        ArrayList<RentedMotorBike> result = new ArrayList<>();
        String stmt = "SELECT id,price,receiveDay,returnDay,saleOff,motorbikeID FROM rentedmotorbike WHERE rentingID =?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(stmt);
            ps.setString(1, String.valueOf(i));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RentedMotorBike temp = new RentedMotorBike();
                temp.setID(rs.getInt("ID"));
                temp.setPrice(rs.getFloat("price"));
                temp.setReceiveDay(rs.getDate("receiveDay"));
                temp.setReturnDay(rs.getDate("returnDay"));
                temp.setSaleOff(rs.getFloat("saleOff"));
                temp.setCheckederror(getDetailError(rs.getInt("ID")));
                temp.setMotorbike(getMotorBike(rs.getInt("motorbikeID")));
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<CheckedError> getDetailError(int i) {
        ArrayList<CheckedError> checkedErrordetail = new ArrayList<>();
        String stmt = "SELECT ID,note,errorID FROM checkederror where rentedmotorbikeID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(stmt);
            ps.setString(1, String.valueOf(i));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CheckedError temp = new CheckedError();
                temp.setID(rs.getInt("ID"));
                temp.setNote(rs.getString("note"));
                temp.setError(errors.get(rs.getInt("errorID") - 1));

                checkedErrordetail.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return checkedErrordetail;
    }

    public ArrayList<Bill> getBill() {
        ArrayList<Bill> result = new ArrayList<>();
        String stmt = "SELECT id,paymentDay,paymentType,amount FROM bill";
        try {

            PreparedStatement ps = con.prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bill temp = new Bill();
                temp.setID(rs.getInt("ID"));
                temp.setPaymentDay(rs.getDate("paymentDay"));
                temp.setPaymentType(rs.getString("paymentType"));
                temp.setAmount(rs.getFloat("amount"));
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<Error> getError() {
        ArrayList<Error> result = new ArrayList<>();
        String stmt = "SELECT * FROM error";

        try {

            PreparedStatement ps = con.prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Error temp = new Error();
                temp.setID(rs.getInt("ID"));
                temp.setName(rs.getString("name"));
                temp.setFine(rs.getDouble("fine"));
                temp.setNote(rs.getString("note"));
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ArrayList<CheckedError> getCheckedError() {
        ArrayList<CheckedError> result = new ArrayList<>();
        String stmt = "SELECT * FROM checkederror";

        try {

            PreparedStatement ps = con.prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CheckedError temp = new CheckedError();
                temp.setID(rs.getInt("ID"));
                temp.setNote(rs.getString("note"));
                temp.setError(errors.get(rs.getInt("errorID") - 1));
                temp.setTotal(errors.get(rs.getInt("errorID") - 1).getFine());
                result.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public MotorBike getMotorBike(int i) {
        MotorBike temp = new MotorBike();
        String stmt = "SELECT * FROM motorbike WHERE ID = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(stmt);
            ps.setString(1, String.valueOf(i));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                temp.setID(rs.getInt("ID"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("type"));
                temp.setNumberplate(rs.getString("numberplate"));
                temp.setCompany(rs.getString("company"));
                temp.setPrice(rs.getFloat("price"));
                temp.setDes(rs.getString("des"));
                temp.setMotorbikeValue(rs.getFloat("motorbikeValue"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
}
