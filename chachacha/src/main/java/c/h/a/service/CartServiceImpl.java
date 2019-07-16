package c.h.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import c.h.a.dao.CartDAO;
import c.h.a.domain.Cart;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO dao;
	
	// 1. ��ٱ��� �߰�
	@Override
	public void addCart(Cart cart) {
		dao.addCart(cart);
	}
	
	// 2. ��ٱ��� ���
	@Override
	public List<Cart> listCart(String userId) {
		return dao.listCart(userId);
	}
	
	// 3. ��ٱ��� �ݾ� �հ�
	@Override
	public int sumMoney(String userId) {
		return dao.sumMoney(userId);
	}
	
	// 4. ��ٱ��� ����
	@Override
	public void delete(int cartId) {
		dao.delete(cartId);
	}
	
	@Override
	public void updateCart(Cart vo) {
		dao.updateCart(vo);
	}

	@Override
	public int countCart(int productId, String userId) {
		return dao.countCart(productId, userId);
	}

	@Override
	public void modifyCart(Cart cart) {
		dao.modifyCart(cart);
	}

}
