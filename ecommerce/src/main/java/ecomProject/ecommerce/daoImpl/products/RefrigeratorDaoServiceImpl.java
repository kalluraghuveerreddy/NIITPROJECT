package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.RefrigeratorDaoService;
import ecomProject.ecommerce.model.products.Mobile;
import ecomProject.ecommerce.model.products.Refrigerator;
@Component
@Transactional
public class RefrigeratorDaoServiceImpl implements RefrigeratorDaoService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addRefrigerator(Refrigerator refrigerator) {
		try {
			sessionFactory.getCurrentSession().save(refrigerator);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteRefrigerator(Refrigerator refrigerator) {
		try {
			sessionFactory.getCurrentSession().delete(refrigerator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateRefrigerator(Refrigerator refrigerator) {
		try {
			sessionFactory.getCurrentSession().update(refrigerator);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Refrigerator getRefrigerator(int product_id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Refrigerator.class,product_id);
		} catch (Exception e) {
			return null;
		}
	}

}
