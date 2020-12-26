<%-- 
    Document   : Transaction
    Created on : Dec 26, 2020, 9:21:57 PM
    Author     : boody
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Models.Transaction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Collapsible sidebar using Bootstrap 4</title>
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

        <link rel="stylesheet" href="//cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" >
        <script  src="//cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js" ></script>

        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="style2.css">
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

    </head>
    <body>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@ include file = "layout\sidebar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@ include file = "layout\navbar.jsp" %>
                <div class="card">
                    <div class="card-header">
                        <h1>Money Transfer </h1>
                    </div>
                    <div class="card-body">
                        <form class="needs-validation" novalidate>
                            <div class="form-row">
                                <div class="col-md-4 mb-3">
                                    <label for="source_account_id">Source Account ID</label>
                                    <input type="number" min="1" class="form-control" id="source_account_id" name="source_account_id" placeholder="ex:98448188" value="Mark" required>
                                    
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label  for="destination_account_id">Destination Account ID</label>
                                    <input type="number" min="1"  class="form-control" id="destination_account_id" name="destination_account_id" placeholder="ex: 1658484"  required>
                                   
                                </div>
                                <div class="col-md-4 mb-3">
                                      <label for="transaction_ammount">Transaction Ammount</label>
                                      <input type="number" min="50" class="form-control" id="transaction_ammount" name="transaction_ammount"  placeholder="ex:200" value="Otto" required>
                                   
                                </div>
                            </div>

                            <button class="btn btn-primary" type="submit">Peform Transaction</button>
                        </form>
                    </div>           
                </div>

                <div class="card mt-5">
                    <div class="card-header">
                            
                               <h1>Transactions Logs</h1>
                    </div>
                    <div class="card-body">
                            
                        <table id="example" class="table" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Transactions Id</th>
                                    <th>Transaction Amount</th>
                                    <th>From Account ID</th>
                                    <th>To Account ID</th>
                                    <th>Transaction Date</th>

                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    ArrayList<Transaction> transactions = (ArrayList<Transaction>) request.getAttribute("transactionLists");
                                    for (Transaction transaction : transactions) {
                                        out.print("<tr><td>" + transaction.transactions_id + "</td>");
                                        out.print("<td>" + transaction.transaction_ammount + " L.E </td>");
                                        out.print("<td>" + transaction.from_Account + "</td>");
                                        out.print("<td>" + transaction.to_account + "</td>");
                                        out.print("<td>" + transaction.created_at + "</td>");
                                        out.print("<tr/>");
                                    }
                                %>
                            </tbody>
                        </table>

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
