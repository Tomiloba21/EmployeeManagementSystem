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

@WebServlet(value = "/deleteEmployeeById")
public class DeleteEmployee extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int deletedRow = 0;
        PrintWriter writer = resp.getWriter();
        String _id = req.getParameter("empID");
        employeeDAO = new EmployeeDAOImpl();

        try {
            deletedRow = employeeDAO.deleteEmployee(Integer.parseInt(_id));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (deletedRow > 0){
            writer.println("Record Deleted  for "+ _id);
            req.getRequestDispatcher("/employee.html").include(req,resp);
        }else {
            writer.println("Record Deletion Failed for " + _id);
            req.getRequestDispatcher("404.html").include(req,resp);
        }
        writer.close();

    }
}
