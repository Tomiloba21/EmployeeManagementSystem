package com.tomiloba.daolmps;

import com.tomiloba.bean.Admin;
import com.tomiloba.dao.AdminDAO;
import com.tomiloba.utility.JDBCConnectionUtility;

import java.sql.*;

public class AdminDAOImpl implements AdminDAO {


    private static final String  SELECT_QUERY = "select *from lobzter.administration where adminID = ? and password = ?";

    @Override
    public boolean validate(Admin admin) throws SQLException, ClassNotFoundException {
         boolean status = false;

        //JDBC CODE

        Connection connection = JDBCConnectionUtility.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
        preparedStatement.setInt(1,admin.getEmployeeID());
        preparedStatement.setString(2, admin.getPassword());

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()){
            int id = rs.getInt(1);
            String password = rs.getString(2);
            if (admin.getEmployeeID() == id && admin.getPassword().equals(password)){
                status = true;
            }
        }


        return status;
    }
}
