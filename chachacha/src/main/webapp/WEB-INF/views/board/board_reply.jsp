<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>MVC 게시판</title>
		<jsp:include page="header.jsp" />
		<script src="js/writeform.js" charset="UTF-8"></script>
		<style>
			tr.center-block {
				text-align : center;
			}
			
			h1 {
				font-size : 1.5em;
				text-align : center;
				color : #1a92b9;
			}
			
			.container {
				width : 60%;
			}
			
			label {
				font-weight : bold;
			}
			
			#upfile {
				display : none;
			}
			
			img {
				width : 20px;
			}
		</style>
</head>
<body>
	<div class="container">
		<form action="./BoardReplyAction.bo" method="post" name="boardform">
			<input type="hidden" name="BOARD_NUM" value="${boarddata.BOARD_NUM}">
			<input type="hidden" name="BOARD_RE_REF" value="${boarddata.BOARD_RE_REF}">
			<input type="hidden" name="BOARD_RE_LEV" value="${boarddata.BOARD_RE_LEV}">
			<input type="hidden" name="BOARD_RE_SEQ" value="${boarddata.BOARD_RE_SEQ}">
		
			<h1>게시판-Reply</h1>
			<div class="form-group">
				<label for="board_name">글쓴이</label>
				<input name="BOARD_NAME" id="board_name" value="${id}" readOnly type="text"
						class="form-control" placeholder="Enter board_name">
			</div>
			
			<div class="form-group">
				<label for="board_subject">제목</label>
				<input name="BOARD_SUBJECT" id="board_subject" type="text" class="form-control" 
					placeholder="Enter board_subject" value="Re: ${boarddata.BOARD_SUBJECT }" />
			</div>
			<div class="form-group">
				<label for="board_content">내용</label>
				<textarea name="BOARD_CONTENT" id="board_content" cols="67" rows="10" class="form-control"></textarea>
			</div>
			<div class="form-group">
				<label for="board_pass">비밀번호</label>
				<input name="BOARD_PASS" id="board_pass" type="password" size="10" maxlength="30"
						class="form-control" placeholder="Enter board_pass" autofocus>
			</div>
			<div class="form-group">
				<button type=submit class="btn btn-primary">등록</button>
				<button type=reset class="btn btn-danger">취소</button>
			</div>
		</form>
	</div>
</body>
</html>