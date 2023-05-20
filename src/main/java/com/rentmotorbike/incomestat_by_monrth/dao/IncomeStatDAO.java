/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.dao;


import com.google.protobuf.StringValue;
import com.rentmotorbike.incomestat_by_monrth.models.IncomeStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Hạ Quang
 */
public class IncomeStatDAO extends DAO {
    public IncomeStatDAO() {
        super();
    }

    public ArrayList<IncomeStat > getIncomeStat() {
        ArrayList<IncomeStat> result = new ArrayList<>();//in ra bảng
        ArrayList<String> period = getPeriod();//từng tháng
        String stmt = "SELECT SUM(amount) AS SUMAMOUNT FROM bill where YEAR(paymentDay) = ? AND MONTH(paymentDay) = ?";
        for (int i = 0; i < period.size(); i++) {
            IncomeStat temp = new IncomeStat();
            try {
                PreparedStatement ps = con.prepareStatement(stmt);
                ps.setString(1, period.get(i).substring(3));
                ps.setString(2, period.get(i).substring(0, 2));
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    temp.setPeriod(period.get(i));
                    System.out.println(period.get(i));
                    temp.setRevenue(Float.parseFloat(rs.getString("SUMAMOUNT")));
                    System.out.println(Float.parseFloat(rs.getString("SUMAMOUNT")));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            result.add(temp);
        }
        return result;
    }

    public ArrayList<String> getPeriod() {
        ArrayList<String> result = new ArrayList<>();
        String stmt = "SELECT DISTINCT CONCAT(LPAD(MONTH(paymentDay),2,'0'), '/', YEAR(paymentDay)) AS MonthYear FROM bill";
        try {
            PreparedStatement ps = con.prepareStatement(stmt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("MonthYear"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public ArrayList<String> getPeriods(){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String s="";
            if(i<10) s= "0"+ i+"/2022";
            else s = i+"/2022";
            result.add(s);
        }
        return result;
    }
}
