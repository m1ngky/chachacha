<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>판매자 상품등록 페이지입니다</title>
<link href="css/mingky.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript" src="js/productcommit/img.js"></script>


<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700"
	rel="stylesheet">
<style>
#cart {
	background-color: #DE5E60;
	color: #fff;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>



	<div class="container">
		<form name=addproduct action="addproduct" method="POST" enctype="multipart/form-data">
			<div class="card">
				<div class="container-fliud">
					<div class="wrapper row">
						<!-- 왼쪽부분 사진넣는곳 -->
						<div class="preview col-md-6">

							<div class="preview-pic tab-content">
								<div class="tab-pane active" id="pic-1">
									<label>
									<input type="file" name="uploadfile"
										accept="image/gif, image/jpeg, image/png" style="display: none">									
									<img src="img/noimage.png" />
									</label>
								</div>
<!-- 								<div class="tab-pane" id="pic-2"> -->
<!-- 									<img src="img/noimage.png" /> -->
<!-- 								</div> -->
<!-- 								<div class="tab-pane" id="pic-3"> -->
<!-- 									<img src="img/noimage.png" /> -->
<!-- 								</div> -->
<!-- 								<div class="tab-pane" id="pic-4"> -->
<!-- 									<img src="img/noimage.png" /> -->
<!-- 								</div> -->
<!-- 								<div class="tab-pane" id="pic-5"> -->
<!-- 									<img src="img/noimage.png" /> -->
<!-- 								</div> -->
							</div>
<!-- 							<ul class="preview-thumbnail nav nav-tabs"> -->
<!-- 								<li class="active"><a data-target="#pic-1" -->
<!-- 									data-toggle="tab"><img src="img/noimage.png" /></a></li> -->
<!-- 								<li><a data-target="#pic-2" data-toggle="tab"><img -->
<!-- 										src="img/noimage.png" /></a></li> -->
<!-- 								<li><a data-target="#pic-3" data-toggle="tab"><img -->
<!-- 										src="img/noimage.png" /></a></li> -->
<!-- 								<li><a data-target="#pic-4" data-toggle="tab"><img -->
<!-- 										src="img/noimage.png" /></a></li> -->
<!-- 								<li><a data-target="#pic-5" data-toggle="tab"><img -->
<!-- 										src="img/noimage.png" /></a></li> -->
<!-- 							</ul> -->

						</div>
						<div class="details col-md-6">
							<h3 class="product-title">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1 ">제목</span>
									</div>
									<input type="text" class="form-control"
										placeholder="제목을 입력하세요." aria-label="제목을 입력하세요."
										aria-describedby="basic-addon1" id="p_name" name="p_name">
								</div>

							</h3>

							<div class="form-group">
								<p class="product-description">
									<label for="exampleFormControlTextarea1">제품설명</label>
									<textarea class="form-control" id="p_description" rows="3"
										placeholder="제품설명을 써주세요." name="p_description">
							</textarea>
								</p>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="price">정가</span>
								</div>
								<input type="text" class="form-control" placeholder="정가를 입력하세요."
									aria-label="정가를 입력하세요." aria-describedby="basic-addon1"
									name="p_price" id="p_price">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="gprice">공동구매가</span>
								</div>
								<input type="text" class="form-control"
									placeholder="공동구매가를 입력하세요." aria-label="공동구매가를 입력하세요."
									aria-describedby="basic-addon1" name="p_gprice" id="p_gprice">
							</div>

							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="count">상품수량</span>
								</div>
								<input type="text" class="form-control"
									placeholder="상품수량을 입력해주세요." aria-label="상품수량을 입력해주세요."
									aria-describedby="basic-addon1" name="p_count" id="p_count">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="limit">구매제한 개수</span>
								</div>
								<input type="text" class="form-control"
									placeholder="구매제한 개수입력해주세요." aria-label="구매제한 개수 를입력해주세요."
									aria-describedby="basic-addon1" name="p_limit" id="p_limit">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="sellername">판매자이름</span>
								</div>
								<input type="text" class="form-control"
									placeholder="판매자이름을  입력해주세요." aria-label="판매자이름을 입력해주세요."
									aria-describedby="basic-addon1" name="p_sellername"
									id="p_sellername">
							</div>

							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="code">상품 코드</span>
								</div>
								<input type="text" class="form-control"
									placeholder="상품코드를 입력해주세요." aria-label="상품코드를 입력해주세요."
									aria-describedby="basic-addon1" name="p_code" id="p_code">
							</div>


							<div class="action">
								<button class="add-to-cart btn btn-default" type="submit"
									id="add">판매상품 등록</button>
								<button class="like btn btn-default" type="button">
									<span class="fa fa-heart"></span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>



</body>
</html>