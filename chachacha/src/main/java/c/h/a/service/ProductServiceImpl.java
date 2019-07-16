package c.h.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.h.a.dao.ProductDAO;
import c.h.a.domain.Product;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	ProductDAO dao;
	
	@Override
	public List<Product> productList(String p_category) {
		return dao.productList(p_category);
	}

	@Override
	public Product productDetail(int p_code) {
		return dao.productDetail(p_code);
	}

}
