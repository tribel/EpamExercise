<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		class="com.restaurant.web.beans.AdminBean" />
	<c:if test="${cart.getCartItemCount()==0 }">
		<h2><fmt:message key="cart.label.empty"/></h2>
	</c:if>
	
		<table class="table table-hover">

			<thead>
				<tr>
					<th>Блюдо</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach var="cartItem" items="${cart.dishList}">
					<tr>
						<td>${cartItem.name}</td>
						
					
					</tr>
					
				</c:forEach>
			</tbody>
		</table>
		
		


</body>
</html>