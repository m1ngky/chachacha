package c.h.a.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.h.a.dao.MemberDAO;
import c.h.a.domain.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Override
	public int isId(String id) {
		Member rmember = dao.isid(id);
		return (rmember==null)? -1 :1 ; 
	}
	
	@Override
	public int isEmail(String email) {
		Member rmember = dao.isemail(email);
		return (rmember==null)? -1 :1 ; 
	}

	@Override
	public int isId(String id, String password) {
		Member rmember =  dao.isid(id);
		
		int result = 1;
		if(rmember!=null) {
			if(rmember.getPassword().equals(password)) {
				result= 1;
			}else {
				result = 0;
			}
		}
		return result;
	}

	@Override
	public int insert(Member m) {
		return dao.insert(m);
	}

	@Override
	public Member member_info(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> getList(int index, String search_word) {
		String[] search_field = new String[] { "id", "name", "age", "gender" };
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("index", search_field[index]);
		map.put("search_word", search_word);
		List<Member> list = dao.getList(map);
		return list;
	}

	@Override
	public List<Member> getList() {
		return dao.getList();
	}

	@Override
	public int delete(String id) {
		return dao.delete(id);
	}

	@Override
	public int isNickname(String nickname) {
		Member rmember = dao.isnickname(nickname);
		return (rmember==null)? -1 :1 ; 
	}

	@Override
	public List<Member> gradeList(String grade) {
		return dao.gradeList(grade);
	}

}

