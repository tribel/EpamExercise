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
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<title>Registration></title>


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

			<h2><fmt:message key="registration.label.form"/></h2>

		<form action="ControllerServlet" method="post" class="form-signin-reg">
			<label><fmt:message key="registration.label.name"/></label> <input type="text"
				class="form-control input-lg" name="name" required/> <br /> 
			
			<label><fmt:message key="registration.label.email"/></label>
			<input type="text" class="form-control input-lg" name="email" required/> <br />
			
			<label><fmt:message key="registration.label.address"/></label> 
			<input type="text"
				class="form-control input-lg" name="address" required/> <br /> 
				
			<label><fmt:message key="registration.label.login"/></label>
			<input type="text" class="form-control input-lg" name="login" required/> <br />
			
			<label><fmt:message key="registration.label.password"/></label> 
			<input type="password"
				class="form-control input-lg" name="password" required/> <br /> 
				
			<label><fmt:message key="registration.label.repeatPsw"/></label> 
			<input type="password" class="form-control input-lg" name="repeatPassword" required/> <br />
			
			<button type="submit" class="btn btn-primary btn-lg btn-block" name="action" value="registration">
			<fmt:message key="registration.button.registration"/></button>
			<br />
		</form>
	</div>
</body>
</html>