package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Models.Transaction;

public final class Transaction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/layout/sidebar.jsp");
    _jspx_dependants.add("/layout/navbar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\n");
      out.write("        <title>Collapsible sidebar using Bootstrap 4</title>\n");
      out.write("        <link href=\"//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Bootstrap CSS CDN -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" integrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"//cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css\" >\n");
      out.write("        <script  src=\"//cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js\" ></script>\n");
      out.write("\n");
      out.write("        <!-- Our Custom CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"style2.css\">\n");
      out.write("        <!-- Scrollbar Custom CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Font Awesome JS -->\n");
      out.write("        <script defer src=\"https://use.fontawesome.com/releases/v5.0.13/js/solid.js\" integrity=\"sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script defer src=\"https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js\" integrity=\"sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
      out.write("\n");
      out.write("        \n");
      out.write("        ");

            
        if (session.getAttribute("customer_id") == null) {
                                        response.sendRedirect("login.jsp");
                                    }
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <!-- Sidebar  -->\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("    <nav id=\"sidebar\">\n");
      out.write("            <div class=\"sidebar-header\">\n");
      out.write("                <h3>welcome </h3>\n");
      out.write("            </div>\n");
      out.write("            <ul class=\"list-unstyled components\">\n");
      out.write("               <li>\n");
      out.write("                    <a href=\"DashboardController\">Home</a>\n");
      out.write("                </li>\n");
      out.write("                 <li>\n");
      out.write("                    <a href=\"TransactionsController\">Transactions</a>\n");
      out.write("                </li>           \n");
      out.write("            </ul>\n");
      out.write("        </nav>");
      out.write("\n");
      out.write("            <!-- Page Content  -->\n");
      out.write("            <div id=\"content\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<nav class=\"navbar navbar-expand-md \">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <button type=\"button\" id=\"sidebarCollapse\" class=\"btn btn-info\">\n");
      out.write("            <i class=\"fas fa-align-left\"></i>\n");
      out.write("\n");
      out.write("        </button>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown3\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                       ");
  out.print(request.getSession().getAttribute("customer_name")); 
      out.write("\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown3\">\n");
      out.write("                         <a class=\"dropdown-item\" href=\"log_out\">Log out</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>              \n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("                        <h1>Money Transfer </h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <form class=\"needs-validation\" method=\"POST\" action=\"TransactionsController\" >\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"col-md-4 mb-3\">\n");
      out.write("                                    <label for=\"source_account_id\">Source Account ID</label>\n");
      out.write("                                    <input type=\"number\" min=\"1\" class=\"form-control\" id=\"source_account_id\" name=\"source_account_id\" placeholder=\"ex:98448188\" value=\"Mark\" required>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-4 mb-3\">\n");
      out.write("                                    <label  for=\"destination_account_id\">Destination Account ID</label>\n");
      out.write("                                    <input type=\"number\" min=\"1\"  class=\"form-control\" id=\"destination_account_id\" name=\"destination_account_id\" placeholder=\"ex: 1658484\"  required>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-4 mb-3\">\n");
      out.write("                                    <label for=\"transaction_ammount\">Transaction Ammount</label>\n");
      out.write("                                    <input type=\"number\" min=\"50\" class=\"form-control\" id=\"transaction_ammount\" name=\"transaction_ammount\"  placeholder=\"ex:200\" value=\"Otto\" required>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <button class=\"btn btn-primary\" type=\"submit\">Peform Transaction</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>           \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card mt-5\">\n");
      out.write("                    <div class=\"card-header\">\n");
      out.write("\n");
      out.write("                        <h1>Transactions Logs</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("\n");
      out.write("                        <table id=\"example\" class=\"table\" style=\"width:100%\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Transactions Id</th>\n");
      out.write("                                    <th>Transaction Amount</th>\n");
      out.write("                                    <th>From Account ID</th>\n");
      out.write("                                    <th>To Account ID</th>\n");
      out.write("                                    <th>Transaction Date</th>\n");
      out.write("                                    <th>Operations</th>\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("\n");
      out.write("                                ");

                                    
                                    if( session.getAttribute("transactionList")!=null)
                                    {
                                    
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
                                
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- jQuery CDN - Slim version (=without AJAX) -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!-- Popper.JS -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" integrity=\"sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!-- Bootstrap JS -->\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" integrity=\"sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <!-- jQuery Custom Scroller CDN -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#sidebar\").mCustomScrollbar({\n");
      out.write("                    theme: \"minimal\"\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $('#sidebarCollapse').on('click', function () {\n");
      out.write("                    $('#sidebar, #content').toggleClass('active');\n");
      out.write("                    $('.collapse.in').toggleClass('in');\n");
      out.write("                    $('a[aria-expanded=true]').attr('aria-expanded', 'false');\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
