/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class checklogin extends HttpServlet {


    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
      
     response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Pragma", "no-cache"); 
response.setDateHeader("Expires", 0);  

        //response.setHeader(“Cache-Control”, “private, no-store, no-cache, must-revalidate”);
        PrintWriter out = response.getWriter();
        try {
            String user=request.getParameter("user");
            String password=request.getParameter("password");
            SQL s=new SQL("root");
           
          
            boolean value=s.viewdetails(user, password);
            if(!value){
                out.println("Invalid Username/password");
                 RequestDispatcher rd1=request.getRequestDispatcher("error.jsp");  
        rd1.forward(request, response);
            }
            else{
                 
                out.println("Success");
                
            String fname=null;
             ResultSet rs=s.getdetails(user, password);
             if(rs.next())
           fname=rs.getString(2);
            //request.setAttribute("name", fname);
              HttpSession session=request.getSession(); 
                  session.setAttribute("name",fname);
                  session.setMaxInactiveInterval(10);
                  
              RequestDispatcher rd=request.getRequestDispatcher("selectmovie.jsp");  
        rd.forward(request, response);
            
        
            //out.print("Please login first");  
            //request.getRequestDispatcher("homepage.html").include(request, response);  
        
        }} finally {     
           
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(checklogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(checklogin.class.getName()).log(Level.SEVERE, null, ex);
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
