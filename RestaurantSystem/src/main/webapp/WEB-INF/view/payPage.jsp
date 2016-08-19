<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri= "mytags" prefix="mytags" %>

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
			 padding-top: 80px;
  			 padding-bottom: 40px;
             background-color: #eee;
             width: 60%;
             margin: auto;
		}
		
	</style>
</head>
<body>
		
	
	<c:if test="${requestScope.payList.size() == 0}">
		<div class="jumbotron">
			<p><fmt:message key="pay.label.notYet"/> </p>
		</div>
	</c:if>	
	<table class="table table-hover">
		<thead>
			<tr>
				<th><fmt:message key="pay.label.time"/></th>
				<th><fmt:message key="pay.label.total"/> </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="${requestScope.payList}">
				<tr>
					<td>${order.dateTime}</td>
					<td><mytags:formatPrice price="${order.totalSum}"/></td>
					<td>
						<form action="ControllerServlet" method="post">
							<input type="hidden" name="orderId" value="${order.orderId}">
							<button name="action" value="pay" type="submit" class="btn btn-info">
							<fmt:message key="pay.button.pay"/></button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>