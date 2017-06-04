/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

/**
 *
 * @author Aishwarya Kannan
 */
public class bookingnep extends HttpServlet {

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
        int seatstotal=0;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String movie=request.getParameter("movie");
       String name=request.getParameter("uname");
       String id=request.getParameter("eid");
       
       
       String date=request.getParameter("date");
       String time=request.getParameter("time");
       String seat=request.getParameter("seats");
       
       int seats=Integer.parseInt(seat);
       
       //System.out.println(seats);
      
       if(name.length()>3 && id.length()!=0 && (id.contains("@") && id.contains(".com"))){
       SQL s=new SQL("root");
        ResultSet rs=s.get_showdetails(movie, date, time);
       
       // System.out.println("done3");
       if(rs.next()){
            
          String seattotal=rs.getString(4);
           seatstotal=Integer.parseInt(seattotal);
          if(seatstotal==0){
                 out.println("<html>");
             out.println("<head>");
             out.println("<script>alert('BOOKING CLOSED !! SELECT SOMEOTHER SHOWTIME OR DATE !!')</script>");
             out.println("</head>");
             out.println("<body>");
             out.println("<h1><br><br>");
             out.println("Booking closed for the movie "+movie+" on "+date+" and time "+time+" ..Go back and try again !!");
             out.println("</h1>");
             out.println("</html>");
          }
           //request.setAttribute("name", seattotal);
             //RequestDispatcher rd=request.getRequestDispatcher("testing.jsp");  
        //rd.forward(request, response); }
      
       else{
           int newseat=seatstotal-seats;
           //System.out.println(newseat);
          s.update_showdetails(newseat, movie, date, time);
             request.setAttribute("name", newseat);
             out.println("<html>");
             out.println("<head>");
             out.println("<script>alert('BOOKING SUCCESSFUL !!')</script>");
            
             out.println("</head>");
             out.println("<body bgcolor='#99CCFF'>");
             out.println("<div style='position:absolute; top:10%; left:45%'><h2>");
             out.println("MOVIE : ");
             out.print(movie+"<br><br><br>");
             out.println("NAME : ");
             out.print(name+"<br><br><br>");
             out.println("EMAIL ID: ");
             out.print(id+"<br><br><br>");
             out.println("DATE : ");
             out.print(date+"<br><br><br>");
             out.println("TIME : ");
             out.print(time+"<br><br><br>");
             out.println("</h2><br><br><br> ");
             out.println("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type='submit' value='Print' onClick='window.print()'></div>");
             out.println("<body>");
             
            
             out.println("</html>");
            // RequestDispatcher rd1=request.getRequestDispatcher("sucess.jsp");  
       // rd1.forward(request, response);
          }
       }}
       else{
           out.println("<html><head><script>alert('INVALID USERNAME OR ID')</script></head><body><h1>Invalid name or id..Try again</h1></body></html>");
           
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
            Logger.getLogger(bookingnep.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(bookingnep.class.getName()).log(Level.SEVERE, null, ex);
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
