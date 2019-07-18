<%@ page import="c.h.a.domain.Member"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드</title>
<jsp:include page="../header.jsp" />
<style>
.center-block {
	display: flex;
	justify-content: center; /* 가운데 정렬 */
}

select.form-control {
	width: auto;
	margin-bottom: 2em;
	display: inline-block
}

.rows {
	text-align: right;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<form action="search.net">
		<div class="input-group">
			<select id="viewcount" name="search_field">
				<option value="0" selected>아이디</option>
				<option value="1">이름</option>
				<option value="2">나이</option>
				<option value="3">성별</option>
			</select> <input name="search_word" type="text" class="form-control"
				placeholder="Search">
			<button class="btn btn-primary" type="submit">검색</button>
		</div>
	</form>

	<table class="table table-striped">
		<thead>
			<tr>
				<td colspan=3>회원목록</td>
			</tr>
			<tr>
				<th width="20%"><div>아이디</div></th>
				<th width="20%"><div>비밀번호</div></th>
				<th width="20%"><div>이름</div></th>
				<th width="20%"><div>이메일</div></th>
				<th width="20%"><div>등급</div></th>
				<th width="20%"><div>삭제</div></th>

			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Member> arr = (ArrayList<Member>) request.getAttribute("memberlist");
				for (Member m : arr) {
			%>
			<tr>

				<th width="15%"><div>
						<%=m.getId()%>					
				</div></th>
				
				<th width="15%"><div>
						<%=m.getPassword()%>					
				</div></th>

				<th width="15%"><div>
						<%=m.getName()%>
				</div></th>
				
				<th width="15%"><div>
						<%=m.getEmail()%>
				</div></th>
				
				<th width="15%"><div>
						<%=m.getGrade()%>
				</div></th>
				
				<th width="15%"><div>
						<a href="member_delete.net?id=<%=m.getId()%>">삭제</a>
				</div></th>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<input type="button" value="이전 페이지로 이동" onclick="history.back();">
</body>
</html>