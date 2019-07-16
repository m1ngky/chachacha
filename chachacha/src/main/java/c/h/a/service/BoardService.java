package c.h.a.service;

import java.util.List;

import c.h.a.domain.Board;

public interface BoardService {

	int getListCount();

	List<Board> getBoardList(int page, int limit, String category);

	int insertBoard(Board board);
	
	//�� ���� ����
	public Board getDetail(int num);
	
	//�� �亯
//	public int boardReply(Board board);
	
	//�� ����
	public int boardModify(Board modifyboard);
	
	//�� ����
	public int boardDelete(int num);
	
	//��ȸ�� ������Ʈ
	public void setReadCountUpdate(int num);

	//�� ���� Action
	public int boardModifyAction(int num);

	boolean isBoardWriter(int NUM, String password);

//	void boardDeleteall(int num);
	
}
