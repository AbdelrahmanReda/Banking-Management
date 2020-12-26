/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author boody
 */
@WebServlet(urlPatterns = {"/add_account"})
public class add_account extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            try {

                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/bank_management_system?zeroDateTimeBehavior=convertToNull";
                Connection con = (Connection) DriverManager.getConnection(url, "root", "");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO banck_account VALUES (?,?,?,?)");
                stmt.setInt(1, 5);
                stmt.setInt(2, Integer.parseInt(request.getSession().getAttribute("customer_id").toString()));//1 specifies the first parameter in the query  
                stmt.setInt(3, 1000);//1 specifies the first parameter in the query  
                stmt.setTimestamp(4, getCurrentTimeStamp());
//1 specifies the first parameter in the query  
                out.print(stmt);
                try {
                    stmt.executeUpdate();
                    out.print("inserted");
                    
                    response.sendRedirect("customerhome.jsp");

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                out.print("Heloooooo");
                e.printStackTrace();

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
