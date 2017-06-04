<%-- 
    Document   : welcome
    Created on : 28 Apr, 2015, 9:06:05 PM
    Author     : Aishwarya Kannan
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">
        function ShowDiv(id) {
    document.getElementById(id).style.display = "";
}
    </script>
  
</head>
    <body>
        <div style="height:7%; width:55%">
            <table cellspacing="10px">
                <tr>
                <th><img src="images/Fast-And-Furious-6.jpg"/></th>
                <th>
                <p align="left"><font size="5">FAST AND FURIOUS 6 <br><br>
                    Hobbs has Dominic and Brian reassemble their crew to take down a team of mercenaries: Dominic unexpectedly gets convoluted also facing his presumed deceased girlfriend, Letty.<br>

                    Director: Justin Lin<br>
                    Writers:  Chris Morgan, Gary Scott Thompson (characters).<br>
Stars:  Vin Diesel, Paul Walker, Dwayne Johnson </font></p>
                </th>
            </tr>
           </table>
        </div>
        <div style="position:absolute; top:450px; left:450px;"> <input type="button" value="View Show Timings" onclick="ShowDiv('mydiv')" /></div> 
        <div id="mydiv" style="display: none; background-color: #ffffdd; position:absolute; top:500px; width:53%; height:40%">
	<%@ include file="moviedetailsff.jsp" %>
        <input type="button" value="Book Tickets" style="position:absolute; top:350px; left:45%" onclick="ShowDiv('bookdiv')"/>
        </div><br>
        <div id="bookdiv" style="display: none; background-color: #ffffdd; position:absolute; top:490px; width:30%; height:40%; left:65%;">
            <%@ include file="bookff.jsp" %>
             </div>
        
    </body>
</html>

