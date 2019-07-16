package c.h.a.service;

import java.util.List;

import c.h.a.domain.Product;

public interface ProductService {

	public List<Product> productList(String p_category);

	public Product productDetail(int productId);

}

