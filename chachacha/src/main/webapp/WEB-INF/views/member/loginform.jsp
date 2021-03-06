<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="css/loginform/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="css/loginform/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="css/loginform/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/loginform/css/util.css">
	<link rel="stylesheet" type="text/css" href="css/loginform/css/main.css">
<!--===============================================================================================-->

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(css/loginform/images/bg-01.jpg);">
					<span class="login100-form-title-1">
						Sign In
					</span>
				</div>

				<form class="login100-form validate-form" name="loginform" action = "loginProcess.net">
					<div class="wrap-input100 validate-input m-b-26" data-validate="userid is required">
						<span class="label-input100">Id</span>
						<input class="input100" type="text" name="id" placeholder="Enter userid">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="password" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>


					  <div class="flex-sb-m w-full p-b-30">
				 
						<!-- <div class="contact100-form-checkbox">
						
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
							
						</div>  -->
						<div>
					<div class="contact100-form-checkbox">
						<div>
							<a href="join.net" class="txt1">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me" onClick="location.href='join.net'">
							<label class="label-checkbox100" for="ckb1">
								회원이 아니신가요?
							</label>
							</a>
						</div>
					</div>
					<br>
					<div class="container-login100-form-btn">
					<input type="submit" class="login100-form-btn" value="Login">
					</div>
					</div>
					
					
					
				</form>
				<!-- 
				<a href="join.net">
						<button class="join100">
							Sign up
						</button>
						</a> -->
					
			</div>
		</div>
	</div>
	
<!--===============================================================================================-->
	<script src="css/loginform/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="css/loginform/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="css/loginform/vendor/bootstrap/js/popper.js"></script>
	<script src="css/loginform/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="css/loginform/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="css/loginform/vendor/daterangepicker/moment.min.js"></script>
	<script src="css/loginform/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="css/loginform/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="css/loginform/js/main.js"></script>

</body>
</html>