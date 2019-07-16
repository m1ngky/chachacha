package c.h.a.service;

import java.util.List;

import c.h.a.domain.Cart;

public interface CartService {
	
	public void updateCart(Cart vo);

	public int countCart(int productId, String userId);

	public void addCart(Cart vo);

	public List<Cart> listCart(String userId);

	public int sumMoney(String userId);

	public void delete(int cartId);

	public void modifyCart(Cart cart);

}
