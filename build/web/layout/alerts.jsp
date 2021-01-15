<%-- 
    Document   : alerts
    Created on : Jan 15, 2021, 9:19:12 PM
    Author     : boody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("same_id_error") != null) {
        session.removeAttribute("same_id_error");%>
<div class="alert alert-danger" role="alert">
    Will you transfer money for yourself !? -_-
</div>
<%}
    if (session.getAttribute("not_sufficent_ammount") != null) {
        session.removeAttribute("not_sufficent_ammount");

%>

<div class="alert alert-danger" role="alert">
    Unfortunately, you don't have enough money, contact Elon Musk!
</div>
<%}
    if (session.getAttribute("no_existing_destination") != null) {
        session.removeAttribute("no_existing_destination");

%>
<div class="alert alert-danger" role="alert">
    The destination couldn't be found !
</div>

<%}
    if (session.getAttribute("successfull_transaction") != null) {
        session.removeAttribute("successfull_transaction");

    

%>
<div class="alert alert-success" role="alert">
    Transaction accomplished successfully 
</div>
<%}
    if (session.getAttribute("cancelation_error") != null) {
        session.removeAttribute("cancelation_error");
%>
<div class="alert alert-danger" role="alert">
   You are too late, unfortunately you can't cancel the transaction right now
</div>

<%}%>