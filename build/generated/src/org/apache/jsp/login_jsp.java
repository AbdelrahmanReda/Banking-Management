package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TODO supply a title</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style2.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\" >\n");
      out.write("                <div class=\"col-lg-12 \" style=\"padding-top: 225px\">\n");
      out.write("                    <form  class=\"login-form\" method=\"POST\" action=\"ValidateController\" >\n");
      out.write("                        <h1 class=\"text-center\" >Welcome To </h1>\n");
      out.write("                        <h4 class=\"text-center\">Online Banking System</h4>\n");
      out.write("                        ");

                            if (session.getAttribute("wrong_logging") != null){
                               out.print( "<div class=\"alert alert-danger\"><strong > Error!</strong > Wrong Loging Data, please try again.</div> ");         
                              }
                            session.removeAttribute("wrong_logging");
                            if (session.getAttribute("customer_id")!=null){
                                    response.sendRedirect("customerhome.jsp");
                                }
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label for=\"customer_id\" class=\"form-label\">Customer Id</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"customer_id\" name=\"customer_id\">\n");
      out.write("                            <div id=\"emailHelp\" class=\"form-text\">We'll never share your email with anyone else.</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"mb-3\">\n");
      out.write("                            <label for=\"customer_password\" class=\"form-label\">Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"customer_password\" name=\"customer_password\">\n");
      out.write("                        </div>\n");
      out.write("                        <button style=\"width: 100%\" type=\"submit\" class=\"btn btn-primary\">sign in</button>  \n");
      out.write("                    </form>    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
