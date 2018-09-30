package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.OrderedItemIdDaoService;
import ecomProject.ecommerce.model.OrderedItemId;
@Component
@Transactional
public class OrderedItemsIdDaoServiceImpl implements OrderedItemIdDaoService {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrderedItemIds(OrderedItemId orderedItemId) {
		try {
			sessionFactory.getCurrentSession().save(orderedItemId);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean deleteOrderedItemIds(OrderedItemId orderedItemId) {
		try {
			sessionFactory.getCurrentSession().delete(orderedItemId);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean updateOrderedItemIds(OrderedItemId orderedItemId) {
		try {
			sessionFactory.getCurrentSession().update(orderedItemId);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public List<OrderedItemId> getOrderedItemIdsList(int orderedItem_id) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from OrderedItemId where orderedItem_orderedItem_id=:id", OrderedItemId.class)
					.setParameter("id", orderedItem_id).getResultList();
		} catch (HibernateException e) {

			return null;
		}
	}

}
