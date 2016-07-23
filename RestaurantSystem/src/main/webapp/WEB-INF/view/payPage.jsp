<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri= "mytags" prefix="mytags" %>

<!DOCTYPE html>
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
		
	
	<c:if test="${requestScope.payList.size() == 0}">
		<div class="jumbotron">
			<p>The administrator not confirm your order yet , please try again later. </p>
		</div>
	</c:if>	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Time</th>
				<th>Total price </th>
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
							Pay for order</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
</body>
</html>