<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="bundle.text" />
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
			<h2 class="form-signin-heading"><fmt:message key="login.label.signIn"/></h2>
			<input type="text" class="form-control input-lg" name="login" placeholder="Your login" autofocus/> 
			<input type="password" class="form-control input-lg" name="password" placeholder="Password" required/>

			<button type="submit" class="btn btn-lg btn-primary btn-block" value="login" name="action">
			<fmt:message key="login.button.signIn"/></button>
			<a href="registration"><fmt:message key="login.label.registration"/></a>
		</form>

	</div>




</body>
</html>