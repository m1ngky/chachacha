package c.h.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.h.a.dao.ProductsDAO;
import c.h.a.domain.Products;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	ProductsDAO dao;
	@Override
	public int addproduct(Products product) {
		
		return dao.addproduct(product);
	}
	@Override
	public List<Products> productlist() {
		return dao.productlist();
		
	}

}
