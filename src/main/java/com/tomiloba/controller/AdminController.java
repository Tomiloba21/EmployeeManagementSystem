package com.tomiloba.controller;

import com.tomiloba.bean.Admin;
import com.tomiloba.dao.AdminDAO;
import com.tomiloba.daolmps.AdminDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/admin" )
public class AdminController extends HttpServlet {
    private AdminDAO adminDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        adminDAO = new AdminDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");



        int emID = Integer.parseInt(req.getParameter("EmployeeID"));
        String pswrd = req.getParameter("password");



        Admin admin = new Admin(emID,pswrd);


        boolean status = false;
        try {
            status = adminDAO.validate(admin);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (status){
            req.getRequestDispatcher("employee.html").include(req,resp);

        }else {
            req.getRequestDispatcher("404.html").include(req,resp);
        }
    }

}

//@WebServlet(value = "/adminPage")
//class  Admins extends HttpServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("admin.html").include(req,resp);
//    }
//}
//
//@WebServlet(value = "/employee")
//class Employee extends HttpServlet{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("employee.html").include(req,resp);
//    }
//}