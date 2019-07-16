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
 
	

	public int getServiceListCount(String category) {
		return sqlSession.selectOne("Boards.getServiceListCount", category);
	}



	public List<Board> getServiceBoardList(Map<String, Object> map) {
		return sqlSession.selectList("Boards.getServiceboardList",map);
	}



	public int Boardinsert(Board board) {
		return sqlSession.insert("Boards.insert", board);
	}

}
