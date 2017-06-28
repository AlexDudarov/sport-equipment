<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="sportequipment,sport,equipment">
<meta name="description" content="Sportequipment shop">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/css/Table.css" rel="stylesheet" type="text/css">
<link href="resources/img/favicon.png" rel="shortcut icon" type="image/x-icon">
<script type="text/javascript" src="jquery/jquery-3.2.0.js"></script>
<title>Товары</title>
</head>
<body>
<noscript>no js</noscript>
<c:import url="header.jsp"></c:import>
	<form method="post">
		<table class="bordered">
		<tr>
			<td></td>
			<td>Type</td>
			<td>Brand</td>
			<td>Model</td>
			<td>In stock</td>
			<td>Price</td>
			<td>In cart</td>
			</tr>
			<c:forEach var="good" items="${goods}">
				<tr>
					<td><div class="container"><img src="resources/img/${good.iconPath}.jpg"></div></td>
					<td>${good.type.name}</td>
					<td>${good.brand.name}</td>
					<td>${good.model}</td>
					<td>${good.availability}</td>
					<td>${good.price}</td>
					<td><input type="checkbox" onclick="if(this.checked){this.nextElementSibling.style.visibility='visible'}else {this.nextElementSibling.style.visibility='hidden';}" name="inCart" value="${good.id}"/>
					<input id="checkedGoods"  type="number" name="count" value="1" min="1" max="3"></td>
					
				</tr>
			</c:forEach>
		</table>
		<div class="right-side">
		<div>
		Brand
		<br>
		<c:forEach var="brand" items="${brands}">
		<input type="checkbox" name="brand" value="${brand.name}"/>${brand.name}<br>
		</c:forEach>
		</div>
		<br>
		<div>
		Type
		<br>
		<c:forEach var="type" items="${types}">
		<input type="checkbox" name="type" value="${type.name}"/>${type.name}<br>
		</c:forEach>
		</div>
		
		
		<input type="submit" formaction="Catalog" class="button" value="Подобрать"><br>
		<input type="submit" formaction="MyServlet?action=add_to_cart" class="button" value="Заказать"><br>
		<h3>${message}</h3>
		</div>
	</form>

		<c:import url="footer.jsp"></c:import>
</body>
</html>