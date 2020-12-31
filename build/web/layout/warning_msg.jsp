<%-- 
    Document   : warning_msg
    Created on : Dec 26, 2020, 3:51:22 AM
    Author     : boody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

   


%>

<%
    if (request.getAttribute("has_account")=="false") {%>
    
              <div class="alert alert-warning alert-dismissable">
    <div class="alertwrapper clearfix">
        <div class="alertcontent">
            <h4>Warning!</h4>
            <span> You don't have a bank account yet!</span>
            </br>
            <a style="text-decoration: underline" href="add_account">create one now</a>
        </div>
    </div>
</div>

     




<%
    }
%>
