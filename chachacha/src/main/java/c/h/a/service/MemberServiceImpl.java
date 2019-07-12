package c.h.a.service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
