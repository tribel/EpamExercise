
<!DOCTYPE>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="/WEB-INF/view/template/include.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<form action="ControllerServlet" method="post" id="form-pay">
	<input type="hidden" name="action" value="payList"/>
</form>
<form action="ControllerServlet" method="post" id="form-menu">
	<input type="hidden" name="action" value="menu"/>
</form>
<form action="ControllerServlet" method="post" id="form-logout">
	<input type="hidden" name="action" value="logout"/>
</form>
<form action="ControllerServlet" method="post" id="form-admin">
	<input type="hidden" name="action" value="adminList"/>
</form>



	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Restaurant</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#" onclick="$('#form-menu').submit()" >Menu</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<jsp:useBean id="user" scope="session" class="com.restaurant.entity.Users" />
						<c:if test="${not empty user.name}">
							<li><a href="#" onclick="$('#form-pay').submit()" >Pay for order</a></li>
							<li><a href="#" onclick="$('#form-logout').submit()" >LogOut</a></li>
						</c:if>
						<c:if test="${user.roleId == 1}">
							<li><a href="#" onclick="$('#form-admin').submit()" >AdminPage</a></li>
						</c:if>
						<c:if test="${empty user.name}">
							<li><a href="login">LogIn</a> </li>
						</c:if>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</body>
</html>