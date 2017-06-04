/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class movies extends HttpServlet {
    

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
        PrintWriter out = response.getWriter();
        ServletContext contextvar=request.getServletContext();
        String movie=(String)contextvar.getAttribute("movie");
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='bookmovie'>");
            String bookingdate=request.getParameter("bookingdate");
            String seats=request.getParameter("seats");
            String [] date=bookingdate.split("-");
            Calendar cal= Calendar.getInstance();
            int currentday=cal.get(Calendar.DAY_OF_MONTH);
            int day= Integer.parseInt(date[0]);
            int seat=Integer.parseInt(seats);
            SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-dd-MMM-EEEHH:mm");
            Date today;
            Calendar c = Calendar.getInstance();
            c.add(c.HOUR,1);
            today=c.getTime();
            StringBuilder builder=new StringBuilder();
            builder.append("2013-");
            builder.append(bookingdate);
            SQL s=new SQL("root");
            ResultSet rs=s.view_showdetails(movie);
            while(rs.next())
            {
                out.println("&nbsp;&nbsp;"+rs.getString(2)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(3));
                    try{
                    builder.append(rs.getString(3));
                    String movietime=builder.toString();
                    Date bookingday=parseFormat.parse(movietime);
                    out.println(bookingday);
                    if(today.getTime()<bookingday.getTime())
                    {
                      if(seat <=rs.getInt(4))
                      {
                       out.println("<font color='green'>");
                       out.println("&nbsp;&nbsp; Available &nbsp;&nbsp;&nbsp;&nbsp;</font>");
                       out.println("<input type='radio' name='radio' value='"+rs.getString(3)+"' />");
                      }
                      else
                      {
                       out.println("<font color='red'>");
                       out.println("&nbsp;&nbsp; Booked &nbsp;&nbsp;&nbsp;&nbsp;</font>");   
                      }
                    }
                    else
                    {
                      out.println("&nbsp;&nbsp; Booking Closed &nbsp;&nbsp;&nbsp;&nbsp;");   
                    }
                    }
                    catch(Exception e)
                    {
                        out.println(e);
                    }
                    out.println("<br>");
            }
            contextvar.setAttribute("seat", seat);
            contextvar.setAttribute("bookingdate", bookingdate);
            out.println("<input type='submit' value='Book Now'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");  
        }
            finally {            
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
            Logger.getLogger(movies.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(movies.class.getName()).log(Level.SEVERE, null, ex);
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
