
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.lang.Object"%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> HELLO At Customer Home Page</h1>

  
        <%
            
            try{  
                Integer customer_id = Integer.parseInt(request.getParameter("customer_id"));
Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/bank_management_system?zeroDateTimeBehavior=convertToNull";
Connection   con = DriverManager.getConnection(url, "root", "");  
PreparedStatement stmt=con.prepareStatement("SELECT * FROM customer WHERE customer.customer_id = ?");  
stmt.setInt(1,customer_id);//1 specifies the first parameter in the query  

 try {
      ResultSet rs = stmt.executeQuery();
    while ( rs.next() )
    {
     out.print(rs.getInt("customer_id"));
     out.print(rs.getString("customer_name"));
     out.print(rs.getString("customer_address"));
     out.print(rs.getString("customer_phone"));
    }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 
     HttpSession session = request.getSession(true);
     

}catch(Exception e){ 
  out.print("Heloooooo");

}  

  

        
        
        %>
        
        
    </body>
</html>
