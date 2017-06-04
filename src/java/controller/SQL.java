package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;

import javax.swing.*;

public class SQL {
    
    
public Connection conn;
    
public ResultSet rs;
public Statement stmt;
    
public PreparedStatement pst;
    
    
   public SQL(String user){
        //To Connect with any other Database
        try{
            String URL="jdbc:mysql://localhost:3306/ticketing";
            String driver="com.mysql.jdbc.Driver";
            String password="admin";
            Class.forName(driver);
            conn = DriverManager.getConnection(URL,user,password);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
   }
    
 public void insertdetails(String user,String fname,String lname,String dob,String password,String gender,String address,String phno) throws SQLException
   {
        pst=conn.prepareStatement("INSERT INTO CUSTOMERDETAILS VALUES(?,?,?,?,?,?,?,?)");
        pst.setString(1, user);
        pst.setString(2, fname);
        pst.setString(3, lname);
        pst.setString(4, dob);
        pst.setString(5, password);
        pst.setString(6, gender);
        pst.setString(7, address);
        pst.setString(8, phno);
        pst.executeUpdate();
        conn.close();
    }
     public boolean viewdetails(String user,String password) throws SQLException
     {
         pst=conn.prepareStatement("SELECT FNAME FROM CUSTOMERDETAILS WHERE USER=? AND PASS=?");
          pst.setString(1, user);
          pst.setString(2, password);
        rs=pst.executeQuery();
        if(rs.next())
            return true;
        else
            return false;
     }
      public ResultSet getdetails(String user,String password) throws SQLException
     {
         pst=conn.prepareStatement("SELECT * FROM CUSTOMERDETAILS WHERE USER=? AND PASS=?");
          pst.setString(1, user);
          pst.setString(2, password);
        rs=pst.executeQuery();
            return rs;
      
     }
     public ResultSet view_showdetails(String movie) throws SQLException
   {
        pst=conn.prepareStatement("select * from showdetails where moviename=?");
        pst.setString(1, movie);
        rs=pst.executeQuery();
        return rs;
   }
     public ResultSet get_showdetails(String movie,String dates,String showtime ) throws SQLException
   {
        pst=conn.prepareStatement("select * from showdetails where moviename=? and dates=? and showtime=?");
        pst.setString(1, movie);
        pst.setString(2, dates);
        pst.setString(3, showtime);
        rs=pst.executeQuery();
        return rs;
   }
     public void update_showdetails(int seat, String movie, String dates, String time) throws SQLException{
     String updateTableSQL = "UPDATE showdetails SET seats=? WHERE moviename=? and dates=? and showtime=?";
pst= conn.prepareStatement(updateTableSQL);
pst.setInt(1, seat);
pst.setString(2, movie);
pst.setString(3, dates);
pst.setString(4, time);
// execute insert SQL stetement
pst .executeUpdate();
//conn.close();
     
     
     }
     public ResultSet view_moviesynopsis(String moviename) throws SQLException
    {
        pst=conn.prepareStatement("select * from movieinfo where moviesf=?");
        pst.setString(1, moviename);
        rs=pst.executeQuery();
        return rs;
    }
     public void insert_bookingdetails(String movie,String bookingdate,String showtime,int seat,int cardno) throws SQLException
     {
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=stmt.executeQuery("select * from bookingdetails");
        int bookingid=0;
        if(rs.last())
        {
        bookingid=rs.getInt(1)+1;
        }
        String user="aishu";
        pst=conn.prepareStatement("insert into bookingdetails values(?,?,?,?,?,?,?)");
        pst.setInt(1,bookingid);
        pst.setString(2,movie);
        pst.setString(3, user);
        pst.setString(4, bookingdate);
        pst.setString(5, showtime);
        pst.setInt(6, seat);
        pst.setInt(7, cardno);
        pst.executeUpdate();
        conn.close();
     }
     public ResultSet view_bookingdetails() throws SQLException
     {
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=stmt.executeQuery("select * from bookingdetails");
        return rs;   
     }
    } 