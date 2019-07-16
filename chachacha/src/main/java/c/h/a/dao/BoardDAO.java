package c.h.a.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import c.h.a.domain.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getListCount() {
		
		return sqlSession.selectOne("Boards.count");
	}

	public List<Board> getBoardList(HashMap<String, Integer> map) {
		
		return sqlSession.selectList("Boards.boardlist", map);
	}

	public int insertBoard(Board board) {
		
		return sqlSession.insert("Boards.insert", board);
		
	}

	public Board getDetail(int num) {
		
		return sqlSession.selectOne("Boards.detail", num);
	}

	public int boardModify(Board modifyboard) {
		
		return sqlSession.update("Boards.modify", modifyboard);
	}

	public void setReadCountUpdate(int num) {
		
		sqlSession.selectOne("Boards.readcountupdate", num);
		
	}

	public int boardModifyAction(int num) {
		
		return sqlSession.update("Boards.modify", num);
	}

	public Board isBoardWriter(Map<String, Object> map) {
		
		return sqlSession.selectOne("Boards.boardwriter", map);
	}

	public int boardDelete(int num) {
		
		return sqlSession.delete("Boards.boarddelete", num);
	}

	public int boardReply(Board board) {
		
		return sqlSession.insert("Boards.reply", board);
	}

	public void boardReplyUpdate(Board board) {
		
		sqlSession.update("Boards.replyupdate", board);
		
	}

}
