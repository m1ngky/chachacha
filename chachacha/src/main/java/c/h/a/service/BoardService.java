package c.h.a.service;

import java.util.List;

import c.h.a.domain.Board;

public interface BoardService {

	int getListCount();

	List<Board> getBoardList(int page, int limit);

	int insertBoard(Board board);
	
	//글 내용 보기
	public Board getDetail(int num);
	
	//글 답변
//	public int boardReply(Board board);
	
	//글 수정
	public int boardModify(Board modifyboard);
	
	//글 삭제
	public int boardDelete(int num);
	
	//조회수 업데이트
	public void setReadCountUpdate(int num);

	//글 수정 Action
	public int boardModifyAction(int num);

	boolean isBoardWriter(int board_NUM, String board_PASS);

//	void boardDeleteall(int num);
	
}
