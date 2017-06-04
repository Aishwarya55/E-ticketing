<%-- 
    Document   : book
    Created on : 30 Apr, 2015, 8:51:09 PM
    Author     : Aishwarya Kannan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Enter your details</h1><br><br>
        <form action="bookingnep">
            <table cellspacing="15px">
                <tr><td><input type="hidden" name="movie" value="hasee"></td></tr>
                <tr><td>Name : &nbsp; <input type="text" name="uname"></td>  <td>&nbsp; &nbsp; &nbsp; &nbsp; Email ID: &nbsp; <input type="text" name="eid"></td></tr>
                <tr><td>    </td></tr><tr>
                    <td>Date: &nbsp;<select name="date"> 
                <option> 4th May </option>
                <option>5th May </option>
                <option>6th May</option>
                    </td>
                <td>&nbsp; &nbsp; &nbsp; &nbsp; Time: &nbsp; <select name="time">
                        <option>11:30 AM</option>
                        <option>4:20 PM</option>
                        <option>9:20 PM</option>
                    </select>
                </td>
</tr>
<tr><td>   </td></tr>
<tr>
    <td>
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; No. of Seats : &nbsp;
        <select name="seats">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>11</option>
            <option>12</option>
            <option>13</option>
            <option>14</option>
            <option>15</option>
            <option>16</option>
            <option>17</option>
            <option>18</option>
            <option>19</option>
            <option>20</option>


    </td>
</tr>
<tr><td>   </td></tr>
<tr>
    <td>
       &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" value="Submit details" name="submitdetails">
    </td>
</tr>

                
            </table>    
        </form>
        
    </body>
</html>
