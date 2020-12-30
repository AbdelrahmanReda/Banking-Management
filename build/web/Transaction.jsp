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
    <%@include file="layout/header.jsp" %> 
    <body>

        <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

        <%
            if (session.getAttribute("customer_id") == null) {
                response.sendRedirect("login.jsp");
            }
        %>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@ include file = "layout\sidebar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@ include file = "layout\navbar.jsp" %>
                <div class="card">
                    <div class="card-header">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-1 d-flex align-items-center">
                                    <span data-balloon="Copy Unicode Glyph" data-balloon-pos="down" class="dib hover-orange4"><svg style="width: 45px; height: auto" aria-hidden="true" focusable="false" data-prefix="far" data-icon="barcode-alt" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" class="svg-inline--fa fa-barcode-alt fa-w-20" style=""><path fill="currentColor" d="M360 384h48c4.4 0 8-3.6 8-8V136c0-4.4-3.6-8-8-8h-48c-4.4 0-8 3.6-8 8v240c0 4.4 3.6 8 8 8zm96 0h48c4.4 0 8-3.6 8-8V136c0-4.4-3.6-8-8-8h-48c-4.4 0-8 3.6-8 8v240c0 4.4 3.6 8 8 8zm-160 0h16c4.4 0 8-3.6 8-8V136c0-4.4-3.6-8-8-8h-16c-4.4 0-8 3.6-8 8v240c0 4.4 3.6 8 8 8zM592 0H48C21.5 0 0 21.5 0 48v416c0 26.5 21.5 48 48 48h544c26.5 0 48-21.5 48-48V48c0-26.5-21.5-48-48-48zm0 464H48V48h544v416zm-456-80h48c4.4 0 8-3.6 8-8V136c0-4.4-3.6-8-8-8h-48c-4.4 0-8 3.6-8 8v240c0 4.4 3.6 8 8 8zm96 0h16c4.4 0 8-3.6 8-8V136c0-4.4-3.6-8-8-8h-16c-4.4 0-8 3.6-8 8v240c0 4.4 3.6 8 8 8z" class=""></path></svg></span>
                                </div>
                                <div class="col" >
                                    <h1>Money Transfer </h1>
                                </div>
                            </div>
                        </div>



                    </div>
                    <div class="card-body">
                        <form class="needs-validation" method="POST" action="TransactionsController" >
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
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-1 d-flex align-items-center">
<span data-balloon="Copy Unicode Glyph" data-balloon-pos="down" class="dib hover-orange4"><svg  style="width: 27px; height: auto"  aria-hidden="true" focusable="false" data-prefix="far" data-icon="euro-sign" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512" class="svg-inline--fa fa-euro-sign fa-w-10"><path fill="currentColor" d="M315.6 458.6l-6.5-29.4c-1.4-6.5-8-10.6-14.5-9.1-10.3 2.4-26.5 5.4-44.7 5.4-65.5 0-117-39.5-138.2-97.4h129.5c5.7 0 10.6-4 11.7-9.6l5-24c1.5-7.5-4.1-14.4-11.7-14.4h-148c-1.5-16.1-2.1-32.3-.6-48h162.5c5.7 0 10.6-4 11.7-9.5l5.1-24c1.6-7.5-4.1-14.5-11.7-14.5H108.1c21-58.4 72.5-98 140-98 14.7 0 28.9 2.1 38.2 3.8 6.2 1.1 12.2-2.6 13.8-8.7l7.9-29.6c1.8-6.8-2.5-13.6-9.4-14.9-11.4-2.1-29.4-4.7-49.3-4.7-100 0-179.7 64.1-205.9 152H12c-6.6 0-12 5.4-12 12v24c0 6.6 5.4 12 12 12h23.1c-1.2 15.8-1 35.5.4 48H12c-6.6 0-12 5.4-12 12v24c0 6.6 5.4 12 12 12h32.2c26 88.7 103.4 152 205 152 24.4 0 45.4-4.2 57.5-7.2 6.4-1.6 10.3-7.9 8.9-14.2z" class=""></path></svg></span>                                </div>
                                <div class="col" >
                                    <h1>Transactions Logs</h1>
                                </div>
                            </div>
                        </div>

                        
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
                                    <th>Operations</th>

                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    if (session.getAttribute("transactionList") != null) {

                                        ArrayList<Transaction> transactions = (ArrayList<Transaction>) session.getAttribute("transactionList");
                                        for (Transaction transaction : transactions) {
                                            out.print("<tr><td>" + transaction.transactions_id + "</td>");
                                            out.print("<td>" + transaction.transaction_ammount + " L.E </td>");
                                            out.print("<td>" + transaction.from_Account + "</td>");
                                            out.print("<td>" + transaction.to_account + "</td>");
                                            out.print("<td>" + transaction.created_at + "</td>");
                                            out.print("<td> <form method=\"POST\" action=\"TransactionsController\" > <input type=\"hidden\" name=\"cancelled_transaction_id\" value=\"" + transaction.transactions_id + "\"> <button class=\"btn btn-primary\" type=\"submit\">Cancel Transaction</button> </form> " + "" + "</td>");
                                            out.print("<tr/>");
                                        }
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
