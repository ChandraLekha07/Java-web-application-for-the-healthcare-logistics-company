<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/styles.css">
<title>PHARMA | Welcome</title>
</head>
<body>
<%
if(session.getAttribute("usermail")==null){
	response.sendRedirect("login.html");
}
%>
<div class="container" style="margin-top:30px;">
<nav class="navbar navbar-inverse" >
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="index.html" style="letter-spacing:0.5rem;">PHARMA</a>
	    </div>
	    	<ul class="nav navbar-nav navbar-right">
		      <li ><a href="welcome.jsp">Welcome</a></li>
		      <li ><a href="shop.jsp">Shop</a></li>
		      <li><a><form action="logout" method="post">
		      		<button style="background:white; color:black; border:none; border-radius:10px;"><li><span class="glyphicon glyphicon-log-in"></span> Logout</li></button>
		      </form></a></li>
		    </ul>
	    
	  </div>
	</nav>
	<h1 style="text-align:center;">Welcome ${usermail }</h1>
</div>
</body>
</html>