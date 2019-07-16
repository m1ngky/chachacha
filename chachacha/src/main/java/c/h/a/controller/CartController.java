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
	
	// 1. ��ٱ��� �߰�(īƮ�� ���)
	@RequestMapping(value="addCart.bo", method= RequestMethod.POST)
	public String addCart(@ModelAttribute Cart cart, HttpSession session)
	throws Exception{
		
		String userId = (String)session.getAttribute("id");
		System.out.println("userId : " +userId);
		System.out.println("c_no : "  +cart.getC_no());
		
		cart.setC_id(userId);
		// ��ٱ��Ͽ� ���� ��ǰ�� �ִ��� �˻��ϴ� �κ�
		int count = cartService.countCart(cart.getP_code(), userId);
		if( count == 0) {
			// ��ٱ��Ͽ� ��ǰ�� ������ insert
			cartService.addCart(cart);
		} else {
			// ��ٱ��Ͽ� ��ǰ�� ������ update
			cartService.updateCart(cart);
		}
		
		
		return "redirect:cartList.bo";
	}
	
	// 2. ��ٱ��� ���
	@RequestMapping(value="/cartList.bo")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		String userId = (String)session.getAttribute("id");
		System.out.println("USERID : "+userId);
		Map<String,Object> map = new HashMap<String ,Object>();
		List<Cart> list = cartService.listCart(userId);	//��ٱ��� ����
		int sumMoney = cartService.sumMoney(userId);	//��ٱ��� ��ü �ݾ� ȣ��
		// ��ٱ��� ��ü �ݾ׿� ���� ��ۺ� ����
		// ��۷�(10�����̻� => ����, �̸� => 2500��)
		int fee = sumMoney >= 100000 ? 0 : 2500;
		map.put("list", list);				//��ٱ��� ������ map�� ����
		map.put("count",list.size());		//��ٱ��� ��ǰ�� ����
		System.out.println("count : " + list.size());
		map.put("sumMoney", sumMoney);		//��ٱ��� ��ü �ݾ�
		map.put("fee", fee);				//��۱ݾ�
		map.put("allSum",sumMoney+fee);		//�ֹ� ��ǰ ��ü �ݾ�
		mv.addObject("map", map);			
		mv.setViewName("cart/cartList");	
		
		return mv;
	}
	
	// 3. ��ٱ��� ����
	@RequestMapping(value="/CartDelete.bo")
	public String delete(@RequestParam int cartId) {
		cartService.delete(cartId);
		return "redirect:cartList.bo";
	}
	
	// 4. ��ٱ��� ����
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
