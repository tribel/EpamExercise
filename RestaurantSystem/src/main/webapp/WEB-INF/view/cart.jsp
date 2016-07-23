
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
		body {
			 padding-top: 50px;
  			 padding-bottom: 40px;
             background-color: #eee;
             width: 60%;
             margin: auto;
		}
		
	</style>
</head>


<body>

	<jsp:useBean id="cart" scope="session"
		class="com.restaurant.web.beans.CartBean" />
	<c:if test="${cart.getCartItemCount()==0 }">
		<h2>Cart is empty</h2>
	</c:if>
	
		<table class="table table-hover">

			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach var="cartItem" items="${cart.allCartItems}">
					<tr>
						<td>${cartItem.name}</td>
						<td>${cartItem.price}</td>
						
						<td>
							<form action="ControllerServlet" method="post">
								<input name="idDishDel" value="${cartItem.id}" type="hidden"/>
								<button type="submit" value="delete" name="action" class="btn btn-danger">
								Remove from cart</button> 
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
	Total sum:
	<c:out value="${cart.totalSum}"></c:out>
	<a href="#" onclick="$('#form-menu').submit()" > Back to menu</a>

	<form action="ControllerServlet" method="post">
			<button type="submit" value="order" name="action" class="btn btn-success">
			Create order</button>
	</form>

</body>
</html>