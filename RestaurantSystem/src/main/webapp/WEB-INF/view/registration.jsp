<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<style type="text/css">
body {
	padding-top: 70px;
	padding-bottom: 40px;
	background-color: #eee;
	margin-left: auto
}

.form-signin-reg {
  max-width: 330px;
  padding: 15px;
  margin: 20;
}
</style>

</head>
<body>
	<div class="container">

			<h2>Registration form</h2>

		<form action="ControllerServlet" method="post" class="form-signin-reg">
			<label>Enter name</label> <input type="text"
				class="form-control input-lg" name="name" required/> <br /> <label>Email</label>
			<input type="text" class="form-control input-lg" name="email" required/> <br />
			<label>Address</label> <input type="text"
				class="form-control input-lg" name="address" required/> <br /> <label>Login</label>
			<input type="text" class="form-control input-lg" name="login" required/> <br />
			<label>Password</label> <input type="password"
				class="form-control input-lg" name="password" required/> <br /> <label>Repeat
				password</label> <input type="password" class="form-control input-lg"
				name="repeatPassword" required/> <br />
			<button type="submit" class="btn btn-primary btn-lg btn-block" name="action" value="registration">
			Registration</button>
			<br />
		</form>
	</div>
</body>
</html>