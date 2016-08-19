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
			 padding-top: 50px;
  			 padding-bottom: 40px;
             background-color: #eee;
             width: 60%;
             margin: auto;
		}
		
	</style>
</head>
<body>
	<h3><fmt:message key="menu.label.page"/></h3>
		
			<form  class="custom-select" method="post" >
				<select name="category"  class="form-control" >
					<c:forEach var="item" items="${requestScope.categoryList}">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
			
				<button type="submit" value="menu" name="action" class="btn btn-info" style="float: right;">
					<fmt:message key="menu.button.select"/>
				</button>
			</form>
	
		
			

	<div class="sub-header">
	<table class="table table-hover">
		<thead>
			<tr>
				<th><fmt:message key="menu.label.name"/></th>
				<th><fmt:message key="menu.label.price"/></th>

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
								<fmt:message key="menu.button.addToCart"/></button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</div>
	<a href="cart" title="Go to cart" class="btn btn-success" role="button"><fmt:message key="menu.label.toCart"/></a>
	

</body>
</html>