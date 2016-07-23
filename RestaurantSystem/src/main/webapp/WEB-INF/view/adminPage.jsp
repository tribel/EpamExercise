<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri= "mytags" prefix="mytags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
				<th>Time</th>
				<th>Customer name</th>
				<th>Total price </th>
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
							Confirm</button>
							<button  type="submit" class="btn btn-danger">
							Denial</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>