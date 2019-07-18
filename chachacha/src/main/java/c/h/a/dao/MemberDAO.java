package c.h.a.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import c.h.a.domain.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member isid(String id) {
		return sqlSession.selectOne("Members.idcheck", id);
	}
	
	public Member isemail(String email) {
		return sqlSession.selectOne("Members.emailcheck", email);
	}

	public int insert(Member m) {
		return sqlSession.insert("Members.insert", m);
	}

	public Member isnickname(String nickname) {
		return sqlSession.selectOne("Members.nicknamecheck", nickname);
	}

	public List<Member> getList(HashMap<String, String> map) {
		return sqlSession.selectList("Members.search", map);
	}

	public List<Member> getList() {
		return sqlSession.selectList("Members.memberList");
	}

	public int delete(String id) {
		return sqlSession.delete("Members.delete", id);
	}

	public List<Member> gradeList(String grade) {
		return sqlSession.selectList("Members.gradeList", grade);
	}

}
