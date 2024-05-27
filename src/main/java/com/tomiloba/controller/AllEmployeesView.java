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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/getAllEmployees")
public class AllEmployeesView extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        req.getRequestDispatcher("employees.jsp").include(req,resp);
    }
}
