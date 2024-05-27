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



@WebServlet(value = "/editEmployeeById")
public class EditEmployeeByIdController extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // The codes are on the .jsp file

        req.getRequestDispatcher("hiddenForm.jsp").include(req,resp);


        //hidden Form field, to edit the information of the employee

    }
}
