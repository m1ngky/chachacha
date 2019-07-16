package c.h.a.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import c.h.a.domain.Product;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Product> productList(String p_category){
		return sqlSession.selectList("Products.productList",p_category);
	}
	
	public Product productDetail(int p_code) {
		return sqlSession.selectOne("Products.productDetail", p_code);
	}
	
	

}
