
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

@WebServlet(urlPatterns = {"/ValidateController"})
public class ValidateController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                
                Integer customer_id = Integer.parseInt(request.getParameter("customer_id"));
                String customer_password = (request.getParameter("customer_password"));
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(-1);
                databaseController dbconteroller = new databaseController();
                java.sql.Connection con = dbconteroller.openDatabaseConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM customer WHERE customer.customer_id = ? AND customer.password = ?");
                stmt.setInt(1, customer_id);//1 specifies the first parameter in the query  
                stmt.setString(2, customer_password);//1 specifies the first parameter in the query  

                try {
                    int rowsCounter = 0;
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        rowsCounter = rowsCounter + 1;
                        session.setAttribute("customer_id", rs.getInt("customer_id"));
                        session.setAttribute("customer_name", rs.getString("customer_name"));
                       
                    }
                    if (rowsCounter == 0) {
                        //wrong credititails 
                        session.setAttribute("wrong_logging", "true");
                        response.sendRedirect("login.jsp");

                    }             
                    DashboardController ob = new DashboardController();
                    //ob.doPost(request, response);
                    response.sendRedirect("DashboardController");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {

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
