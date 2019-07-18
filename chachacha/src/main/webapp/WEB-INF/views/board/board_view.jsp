<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp" />
<script src="js/view.js" charset="UTF-8"></script>
<title>게시판</title>
<script>
	$(function() {
		$('form').submit(function() {
			if ($("#board_pass").val() == '') {
				alert("비밀번호를 입력하세요");
				$("#board_pass").focus();
				return false;
			}
		});
	});
</script>
<style>
#count {
	position: relative;
	top: -10px;
	left: -10px;
	background: orange;
	color: white;
	border-radius: 30%;
}

*, ::after, ::before {
	box-sizing: border-box;
}
</style>
</head>
<body>
	<input type="hidden" id="loginid" value="${id}" name="loginid">
	<div class="container">
		<table class="table table-striped">
			<tr>
				<th colspan="2">게시판-view페이지</th>
			</tr>
			<tr>
				<td>
					<div>글쓴이</div>
				</td>
				<td>
					<div>${boarddata.BOARD_NAME}</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>제목</div>
				</td>
				<td>
					<div>${boarddata.BOARD_SUBJECT}</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>내용</div>
				</td>
				<td>
					<div>${boarddata.BOARD_CONTENT}</div>
				</td>
			</tr>
			<tr>
				<td>
					<div>첨부파일</div>
				</td>
				<c:if test="${!empty boarddata.BOARD_FILE}">
					<td><img src="image/down.png" width="10px"> <a
						href="./BoardFileDown.bo?filename=${boarddata.BOARD_FILE}&original=${boarddata.BOARD_ORIGINAL}">
						${boarddata.BOARD_ORIGINAL}</a>
					</td>
				</c:if>
				<c:if test="${empty boarddata.BOARD_FILE}">
					<td></td>
				</c:if>
			</tr>
			<tr>
				<td colspan="2" class="center">
				<a href="./BoardReplyView.bo?num=${boarddata.BOARD_NUM }">
						<button class="btn btn-primary">답글</button>
				</a>

					<button class="btn btn-primary start">댓글</button> <span id="count">${count}</span>
					<c:if test="${boarddata.BOARD_NAME == id || id == 'admin'}">
						<a href="./BoardModifyView.bo?num=${boarddata.BOARD_NUM}">
							<button class="btn btn-primary">수정</button>
						</a>
						<a href="#">
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#myModal">삭제</button>
						</a>
					</c:if> <a href="./BoardList.bo">
						<button class="btn btn-primary">목록</button>
				</a></td>
			</tr>
		</table>
		<%-- modal 시작 --%>
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal body -->
					<div class="modal-body">
						<form name="deleteForm" action="./BoardDeleteAction.bo"
							method="post">
							<%-- http://localhost:8088/Board_Ajax_bootstrap/BoardDeleteAction
						  주소를 보면 num을 파라미터로 넘기고 있습니다. 이 값을 가져와서 ${param.num}
						  또는 ${boarddata.BOARD_NUM} --%>
							<input type="hidden" name="num" value="${boarddata.BOARD_NUM}"
								id="BOARD_RE_REF">
							<div class="form-group">
								<label for="pwd">비밀번호</label> <input type="password"
									class="form-control" placeholder="Enter password"
									name="BOARD_PASS" id="board_pass">
							</div>
							<button type="submit" class="btn btn-primary">전송</button>
							<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div id="comment">
			<button class="btn btn-info float-left">총 50자 까지 가능합니다.</button>
			<button id="write" class="btn btn-info float-right">등록</button>
			<textarea rows=3 class="form-control" id="content" maxLength="50"></textarea>

			<table class="table table_striped">
				<thead>
					<tr>
						<td>아이디</td>
						<td>내용</td>
						<td>날짜</td>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
			<div id="message"></div>
		</div>

	</div>
</body>
</html>