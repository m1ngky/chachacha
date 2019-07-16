<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"/>
<title>상품 목록 리스트 - productList.jsp</title>
<style>
.item{
	width:300px;
	float:left;
	maring:0 13px;
	text-align:center
}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("img").onclick(function(){
		location.href="product";
	})
})

</script>
</head>
<body>
<div class="container">
	<!-- 상품 목록이 있는 경우 --> 
		<h2>상품 목록</h2>
			<c:forEach var="row" items="${plist}">
				<div class="item">
		
						<a href="ProductDetail.bo?p_code=${row.p_code }">
							<img src="img/product/${row.p_image}" width="250px" height="200px">
						</a>
						<h3>
						<a href="ProductDetail.bo?p_code=${row.p_code }">
							${row.p_name}
						</a></h3>
						<p>정가 :<fmt:formatNumber value="${row.p_price}" pattern="###,###,###"/>원</p>
						<p>할인가  : <fmt:formatNumber value="${row.p_gprice}" pattern="###,###,###"/>원</p>
					
				</div>
			</c:forEach>
		
</div>

</body>
</html>

