package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.RefrigeratorDaoService;
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

}
