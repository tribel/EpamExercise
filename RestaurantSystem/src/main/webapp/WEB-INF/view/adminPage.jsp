<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri= "mytags" prefix="mytags" %>

<!DOCTYPE>
<html>
<head>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="bundle.text" />
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

	<table class="table table-hover">
		<thead>
			<tr>
				<th><fmt:message key="admin.label.time"/></th>
				<th><fmt:message key="admin.label.name"/></th>
				<th><fmt:message key="admin.label.total"/> </th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="ord" items="${requestScope.orders}">
				<tr>
					<td>${ord.dateTime}</td>
					<td>${ord.user.name}</td>
					<td><mytags:formatPrice price="${ord.totalSum}"/></td>
					<td>
						<form action="ControllerServlet" method="post">
							<input type="hidden" name="orderId" value="${ord.orderId}">
							<button name="action" value="confirm" type="submit" class="btn btn-success">
							<fmt:message key="admin.label.confirm"/></button>
							<button  type="submit" class="btn btn-danger" name="action" value="denial">
							<fmt:message key="admin.label.denial"/></button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<a href="history" title="Hisroty" class="btn btn-success" role="button">History</a>
</body>
</html>