package com.tomiloba.bean;

import java.io.Serializable;

public class Admin implements Serializable {


    private int employeeID;

    private String password;

    public Admin(){}



    public Admin(int employeeID, String password){
        this.employeeID= employeeID;
        this.password = password;

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
