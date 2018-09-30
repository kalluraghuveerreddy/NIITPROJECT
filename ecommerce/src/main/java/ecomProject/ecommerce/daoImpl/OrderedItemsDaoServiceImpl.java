package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.OrderedItemsDaoService;
import ecomProject.ecommerce.model.OrderedItems;
@Component
@Transactional
public class OrderedItemsDaoServiceImpl implements OrderedItemsDaoService {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrderedItems(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().save(orderedItems);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean deleteOrderedItems(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().delete(orderedItems);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean updateOrederedItems(OrderedItems orderedItems) {
		try {
			sessionFactory.getCurrentSession().update(orderedItems);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public List<OrderedItems> getOrderedItemsList(int order_id) {
		 try {
				return	sessionFactory.getCurrentSession().createQuery("from OrderedItems where order_order_id=:id",OrderedItems.class).setParameter("id",order_id).getResultList();
					
				} catch (HibernateException e) {
					
					return null;
		} 
	}

}
