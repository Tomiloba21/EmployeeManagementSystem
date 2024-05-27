package com.tomiloba.utility;

import java.sql.*;

public class JDBCConnectionUtility {
    private static final String URL = "jdbc:mysql://localhost:3306/lobzter";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Java2023!";

//    jdbc:mysql://localhost:3306/?user=root


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection(URL,USER_NAME,PASSWORD);

        return conn;

    }

    //cleanUP

    public static void cleanUP(ResultSet rs, PreparedStatement ps,Connection conn) throws SQLException {
        if (rs!=null){
            rs.close();
        }

        if (ps!=null){
            ps.close();
        }
        if (conn!=null){
            conn.close();
        }
    }

    public static void cleanUP( PreparedStatement ps,Connection conn) throws SQLException {

        if (ps!=null){
            ps.close();
        }
        if (conn!=null){
            conn.close();
        }
    }








}
