
$(function(){
	   var checkid = false;
	   var checkphone = false;
	   var checkpass = false;
	   var checkemail = false;
	   var checknickname = false;

	   
	   $("form").submit(function() {
	      if(!checkid) {
	         alert("ID를 확인해주세요");
	         $("#id").val("").focus();
	         return false;
	      }
	   });
	   
	   $("form").submit(function() {
		      if(!checkemail) {
		         alert("이메일을 확인해주세요");
		         $("#email").val("").focus();
		         return false;
		      }
		   });
	   
	   $("form").submit(function() {
		      if(!checkpass) {
		         alert("비밀번호를 확인해주세요");
		         $("#password").val("").focus();
		         return false;
		      }
		   });
	   
	   $("form").submit(function() {
		      if(!checkphone) {
		         alert("휴대폰 번호를 확인해주세요");
		         $("#phonenumber").val("").focus();
		         return false;
		      }
		   });
	   
	   $("form").submit(function() {
		      if(!checknickname) {
		         alert("닉네임을 확인해주세요");
		         $("#nickname").val("").focus();
		         return false;
		      }
		   });
	   
	   
	   
	   $("#id").on('input',function(){
	         checkid = false;
	         $('#message').val(""); 
	         var pattern = /^\w{5,12}$/;
	         var id = $('#id').val();
	         if(!pattern.test(id)){
	            $('#message').css('color','#cf86db').html(
	                  "5~15자의 영문자, 숫자 및 _의 조합으로 입력해주세요");
	            checkid = false;
	         } else {
	            $.ajax({
	               url : "idcheck.net",
	               data : {"id":id},
	               success : function(resp) {
	                  if(resp == -1){
	                     $("#message").css('color','#17a2b8ad').html(
	                           "사용 가능한 아이디입니다.");
	                     checkid=true;
	                  }else{
	                     $("#message").css('color','#cf86db').html(
	                     "이미 사용 중인 아이디입니다.");
	                     checkid = false
	                  }
	               }
	            })
	         }
	      }
	   )
	   
	$("#email").on('input',function(){
		checkemail = false
		$('#emailcheck').val("");  
		var pattern = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/;
		var email = $('#email').val();
		
		if(!pattern.test(email)){
            $('#emailcheck').css('color','#cf86db').html(
                  "이메일 형식으로 입력해주세요");
            checkid = false;
         } else {
	         $.ajax({
	               url : "emailcheck.net",
	               data : {"email":email},
	               success : function(resp) {
	                  if(resp == -1){
	                     $("#emailcheck").css('color','#17a2b8ad').html(
	                           "사용 가능한 이메일 입니다.");
	                     checkemail=true;
	                  }else{
	                     $("#emailcheck").css('color','#cf86db').html(
	                     "이미 사용 중인 이메일 입니다.");
	                     checkemail = false
	                  }
	               }
	            })
	         }
	      }
	   )
	   
	   
	   
	   	$("#nickname").on('input',function(){
	   		checknickname = false
	   		$('#nicknamecheck').val("");  
	   		var nickname = $('#nickname').val();
		
	         $.ajax({
	               url : "nicknamecheck.net",
	               data : {"nickname":nickname},
	               success : function(resp) {
	                  if(resp == -1){
	                     $("#nicknamecheck").css('color','#17a2b8ad').html(
	                           "사용 가능한 닉네임 입니다.");
	                     checknickname=true;
	                  }else{
	                     $("#nicknamecheck").css('color','#cf86db').html(
	                     "이미 사용 중인 닉네임 입니다.");
	                     checknickname = false
	                  }
	               }
	            })
	      }
	   )
	   
	   
	   
	    $("#password").on('input',function(){
	         checkpass = false;
	         $('#message').empty();  
	         
	         var pattern = /^\w{5,12}$/;
	         var password = $('#password').val();
	         var password2 = $('#repeat_password').val();
	         
	         if(!pattern.test(password)){   
	            $('#validate_password').css('color','#cf86db').html(
	                  "5~15자의 영문자, 숫자 및 _의 조합으로 입력해주세요");  
	            return;
	         } else {  
	        	 $('#validate_password').html("");
	        	 
	        	 $("#repeat_password").keyup(function(){ 
	        		 if($("#password").val() != $("#repeat_password").val()){  
	        			 $("#validate_passcheck").css('color','#cf86db').html("비밀번호가 일치하지 않습니다.");  
	        			 return;
	        		 }else {
	        			 $("#validate_passcheck").html(""); 
	     			   checkpass = true;
	     		}
    		})
    	  }
	    })
	  
	  
	  
	  	$('#phonenumber').keyup(function(){
		checkphone = false;
		var pattern = /^\d{3}-\d{3,4}-\d{4}$/;
		var phonenumber = $('#phonenumber').val();
		if(!pattern.test(phonenumber)){  
            $('#phonecheck').css('color','#cf86db').html(
                  "휴대폰 번호를 정확히 입력해주세요");  
            return;
         }else{
           $('#phonecheck').html("");
           checkphone = true;
	}
})
	  
	  
	});



$(function(){
	  $('#bankselect').change(function(){
	    	var bankselect = $('#bankselect').val();
	    	$('#account').val(bankselect).focus();
	    })
})




