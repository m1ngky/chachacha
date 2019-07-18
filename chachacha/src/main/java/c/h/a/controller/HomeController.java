package c.h.a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/home")
	public String home() {
		
		
		System.out.println("home입니다.");
		
		return "home";
	}

	
	@RequestMapping(value="/productcommit.cha")
	public String productcommit() {
		System.out.println("판매자 상품 등록");
		return "productcommit";
		
	}
	
	@RequestMapping(value="/board_list")
	public String board_list() {
		System.out.println("board리스트입니다.");
		return "board_list";
	}
	
}
