/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aishwarya Kannan
 */
public class verify extends HttpServlet {

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
        String user=request.getParameter("user");
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String day=request.getParameter("day");
        String month=request.getParameter("month");
        String year=request.getParameter("year");
        String password=request.getParameter("password");
        String confirmpassword=request.getParameter("confirm");
        String gender=request.getParameter("gender");
        String address=request.getParameter("address");
        String phno=request.getParameter("phno");
        LinkedList l=new LinkedList();
        int yr;
        if(user.length()==0)
        {
            l.add("Enter the username");
        }
        else
            if(!(user.indexOf("@")>-1&&user.indexOf(".com")>-1))
            {
                l.add("Enter a proper username");
            }
        if(lname.length()<3||fname.length()<3)
        {
            l.add("Invalid Name");
        }
        if(day.equals("Unknown")||month.equals("Unknown")||year.equals("Unknown"))
        {
            l.add("Invalid DoB");
        }
        else
            if(month.equals("Feb"))
            {
                yr=Integer.parseInt(year);
                if(yr%4==0)
                {
                    if(day.equals("30")||day.equals("31"))
                        l.add("Invalid DoB");
                }
                else
                {
                    if(day.equals("29")||day.equals("30")||day.equals("31"))
                        l.add("Invalid DoB");
                }
                    
            }
        else
            if(month.equals("Apr")||month.equals("Jun")||month.equals("Sep")||month.equals("Nov"))
            {
                if(day.equals("31"))
                    l.add("Invalid DoB");
            }
        if(password.length()<8)
        {
            l.add("Password should be minimum 8 characters");
        }
        else
            if(!(password.equals(confirmpassword)))
            {
                l.add("Invalid Password");
            }
        if(gender==null)
        {
            l.add("Choose your Gender");
        }
        if(address.length()<10)
        {
            l.add("enter a proper address");
        }
        String expression = "(\\d{3})(\\d{7})$";
        CharSequence inputStr;
        inputStr = phno;
    Pattern pattern = Pattern.compile(expression);
    Matcher matcher = pattern.matcher(inputStr);
    if(!(matcher.matches()))
    {
        l.add("Invalid Phone Number");
    }       
        if(l.isEmpty())
        {
            StringBuilder builder=new StringBuilder();
            builder.append(day);
            builder.append("/");
            builder.append(month);
            builder.append("/");
            builder.append(year);
            String dob=builder.toString();
           
            SQL s=new SQL("root");
            s.insertdetails(user,fname,lname,dob,password,gender,address,phno);
       request.setAttribute("name", fname);
            RequestDispatcher rd=request.getRequestDispatcher("selectmovie.jsp");
            rd.forward(request, response);
            
        }
        else
        {
        Iterator i=l.iterator();
        out.println("<font color='red' face='arial'>");
        out.println("Please Correct the Following mistakes");
        out.println("<ol>");
        while(i.hasNext())
        {
            out.println(i.next());
            out.println("<br>");
        }
        out.println("</ol> </font>");
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");    
            out.println("     <style type='text/css'>");
out.println("body{");
out.println("	background-image:url('images/background.jpg');");
out.println("        background-size:cover;");
out.println("}");
out.println("font{ color:black;");
out.println("    size: 14px;}");
out.println("input#tb{");
out.println("    width: 250px;");
out.println("}");
out.println("input#tb1{");
out.println("    width: 700px;");
out.println("}");
out.println("</style>");
            out.println("</head>");
            out.println("<body>");
        out.println("<form action='verify'>");
        out.println("<font> <b>");
out.println("<table width='1022' height='39' border='0'>");
out.println("  <tr>");
out.println("    <th width='1016' scope='row'>&nbsp;</th>");
out.println("  </tr>");
out.println("</table>");
out.println("    <p></p>");
out.println("<table width='1020' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' scope='row'>&nbsp;</th>");
out.println("    <td width='340'>Username</td>");
out.println("    <td width='415'>Phone Number:</td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1019' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' height='31' scope='row'>&nbsp;</th>");
out.println("    <td width='341' valign='top'><input type='text' name='user' value='Your email-id' id='tb'/> </td>");
out.println("    <td width='415' valign='top'><input type='text' name='phno' value='' id='tb' /></td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' scope='row'>&nbsp;</th>");
out.println("    <td width='341'>First Name:</td>");
out.println("    <td width='415'>Last Name:</td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' height='32' scope='row'>&nbsp;</th>");
out.println("    <td width='341' valign='top'><input type='text' name='fname' value='' id='tb' /></td>");
out.println("    <td width='415' valign='top'><input type='text' name='lname' value='' id='tb' /></td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' align='right' scope='row'>&nbsp;</th>");
out.println("    <td width='106'>DD</td>");
out.println("    <td width='105'>MM</td>");
out.println("    <td width='122'>YY</td>");
out.println("    <td width='415'>Gender: <input type='radio' name='gender' value='male' />"); 
out.println("    Male &nbsp;&nbsp;&nbsp;<input type='radio' name='gender' value='female' /> Female</td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' height='29' align='right' scope='row'>DOB</th>");
out.println("    <td width='105'><select name='day'>");
out.println("<option>Unknown</option>");
out.println("<option>1</option>");
out.println("<option>2</option>");
out.println("<option>3</option>");
out.println("<option>4</option>");
out.println("<option>5</option>");
out.println("<option>6</option>");
out.println("<option>7</option>");
out.println("<option>8</option>");
out.println("<option>9</option>");
out.println("<option>10</option>");
out.println("<option>11</option>");
out.println("<option>12</option>");
out.println("<option>13</option>");
out.println("<option>14</option>");
out.println("<option>15</option>");
out.println("<option>16</option>");
out.println("<option>17</option>");
out.println("<option>18</option>");
out.println("<option>19</option>");
out.println("<option>20</option>");
out.println("<option>21</option>");
out.println("<option>22</option>");
out.println("<option>23</option>");
out.println("<option>24</option>");
out.println("<option>25</option>");
out.println("<option>26</option>");
out.println("<option>27</option>");
out.println("<option>28</option>");
out.println("<option>29</option>");
out.println("<option>30</option>");
out.println("<option>31</option>");
out.println("</select></td>");
out.println("    <td width='106'><select name='month'>");
out.println("<option>Unknown</option>");
out.println("<option>Jan</option>");
out.println("<option>Feb</option>");
out.println("<option>Mar</option>");
out.println("<option>Apr</option>");
out.println("<option>May</option>");
out.println("<option>Jun</option>");
out.println("<option>Jul</option>");
out.println("<option>Aug</option>");
out.println("<option>Sep</option>");
out.println("<option>Oct</option>");
out.println("<option>Nov</option>");
out.println("<option>Dec</option>");
out.println("</select></td>");
out.println("    <td width='540'><select name='year'>");
out.println("<option>Unknown</option>");
out.println("<option>1985</option>");
out.println("<option>1986</option>");
out.println("<option>1987</option>");
out.println("<option>1988</option>");
out.println("<option>1989</option>");
out.println("<option>1990</option>");
out.println("<option>1991</option>");
out.println("<option>1992</option>");
out.println("<option>1993</option>");
out.println("<option>1994</option>");
out.println("</select></td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' scope='row'>&nbsp;</th>");
out.println("    <td width='341'>Password:(min 8 characters)</td>");
out.println("    <td width='415'>Confirm Password:</td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' height='32' scope='row'>&nbsp;</th>");
out.println("    <td width='341' valign='top'><input type='password' name='password' value='' id='tb' /></td>");
out.println("    <td width='415' valign='top'><input type='password' name='confirm' value='' id='tb' /></td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' scope='row'>&nbsp;</th>");
out.println("    <td width='758'>Address:</td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' height='40' scope='row'>&nbsp;</th>");
out.println("    <td width='758' valign='top'><input type='text' name='address' value='' id='tb1' /></td>");
out.println("  </tr>");
out.println("</table>");
out.println("<table width='1021' border='0'>");
out.println("  <tr>");
out.println("    <th width='251' height='60' scope='row'>&nbsp;</th>");
out.println("    <td width='760'><input type='image' src='images/sign_up.jpg' height='50' width='400'/></td>");
out.println("  </tr>");
out.println("</table>");
out.println("</b> </font>");
out.println("        </form>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
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
            Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
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