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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/databaseController"})
public class databaseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    public Connection openDatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bank_management_system?zeroDateTimeBehavior=convertToNull";
            Connection con;
            try {
                con = (Connection) DriverManager.getConnection(url, "root", "");
                 return con;
            } catch (SQLException ex) {
                Logger.getLogger(databaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(databaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet validate</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet validate at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//            try {
//               
//                Class.forName("com.mysql.jdbc.Driver");
//                HttpSession session = request.getSession(true);
//                String url = "jdbc:mysql://localhost:3306/bank_management_system?zeroDateTimeBehavior=convertToNull";
//                Connection con = (Connection) DriverManager.getConnection(url, "root", "");
////               PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE customer.customer_id = ?");
//               stmt.setInt(1, customer_id);//1 specifies the first parameter in the query  
//
////                try {
////
////                    ResultSet rs = stmt.executeQuery();
////                    while (rs.next()) {
////                        session.setAttribute("customer_id", rs.getInt("customer_id"));
////                        session.setAttribute("customer_name", rs.getString("customer_name"));
////                        session.setAttribute("customer_address", rs.getString("customer_address"));
////                        session.setAttribute("customer_phone", rs.getString("customer_phone"));
////                    }
////                    //out.print(request.getSession().getAttribute("customer_name"));
////                   
////                    
////                } catch (SQLException e) {
////                    e.printStackTrace();
////                }
//
//            } catch (Exception e) {
//                out.print("Heloooooo");
//
//            }
//
//        }
//    }
