package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
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
	public boolean addCartItem(CartItems cartItems) {

		try {
			sessionFactory.getCurrentSession().save(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteCartItem(CartItems cartItems) {

		try {
			sessionFactory.getCurrentSession().delete(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItems cartItems) {

		try {
			sessionFactory.getCurrentSession().update(cartItems);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CartItems> getAllCartItemsByCartId(int cart_id) {

		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItems where cart_cart_id=:id", CartItems.class).setParameter("id", cart_id)
					.getResultList();
		} catch (HibernateException e) {

			return null;
		}
	}

	@Override
	public CartItems getCartItemByCartId(int cart_id) {
		try {
			return (CartItems) sessionFactory.getCurrentSession().createQuery("from CartItems where cart_cart_id=:id")
					.setParameter("id", cart_id).getSingleResult();
		} catch (HibernateException e) {

			return null;
		}
	}

	@Override
	public boolean deleteAllCartItems(int cart_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItems where cart_cart_id=:id")
					.setParameter("id", cart_id);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

}
