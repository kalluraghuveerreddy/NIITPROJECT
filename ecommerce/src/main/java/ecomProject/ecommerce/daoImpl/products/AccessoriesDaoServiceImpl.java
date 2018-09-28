package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.AccessoriesDaoService;
import ecomProject.ecommerce.model.products.Accessories;
@Component
@Transactional
public class AccessoriesDaoServiceImpl implements AccessoriesDaoService{
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean add(Accessories accessories) {

        try {
			sessionFactory.getCurrentSession().save(accessories);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Accessories accessories) {

        try {
			sessionFactory.getCurrentSession().delete(accessories);
			return true;
		} catch (Exception e) {
			return false;
		}	}

	@Override
	public boolean update(Accessories accessories) {

        try {
			sessionFactory.getCurrentSession().update(accessories);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Accessories getAccessories(int product_id) {

        try {
			Query<Accessories> query=sessionFactory.getCurrentSession().createQuery("from Accessories where product_id=:id", Accessories.class);
			query.setParameter("id", product_id);
			return query.getSingleResult();
			
		} catch (Exception e) {
			return null;
		}
	}

}
