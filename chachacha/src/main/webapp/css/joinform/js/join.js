
$(function(){
	   var checkid = false;
	   var checkemail = false;
	   
	   
	   $("form").submit(function() {
	      if(!checkid) {
	         alert("Please check your ID");
	         $("#id").val("").focus();
	         return false;
	      }
	      
	   });
	   
	   $("#id").on(
	      'input',function(){
	         checkid = false;
	         $('#message').empty();  // 처음에 pattern에 적합하지 않은 경우 
	         //[A-Za-z0-9_]의 의미가 \w
	         var pattern = /^\w{5,12}$/;
	         var id = $('#id').val();
	         if(!pattern.test(id)){
	            $('#message').css('color','red').html(
	                  "You can use 5 to 12 characters in English, number, and_");
	            return;
	         } else {
	            $.ajax({
	               url : "idcheck.net",
	               data : {"id":id},
	               success : function(resp) {
	                  if(resp == -1){
	                     $("#message").css('color','green').html(
	                           "This ID is available.");
	                     checkid=true;
	                  }else{
	                     $("#message").css('color','blue').html(
	                     "Unavailable ID");
	                  }
	               }
	            })
	         }
	      }
	   )
	   
	   
	   // 비밀번호 정규식(특수문자를 제외한 영문, 숫자 혼합 6~20자리 이내)
	  var checkpassword = false;
	   $("#password").on('input',function(){
		 var pattern2 = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; 
		 var password = $("#password").val();
		 $("#validate_password").empty();
    	  if(!pattern2.test(password)) {	// 패턴이랑 일치하지 않을때
    		  $("#validate_password").html("Write it down according to the pattern");
    		  return false;
    	  }else{	// 패턴이랑 일치할때 
    		  $("#repeat-password").keyup(function(){
    		
    			  if($("#password").val() != $("#repeat-password").val()){
    				  $("#validate_passcheck").css('color','red').html("Password doesn't match.");
    				  return false;
    			  }
    			  else{
    			    $("#validate_passcheck").css('color','blue').html("The password matches");
    				}
    		  })
    	  }
	  })
	});
