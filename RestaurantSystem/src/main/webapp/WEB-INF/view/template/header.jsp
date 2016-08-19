<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:include page="/WEB-INF/view/template/include.jsp" />
<meta http-equiv="Content-Type" content="text/html; ccharset=UTF-8">

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="bundle.text" />

<c:if test="${language==null}">
        <fmt:setBundle basename="bundle" var="language" scope="session"/>
</c:if>
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
<form action="ControllerServlet" method="post" id="form-history">
	<input type="hidden" name="action" value="history"/>
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
				<a class="navbar-brand" href="#"><fmt:message key="header.label.restaurant"/></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#" onclick="$('#form-menu').submit()" ><fmt:message key="header.label.menu"/></a></li>
					<li><a href="#about"><fmt:message key="header.label.about"/></a></li>
					<li><a href="#contact"><fmt:message key="header.label.contact"/></a></li>
					<jsp:useBean id="user" scope="session" class="com.restaurant.entity.Users" />
						<c:if test="${not empty user.name}">
							<li><a href="#" onclick="$('#form-pay').submit()" ><fmt:message key="header.label.pay"/></a></li>
							<li><a href="#" onclick="$('#form-logout').submit()" ><fmt:message key="header.label.logout"/></a></li>
						</c:if>
						<c:if test="${user.roleId == 1}">
							<li><a href="#" onclick="$('#form-admin').submit()" ><fmt:message key="header.label.admin"/></a></li>
							<li><a href="#" onclick="$('#form-history').submit()" >История</a></li>
						</c:if>
						<c:if test="${empty user.name}">
							<li><a href="login"><fmt:message key="header.label.login"/></a> </li>
						</c:if>
				</ul>
				
				<form class="navbar-search pull-right">
						<select  class="form-control" id="language" name="language" onchange="submit()">
							<option  value="en" ${language == 'en' ? 'selected' : ''}>English</option>
							<option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
						</select>
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	
	
	
</body>
</html>