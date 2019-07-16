package c.h.a.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import c.h.a.domain.Cart;

@Repository
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 1. ��ٱ��� �߰�
	public void addCart(Cart cart) {
		sqlSession.insert("Carts.addCart", cart);
	}
	
	// 2. ��ٱ��� ���
	public List<Cart> listCart(String userId){
		return sqlSession.selectList("Carts.listCart", userId);
	}
	
	// 3. ��ٱ��� �ݾ� �հ�
	public int sumMoney(String userId) {
		return sqlSession.selectOne("Carts.sumMoney", userId);
	}
	
	// 4. ��ٱ��� ����
	public void delete(int cartId) {
		sqlSession.delete("Carts.delete", cartId);
	}
	
	// 5. ��ٱ��� ����
	public void modifyCart(Cart vo) {
		sqlSession.update("Carts.modifyCart", vo);
	}
	
	// 6. ��ٱ��� ���� ��ǰ Ȯ��
	public int countCart(int productId, String userId) {
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("productId", productId);
		map.put("userId", userId);
		return sqlSession.selectOne("Carts.countCart",map);
	}
	
	// 7. ��ٱ��� ��ǰ���� ����
	public void updateCart(Cart vo) {
		sqlSession.update("Carts.updateCart", vo);
	}
}