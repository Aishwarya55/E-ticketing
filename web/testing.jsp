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
    $('#myButton').click(function() {
  $('#myDiv').toggle('slow', function() {
    // Animation complete.
  });
});

    </script>
  
</head>
    <body>
  <div id="myDiv" style="display:none;" class="answer_list" ><%@ include file="moviedetails.jsp" %></div>
<input id="myButton" type="button" name="answer" onclick="ShowDiv('myDiv')" />

    </body>
</html>

