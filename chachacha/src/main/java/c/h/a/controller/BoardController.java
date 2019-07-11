package c.h.a.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		@RequestMapping(value = "/BoardList.bo")
		public ModelAndView boardList(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv)
				throws Exception {

			int limit = 10; // �� ȭ�鿡 ����� ���ڵ� ����
			int listcount = boardService.getListCount(); // �� ����Ʈ ���� �޾ƿ�

			// �� ������ ��
			int maxpage = (listcount + limit - 1) / limit;

			// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
			int startpage = ((page - 1) / 10) * 10 + 1;

			// ���� ���������� ������ ������ ������ �� (10, 20, 30 �� ...)
			int endpage = startpage + 10 - 1;

			if (endpage < page)
				page = endpage;

			List<Board> boardlist = boardService.getBoardList(page, limit);

			mv.addObject("page", page);
			mv.addObject("limit", limit);
			mv.addObject("startpage", startpage);
			mv.addObject("endpage", endpage);
			mv.addObject("maxpage", maxpage);
			mv.addObject("listcount", listcount);
			mv.addObject("boardlist", boardlist);
			mv.setViewName("board/board_list");

			return mv;

		}
		
		@RequestMapping(value = "/BoardAddAction.bo")
		public String qna_board_write(Board board, HttpServletRequest request) throws Exception {

			MultipartFile uploadfile = board.getUploadfile();

			if (!uploadfile.isEmpty()) {
				String fileName = uploadfile.getOriginalFilename(); // ���� ���ϸ�
				board.setBOARD_ORIGINAL(fileName); // ���� ���ϸ� ����

				// ���ο� ���� �̸� : ���� ��+��+��
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR); // ���� �⵵ ���մϴ�.
				int month = c.get(Calendar.MONTH) + 1; // ���� �� ���մϴ�.
				int date = c.get(Calendar.DATE); // ���� �� ���մϴ�.
				String saveFolder = request.getSession().getServletContext().getRealPath("resources") + "/upload/";

				String homedir = saveFolder + year + "-" + month + "-" + date;
				System.out.println(homedir);
				File path1 = new File(homedir);
				if (!(path1.exists())) {
					path1.mkdir(); // ���ο� ������ ����
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
				/*** Ȯ���� ���ϱ� �� ***/

				// ���ο� ���ϸ�
				String refileName = "bbs" + year + month + date + random + "." + fileExtension;
				System.out.println("refileName = " + refileName);

				// ����Ŭ ��� ����� ���� ��
				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
				System.out.println("fileDBName = " + fileDBName);

				// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
				uploadfile.transferTo(new File(saveFolder + fileDBName));

				// �ٲ� ���ϸ����� ����
				board.setBOARD_FILE(fileDBName);

			}

			boardService.insertBoard(board); // ���� �޼ҵ� ȣ��

			return "redirect:BoardList.bo";
		}

		@RequestMapping(value = "/BoardWrite.bo")
		public ModelAndView write(HttpSession session, ModelAndView mv) throws Exception {

			String id = (String) session.getAttribute("id");
			mv.setViewName("board/qna_board_write");
			mv.addObject("id", id);

			return mv;
		}


		@RequestMapping("/BoardDetailAction.bo")
		public ModelAndView Detail(int num, ModelAndView mv, HttpServletRequest request) {
			// ��ȸ�� ������ŵ�ϴ�.
			boardService.setReadCountUpdate(num);

			Board board = boardService.getDetail(num);
			if (board == null) {
				System.out.println("�󼼺��� ���� ");
				mv.setViewName("error/error");
				mv.addObject("url", request.getRequestURL());
				mv.addObject("message", "�󼼺��� �����Դϴ�.");
			} else {
				System.out.println("�󼼺��� ����");
				int count = commentService.getListCount(num);
				mv.setViewName("board/qna_board_view");
				mv.addObject("count", count);
				mv.addObject("boarddata", board);
			}

			return mv;
		}

		@RequestMapping(value = "/BoardModifyView.bo")
		public ModelAndView modifyview(@RequestParam(value = "num") int num, Board board, ModelAndView mv) {

			board = boardService.getDetail(num);
			mv.setViewName("board/qna_board_modify");
			mv.addObject("boarddata", board);

			return mv;
		}

		@RequestMapping(value = "/BoardModifyAction.bo")
		public ModelAndView BoardModifyAction(Board board, String check, ModelAndView mv, HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			boolean usercheck = boardService.isBoardWriter(board.getBOARD_NUM(), board.getBOARD_PASS());

			// ��й�ȣ�� �ٸ� ���
			if (usercheck == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��й�ȣ�� �ٸ��ϴ�.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				return null;

			}

			MultipartFile uploadfile = board.getUploadfile();
			String saveFolder = request.getSession().getServletContext().getRealPath("resources") + "/upload/";
			System.out.println("check=" + check);

			if (check != null && !check.equals("")) { // �������� �״�� ����ϴ� ����Դϴ�.

				System.out.println("�������� �״�� ����մϴ�.");
				String fileDBName = fileDBName(check, saveFolder);
				board.setBOARD_FILE(fileDBName);
			} else {
				if (!uploadfile.isEmpty()) { // ���� ������ ���
					String fileName = uploadfile.getOriginalFilename(); // ���� ���ϸ�
					board.setBOARD_ORIGINAL(fileName);

					String fileDBName = fileDBName(fileName, saveFolder);

					// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
					uploadfile.transferTo(new File(saveFolder + fileDBName));

					// �ٲ� ���ϸ����� ����
					board.setBOARD_FILE(fileDBName);
				} else { // uploadfile.isEmpty() �ΰ�� - ���� �������� ���� ���
					System.out.println("uploadfile.isEmpty()");
					// <input type="hidden" name="BOARD_ORIGINAL"
					// value="${boarddata.BOARD_ORIGINAL}>
					// �� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
					board.setBOARD_ORIGINAL("");
				}
			}

			// DAO���� ���� �޼ҵ� ȣ���Ͽ� �����մϴ�.
			int result = boardService.boardModify(board);

			// ������ ������ ���
			if (result == 0) {
				System.out.println("�Խ��� ���� ����");
				mv.setViewName("error/error");
				mv.addObject("url", request.getRequestURL());
				mv.addObject("message", "�Խ��� ���� ����");
			} else { // ���� ������ ���
				System.out.println("�Խ��� ���� �Ϸ�");
				String url = "redirect:BoardDetailAction.bo?num=" + board.getBOARD_NUM();

				// ������ �� ������ �����ֱ� ���� �� ���� ���� �������� �̵��ϱ����� ��θ� �����մϴ�.
				mv.setViewName(url);
			}

			return mv;

		}

		private String fileDBName(String fileName, String saveFolder) {
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // ���� �⵵ ���մϴ�.
			int month = c.get(Calendar.MONTH) + 1; // ���� �� ���մϴ�.
			int date = c.get(Calendar.DATE); // ���� �� ���մϴ�.

			String homedir = saveFolder + year + "-" + month + "-" + date;
			System.out.println(homedir);
			File path1 = new File(homedir);
			if (!(path1.exists()))
				path1.mkdir(); // ���ο� ������ ����

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
			/*** Ȯ���� ���ϱ� �� ***/

			// ���ο� ���ϸ�
			String refileName = "bbs" + year + month + date + random + "." + fileExtension;
			System.out.println("refileName = " + refileName);

			// ����Ŭ ��� ����� ���� ��
			String refileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			System.out.println("refileDBName = " + refileDBName);
			return refileDBName;

		}

		@RequestMapping(value = "/BoardDeleteAction.bo")
		public String BoardDeleteAction(String BOARD_PASS, int num, HttpServletResponse response) throws Exception {
			// �� ���� ����� ��û�� ����ڰ� ���� �ۼ��� ��������� �Ǵ��ϱ� ����
			// �Է��� ��й�ȣ�� ����� ��й�ȣ�� ���Ͽ� ��ġ�ϸ� �����մϴ�.
			boolean usercheck = boardService.isBoardWriter(num, BOARD_PASS);

			// ��й�ȣ ��ġ���� �ʴ� ���
			if (usercheck == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��й�ȣ�� �ٸ��ϴ�.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				return null;
			}

			// ��й�ȣ ��ġ�ϴ� ��� ���� ó�� �մϴ�.
			int result = boardService.boardDelete(num);

			// ���� ó�� ������ ���
			if (result == 0) {
				System.out.println("�Խ��� ���� ����");
			}

			// ���� ó�� ������ ��� - �� ��� ���� ��û�� �����ϴ� �κ��Դϴ�.
			System.out.println("�Խ��� ���� ����");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('���� �Ǿ����ϴ�.');");
			out.println("location.href='BoardList.bo';");
			out.println("</script>");
			out.close();
			return null;
		}

		@RequestMapping("BoardReplyView.bo")
		public ModelAndView BoardReplyView(int num, ModelAndView mv, HttpServletRequest request) {
			Board board = boardService.getDetail(num);
			if (board == null) {
				mv.setViewName("error/error");
				mv.addObject("url", request.getRequestURL());
				mv.addObject("message", "�Խ��� �亯�� �������� ����");
			} else {
				mv.addObject("boarddata", board);
				mv.setViewName("board/qna_board_reply");
			}
			return mv;

		}

		@RequestMapping("/BoardReplyAction.bo")
		public ModelAndView BoardReplyAction(Board board, ModelAndView mv, HttpServletResponse response,
				HttpServletRequest request) throws Exception {

			/*
			 	boardService.boardReply(board);
			 	mv.setViewName=("redirect"BoardList.bo");
			 	return mv;
			 */
			
			int result = boardService.boardReply(board);

			if (result == 0) {
				mv.setViewName("error/error");
				mv.addObject("message", "��� �ޱ� ����");
			}
			mv.addObject("boarddata", board);
			mv.addObject("message", "��� �ޱ� ����");
			mv.addObject("url", request.getRequestURL());
			String url = "redirect:BoardList.bo";
			mv.setViewName(url);

			return mv;

		}
		
		@RequestMapping("BoardFileDown.bo")
		public void BoardFileDown(String filename, HttpServletRequest request, HttpServletResponse response, String original) 
				throws Exception {
			
			String savePath = "resources/upload";
			
			//������ ���� ȯ�� ������ ��� �ִ� ��ü�� �����մϴ�.
			ServletContext context = request.getSession().getServletContext();
			String sDownloadPath = context.getRealPath(savePath);
			
			//String sFilePath = sDownloadPath + "\\" + fileName;
			// "\" �߰��ϱ� ���� "\\" ����մϴ�.
			String sFilePath = sDownloadPath + "/" + filename;
			System.out.println(sFilePath);
			
			byte b[] = new byte[4096];
			
			//sFilePath�� �ִ� ������ MimeType�� ���ؿɴϴ�.
			String sMimeType = context.getMimeType(sFilePath);
			System.out.println("sMimeType>>>" + sMimeType);
			
			if(sMimeType == null)
				sMimeType = "application/octet-stream";
			
			response.setContentType(sMimeType);
			
			// - �� �κ��� �ѱ� ���ϸ��� ������ ���� ������ �ݴϴ�.
			String sEncoding = new String(original.getBytes("utf-8"), "ISO-8859-1");
			System.out.println(sEncoding);
			
			/*
			 	Content-Disposition : attachment : �������� �ش� Content�� ó������ �ʰ�, �ٿ�ε��ϰ� �˴ϴ�.
			 */
			response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
			try (
				//�� ���������� ��� ��Ʈ�� �����մϴ�.
				BufferedOutputStream out2 = new BufferedOutputStream(response.getOutputStream());
				
				//sFilePath�� ������ ���Ͽ� ���� �Է� ��Ʈ���� �����մϴ�.
				BufferedInputStream in = new BufferedInputStream(new FileInputStream(sFilePath));){
				
				
				int numRead;
				//read(b, 0, b.length) : ����Ʈ �迭 b�� 0������ b.length ũ�⸸ŭ �о�ɴϴ�.
				while ((numRead = in.read(b, 0, b.length)) != -1) {	// ���� �����Ͱ� �����ϴ� ���
					//����Ʈ �迭 b�� 0�� ���� numReadũ�� ��ŭ �������� ���
					out2.write(b, 0, numRead);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

}
