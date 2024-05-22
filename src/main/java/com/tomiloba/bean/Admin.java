package com.tomiloba.bean;

import java.io.Serializable;

public class Admin implements Serializable {

    private String adminID;
    private String employeeID;
    private String username;
    private String password;
    private String email;

    public Admin(String employeeID, String password){
        this.employeeID= employeeID;
        this.password = password;

    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
