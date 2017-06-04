<%-- 
    Document   : registration
    Created on : Mar 1, 2013, 10:15:55 PM
    Author     : Aishwarya Kannan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
body{
	background-image:url('images/background.jpg');
        background-size:cover;
}
font{
    color:#FFFFFF;
    size: 14px;
}
input#tb{
    width: 250px;
}
input#tb1{
    width: 700px;
}
</style>
    </head>
    <body>
        <form action="verify" style="position: absolute; top: 100px; left : 50px;">
<font><b>
<table width="1022" height="39" border="0">
  <tr>
    <th width="1016" scope="row">&nbsp;</th>
  </tr>
</table>
    <p></p>
<table width="1020" border="0">
  <tr>
    <th width="251" scope="row">&nbsp;</th>
    <td width="340">Username</td>
    <td width="415">Phone Number:</td>
  </tr>
</table>
<table width="1019" border="0">
  <tr>
    <th width="251" height="31" scope="row">&nbsp;</th>
    <td width="341" valign="top"><input type="text" name="user" value="Your Email-id" id="tb"/> </td>
    <td width="415" valign="top"><input type="text" name="phno" value="" id="tb" /></td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" scope="row">&nbsp;</th>
    <td width="341">First Name:</td>
    <td width="415">Last Name:</td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" height="32" scope="row">&nbsp;</th>
    <td width="341" valign="top"><input type="text" name="fname" value="" id="tb" /></td>
    <td width="415" valign="top"><input type="text" name="lname" value="" id="tb" /></td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" align="right" scope="row">&nbsp;</th>
    <td width="106">DD</td>
    <td width="105">MM</td>
    <td width="122">YY</td>
    <td width="415">Gender: <input type="radio" name="gender" value="male" /> 
    Male &nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="female" /> Female</td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" height="29" align="right" scope="row">DOB</th>
    <td width="105"><select name="day">
<option>Unknown</option>
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
<option>21</option>
<option>22</option>
<option>23</option>
<option>24</option>
<option>25</option>
<option>26</option>
<option>27</option>
<option>28</option>
<option>29</option>
<option>30</option>
<option>31</option>
</select></td>
    <td width="106"><select name="month">
<option>Unknown</option>
<option>Jan</option>
<option>Feb</option>
<option>Mar</option>
<option>Apr</option>
<option>May</option>
<option>Jun</option>
<option>Jul</option>
<option>Aug</option>
<option>Sep</option>
<option>Oct</option>
<option>Nov</option>
<option>Dec</option>
</select></td>
    <td width="540"><select name="year">
<option>Unknown</option>
<option>1985</option>
<option>1986</option>
<option>1987</option>
<option>1988</option>
<option>1989</option>
<option>1990</option>
<option>1991</option>
<option>1992</option>
<option>1993</option>
<option>1994</option>
</select></td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" scope="row">&nbsp;</th>
    <td width="341">Password:(min 8 characters)</td>
    <td width="415">Confirm Password:</td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" height="32" scope="row">&nbsp;</th>
    <td width="341" valign="top"><input type="password" name="password" value="" id="tb" /></td>
    <td width="415" valign="top"><input type="password" name="confirm" value="" id="tb" /></td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" scope="row">&nbsp;</th>
    <td width="758">Address:</td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" height="40" scope="row">&nbsp;</th>
    <td width="758" valign="top"><input type="text" name="address" value="" id="tb1" /></td>
  </tr>
</table>
<table width="1021" border="0">
  <tr>
    <th width="251" height="60" scope="row">&nbsp;</th>
    <td width="760"><button type="submit">  <img src="images/sign_up.jpg" height="50" width="400"/> </button> </td>
  </tr>
</table>
</b></font>
        </form>
    </body>
</html>