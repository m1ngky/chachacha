package c.h.a.service;

import java.util.List;

import c.h.a.domain.Board;

public interface BoardService {


	int getListCount();

	List<Board> getBoardList(int page, int limit, String category);

	int insertBoard(Board board);
	
	//±Û ³»¿ë º¸±â
	public Board getDetail(int num);
	
	//±Û ´äº¯
//	public int boardReply(Board board);
	
	//±Û ¼öÁ¤
	public int boardModify(Board modifyboard);
	
	//±Û »èÁ¦
	public int boardDelete(int num);
	
	//Á¶È¸¼ö ¾÷µ¥ÀÌÆ®
	public void setReadCountUpdate(int num);

	


	int getServiceListCount(String category);


	boolean isBoardWriter(int NUM, String password);

//	void boardDeleteall(int num);





}
