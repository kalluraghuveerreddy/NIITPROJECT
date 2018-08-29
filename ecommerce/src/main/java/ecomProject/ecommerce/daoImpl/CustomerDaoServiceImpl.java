package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.model.Customer;

@Component
@Transactional
public class CustomerDaoServiceImpl  implements CustomerDaoService{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addEndUser(Customer endUser) {
		
		try {
			
			sessionFactory.getCurrentSession().save(endUser);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean delete(Customer endUser) {
		
		try {
			sessionFactory.getCurrentSession().delete(endUser);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Customer getCustomer(int customerId) {
		
		try {
			return sessionFactory.getCurrentSession().get(Customer.class,customerId);
		}
		catch(Exception e) {
		return null;
	    }
	}

	@Override
	public Customer login(String email, String password) {
		
		return null;
	}

}
