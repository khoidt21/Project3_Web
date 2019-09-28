/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vuvan
 */
@WebServlet (urlPatterns = "/SignupController")
public class SignupController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    Database db;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect(request.getContextPath() + "/sign-up.jsp");
    }

    public void init() throws ServletException {
        UsersData.getInstance().scanData();
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

        User u = new User(request.getParameter("username"), request.getParameter("password"));

        if (u.validUser() && !UsersData.getInstance().hasUser(u.getUsername())) {
            //success. add user to database
            UsersData.getInstance().addUser(u.getUsername(), u.getPassword());

            //save data to file
            UsersData.getInstance().saveUsers();
            
            //goto login.jsp
            request.getServletContext().setAttribute("users", UsersData.getInstance());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else { //something wrong
            if (UsersData.getInstance().hasUser(u.getUsername())) {
                u.addError("username exists.");
            }
            request.setAttribute("u", u);
            request.getRequestDispatcher("/sign-up.jsp").forward(request, response);
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

   

    public void destroy() {
        super.destroy();
        UsersData.getInstance().saveUsers();
    }
}
