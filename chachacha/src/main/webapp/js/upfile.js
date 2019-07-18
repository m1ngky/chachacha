$(function() {
   var check=0;
   // 파일이름이 있는 경우remove이미지를 보이게 하고 없는 경우 보이지 않게 한다.
   if ($('#filevalue').text() == '') {
      $(".remove").css('display', 'none');
   } else {
      $("remove").css('display', 'inline-block');
   }

   $("#upfile").change(function() {
      check++;
      var inputfile = $(this).val().split('\\');
      $("#filevalue").text(inputfile[inputfile.length - 1]);
      $(".remove").css('display', 'inline-block');
   })

   $('.remove').click(function() {
      $('#filevalue').text('');
      $(".remove").css('display', 'none');
   })
})