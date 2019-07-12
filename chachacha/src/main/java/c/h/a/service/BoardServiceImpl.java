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
	public int getListCount() {
		
		return dao.getListCount();
	}

	@Override
	public List<Board> getBoardList(int page, int limit) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int startrow = (page - 1) * limit + 1;	//읽기 시작할 row 번호
		int endrow = startrow + limit - 1;	//읽을 마지막 row 번호.
		
		map.put("startrow", startrow);
		map.put("endrow", endrow);
		return dao.getBoardList(map);
	}

	@Override
	public int insertBoard(Board board) {
		int result = dao.insertBoard(board);
		return result;
		
	}

	@Override
	public Board getDetail(int num) {
		
		return dao.getDetail(num);
	}

	@Transactional
	@Override
	public int boardReply(Board board) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		
		//PROPAGATION_REQUIRED : 활성화된 트랜잭션이 존재한다면 스프링은
		//이 트랜잭션을 사용하고 그렇지 않으면 새로운 트랜잭션을 시작한다.
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transaction.getTransaction(def);
		try {
			dao.boardReplyUpdate(board);
			board.setBOARD_RE_LEV(board.getBOARD_RE_LEV() + 1);
			board.setBOARD_RE_SEQ(board.getBOARD_RE_SEQ() + 1);
			dao.boardReply(board);
			transaction.commit(status);
			return 1;
		} catch (Exception e) {
			System.out.println("rollback 합니다.");
			transaction.rollback(status);
			return 0;
		}
		
	}

	@Override
	public int boardModify(Board modifyboard) {
		return dao.boardModify(modifyboard);
	}

	@Override
	public int boardDelete(int num) {
		
		return dao.boardDelete(num);
	}

	@Override
	public void setReadCountUpdate(int num) {
		dao.setReadCountUpdate(num);
		
	}

	@Override
	public int boardModifyAction(int num) {
		int result = dao.boardModifyAction(num);
		return result;
	}

	@Override
	public boolean isBoardWriter(int num, String pass) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("pass", pass);
		Board result = dao.isBoardWriter(map);
		if(result == null)
			return false;
		else
			return true;
		
	}

	@Override
	public void boardDeleteall(int num) {
		
		dao.boardDeleteall(num);
		
	}

}
