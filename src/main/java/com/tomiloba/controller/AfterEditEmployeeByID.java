package com.tomiloba.controller;

import com.tomiloba.bean.Employee;
import com.tomiloba.dao.EmployeeDAO;
import com.tomiloba.daolmps.EmployeeDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/afterEditEmployeeByID")
public class AfterEditEmployeeByID extends HttpServlet {
    private EmployeeDAO employeeDAO;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int status = 0;

        //get User Data

        String _id = req.getParameter("empID");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String country = req.getParameter("country");

        Employee employee = new Employee(firstName,lastName,userName,password,country);
        employee.setEmpID(Integer.parseInt(_id));
        employeeDAO = new EmployeeDAOImpl();

        try {
            status =  employeeDAO.updateEmployee(employee);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (status > 0){
            writer.println("Record Updated Succesfully for "+ employee.getEmpID());
            req.getRequestDispatcher("/employee.html").include(req,resp);
        }else {
            writer.println("Record Adaptation Failed for " + employee.getEmpID());
            req.getRequestDispatcher("404.html").include(req,resp);
        }
        writer.close();
    }
}
