package c.h.a.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import c.h.a.domain.Board;
import c.h.a.domain.BoardAjax;
import c.h.a.service.BoardService;
import c.h.a.service.CommentService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private CommentService commentService;

	// ���� �Խ��� ����
	@RequestMapping(value = "/BoardBuyList.bo")
	public ModelAndView boardbuyList(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv)
			throws Exception {
		
		String category = "b";

		int limit = 10; // �� ȭ�鿡 ����� ���ڵ� ����
		int listcount = boardService.getListCount(); // �� ����Ʈ ���� �޾ƿ�

		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� ���������� ������ ������ ������ �� (10, 20, 30 �� ...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		List<Board> boardlist = boardService.getBoardList(page, limit, category);

		mv.addObject("page", page);
		mv.addObject("limit", limit);
		mv.addObject("startpage", startpage);
		mv.addObject("endpage", endpage);
		mv.addObject("maxpage", maxpage);
		mv.addObject("listcount", listcount);
		mv.addObject("boardlist", boardlist);
		mv.setViewName("board/board_buy");

		return mv;

	}
	
	// �Ǹ� �Խ��� ����
		@RequestMapping(value = "/BoardSaleList.bo")
		public ModelAndView boardsaleList(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv)
				throws Exception {
			
			String category = "s";

			int limit = 10; // �� ȭ�鿡 ����� ���ڵ� ����
			int listcount = boardService.getListCount(); // �� ����Ʈ ���� �޾ƿ�

			// �� ������ ��
			int maxpage = (listcount + limit - 1) / limit;

			// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
			int startpage = ((page - 1) / 10) * 10 + 1;

			// ���� ���������� ������ ������ ������ �� (10, 20, 30 �� ...)
			int endpage = startpage + 10 - 1;

			if (endpage > maxpage)
				endpage = maxpage;

			List<Board> boardlist = boardService.getBoardList(page, limit, category);

			mv.addObject("page", page);
			mv.addObject("limit", limit);
			mv.addObject("startpage", startpage);
			mv.addObject("endpage", endpage);
			mv.addObject("maxpage", maxpage);
			mv.addObject("listcount", listcount);
			mv.addObject("boardlist", boardlist);
			mv.setViewName("board/board_sale");

			return mv;

		}

	// �� ��Ϻ��� Ajax �̿�
	@ResponseBody
	@RequestMapping(value = "/BoardListAjax.bo")
	public Object boardListAjax(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "10", required = false) int limit, ModelAndView mv)
			throws Exception {

		String category = "b";
		
		int listcount = boardService.getListCount(); // �� ����Ʈ ���� �޾ƿ�

		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

		// ���� �������� ������ ���� ������ �� (1, 11, 21 �� ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// ���� ���������� ������ ������ ������ �� (10, 20, 30 �� ...)
		int endpage = startpage + 10 - 1;

		if (endpage > maxpage)
			endpage = maxpage;

		if (endpage < page)
			page = endpage;

		List<Board> boardlist = boardService.getBoardList(page, limit, category);

		BoardAjax ba = new BoardAjax();
		ba.setPage(page);
		ba.setMaxpage(maxpage);
		ba.setStartpage(startpage);
		ba.setEndpage(endpage);
		ba.setListcount(listcount);
		ba.setBoardlist(boardlist);
		ba.setLimit(limit);

		return ba;

	}

	//�Խñ� �ۼ�
	@RequestMapping(value = "/BoardAddAction.bo")
	public String write(Board board, HttpServletRequest request) throws Exception {

		MultipartFile uploadfile = board.getUploadfile();

		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename(); // ���� ���ϸ�
			board.setFilename(fileName); // ���� ���ϸ� ����

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
			board.setFilename(fileDBName);

		}

		boardService.insertBoard(board); // ���� �޼ҵ� ȣ��

		return "redirect:BoardBuyList.bo";
	}

	@RequestMapping(value = "/BoardWrite.bo")
	public ModelAndView write(HttpSession session, ModelAndView mv) throws Exception {

		String id = (String) session.getAttribute("id");
		mv.setViewName("board/board_write");
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
			mv.setViewName("board/board_view");
			mv.addObject("count", count);
			mv.addObject("boarddata", board);
		}

		return mv;
	}

	@RequestMapping(value = "/BoardModifyView.bo")
	public ModelAndView modifyview(@RequestParam(value = "num") int num, Board board, ModelAndView mv) {

		board = boardService.getDetail(num);
		mv.setViewName("board/board_modify");
		mv.addObject("boarddata", board);

		return mv;
	}

	@RequestMapping(value = "/BoardModifyAction.bo")
	public ModelAndView BoardModifyAction(Board board, String check, ModelAndView mv, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		boolean usercheck = boardService.isBoardWriter(board.getNum(), board.getPassword());

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
			board.setFilename(fileDBName);
		} else {
			if (!uploadfile.isEmpty()) { // ���� ������ ���
				String fileName = uploadfile.getOriginalFilename(); // ���� ���ϸ�
				board.setFilename(fileName);

				String fileDBName = fileDBName(fileName, saveFolder);

				// transferTo(File path) : ���ε��� ������ �Ű������� ��ο� �����մϴ�.
				uploadfile.transferTo(new File(saveFolder + fileDBName));

				// �ٲ� ���ϸ����� ����
				board.setFilename(fileDBName);
			} else { // uploadfile.isEmpty() �ΰ�� - ���� �������� ���� ���
				System.out.println("uploadfile.isEmpty()");
				// <input type="hidden" name="BOARD_ORIGINAL"
				// value="${boarddata.BOARD_ORIGINAL}>
				// �� �±׿� ���� �ִٸ� ""�� ���� �����մϴ�.
				board.setFilename("");
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
			String url = "redirect:BoardDetailAction.bo?num=" + board.getNum();

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
			mv.setViewName("board/board_reply");
		}
		return mv;

	}

//	@RequestMapping("/BoardReplyAction.bo")
//	public ModelAndView BoardReplyAction(Board board, ModelAndView mv, HttpServletResponse response,
//			HttpServletRequest request) throws Exception {
//
//		/*
//		 * boardService.boardReply(board); mv.setViewName=("redirect"BoardList.bo");
//		 * return mv;
//		 */
//
//		int result = boardService.boardReply(board);
//
//		if (result == 0) {
//			mv.setViewName("error/error");
//			mv.addObject("message", "��� �ޱ� ����");
//		}
//		mv.addObject("boarddata", board);
//		mv.addObject("message", "��� �ޱ� ����");
//		mv.addObject("url", request.getRequestURL());
//		String url = "redirect:BoardList.bo";
//		mv.setViewName(url);
//
//		return mv;
//
//	}

}
