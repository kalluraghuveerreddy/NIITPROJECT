package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.OrderDaoService;
import ecomProject.ecommerce.model.Ordered;
@Component
@Transactional
public class OrderDaoServiceImpl implements OrderDaoService {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrder(Ordered order) {
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean deleteOrder(Ordered order) {
		try {
			sessionFactory.getCurrentSession().delete(order);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean updateOrder(Ordered order) {
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public List<Ordered> getOrderListByCustomerId(int customer_id) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from Order where customer_customer_id=:id", Ordered.class)
					.setParameter("id", customer_id).getResultList();
		} catch (HibernateException e) {

			return null;
		}
	}

}
