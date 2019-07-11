<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>판매자 상품등록 페이지입니다</title>
<link href="css/mingky.css" rel="stylesheet">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700"
	rel="stylesheet">


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<!-- 					왼쪽부분 사진넣는곳 -->
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img src="img/noimage.png" />
							</div>
							<div class="tab-pane" id="pic-2">
								<img src="img/noimage.png" />
							</div>
							<div class="tab-pane" id="pic-3">
								<img src="img/noimage.png" />
							</div>
							<div class="tab-pane" id="pic-4">
								<img src="img/noimage.png" />
							</div>
							<div class="tab-pane" id="pic-5">
								<img src="img/noimage.png" />
							</div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
							<li class="active"><a data-target="#pic-1" data-toggle="tab"><img
									src="img/noimage.png" /></a></li>
							<li><a data-target="#pic-2" data-toggle="tab"><img
									src="img/noimage.png" /></a></li>
							<li><a data-target="#pic-3" data-toggle="tab"><img
									src="img/noimage.png" /></a></li>
							<li><a data-target="#pic-4" data-toggle="tab"><img
									src="img/noimage.png" /></a></li>
							<li><a data-target="#pic-5" data-toggle="tab"><img
									src="img/noimage.png" /></a></li>
						</ul>

					</div>
					<div class="details col-md-6">
						<h3 class="product-title">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text" id="basic-addon1">제목</span>
								</div>
								<input type="text" class="form-control" placeholder="제목을 입력하세요."
									aria-label="제목을 입력하세요." aria-describedby="basic-addon1">
							</div>

						</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span
									class="fa fa-star checked"></span> <span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no"></span>
						</div>
						<div class="form-group">
							<p class="product-description">
								<label for="exampleFormControlTextarea1">제품설명</label>
								<textarea class="form-control" id="description" rows="3"
									placeholder="제품설명을 써주세요.">
							</textarea>
							</p>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="price">정가</span>
							</div>
							<input type="text" class="form-control" placeholder="정가를 입력하세요."
								aria-label="정가를 입력하세요." aria-describedby="basic-addon1">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="gprice">공동구매가</span>
							</div>
							<input type="text" class="form-control"
								placeholder="공동구매가를 입력하세요." aria-label="공동구매가를 입력하세요."
								aria-describedby="basic-addon1">
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="count">상품수량</span>
							</div>
							<input type="text" class="form-control"
								placeholder="상품수량을 입력해주세요." aria-label="상품수량을 입력해주세요."
								aria-describedby="basic-addon1">
						</div>
						<p class="vote">
							<strong>91%</strong> of buyers enjoyed this product! <strong>(87
								votes)</strong>
						</p>
						<h5 class="sizes">
							sizes: <span class="size" data-toggle="tooltip" title="small">s</span>
							<span class="size" data-toggle="tooltip" title="medium">m</span>
							<span class="size" data-toggle="tooltip" title="large">l</span> <span
								class="size" data-toggle="tooltip" title="xtra large">xl</span>
						</h5>
						<h5 class="colors">
							colors: <span class="color orange not-available"
								data-toggle="tooltip" title="Not In store"></span> <span
								class="color green"></span> <span class="color blue"></span>
						</h5>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button">add
								to cart</button>
							<button class="like btn btn-default" type="button">
								<span class="fa fa-heart"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>