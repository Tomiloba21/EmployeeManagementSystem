package com.tomiloba.servlet;


import com.tomiloba.bean.Admin;
import com.tomiloba.dao.AdminAuthentication;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;

@WebServlet(value = "/loginAdmin")
public class AdminServlet extends HttpServlet  {
    RequestDispatcher requestDispatcher;
    AdminAuthentication adminAuthentication;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String adminID =(String) req.getParameter("EmployeeID");
        String pswrd = req.getParameter("password");

        Admin admin = new Admin(adminID,pswrd);

        adminAuthentication = new AdminAuthentication();


        try {
            boolean status = adminAuthentication.validate(admin);
            System.out.println(status);
            if (status){

                requestDispatcher  = req.getRequestDispatcher("views/employee.html");
                requestDispatcher.forward(req,resp);
            }else {
                requestDispatcher  = req.getRequestDispatcher("views/404.html");
                requestDispatcher.forward(req,resp);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String encrypt(String s){
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    private static String decode(String s){
        byte[] decodeBytes = Base64.getDecoder().decode(s);
        return  new String(decodeBytes);
    }
}
