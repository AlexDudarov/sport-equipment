<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
<link href="resources/img/favicon.png" rel="shortcut icon" type="image/x-icon">


	<header>
		<a href="index.jsp" title="На главную" id="logo">Sport shop</a>
		<span class="contact"><a href="about.jsp">О нас</a></span>
		  <input type="text" class="field" placeholder="Найти">
		   <span class="right">

		   		<span class="contact">
		   			<a href="reg.jsp" title="Зарегистрироваться">Регистрация</a>
		   		</span>
		   		<span class="contact">
		    		<a href="login.jsp" title="Войти">Вход</a>
		   		</span> 
		   		<c:if test="${sessionScope.role eq 'admin' or 'user'}">
					<span class="contact">
					 <a href="MyServlet?action=exit">Выход</a>
					</span>
				</c:if>
	</span>
	</header>
	
	<nav>
		<ul>
			<li><a href="index.jsp">Главная</a></li>
			<li><a href="Catalog">Каталог</a></li>
			<li><a href="contacts.jsp">Контакты</a></li>
			<li><a href="MyServlet?action=Shopping_Cart">Корзина</a></li>
			<c:if test="${sessionScope.role eq 'admin'}"><li><a href="MyServlet?action=administration">Администрирование</a></li></c:if>
		</ul>
	</nav>
	

