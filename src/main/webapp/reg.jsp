<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="header.jsp"/>
<div id="page-wrap">
	<form action="MyServlet?action=registration" method="post" name="registration">
		Username: <input type="text" name="login">
		Password: <input type="password" name="password"> 
		<input type="submit" class="button" value="Registrate">
		
	</form>
	</div>
	<c:import url="footer.jsp"></c:import>
</body>
</html>