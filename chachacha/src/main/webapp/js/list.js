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
//                     blank_count = item.board_RE_LEV * 2 + 1;
                     blank = '&nbsp;';
                     for ( var i = 0;  i< blank_count; i ++){
                        blank += '&nbsp;&nbsp';
                     }
                     img="";
//                     if(item.board_RE_LEV >0){
//                        img = "<img src='image/AnswerLine.gif'>";
//                     }
                     output += "<td><div>" + blank + img
                     output += ' <a href="BoardDetailAction.bo?num='
                        +item.num + '&page='
                        +data.page + '">'
                     output += item.subject +'</a></div></td>'
                     output += '<td><div>' + item.id+'</div></td>'
                     output += '<td><div>' + item.inputdate+'</div></td>'
                     output += '<td><div>' + item.readcount+'</div></td>'
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

   $("button").click(function() {
      location.href = "BoardWrite.bo";
   })


   $("#viewcount").change(function() {
      go(1); // 보여줄 페이지를 1페이지로 설정합니다/

   })//

})