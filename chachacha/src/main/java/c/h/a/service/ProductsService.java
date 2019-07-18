package c.h.a.service;

import java.util.List;

import c.h.a.domain.Products;

public interface ProductsService {

	int addproduct(Products product);

	List<Products> productlist();

}
