/*function go(page) {
	var limit = $('#viewcount').val();
	var data = "limit=" + limit + "&state=ajax&page=" + page;
	ajax(data);
}

function setPaging(page, href, digit){
	output += "<li class=page-item>";
	gray="";
	if(href=="") {
		gray="gray";
	}
	anchor = "<a class='page-link " + gray + "'" 
	        + href + ">"+ digit + "</a></li>";
	output += anchor;
}

function ajax(data) {
	// 1줄보기 선택시 리턴된 데이터
	
	 {"page":1,"maxpage":6,"startpage":1,"endpage":6,"listcount":6,"limit":1,
	  "boardlist":[{"BOARD_NUM":6,"BOARD_NAME":"admin","BOARD_SUBJECT":"1","BOARD_CONTENT":"1","BOARD_RE_REF":6,"BOARD_RE_LEV":0,"BOARD_RE_SEQ":0,"BOARD_READCOUNT":0,"BOARD_DATE":"2019-05-26"}]}
	 
	console.log(data)
	output = "";
	$.ajax({
		type : "POST",
		data : data,
//		url : "BoardList.bo",
		url : "BoardListAjax.bo",
		dataType : "json",
		cache : false,
		success : function(data) {
			$("#viewcount").val(data.limit);
			$("table").find("font").text("글 개수 : " + data.listcount);

			if (data.listcount > 0) { // 총갯수가 0개이상인 경우
				$("tbody").remove();
				var num = data.listcount - (data.page - 1) * data.limit;
				console.log(num)
				output = "<tbody>";
				$(data.boardlist).each(
					function(index, item) {
						output += '<tr><td>' + (num--) + '</td>'
						blank_count = item.board_RE_LEV * 2 + 1;
						blank = '&nbsp;';
						for (var i = 0; i < blank_count; i++) {
							blank += '&nbsp;&nbsp;';
						}
						img="";
						if (item.board_RE_LEV > 0) {
							img="<img src='image/AnswerLine.gif'>";
						}
							
						output +=  "<td><div>" + blank + img
						output += ' <a href="./BoardDetailAction.bo?num='
							     + item.board_NUM + '&page='
								 + data.page + '">'
						output += item.board_SUBJECT + '</a></div></td>'
						output += '<td><div>' + item.board_NAME+'</div></td>'
						output += '<td><div>' + item.board_DATE+'</div></td>'
						output += '<td><div>' + item.board_READCOUNT
								+ '</div></td></tr>'
					})
				output += "</tbody>"
				$('table').append(output)//table 완성
				
				$(".pagination").empty(); //페이징 처리
				output = "";
				
				digit = '이전&nbsp;'
				href="";	
				if (data.page > 1) {
					href = 'href=javascript:go(' + (data.page - 1) + ')';
				}
				setPaging(data.page, href, digit);
				
				for (var i = data.startpage; i <= data.endpage; i++) {
					digit = i;
					href="";
					if (i != data.page) {
						href = 'href=javascript:go(' + i + ')';
					} 
					setPaging(data.page, href, digit);
				}
				
				digit = '다음&nbsp;';
				href="";
				if (data.page < data.maxpage) {
					href = 'href=javascript:go(' + (data.page + 1) + ')';
				} 
				setPaging(data.page, href, digit);

				$('.pagination').append(output)
			}//if(data.listcount) end
		}, //success end
		error : function() {
			console.log('에러')
		}
	})// ajax end
 } // fucntion ajax end

$(function() {
	$("#viewcount").change(function() {
		go(1);//보여줄 페이지를 1페이지로 설정합니다.
	});// change end

   	  $("button").click(function(){
   		  location.href="BoardWrite.bo";
     })
})
*/ // 원래 내가 사용하던 js

// 아래는 현기한테 받은 js
function go(page) {
   var limit = $('#viewcount').val();
   var data = "limit=" + limit + "&state=ajax&page=" + page;
   ajax(data);
}

function setPaging(href, digit){
   output += "<li class=page-item>";
   gray="";
   if(href==""){
      gray="gray";
   }
   anchor = "<a class ='page-link " + gray +  "' " + href + ">"+digit+"</a></li>";
   output += anchor;
}


function ajax(data){
   // 1줄 보기 선택시 리턴된 데이터
   /*
    * 
    */
   console.log(data)
   output=""
      
      
      
$.ajax({   
   type : "POST",
   data : data,
   url : "BoardListAjax.bo",
   dataType : "json",
   cache : false,
   success : function(data) {
         $("#viewcount").val(data.limit);
         $("table").find("font").text("글 개수 : "+ data.listcount);
         
         if(data.listcount > 0) { // 총 갯수가 0개 이상인 경우
            $("tbody").remove();
            var num = data.listcount - (data.page -1) * data.limit;
            console.log(num)
            output = "<tbody>";
            $(data.boardlist).each(
                  function(index, item){
                     output += '<tr><td>' + (num--) + '</td>'
                     blank_count = item.board_RE_LEV * 2 + 1;
                     blank = '&nbsp;';
                     for ( var i = 0;  i< blank_count; i ++){
                        blank += '&nbsp;&nbsp';
                     }
                     img="";
                     if(item.board_RE_LEV >0){
                        img = "<img src='image/AnswerLine.gif'>";
                     }
                     output += "<td><div>" + blank + img
                     output += ' <a href="BoardDetailAction.bo?num='
                        +item.board_NUM + '&page='
                        +data.page + '">'
                     output += item.board_SUBJECT +'</a></div></td>'
                     output += '<td><div>' + item.board_NAME+'</div></td>'
                     output += '<td><div>' + item.board_DATE+'</div></td>'
                     output += '<td><div>' + item.board_READCOUNT+'</div></td>'
                              +   '</div></td></tr>'
                        
                     
                  })
                  output += "</tbody>"
                  $('table').append(output)// table 완성
                  
                  $(".pagination").empty();// 페이징 처리
                  output = "";
                  
                  digit = '이전&nbsp;'
                  href="";
                  if(data.page > 1){
                     href = 'href=javascript:go(' + (data.page - 1) + ')';
                     
                  }
                  setPaging(href,digit);
                  
                  for (var i = data.startpage; i <= data.endpage; i++){
                     
                     digit = i;
                     href="";
                     if (i != data.page){
                        href = 'href=javascript:go(' + i+')';
                        
                     }
                     setPaging(href,digit);
                  }
                  
                  digit = '다음&nbsp;';
                  href="";
                  if(data.page < data.maxpage){
                     href = 'href=javascript:go(' + (data.page + 1 ) + ')';
                  }
                  setPaging(href, digit);
                  $('.pagination').append(output)
            
            }
         
         
         },
         error : function(){
            console.log('에러')
         }
         
   })
   

}
   

$(function() {

   $("button").click(function(e) {
	   e.preventDefault();
	   console.log("88");
      location.href = "ServiceQuestion.bo";
   })


   $("#viewcount").change(function() {
      go(1); // 보여줄 페이지를 1페이지로 설정합니다/

   })//

})