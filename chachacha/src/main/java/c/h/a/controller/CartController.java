package c.h.a.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import c.h.a.domain.Cart;
import c.h.a.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	// 1. 장바구니 추가(카트에 담기)
	@RequestMapping(value="addCart.bo", method= RequestMethod.POST)
	public String addCart(@ModelAttribute Cart cart, HttpSession session)
	throws Exception{
		
		String userId = (String)session.getAttribute("id");
		System.out.println("userId : " +userId);
		System.out.println("c_no : "  +cart.getC_no());
		
		cart.setC_id(userId);
		// 장바구니에 기존 상품이 있는지 검사하는 부분
		int count = cartService.countCart(cart.getP_code(), userId);
		if( count == 0) {
			// 장바구니에 상품이 없으면 insert
			cartService.addCart(cart);
		} else {
			// 장바구니에 상품이 있으면 update
			cartService.updateCart(cart);
		}
		
		
		return "redirect:cartList.bo";
	}
	
	// 2. 장바구니 목록
	@RequestMapping(value="/cartList.bo")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		String userId = (String)session.getAttribute("id");
		System.out.println("USERID : "+userId);
		Map<String,Object> map = new HashMap<String ,Object>();
		List<Cart> list = cartService.listCart(userId);	//장바구니 정보
		int sumMoney = cartService.sumMoney(userId);	//장바구니 전체 금액 호출
		// 장바구니 전체 금액에 따라 배송비 구분
		// 배송료(10만원이상 => 무료, 미만 => 2500원)
		int fee = sumMoney >= 100000 ? 0 : 2500;
		map.put("list", list);				//장바구니 정보를 map에 저장
		map.put("count",list.size());		//장바구니 상품의 유무
		System.out.println("count : " + list.size());
		map.put("sumMoney", sumMoney);		//장바구니 전체 금액
		map.put("fee", fee);				//배송금액
		map.put("allSum",sumMoney+fee);		//주문 상품 전체 금액
		mv.addObject("map", map);			
		mv.setViewName("cart/cartList");	
		
		return mv;
	}
	
	// 3. 장바구니 삭제
	@RequestMapping(value="/CartDelete.bo")
	public String delete(@RequestParam int cartId) {
		cartService.delete(cartId);
		return "redirect:cartList.bo";
	}
	
	// 4. 장바구니 수정
	@RequestMapping(value="/CartUpdate.bo")
	public String update(@RequestParam int[] c_amount,
			@RequestParam int[] p_code, HttpSession session) {
		
		String userId = (String) session.getAttribute("id");
		
		for(int i=0;i<p_code.length;i++) {
			Cart cart = new Cart();
			cart.setC_id(userId);
			cart.setC_amount(c_amount[i]);
			cart.setP_code(p_code[i]);
			cartService.modifyCart(cart);
		}
		
		return "redirect:cartList.bo";
		
	}
	
}
