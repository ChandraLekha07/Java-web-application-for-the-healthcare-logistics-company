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
<title>PHARMA | Shop</title>
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
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" type="text/css" href="shop.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
  </head>
  <body>
    <div class="product-card">
      <h1>Your Medicines</h1>
      <p>Always laugh when you can, it is cheap medicine.</p>
      <div class="product-pic"></div>
      <div class="product-colors">
        <span class="blue active" data-color="#7ed6df" data-pic="url(1.jpg)"></span>
        <span class="green" data-color="#badc58" data-pic="url(2.jpg)"></span>
        <span class="yellow" data-color="#f9ca24" data-pic="url(3.jpg)"></span>
        <span class="rose" data-color="#ff7979" data-pic="url(4.jpg)"></span>
      </div>
      <div class="product-info">
        <div class="product-price">$90</div>
        <a href="#" class="product-button">Add to Cart</a>
      </div>
    </div>

    <script>
      $(".product-colors span").click(function(){
        $(".product-colors span").removeClass("active");
        $(this).addClass("active");
        $("body").css("background",$(this).attr("data-color"));
        $(".product-price").css("color",$(this).attr("data-color"));
        $(".product-button").css("color",$(this).attr("data-color"));
        $(".product-pic").css("background-image",$(this).attr("data-pic"));
      });
    </script>
  </body>
</html>
</div>
</body>
</html>