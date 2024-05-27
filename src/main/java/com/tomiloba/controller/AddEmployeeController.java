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

@WebServlet(value = "/addEmployee")
public class AddEmployeeController extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int result = 0;

        //get User Data

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String country = req.getParameter("country");

        Employee employee = new Employee(firstName,lastName,userName,password,country);
        employeeDAO = new EmployeeDAOImpl();

        try {
           result =  employeeDAO.saveEmployee(employee);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (result > 0){
            writer.println("Employee Added Succesfully");
            req.getRequestDispatcher("employee.html").include(req,resp);
        }else {
            req.getRequestDispatcher("404.html").include(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee.html").include(req,resp);
    }
}
