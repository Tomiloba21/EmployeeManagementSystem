package com.tomiloba.daolmps;

import com.tomiloba.bean.Employee;
import com.tomiloba.dao.EmployeeDAO;
import com.tomiloba.utility.JDBCConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String SAVE_EMPLOYEE = "INSERT INTO lobzter.Employees (FirstName, LastName, username, PasswordHash, country)VALUES (?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE lobzter.Employees set FirstName =?, LastName = ?, username = ?, PasswordHash = ?, country=? WHERE employeeID = ?";
    private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM lobzter.Employees where employeeID = ?";
    private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM lobzter.Employees WHERE employeeID = ?";
    private static final String GET_ALL_EMPLOYEES = "SELECT * FROM lobzter.Employees";

    @Override
    public int saveEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int status = 0;

        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(SAVE_EMPLOYEE);
        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getUsername());
        ps.setString(4, employee.getPassword());
        ps.setString(5, employee.getCountry());


        status = ps.executeUpdate();

        JDBCConnectionUtility.cleanUP(ps,con);
        return status;

    }

    @Override
    public int updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        int status = 0;
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(UPDATE_EMPLOYEE_BY_ID);

        ps.setString(1, employee.getFirstName());
        ps.setString(2, employee.getLastName());
        ps.setString(3, employee.getUsername());
        ps.setString(4, employee.getPassword());
        ps.setString(5, employee.getCountry());
        ps.setInt(6,employee.getEmpID());


        status = ps.executeUpdate();

        JDBCConnectionUtility.cleanUP(ps,con);
        return status;

    }

    @Override
    public int deleteEmployee(int empID) throws SQLException, ClassNotFoundException {
        int status = 0;

        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEE_BY_ID);

        ps.setInt(1,empID );


        status = ps.executeUpdate();
        JDBCConnectionUtility.cleanUP(ps,con);
        return status;
    }

    @Override
    public Employee getEmployeeByID(int empID) throws SQLException, ClassNotFoundException {
        int status = 0;

        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_BY_ID);
        ps.setInt(1,empID);
        ResultSet rs = ps.executeQuery();
        Employee emp = new Employee();
        while (rs.next()){

            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setUsername(rs.getString(4));
            emp.setPassword(rs.getString(5));
            emp.setCountry(rs.getString(6));


        }
        JDBCConnectionUtility.cleanUP(rs,ps,con);

        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employee> employeeList = new ArrayList<>();

        int status = 0;

        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_ALL_EMPLOYEES);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            Employee emp = new Employee();
            emp.setEmpID(rs.getInt(1));
            emp.setFirstName(rs.getString(2));
            emp.setLastName(rs.getString(3));
            emp.setUsername(rs.getString(4));
            emp.setPassword(rs.getString(5));
            emp.setCountry(rs.getString(6));
            employeeList.add(emp);


        }
        JDBCConnectionUtility.cleanUP(rs,ps,con);

        return employeeList;
    }
}
