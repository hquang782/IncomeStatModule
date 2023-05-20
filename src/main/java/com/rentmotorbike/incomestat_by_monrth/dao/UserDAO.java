/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentmotorbike.incomestat_by_monrth.dao;

import com.rentmotorbike.incomestat_by_monrth.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Hạ Quang
 */
public class UserDAO extends DAO {
    public UserDAO() {
        super();
    }

    public boolean checkLogin(User user) {
        boolean result = false;
        String stmt = "SELECT ID, role FROM user WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(stmt);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setID(resultSet.getInt("ID"));
                user.setRole(resultSet.getString("role"));
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }
}
