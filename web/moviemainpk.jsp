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
                <th><img src="images/pk.jpg"/></th>
                <th>
                <p align="left"><font size="5">PK <br><br>
                    A stranger in the city asks questions no one has asked before. Known only by his initials, P.K.'s innocent questions and childlike curiosity will take him on a journey of love, laughter and letting-go.<br>

                    Director: Rajkumar Hirani<br>
                    Writers: Rajkumar Hirani, Abhijat Joshi<br>
Stars:  Aamir Khan, Anushka Sharma, Sanjay Dutt</font></p>
                </th>
            </tr>
           </table>
        </div>
        <div style="position:absolute; top:450px; left:450px;"> <input type="button" value="View Show Timings" onclick="ShowDiv('mydiv')" /></div> 
        <div id="mydiv" style="display: none; background-color: #ffffdd; position:absolute; top:500px; width:53%; height:40%">
	<%@ include file="moviedetailspk.jsp" %>
        <input type="button" value="Book Tickets" style="position:absolute; top:350px; left:45%" onclick="ShowDiv('bookdiv')"/>
        </div><br>
        <div id="bookdiv" style="display: none; background-color: #ffffdd; position:absolute; top:490px; width:30%; height:40%; left:65%;">
            <%@ include file="bookpk.jsp" %>
             </div>
        
    </body>
</html>

