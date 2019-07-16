package c.h.a.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import c.h.a.domain.Member;
import c.h.a.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping(value="/login.net")
	public String login() {
		System.out.println("loginform");
		return "member/loginform";
	}
	
	@RequestMapping(value="/join.net")
	public String join() {
		System.out.println("joinform");
		return "member/joinform";
	}

	
	@RequestMapping(value = "/joinProcess.net")
	public void insert(Member member, HttpServletResponse response) throws Exception {
		System.out.println("joinprocess");
		int result = memberservice.insert(member);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		if (result == 1) {

			out.println("alert('회원가입을 축하합니다.')");
			out.println("location.href='login.net';");

		} else if (result == -1) {
			out.println("alert('회원가입 실패')");
			out.println("history.back()");

		}
		out.println("</script>");
	}
	
	@RequestMapping(value = "/idcheck.net", method = RequestMethod.GET)
	public void idcheck(@RequestParam(value = "id") String id, HttpServletResponse response) throws Exception {

		int result = memberservice.isId(id);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);

	}

	@RequestMapping(value = "/loginProcess.net")
	public String loginProcess(@RequestParam(value = "id") String id, @RequestParam(value = "password") String password,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		int result = memberservice.isId(id, password);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if (result == 1) {
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			//return "member/main" //boardlist.bo 
			return "/home";
		} else {
			String message = "";
			if (result == -1)
				message = "로그인 실패";
			else
				message = "로그인 실패";
			out.println("<script>");
			out.println("alert('" + message + "');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;

		}

	}
	
	
}
