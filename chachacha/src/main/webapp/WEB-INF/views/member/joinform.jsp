<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Sign up</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="css/joinform/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="css/joinform/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="css/joinform/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/joinform/css/util.css">
	<link rel="stylesheet" type="text/css" href="css/joinform/css/main.css">
<!--===============================================================================================-->
<script src="css/joinform/js/jquery-3.0.0.js"></script>
<script src="css/joinform/js/join.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


</head>

<body style="background-color: #999999;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="login100-more" style="background-image: url('css/joinform/images/bg-01.jpg');"></div>

			<div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
				<form class="login100-form validate-form" name="joinform" action="joinProcess.net">
					<span class="login100-form-title p-b-59">
						Sign Up
					</span>

					<div class="wrap-input100 validate-input" data-validate="Name is required">
						<span class="label-input100">Name</span>
						<input class="input100" type="text" name="name" placeholder="">
						<span class="focus-input100"></span>
					</div>
					
				    <div class="wrap-input100 validate-input" data-validate="NickName is required">
						<span class="label-input100">NickName</span>
						<input id="nickname" class="input100" type="text" name="nickname" placeholder="">
						<span id="nicknamecheck"></span>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<span class="label-input100">Email</span>
						<input id="email" class="input100" type="text" name="email" placeholder="">
						<span id="emailcheck"></span>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="ID is required">
						<span class="label-input100">ID</span>
						
						<input class="input100" type="text" id="id" name="id" placeholder="">
						<span id="message"></span>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<span class="label-input100">Password</span>
						<input id="password" class="input100" type="text" name="password" placeholder="*************">
						<span id="validate_password"></span>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Repeat Password is required">
						<span class="label-input100">Repeat Password</span>
						<input id="repeat_password" class="input100" type="text" name="repeat-password" placeholder="*************">
						<span id="validate_passcheck"></span>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "PhoneNumber is required">
						<span class="label-input100">PhoneNumber</span>
						<input class="input100" type="text" name="phonenumber" id="phonenumber" placeholder="010-1234-5678">
						<span id="phonecheck"></span>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Address is required">
						<span class="label-input100">Address</span>
						<input class="input100" type="text" name="address" placeholder="">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Date of Birth is required">
					<span class="label-input100">Date of Birth</span><br><br>
					<input type="date" id="birthdate" name="birthdate" class="form-control"><br>
					<input id="birth" class="input100" type="text" name="birth" placeholder="..." readonly>
					<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input">
						<span class="label-input100">Gender</span><br><br>
						  <label class="gender"> 
                              <input type="radio" name="gender" value="male" checked>
                              <span> Male </span> 
                              </label>&nbsp;&nbsp;&nbsp;
                           <label class="gender"> 
                              <input type="radio" name="gender" value="female">
                              <span>Female </span> 
                              </label>
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Account is required">
						<span class="label-input100">Account</span><br><br>
						 <select id="bankselect" class="form-control" name="bankselect" style="width:30%;height:27%;">
						    <option value="">은행</option>
                            <option value="농협은행  :   ">농협은행</option>
                            <option value="신한은행  :   ">신한은행</option>
                            <option value="기업은행  :   ">기업은행</option>
                            <option value="우리은행  :   ">우리은행</option>
                            <option value="국민은행  :   ">국민은행</option>
                        </select>
						<input id="account" class="input100" type="text" name="account" placeholder="12345-67-890123">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-m w-full p-b-33">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								<span class="txt1">
									I agree to the
									<a href="#" class="txt2 hov1">
										Terms of User
									</a>
								</span>
							</label>
						</div>

						
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Sign Up
							</button>
						</div>
						</div>
						</form>

						<a href="login.net" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">
							Sign in
							<i class="fa fa-long-arrow-right m-l-5"></i>
						</a>
					</div>
			</div>
		</div>
	
<!--===============================================================================================-->
	<script src="css/joinform/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="css/joinform/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="css/joinform/vendor/bootstrap/js/popper.js"></script>
	<script src="css/joinform/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="css/joinform/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="css/joinform/vendor/daterangepicker/moment.min.js"></script>
	<script src="css/joinform/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="css/joinform/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="css/joinform/js/main.js"></script>
</body>
</html>