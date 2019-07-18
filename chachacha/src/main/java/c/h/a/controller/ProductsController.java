package c.h.a.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import c.h.a.domain.Products;
import c.h.a.service.ProductsService;

@Controller
public class ProductsController {

	@Autowired
	ProductsService pservice;

	@PostMapping(value="addproduct")
	
	public void addproduct(Products product,HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		
		
		MultipartFile uploadfile = product.getP_uploadfile();

		if (!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename(); // 원래 파일명
			product.setP_originalfile(fileName);// 원래 파일명 저장
			System.out.println("원래파일명 저장");
			// 새로운 폴더 이름 : 오늘 년+월+일
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR); // 년도
			int month = c.get(Calendar.MONTH) + 1; // 월
			int date = c.get(Calendar.DATE); // 일
			String saveFolder = request.getSession().getServletContext().getRealPath("resources") + "/upload/";
			String homedir = saveFolder + year + "-" + month + "-" + date;
			System.out.println(homedir);
			File path1 = new File(homedir);
			if (!(path1.exists())) {
				path1.mkdir();
			}

			// 난수를 구합니다.
			Random r = new Random();
			int random = r.nextInt(10000000);

			/**** 확장자 구하기 시작 ****/
			int index = fileName.lastIndexOf(".");
			// 문자열에서 특정 문자열의 위치 값(index)를 반환한다.
			// indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
			// lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
			// (파일명에 점이 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.)
			System.out.println("index = " + index);

			String fileExtension = fileName.substring(index + 1);
			System.out.println("fileExtension = " + fileExtension);
			/**** 확장자 구하기 끝 ****/

			// 새로운 파일명
			String refileName = "chachacha" + year + month + date + random + "." + fileExtension;
			System.out.println("refileName" + refileName);

			// 오라클 디비에 저장될 파일 명
			String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
			System.out.println("fileDBName" + fileDBName);

			// transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			uploadfile.transferTo(new File(saveFolder + fileDBName));

			// 바뀐 파일명으로 저장
			product.setP_savefile(fileDBName);

		}
		
		System.out.println("전");
		int result =pservice.addproduct(product);		
		System.out.println("insert 후");
		
		response.setContentType("text/html;utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			out.println("<script>");
			out.println("alert('판매상품이 등록되었습니다.')");
			out.println("location.href='productlist.cha'");
			out.println("</script>");			
		}else {
			out.println("<script>");
			out.println("alert('상품등록실패입니다.')");
			out.println("history.back()");
			out.println("</script>");	
		}		


	}
	
	@GetMapping(value="/productlist.cha")
	
	public ModelAndView productlist(Products product,ModelAndView mv) {
		
		List<Products> list = pservice.productlist();
		mv.addObject("productlist", list);
		mv.setViewName("mingky/productlist");
		
		
		
		return mv;
		
	}
	

	
	

}
