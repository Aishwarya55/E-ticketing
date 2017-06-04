<%-- 
    Document   : moviedetails.jsp
    Created on : 1 May, 2015, 8:44:27 AM
    Author     : Aishwarya Kannan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <TABLE style="position:absolute;top:5px;height:67%; width:98%" BORDER="1">
            <TR>
               
               <TH>date</TH>
               <TH>timing</TH>
               <TH>Seats</TH>
               
           </TR>
         <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ticketing", "root", "admin");

            Statement statement = connection.createStatement();

            String id = request.getParameter("id");  

            ResultSet resultset = 
                statement.executeQuery("select * from showdetails where moviename = 'avengers'") ; 
    while(resultset.next())
    {
        %>

      
           <TR>
               
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
               <TD> <%= resultset.getString(4) %> </TD>
              
           </TR>
       
       <BR>
       <% 
           } 
    
       %>
        
        </TABLE><br>
        
    </body>
</html>
