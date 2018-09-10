package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.CustomerDaoService;
import ecomProject.ecommerce.model.Customer;
@Component
@Transactional
public class CustomerDaoServiceImpl implements CustomerDaoService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registerCustomer(Customer customer) {
		try {
		sessionFactory.getCurrentSession().save(customer);
		return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().delete(customer);
			return true;
			}catch(Exception e) {
				return false;
			}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().update(customer);
			return true;
			}catch(Exception e) {
				return false;
			}	}

	@Override
	public Customer getCustomerById(int customer_id) {
		
		return null;
	}

	@Override
	public Customer getCustomerByEmail(String customer_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
