<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link href = "css/header.css" rel="stylesheet">
<header>
		<div class="sticky-nav">
			<a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>

			<div id="logo">
				<a id="goUp" href="home"
					title="CHACHACHA">CHACHACHA</a>
			</div>

			<nav id="menu">
				<ul id="menu-nav">

					<li class="current"><a href="home">Home</a></li>

					<li class="current"><a href="#home-slider">Home</a></li>
					
					<c:if test="${!empty id}">
				    <li><a href="logout.net">${id}님(Logout)</a></li>
				    </c:if>
					
					<c:if test="${empty id}">

					<li><a href="login.net">Login</a></li>
					</c:if>
					
					<li><a href="productcommit.cha">상품등록</a></li>
					<li><a href="BoardList.bo">게시판</a></li>					
					<li><a href="#contact">Contact</a></li>
					<li><a href="shortcodes.html" class="external">Shortcodes</a></li>
				</ul>
			</nav>

		</div>
</header>