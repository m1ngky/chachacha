package c.h.a.service;

import java.util.List;

import c.h.a.domain.Board;

public interface BoardService {

	

	int getServiceListCount(String category);

	List<Board> getServiceboardList(int page, int limit, String category);

	int insertBoard(Board board); 
	
}
