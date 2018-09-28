package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.CartDaoService;
import ecomProject.ecommerce.model.Cart;
@Component
@Transactional
public class CartDaoServiceImpl implements CartDaoService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Cart getCart(int customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
