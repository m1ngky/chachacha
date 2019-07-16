<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
			uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../header.jsp"></jsp:include>
<title>상품 장바구니 목록</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	//상품목록 페이지로 이동
	$("#productList").click(function(){
		location.href = "productList.bo";
	})
	
})
</script>
</head>
<body>
<h2>장바구니 확인</h2>
<div id="cart">
	<c:choose>
		<c:when test="${map.count == 0 }">
			장바구니가 비어있습니다.
		</c:when>
		<c:otherwise>
		<form name="CartUpdate" id="form1" method="post" action="CartUpdate.bo">
			<table class="table table-striped">
			<thead>
				<tr>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>할인가</th>
					<th>수량</th>
					<th>금액</th>
					<th>취소</th>
				</tr>
				</thead>
				<tbody>
				
				</tbody>
				<c:forEach var="row" items="${map.list}">
				<input type="hidden" id="cart_id" value="${row.c_no }" name="cartId">
				<tr>
					<td>${row.p_name}</td>
					<td style="width:80px" align="right">
						<fmt:formatNumber value="${row.p_gprice}" pattern="###,###,###"/>
					</td>
					<td>
						<input type="number" id="amount" style="width:40px" name="amount" value="${row.c_amount}" min="1">
						<input type="hidden" name="c_code" value="${row.p_code}">
					</td>
					<td style="width:100px" align="right">
						<fmt:formatNumber value="${row.money}" pattern="###,###,###"/>
					</td>
					<td>
						<a href="CartDelete.bo?cartId=${row.c_no }">삭제</a>
					</td>	
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						장바구니 금액 합계 : <fmt:formatNumber value="${map.sumMoney }"/><br>
						배송료 : ${map.fee}<br>
						전체 주문금액 : <fmt:formatNumber value="${map.allSum}" pattern="###,###,###"/>
					</td> 
				</tr>
			</table>
			<input type="hidden" name="count" value="${map.count}">
			<button type="submit" id="btnUpdate">수정</button>
		</form> 
		</c:otherwise>
	</c:choose>
</div>
	<button type="button" id="productList">상품목록</button>
</body>
</html>