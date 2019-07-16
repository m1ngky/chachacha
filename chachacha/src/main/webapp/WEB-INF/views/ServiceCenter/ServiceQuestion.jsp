<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<title>MVC 게시판</title>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<jsp:include page="../header.jsp" />
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
		<form action="ServiceAdd.bo" method="post" enctype="multipart/form-data" name="boardform">
			<h1>고객센터 1:1문의</h1>
			<div class="form-group">
				<label for="select">문의</label><br>
				<select name="ccategory">
					<option selected>1:1문의</option> 
					<option value="d">배송</option> 
					<option value="c">환불/교환</option> 
					<option	value="s">주문/결제</option>
					<option value="r">영수증/증빙서류</option>
					<option value="m">마일리지</option>
					<option value="o">기타</option>
				</select>
			</div>
			<div class="form-group">
				<label for="name">글쓴이</label>
				<input name="name" id="board_name" value="${id}" readOnly type="text" size="10" maxlength="30" 
						class="form-control" placeholder="Enter board_name">
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label>
				<input name="password" id="board_pass" type="password" size="10" maxlength="30"
						class="form-control" placeholder="Enter board_pass" autofocus>
			</div>
			<div class="form-group">
				<label for="subject">제목</label>
				<input name="subject" id="board_subject" type="text" class="form-control" placeholder="Enter board_subject">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea name="content" id="board_content" cols="67" rows="10" class="form-control"></textarea>
			</div>
			<div class="form-group">
				<label for="filename">파일 첨부</label>
				<label for="upfile">
					<img src="image/attach.png" alt="사막">
				</label>
				<input type="file" id="upfile" name="uploadfile">
				<span id="filevalue"></span>
			</div>
			<div class="form-group">
				<button type=submit class="btn btn-primary">등록</button>
				<button type=reset class="btn btn-danger">취소</button>
			</div>
		</form>
	</div>
</body>
</html>