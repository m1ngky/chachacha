<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 정보</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<style>
body {
	background-color: #f2f2f2;
}

.table {
	background-color: #fff;
	box-shadow: 0px 2px 2px #aaa;
	margin-top: 50px;
	font-size: 16px;
}
</style>
</head>


<body>


	<jsp:include page="../header.jsp" />
	<div class="container">
		<div class="row">

			<table class="table table-bordered">
				<tr>
					<th> <th>
					<th>상품코드</th>
					<th>상품이름</th>
					<th>판매자</th>
				</tr>

				<c:forEach var="list" items="${productlist}">
					<tr>
						<td><img src="${list.p_savefile}"></td>
						<td>${list.p_code}</td>
						<td>${list.p_name}</td>
						<td>${list.p_sellername}</td>
					</tr>
				</c:forEach>



			</table>
		</div>
	</div>
</body>
</html>