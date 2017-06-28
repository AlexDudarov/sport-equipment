<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../resources/css/style.css" rel="stylesheet" type="text/css">
<link href="../resources/css/Table.css" rel="stylesheet" type="text/css">
<title>Корзина</title>
</head>
<body>
<c:import url="../header.jsp"/>
<div id="page-wrap">
<h2>${message}</h2>
<form method="post">
<table class="bordered">
		<tr>
			<td></td>
			<td>Type</td>
			<td>Brand</td>
			<td>Model</td>
			<td>Price</td>
			<td>Count</td>
			</tr>
			<c:forEach var="item" items="${sessionScope.orderItems}">
				<tr>
					<td><div class="container"><img src="img/${item.good.iconPath}.jpg"></div></td>
					<td>${item.good.type.name}</td>
					<td>${item.good.brand.name}</td>
					<td>${item.good.model}</td>
					<td>${item.good.price}</td>
					<td>${item.count}</td>
					
				</tr>
			</c:forEach>
		</table>
		<input type="submit" formaction="MyServlet?action=to_order" class="button" value="Заказать"><br>
		</form>
</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>