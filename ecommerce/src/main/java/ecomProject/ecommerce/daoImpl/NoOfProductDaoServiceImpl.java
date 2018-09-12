package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.NoOfProductDaoService;
import ecomProject.ecommerce.model.NoOfProducts;
@Component
@Transactional
public class NoOfProductDaoServiceImpl implements NoOfProductDaoService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addNoOfProducts(NoOfProducts noOfProducts) {
		
		try {
			sessionFactory.getCurrentSession().save(noOfProducts);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
