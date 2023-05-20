/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.dao;

/**
 *
 * @author Hạ Quang
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    public static Connection con;

    public DAO() {
        if (con == null) {
            String dbUrl = "jdbc:mysql://localhost:3306/incomestat";
            String dbClass = "com.mysql.cj.jdbc.Driver";

            try {
                Class.forName(dbClass);
                con = DriverManager.getConnection(dbUrl, "root", "");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("e");
            }
        }
    }
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        System.out.println(con);
//    }
}
