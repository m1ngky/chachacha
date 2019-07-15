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
	
	// �� ��Ϻ���
		
			
		
		@RequestMapping("ServiceCenter")
		   public ModelAndView ServiceCenterMain(
		            @RequestParam(value="page",defaultValue = "1")int page,         
		            ModelAndView mv)throws Exception {
			   
			   List<Board> boardlist = new ArrayList<Board>();
			   
			   int limit = 10; // �� ȭ�鿡 ����� ���ڵ� ����
		       String category = "C";
			   	         
		         int listcount = boardService.getServiceListCount(category); // �� ����Ʈ ���� �޾ƿ�
		         
		         //�� ������ ��
		         int maxpage = (listcount +  limit -1 )/ limit;
		         
		         //���� �������� ������ ���� �������� (1,11,21 ���...)
		         int startpage = ((page- 1 )/ 10)* 10 +1 ;
		         //endpage: ���� ������ �׷쿡�� ������ ������ ������ �� ([10],[20],[30] ��.)
		         int endpage = startpage + 10 - 1;
		         
		         boardlist = boardService.getServiceboardList(page, limit, category);
		         if(endpage>maxpage)
		             endpage= maxpage;
		          
		             mv.setViewName("ServiceCenter/ServiceMain");
		             
		             mv.addObject("page",page);
		             mv.addObject("maxpage",maxpage);
		             
		             //���� �������� ǥ���� ù ������ ��
		             
		             mv.addObject("startpage", startpage);
		             
		             //���� �������� ǥ���� �� ������ ��
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
		         String fileName = uploadfile.getOriginalFilename();   // ���� ���ϸ�
		         board.setOriginalfile(fileName);  //���� ���ϸ� ����
		         
		         //���ο� ���� �̸� : ���� ��+��+��
		         Calendar c = Calendar.getInstance();
		         int year = c.get(Calendar.YEAR);  // ���� �⵵ ����.
		         int month = c.get(Calendar.MONTH) + 1;  // ���� �� ����.
		         int date = c.get(Calendar.DATE);  // ���� �� ����.
		         
		         String saveFolder = 
		               request.getSession().getServletContext().getRealPath("resources") + "/upload/";
		         String homedir = saveFolder + year + "-" + month + "-" + date;
		         System.out.println("homedir=" + homedir);
		         
		         File path1 = new File(homedir);
		         if(!(path1.exists())) {
		            path1.mkdir();  // ���ο� ���� ����
		         }
		         
		         // ������ ���մϴ�.
		         Random r = new Random();
		         int random = r.nextInt(100000000);
		         
		         /**** Ȯ���� ���ϱ� ���� ****/
		         int index = fileName.lastIndexOf(".");
		         // ���ڿ����� Ư�� ���ڿ��� ��ġ ��(index)�� ��ȯ�Ѵ�.
		         // indexOf�� ó�� �߰ߵǴ� ���ڿ��� ���� index�� ��ȯ�ϴ� �ݸ�,
		         // lastIndexOf�� ���������� �߰ߵǴ� ���ڿ��� index�� ��ȯ�մϴ�.
		         // (���ϸ� ���� ������ ���� ��� �� �������� �߰ߵǴ� ���ڿ��� ��ġ�� �����մϴ�.)
		         System.out.println("index = " + index);
		         
		         String fileExtension = fileName.substring(index + 1);
		         System.out.println("fileExtension = " + fileExtension);
		         /**** Ȯ���� ���ϱ� �� ****/
		         
		         // ���ο� ���ϸ�
		         String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		         System.out.println("refileName = " + refileName);
		         
		         // ����Ŭ ��� ����� ���� ��
		         String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
		         System.out.println("fileDBName = " + fileDBName);
		         
		         // transferTo(file path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
		         uploadfile.transferTo(new File(saveFolder + fileDBName));
		         
		         // �ٲ� ���ϸ����� ����
		         board.setFilename(fileDBName);
		         board.setCategory("C");
		      }
		      boardService.insertBoard(board);  // ����޼��� ȣ��
		      
		      return "redirect:ServiceCenter/ServiceMain";
		   }

}
