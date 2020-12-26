/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.Transaction;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.ObjectNode;
import Helpers.Helper;

/**
 *
 * @author boody
 */
@WebServlet(urlPatterns = {"/TransactionsController"})
public class TransactionsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void makeTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        PrintWriter out = null;
        PreparedStatement stmt = null;
        databaseController dbconteroller = new databaseController();
        Connection con = dbconteroller.openDatabaseConnection();
        try {
            out = response.getWriter();
            float transaction_ammount = Integer.parseInt(request.getParameter("transaction_ammount"));;
            int from_Account = Integer.parseInt(request.getParameter("source_account_id"));
            int to_account = Integer.parseInt(request.getParameter("destination_account_id"));

            stmt = con.prepareStatement("UPDATE  banck_account  SET banck_account.balance = banck_account.balance-? WHERE bank_account_id = ? AND (banck_account.balance-?)>=0;");
            stmt.setFloat(1, transaction_ammount);
            stmt.setInt(2, from_Account);
            stmt.setFloat(3, transaction_ammount);

            if (stmt.executeUpdate() > 0) {

                stmt = con.prepareStatement("UPDATE  banck_account  SET banck_account.balance = banck_account.balance+? WHERE bank_account_id = ?");
                stmt.setFloat(1, transaction_ammount);
                stmt.setInt(2, to_account);
                stmt.execute();

                stmt = con.prepareStatement("INSERT INTO banck_transaction VALUES (DEFAULT,?,?,?,DEFAULT)");
                stmt.setFloat(1, transaction_ammount);
                stmt.setInt(2, from_Account);
                stmt.setInt(3, to_account);
                stmt.executeUpdate();

            }
            out.print(from_Account + "  " + from_Account + " " + transaction_ammount + " <> " + Helper.getCurrentTimeStamp());

        } catch (IOException ex) {
            Logger.getLogger(TransactionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("source_account_id") != null) {
                makeTransaction(request, response);

            } else {
                databaseController dbconteroller = new databaseController();
                Connection con = dbconteroller.openDatabaseConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM banck_transaction");
//                PreparedStatement stmt = con.prepareStatement("SELECT * FROM banck_transaction WHERE banck_transaction.from_account = ?");
//                stmt.setInt(1, 5);
                ResultSet rs = stmt.executeQuery();
                ArrayList<Transaction> transactions = new ArrayList<Transaction>();

                while (rs.next()) {
                    int transactions_id = rs.getInt("transaction_id");
                    float transaction_ammount = rs.getFloat("transaction_amount");
                    int from_Account = rs.getInt("from_account");
                    int to_account = rs.getInt("to_account");
                    Timestamp created_at = rs.getTimestamp("created_at");
                    Transaction transaction = new Transaction(transactions_id, transaction_ammount, from_Account, to_account, created_at);
                    transactions.add(transaction);
                }

                request.setAttribute("transactionLists", transactions);
                request.getRequestDispatcher("Transaction.jsp").forward(request, response);

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
            Logger.getLogger(TransactionsController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TransactionsController.class.getName()).log(Level.SEVERE, null, ex);
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
