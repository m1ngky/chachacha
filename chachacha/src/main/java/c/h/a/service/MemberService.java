package c.h.a.service;

import java.util.List;

import c.h.a.domain.Member;

public interface MemberService {
	public int isId(String id);
	public int isEmail(String email);
	public int isId(String id, String password);
	public int insert(Member m) ;
	public Member member_info(String id);
	public int update(Member m);
	public List<Member> getList(int index, String search_word) ;
	public List<Member> getList();
	public int delete(String id);
	public int isNickname(String nickname);
	public List<Member> gradeList(String grade);
}
