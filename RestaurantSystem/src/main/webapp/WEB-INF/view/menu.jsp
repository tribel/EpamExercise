
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/template/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h3>menu page</h3>

	<form  class="custom-select">
		<select name="category"  class="form-control" onselect="$('#form-menu').submit();this.form.submit()">
			<c:forEach var="item" items="${requestScope.categoryList}">
				<option value="${item}">${item}</option>
			</c:forEach>
		</select>
	</form>
	<div class="sub-header">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="dish" items="${requestScope.menuList}">
				<tr>
					<td>${dish.name}</td>
					<td>${dish.price}</td>
					
					<td>
						<form action="ControllerServlet" method="post">
								<input name="idDish" value="${dish.id}" type="hidden"/>		
								<button type="submit" value="add" name="action" class="btn btn-default">
								Add to cart</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</div>
	<a href="cart" title="Go to cart" class="btn btn-success" role="button">  To cart</a>
	

</body>
</html>