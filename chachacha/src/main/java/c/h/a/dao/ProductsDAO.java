package c.h.a.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import c.h.a.domain.Products;

@Repository
public class ProductsDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	public int addproduct(Products product) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Products.addproduct",product);
	}
	public List<Products> productlist() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Products.productlist");
		
	}

}
