<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
	<script>
		alert("${id}님이 로그아웃 되었습니다.");
		location.href="/a/home"
	</script>
	<%session.invalidate(); %>
</body>
</html>