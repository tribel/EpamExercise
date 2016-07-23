<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<link type="text/css" href="/signin.css" rel="stylesheet"/>
	<style type="text/css">
		body {
		  padding-top: 40px;
		  padding-bottom: 40px;
		  background-color: #eee;
		}
	</style>

</head>
<body>

	<div class="container">


		

		<form action="ControllerServlet" method="post" class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" class="form-control input-lg" name="login" placeholder="Your login" autofocus/> 
			<input type="password" class="form-control input-lg" name="password" placeholder="Password" required/>

			<button type="submit" class="btn btn-lg btn-primary btn-block" value="login" name="action">
			SignIn</button>
			<a href="registration">Registration</a>
		</form>

	</div>




</body>
</html>