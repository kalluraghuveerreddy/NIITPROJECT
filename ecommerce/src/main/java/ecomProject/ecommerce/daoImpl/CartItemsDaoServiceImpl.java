package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.CartDaoService;
import ecomProject.ecommerce.dao.CartItemsDaoService;
import ecomProject.ecommerce.model.CartItems;
@Component
@Transactional
public class CartItemsDaoServiceImpl implements CartItemsDaoService {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean addCartItems(CartItems cartItems) {
		try {
			sessionFactory.getCurrentSession().save(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CartItems getCartItems(int cart_id) {
		
		return null;
	}

}
