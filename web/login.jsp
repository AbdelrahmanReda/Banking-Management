<%-- 
    Document   : login
    Created on : Dec 27, 2020, 7:50:44 PM
    Author     : boody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet" href="style2.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row" >
                <div class="col-lg-12 " style="padding-top: 225px">
                    <form  class="login-form" method="POST" action="ValidateController" >
                        <h1 class="text-center" >Welcome To </h1>
                        <h4 class="text-center">Online Banking System</h4>
                        <%
                            if (session.getAttribute("wrong_logging") != null) {
                               out.print( "<div class=\"alert alert-danger\"><strong > Error!</strong > Wrong Loging Data, please try again.</div> ");         
                              }
                            session.removeAttribute("wrong_logging");
                            
                           
                            if (session.getAttribute("customer_id")!=null) {
                                    response.sendRedirect("customerhome.jsp");
                                }
                            
                            
                        %>

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
                </div>
            </div>
        </div>
    </body>
</html>
