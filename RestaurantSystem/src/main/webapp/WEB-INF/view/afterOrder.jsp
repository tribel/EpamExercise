<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
		body {
			 padding-top: 90px;
  			 
		}
	</style>
</head>
<body>


	<div class="container">
		<div class="jumbotron">
			<h1>Thank you for order</h1>
			<p>You can go to the menu and to order something else.
				And please , pay for your order on pay page.
			</p>
		</div>
		<p><a href="#" onclick="$('#form-menu').submit()" > Go to menu.</a></p>
		<p><a href="#" onclick="$('#form-pay').submit()" > Pay for order</a></p>
	</div>

	
	

</body>
</html>