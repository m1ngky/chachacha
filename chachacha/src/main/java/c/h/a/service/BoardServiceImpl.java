package c.h.a.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import c.h.a.dao.BoardDAO;
import c.h.a.domain.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private DataSourceTransactionManager transaction;

	@Override
	public int getServiceListCount(String category) {
		return  dao.getServiceListCount(category);
	}

	@Override
	public List<Board> getServiceboardList(int page, int limit, String category) {
		 Map<String,Object> map = new HashMap<String, Object>();
	      int startrow = (page - 1) * limit + 1;  //읽기 시작할 row 번호(1 11 21 31 ...
	      int endrow = startrow + limit - 1; 	  // 읽을 마지막 row 번호(10 20 30 40 ...
	      
	      map.put("startrow", startrow);
	      map.put("endrow", endrow);
	      map.put("category", category);
	      return dao.getServiceBoardList(map);
	}

	@Override
	public int insertBoard(Board board) {
		return dao.Boardinsert(board);
	}

}
