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
<title>상품 상세페이지</title>
</head>
<body>
<h2>상품 상세정보</h2>
<table>
	<tr>
		<td>
			<img src="img/product/${vo.p_image}" width="340" height="300">
		</td>
		<td>
			<table border="1" style="height:300px; width:400px;">
				<tr align="center">
				<td>상품명</td>
				<td>${vo.p_name}</td>
				</tr>
				<tr align="center">
				<td>정가</td>
				<td><fmt:formatNumber value="${vo.p_price}" pattern="###,###,###"/></td>
				</tr>
				<tr align="center">
				<td>할인가</td>
				<td><fmt:formatNumber value="${vo.p_gprice}" pattern="###,###,###"/></td>
				</tr>
				<tr align="center">
					<td>구매제한</td>
					<td>최대 ${vo.p_limit}개</td>
				</tr>
				<tr align="center">
				<td colspan="2">
					<form name="addCart" method="post" action="addCart.bo">
						<input type="hidden" name="p_code" value="${vo.p_code}">
						<select name="c_amount">
							<c:forEach begin="1" end="10" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>&nbsp;개
						<input type="submit" value="장바구니">
						<input type="button" value="바로구매하기"> 					
					</form>
					<a href="productList.bo?p_category=${vo.p_category}">상품 목록</a>
				</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>