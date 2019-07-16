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

	// 구매 게시판 보기
	@RequestMapping(value = "/BoardBuyList.bo")
	public ModelAndView boardbuyList(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv)
			throws Exception {
		
		String category = "b";

		int limit = 10; // 한 화면에 출력할 레코드 갯수
		int listcount = boardService.getListCount(); // 총 리스트 수를 받아옴

		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에서 보여줄 마지막 페이지 수 (10, 20, 30 등 ...)
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
	
	// 판매 게시판 보기
		@RequestMapping(value = "/BoardSaleList.bo")
		public ModelAndView boardsaleList(@RequestParam(value = "page", defaultValue = "1") int page, ModelAndView mv)
				throws Exception {
			
			String category = "s";

			int limit = 10; // 한 화면에 출력할 레코드 갯수
			int listcount = boardService.getListCount(); // 총 리스트 수를 받아옴

			// 총 페이지 수
			int maxpage = (listcount + limit - 1) / limit;

			// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
			int startpage = ((page - 1) / 10) * 10 + 1;

			// 현재 페이지에서 보여줄 마지막 페이지 수 (10, 20, 30 등 ...)
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

	// 글 목록보기 Ajax 이용
	@ResponseBody
	@RequestMapping(value = "/BoardListAjax.bo")
	public Object boardListAjax(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "10", required = false) int limit, ModelAndView mv)
			throws Exception {

		String category = "b";
		
		int listcount = boardService.getListCount(); // 총 리스트 수를 받아옴

		// 총 페이지 수
		int maxpage = (listcount + limit - 1) / limit;

		// 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;

		// 현재 페이지에서 보여줄 마지막 페이지 수 (10, 20, 30 등 ...)
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

	//게시글 작성
	@RequestMapping(value = "/BoardAddAction.bo")
	public String write(Board board, HttpServletRequest request) throws Exception {

		MultipartFile uploadfile = board.getUploadfile();

		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename(); // 원래 파일명
			board.setFilename(fileName); // 원래 파일명 저장

			// 새로운 폴더 이름 : 오늘 년+월+일
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
			int month = c.get(Calendar.MONTH) + 1; // 오늘 월 구합니다.
			int date = c.get(Calendar.DATE); // 오늘 일 구합니다.
			String saveFolder = request.getSession().getServletContext().getRealPath("resources") + "/upload/";

			String homedir = saveFolder + year + "-" + month + "-" + date;
			System.out.println(homedir);
			File path1 = new File(homedir);
			if (!(path1.exists())) {
				path1.mkdir(); // 새로운 폴더를 생성
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
			/*** 확장자 구하기 끝 ***/

			// 새로운 파일명
			String refileName = "bbs" + year + month + date + random + "." + fileExtension;
			System.out.println("refileName = " + refileName);

			// 오라클 디비에 저장될 파일 명
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			System.out.println("fileDBName = " + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile.transferTo(new File(saveFolder + fileDBName));

			// 바뀐 파일명으로 저장
			board.setFilename(fileDBName);

		}

		boardService.insertBoard(board); // 저장 메소드 호출

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
		// 조회수 증가시킵니다.
		boardService.setReadCountUpdate(num);

		Board board = boardService.getDetail(num);
		if (board == null) {
			System.out.println("상세보기 실패 ");
			mv.setViewName("error/error");
			mv.addObject("url", request.getRequestURL());
			mv.addObject("message", "상세보기 실패입니다.");
		} else {
			System.out.println("상세보기 성공");
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

		// 비밀번호가 다를 경우
		if (usercheck == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;

		}

		MultipartFile uploadfile = board.getUploadfile();
		String saveFolder = request.getSession().getServletContext().getRealPath("resources") + "/upload/";
		System.out.println("check=" + check);

		if (check != null && !check.equals("")) { // 기존파일 그대로 사용하는 경우입니다.

			System.out.println("기존파일 그대로 사용합니다.");
			String fileDBName = fileDBName(check, saveFolder);
			board.setFilename(fileDBName);
		} else {
			if (!uploadfile.isEmpty()) { // 파일 변경한 경우
				String fileName = uploadfile.getOriginalFilename(); // 원래 파일명
				board.setFilename(fileName);

				String fileDBName = fileDBName(fileName, saveFolder);

				// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
				uploadfile.transferTo(new File(saveFolder + fileDBName));

				// 바뀐 파일명으로 저장
				board.setFilename(fileDBName);
			} else { // uploadfile.isEmpty() 인경우 - 파일 선택하지 않은 경우
				System.out.println("uploadfile.isEmpty()");
				// <input type="hidden" name="BOARD_ORIGINAL"
				// value="${boarddata.BOARD_ORIGINAL}>
				// 위 태그에 값이 있다면 ""로 값을 변경합니다.
				board.setFilename("");
			}
		}

		// DAO에서 수정 메소드 호출하여 수정합니다.
		int result = boardService.boardModify(board);

		// 수정에 실패한 경우
		if (result == 0) {
			System.out.println("게시판 수정 실패");
			mv.setViewName("error/error");
			mv.addObject("url", request.getRequestURL());
			mv.addObject("message", "게시판 수정 실패");
		} else { // 수정 성공의 경우
			System.out.println("게시판 수정 완료");
			String url = "redirect:BoardDetailAction.bo?num=" + board.getNum();

			// 수정한 글 내용을 보여주기 위해 글 내용 보기 페이지로 이동하기위해 경로를 설정합니다.
			mv.setViewName(url);
		}

		return mv;

	}

	private String fileDBName(String fileName, String saveFolder) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR); // 오늘 년도 구합니다.
		int month = c.get(Calendar.MONTH) + 1; // 오늘 월 구합니다.
		int date = c.get(Calendar.DATE); // 오늘 일 구합니다.

		String homedir = saveFolder + year + "-" + month + "-" + date;
		System.out.println(homedir);
		File path1 = new File(homedir);
		if (!(path1.exists()))
			path1.mkdir(); // 새로운 폴더를 생성

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
		/*** 확장자 구하기 끝 ***/

		// 새로운 파일명
		String refileName = "bbs" + year + month + date + random + "." + fileExtension;
		System.out.println("refileName = " + refileName);

		// 오라클 디비에 저장될 파일 명
		String refileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
		System.out.println("refileDBName = " + refileDBName);
		return refileDBName;

	}

	@RequestMapping(value = "/BoardDeleteAction.bo")
	public String BoardDeleteAction(String BOARD_PASS, int num, HttpServletResponse response) throws Exception {
		// 글 삭제 명령을 요청한 사용자가 글을 작성한 사용자인지 판단하기 위해
		// 입력한 비밀번호와 저장된 비밀번호를 비교하여 일치하면 삭제합니다.
		boolean usercheck = boardService.isBoardWriter(num, BOARD_PASS);

		// 비밀번호 일치하지 않는 경우
		if (usercheck == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}

		// 비밀번호 일치하는 경우 삭제 처리 합니다.
		int result = boardService.boardDelete(num);

		// 삭제 처리 실패한 경우
		if (result == 0) {
			System.out.println("게시판 삭제 실패");
		}

		// 삭제 처리 성공한 경우 - 글 목록 보기 요청을 전송하는 부분입니다.
		System.out.println("게시판 삭제 성공");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제 되었습니다.');");
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
			mv.addObject("message", "게시판 답변글 가져오기 실패");
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
//			mv.addObject("message", "답글 달기 실패");
//		}
//		mv.addObject("boarddata", board);
//		mv.addObject("message", "답글 달기 성공");
//		mv.addObject("url", request.getRequestURL());
//		String url = "redirect:BoardList.bo";
//		mv.setViewName(url);
//
//		return mv;
//
//	}

}
