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
			<h1><fmt:message key="afterOrder.firstMsg"/></h1>
			<p><fmt:message key="afterOrder.secondMsg"/>
			</p>
		</div>
		<p><a href="#" onclick="$('#form-menu').submit()" > <fmt:message key="afterOrder.toMenu"/></a></p>
		<p><a href="#" onclick="$('#form-pay').submit()" > <fmt:message key="afterOrder.toPay"/></a></p>
	</div>

	
	

</body>
</html>