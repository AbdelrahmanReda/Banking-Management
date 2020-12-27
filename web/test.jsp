<%-- 
    Document   : test
    Created on : Dec 27, 2020, 8:02:01 PM
    Author     : boody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form  class="login-form" method="POST" action="test" >
                        <h1 class="text-center" >Welcome To </h1>
                        <h4 class="text-center">Online Banking System</h4>
                        <div class="mb-3">
                            <label for="customer_id" class="form-label">Customer Id</label>
                            <input type="number" class="form-control" id="customer_id" name="customer_id">
                             <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                        <div class="mb-3">
                            <label for="customer_password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="customer_password" name="customer_password">
                        </div>
                        <button style="width: 100%" type="submit" class="btn btn-primary">sign in</button>  
                    </form>    
    </body>
</html>
