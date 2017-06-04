<%-- 
    Document   : selectmovie
    Created on : 1 May, 2015, 8:54:10 AM
    Author     : Aishwarya Kannan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Pragma" content="no-cache">
 <meta http-equiv="Cache-Control" content="no-cache">
 <meta http-equiv="Expires" content="-1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .autoResizeImage {
    max-width: 100%;
    height: auto;
    width: auto;
}
body{
    
    font-family: Verdana, Helvetica, sans-serif;
   background: url(images/blue.jpg);
   
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
	width:520px;
	height:700px;

}
        </style>
    </head>
    <body>
     
   
        <h2 style="position:absolute;top:10px;left:35%">SELECT THE MOVIE OF YOUR CHOICE</h2><br><br><br><br>
        <h4> Welcome ${name} !! <a href="logout" style="position:absolute; left:85%">CLICK HERE TO LOG OUT</a></h4>
        <div>
            <table style="position:absolute; top:200px; left:200px;">
                <tr>
                    <th><a href="moviemain.jsp"><img class="autoResizeImage" src="images/nep.png"/></a><th>
                    <th><a href="moviemainok.jsp"><img class="autoResizeImage" src="images/ok.jpg"/></a></th>
                    <th><a href="moviemainhasee.jsp"><img class="autoResizeImage" src="images/hasee-toh-phasee.jpg"/></a><th>
                  
                </tr>
                <tr>
                    <th><a href="moviemainpk.jsp"><img class="autoResizeImage" src="images/pk.jpg"/></a><th>
                    <th><a href="moviemainff.jsp"><img class="autoResizeImage" src="images/Fast-And-Furious-6.jpg"/></a></th>
                    <th><a href="moviemainavengers.jsp"><img class="autoResizeImage" src="images/avengers.jpg"/></a><th>
                  
                </tr>
            </table>
        </div>
        
    </body>
</html>
