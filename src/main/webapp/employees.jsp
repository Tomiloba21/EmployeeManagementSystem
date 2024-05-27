<%@ page import="java.util.List" %>
<%@ page import="com.tomiloba.bean.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tomiloba.daolmps.EmployeeDAOImpl" %>
<%@ page import="com.tomiloba.dao.EmployeeDAO" %>
<%@ page import="java.sql.SQLException" %>

<%--
  Created by IntelliJ IDEA.
  User: Tomiloba Olowo
  Date: 5/22/2024
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
    .btn {
        padding: 5px 10px;
        text-align: center;
        cursor: pointer;
    }
    .btn-edit {
        background-color: #4CAF50;
        color: white;
    }
    .btn-delete {
        background-color: #f44336;
        color: white;
    }
</style>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>EmployeeID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Username</th>
        <th>Password</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>

    <%

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = new ArrayList<>();


        try {
            employees = employeeDAO.getAllEmployees();
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        for (Employee emp : employees){


            out.println(" <tr>" +
                    "<td>"+emp.getEmpID()+"</td>" +
                    "<td>"+emp.getFirstName()+"</td>" +
                    "<td>"+emp.getLastName()+"</td>" +
                    " <td>"+emp.getUsername()+"</td>" +
                    "<td>"+emp.getPassword()+"</td>" +
                    "<td>"+emp.getCountry()+"</td>" +
                    "<td><a  class=\"btn btn-edit\" href='editEmployeeById?empID="+emp.getEmpID()+"'>Edit</a></td>" +
                    "<td><a class=\"btn btn-delete\" href='deleteEmployeeById?empID="+emp.getEmpID()+"'>Delete</a></td>" +
                    " </tr>");
        }
    %>


    </tbody>
</table>
<br><br>


<div class="-heading">
    <a href="addEmployee" >add Employees</a>

</div>

</body>
</html>
