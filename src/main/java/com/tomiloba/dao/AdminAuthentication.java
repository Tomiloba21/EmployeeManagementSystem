package com.tomiloba.dao;

import com.tomiloba.bean.Admin;

import java.sql.*;

public class AdminAuthentication {
    public boolean status = false;

    public String sqlStatement = "select *from lobzter.admins where EmployeeID = ? and PasswordHash = ?";

    public boolean validate(Admin admin) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lobzter","root","Java2023!");
            PreparedStatement preparedStatement = con.prepareStatement(sqlStatement)){

            preparedStatement.setString(1, admin.getEmployeeID());
            preparedStatement.setString(2,admin.getPassword());

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return status;
    }
}
