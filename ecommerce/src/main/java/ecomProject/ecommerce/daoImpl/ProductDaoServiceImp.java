package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.model.Product;

@Component
@Transactional
public class ProductDaoServiceImp implements ProductDaoService{
	
   @Autowired
   private SessionFactory sessionFactory; 
   
   
  
	@Override
	public boolean addProduct(Product product) {
		
		try {
		sessionFactory.getCurrentSession().save(product);
		return true;
		}
		catch(HibernateException e)
		{
			return false;
		}
	
	}
	
	@Override
	public boolean deleteProduct(Product product) {
	
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;			
		} catch (HibernateException e) {
		
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;			
		} catch (HibernateException e) {
			
			return false;
		}

	}

}
