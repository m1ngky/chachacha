package c.h.a.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import c.h.a.domain.Products;
import c.h.a.service.ProductsService;

@Controller
public class ProductsController {
	@Autowired
	ProductsService pservice;
	
	@GetMapping(value="addproduct")
	public String addproduct(Products product,HttpServletResponse response) throws IOException {
		int result = pservice.addproduct(product);
		
		response.setContentType("text/html;utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.println("<script>");
			out.println("alert('판매상품이 등록되었습니다.')");
			out.println("location.href='home'");
			out.println("</script>");			
		}else {
			out.println("<script>");
			out.println("alert('등록실패입니다.')");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		
		return null;   
		
	}

}
