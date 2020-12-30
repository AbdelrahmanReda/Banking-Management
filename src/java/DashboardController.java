/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/DashboardController"})
public class DashboardController extends HttpServlet {

    /**
     *
     * @throws SQLException
     */
    private void getCustomerInfo(int customer_id) throws SQLException {

        databaseController dbconteroller = new databaseController();
        Connection con = dbconteroller.openDatabaseConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer INNER JOIN banck_account on customer.customer_id = banck_account.customer_id WHERE customer.customer_id = ? AND customer.password = ?");
        stmt.setInt(1, customer_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            String customer_address = rs.getString("customer_address");
            String customer_phone = rs.getString("customer_phone");
            int bank_account_id = rs.getInt("bank_account_id");
            float customer_balance = rs.getFloat("balance");
            Timestamp created_at = rs.getTimestamp("created_at");

        }

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            if (session.getAttribute("customer_id") == null) {
                response.sendRedirect("login.jsp");
            } else {
                int customer_id = Integer.parseInt(request.getSession().getAttribute("customer_id").toString());
                databaseController dbconteroller = new databaseController();
                java.sql.Connection con = dbconteroller.openDatabaseConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer INNER JOIN banck_account on customer.customer_id = banck_account.customer_id WHERE customer.customer_id = ?");
                stmt.setInt(1, customer_id);//1 specifies the first parameter in the query  

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {

                    String customer_address = rs.getString("customer_address");
                    String customer_phone = rs.getString("customer_phone");
                    int bank_account_id = rs.getInt("bank_account_id");
                    float customer_balance = rs.getFloat("balance");
                    Timestamp created_at = rs.getTimestamp("created_at");

                    request.setAttribute("customer_address", customer_address);
                    request.setAttribute("customer_phone", customer_phone);
                    request.setAttribute("bank_account_id", bank_account_id);
                    request.setAttribute("customer_balance", customer_balance);
                    request.setAttribute("created_at", created_at);

                }

                request.getRequestDispatcher("customerhome.jsp").forward(request, response);

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

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
