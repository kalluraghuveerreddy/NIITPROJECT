package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.CartItemIdDaoService;
import ecomProject.ecommerce.model.CartItemId;
@Component
@Transactional
public class CartItemIdDaoServiceImpl implements CartItemIdDaoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCartItemIds(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().save(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItemIds(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().delete(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItemIds(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().update(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllCartItemIds(int cartItem_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItemId where cartItems_cartItems_id=:id")
					.setParameter("id", cartItem_id);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public List<CartItemId> getAllCartItemIds(int cartItem_id) {

		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItemIds where cartItems_cartItemsId=:id", CartItemId.class)
					.setParameter("id", cartItem_id).getResultList();
		} catch (HibernateException e) {
			
			return null;
		}
	}
}
