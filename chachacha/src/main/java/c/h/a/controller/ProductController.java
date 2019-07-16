package c.h.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import c.h.a.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/productList.bo")
	public ModelAndView productList(@RequestParam(value="p_category") String p_category,ModelAndView mv) {
		mv.addObject("plist", productService.productList(p_category));
		mv.setViewName("product/productList");
		
		return mv;
	}
	
	@RequestMapping(value="/ProductDetail.bo")
	public ModelAndView productDetail(@RequestParam(value="p_code")
	int productId, ModelAndView mv) {
		mv.addObject("vo", productService.productDetail(productId));
		mv.setViewName("product/productDetail");
		
		return mv;
		
	}


}
