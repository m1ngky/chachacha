package c.h.a.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import c.h.a.domain.Board;
import c.h.a.service.BoardService;
import c.h.a.service.CommentService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private CommentService commentService;
	
	// 글 목록보기
		
			
		
		@RequestMapping("ServiceCenter")
		   public ModelAndView ServiceCenterMain(
		            @RequestParam(value="page",defaultValue = "1")int page,         
		            ModelAndView mv)throws Exception {
			   
			   List<Board> boardlist = new ArrayList<Board>();
			   
			   int limit = 10; // 한 화면에 출력할 레코드 갯수
		       String category = "C";
			   	         
		         int listcount = boardService.getServiceListCount(category); // 총 리스트 수를 받아옴
		         
		         //총 페이지 수
		         int maxpage = (listcount +  limit -1 )/ limit;
		         
		         //현재 페이지에 보여줄 시작 페이지수 (1,11,21 등등...)
		         int startpage = ((page- 1 )/ 10)* 10 +1 ;
		         //endpage: 현재 페이지 그룹에서 보여줄 마지막 페이지 수 ([10],[20],[30] 등.)
		         int endpage = startpage + 10 - 1;
		         
		         boardlist = boardService.getServiceboardList(page, limit, category);
		         if(endpage>maxpage)
		             endpage= maxpage;
		          
		             mv.setViewName("ServiceCenter/ServiceMain");
		             
		             mv.addObject("page",page);
		             mv.addObject("maxpage",maxpage);
		             
		             //현재 페이지에 표시할 첫 페이지 수
		             
		             mv.addObject("startpage", startpage);
		             
		             //편재 페이지에 표시할 끝 페이지 수
		             mv.addObject("endpage", endpage);
		             
		             mv.addObject("listcount", listcount);
		             mv.addObject("boardlist", boardlist);
		             
		             mv.addObject("limit", limit);
		             
		             return mv;  
		       }
		   
		   @PostMapping("/ServiceQuestion.bo")
		   public String ServiceQuestion(Board board, 
		         HttpServletRequest request) 
		               throws Exception{
		      MultipartFile uploadfile = board.getUploadfile();
		      
		      if(!uploadfile.isEmpty()) {
		         String fileName = uploadfile.getOriginalFilename();   // 원래 파일명
		         board.setOriginalfile(fileName);  //원래 파일명 저장
		         
		         //새로운 폴더 이름 : 오늘 년+월+일
		         Calendar c = Calendar.getInstance();
		         int year = c.get(Calendar.YEAR);  // 오늘 년도 구함.
		         int month = c.get(Calendar.MONTH) + 1;  // 오늘 월 구함.
		         int date = c.get(Calendar.DATE);  // 오늘 일 구함.
		         
		         String saveFolder = 
		               request.getSession().getServletContext().getRealPath("resources") + "/upload/";
		         String homedir = saveFolder + year + "-" + month + "-" + date;
		         System.out.println("homedir=" + homedir);
		         
		         File path1 = new File(homedir);
		         if(!(path1.exists())) {
		            path1.mkdir();  // 새로운 폴더 생성
		         }
		         
		         // 난수를 구합니다.
		         Random r = new Random();
		         int random = r.nextInt(100000000);
		         
		         /**** 확장자 구하기 시작 ****/
		         int index = fileName.lastIndexOf(".");
		         // 문자열에서 특정 문자열의 위치 값(index)를 반환한다.
		         // indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
		         // lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
		         // (파일명에 점이 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
		         System.out.println("index = " + index);
		         
		         String fileExtension = fileName.substring(index + 1);
		         System.out.println("fileExtension = " + fileExtension);
		         /**** 확장자 구하기 끝 ****/
		         
		         // 새로운 파일명
		         String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		         System.out.println("refileName = " + refileName);
		         
		         // 오라클 디비에 저장될 파일 명
		         String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
		         System.out.println("fileDBName = " + fileDBName);
		         
		         // transferTo(file path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
		         uploadfile.transferTo(new File(saveFolder + fileDBName));
		         
		         // 바뀔 파일명으로 저장
		         board.setFilename(fileDBName);
		         board.setCategory("C");
		      }
		      boardService.insertBoard(board);  // 저장메서드 호출
		      
		      return "redirect:ServiceCenter/ServiceMain";
		   }

}
