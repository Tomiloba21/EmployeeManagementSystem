<%@ page import="com.tomiloba.dao.EmployeeDAO" %>
<%@ page import="com.tomiloba.daolmps.EmployeeDAOImpl" %>
<%@ page import="com.tomiloba.bean.Employee" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/27/2024
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<div class="drives">
  <div class="drive">
    <div class="-head">
      <h2 class="heading-title">
        LOGIN
      </h2>
    </div>

    <%
      EmployeeDAO employeeDAO = new EmployeeDAOImpl();
      Employee employee = new Employee();
      String _id = request.getParameter("empID");

      try {
        employee = employeeDAO.getEmployeeByID(Integer.parseInt(_id));
      } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
      }

      out.println("<form name='Hidden form' method='post' action='afterEditEmployeeByID'>");

      out.println("<label><input class='input-field'  type='hidden' name='empID' value ='"+_id+"' > </label>");


      out.println("<label><input class='input-field'  type='text' name='firstName' value ='"+employee.getFirstName()+"' > </label>");

       out.println("<br><br><label><input class='input-field' type='text' name='lastName' value ='"+employee.getLastName()+"' ></label><br><br>");

       out.println(" <label><input  class='input-field'  type='text' name='userName' value ='"+employee.getUsername()+"' ></label><br><br>");

       out.println("<label><input class='input-field'  type='password' name='password' value ='"+employee.getPassword()+"'></label><br><br>");

       out.println("<label>Country:<select name='country' class='input-field'><option value='Nigeria'>Nigeria</option><option value='Germany'>Germany</option><option value='India'>India</option><option value='France'>France</option><option value='Spain'>Spain</option><option value='other'>Other</option></select></label>");

       out.println("<br><br><div><input id='btn' type='submit' value='Edit & Submit'></div></form>");









    %>
    <br><br>

      <br><br>
      <div class="-heading">
          <a href="getAllEmployees" >view all employees</a>

      </div>



  </div>
</div>

  </body>
</html>
