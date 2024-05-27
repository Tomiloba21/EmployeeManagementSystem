package com.tomiloba.dao;


import com.tomiloba.bean.Employee;

import java.sql.SQLException;
import java.util.List;

/*
This DAO will provide all the CRUD operation
* ***/
public interface EmployeeDAO {
    public int saveEmployee(Employee employee) throws SQLException, ClassNotFoundException;

    public int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException;
    public int deleteEmployee(int empID) throws SQLException, ClassNotFoundException;
    public Employee getEmployeeByID(int empID) throws SQLException, ClassNotFoundException;

    public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException;

}
