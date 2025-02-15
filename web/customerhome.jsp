<%-- 
    Document   : customer_home
    Created on : Dec 25, 2020, 10:54:56 PM
    Author     : boody
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="Models.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>



    <%@include file="layout/header.jsp" %> 
    

 

    <body>
        <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@ include file = "layout\sidebar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@ include file = "layout\navbar.jsp" %>


                <%@ include file = "layout\warning_msg.jsp" %>

                <%

                    if (session.getAttribute("customer_id") == null) {
                        response.sendRedirect("login.jsp");
                    }

                %>

                <div class="card">
                    <div class="card-header" >
                        Personal Information
                    </div>
                    <div class="card-body" >
                        <div class="row" >
                            <div class="col-lg-12" >
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>Full Name</th>
                                            <td>    <%  out.print(request.getSession().getAttribute("customer_name")); %> </td>  
                                        </tr>
                                        <tr>
                                            <th>Personal Phone</th>                    
                                            <td>   <%  out.print(request.getAttribute("customer_phone")); %></td>                                          
                                        </tr>
                                        <tr>
                                            <th>Address Details</th>

                                            <td>   <%  out.print(request.getAttribute("customer_address")); %></td>

                                        </tr>
                                        <tr>
                                            <th>Bank Account ID</th>

                                            <td>   <%  out.print(request.getAttribute("bank_account_id")); %></td>

                                        </tr>
                                        <tr>
                                            <th>Account Balance</th>

                                            <td>   <%  out.print(request.getAttribute("customer_balance")); %></td>

                                        </tr>
                                        <tr>
                                            <th>Bank Account Creation Date</th>

                                            <td>   <%  out.print(request.getAttribute("created_at"));%></td>

                                        </tr>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>

               
            </div>
        </div>

        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <!-- jQuery Custom Scroller CDN -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

        <script type="text/javascript">
            
            $('.Dashboard').toggleClass('activeElement');
            
            $(document).ready(function () {
                $("#sidebar").mCustomScrollbar({
                    theme: "minimal"
                });

                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar, #content').toggleClass('active');
                    $('.collapse.in').toggleClass('in');
                    $('a[aria-expanded=true]').attr('aria-expanded', 'false');
                });
            });
        </script>
    </body>

</html>


