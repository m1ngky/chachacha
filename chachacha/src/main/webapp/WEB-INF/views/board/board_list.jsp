<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header.jsp" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="js/list.js"></script>
<title>MVC 게시판</title>
<style>
.center-block {
	display: flex;
	justify-content: center; /* 가운데 정렬 */
}
</style>
</head>
<body>
	<div class="container">

		<%-- 게시글이 있는경우 --%>
		<c:if test="${listcount>0 }">

			<div class="rows">
				<span>줄보기</span> <select class="form-control" id="viewcount">
					<option value="1">1</option>
					<option value="3">3</option>
					<option value="5">5</option>
					<option value="7">7</option>
					<option value="10" selected>10</option>
				</select>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th colspan="3">MVC 게시판 - list</th>
						<th colspan="2"><font size=3>글 개수 : ${listcount }</font></th>
					</tr>
					<tr>
						<th width="8%"><div>번호</div></th>
						<th width="50%"><div>제목</div></th>
						<th width="14%"><div>작성자</div></th>
						<th width="17%"><div>날짜</div></th>
						<th width="11%"><div>조회수</div></th>
					</tr>

				</thead>

				<tbody>
					<c:set var="num" value="${listcount-(page-1)*limit }" />
					<c:forEach var="list" items="${boardlist}">
						<tr>
							<td width="8%"><c:out value="${num }" /> <%-- num출력 --%> <c:set
									var="num" value="${num-1 }" /> <%-- num=num-1; 의미 --%></td>
							<td>
								<div>
										<!-- 원문인 경우 -->
                              &nbsp;      
      
      
									<a href="./BoardDetailAction.bo?num=${list.Num }">
										${list.Subject } </a>
								</div>
							</td>

							<td width="14%"><div>${list.id }</div></td>
							<td width="17%"><div>${list.InputDate}</div></td>
							<td width="11%"><div>${list.readcount }</div></td>
						</tr>
					</c:forEach>


				</tbody>


			</table>
			<div class="center-block">
				<div class="row">
					<div class="col">

						<ul class="pagination">

							<c:if test="${page <= 1 }">
								<li class="page-item"><a class="page-link">이전&nbsp;</a></li>
							</c:if>
							<c:if test="${page > 1 }">
								<li class="page-item"><a
									href="./BoardList.bo?page=${page-1 }" class="page-link">이전&nbsp;</a></li>
							</c:if>

							<%--숫자 나온는것 처리 --%>
							<c:forEach var="a" begin="${startpage }" end="${endpage }">

								<c:if test="${a==page}">
									<li class="page-item"><a class="page-link gray">${a }</a>
									</li>
								</c:if>

								<c:if test="${a!=page}">
									<li class="page-item"><a href="./BoardList.bo?page=${a }"
										class="page-link gray">${a }</a></li>
								</c:if>
							</c:forEach>

							<c:if test="${page>=maxpage}">
								<li class="page-item"><a class="page-link ">&nbsp;다음</a></li>
							</c:if>
							<c:if test="${page < maxpage}">
								<li class="page-item"><a
									href="./BoardList.bo?page=${page+1 }" class="page-link ">&nbsp;다음</a>
								</li>
							</c:if>



						</ul>
					</div>
				</div>
			</div>


		</c:if>


		<!-- 게시글이 없는경우 -->
		<c:if test="${listcount == 0 }">
			<font size=5>등록된 글이 없습니다.</font>
		</c:if>

		<button type="button" class="btn btn-info float-right">글 쓰 기</button>
	</div>
</body>
</html>