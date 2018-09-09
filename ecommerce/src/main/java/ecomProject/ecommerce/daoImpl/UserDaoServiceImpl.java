package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.UserDaoService;
import ecomProject.ecommerce.model.Customer;


@Component
@Transactional
public class UserDaoServiceImpl  implements UserDaoService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registerUser(Customer user) {
	
		try {
			
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateUser(Customer user) {
		   
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(Customer user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Customer getUserDetails(int user_id) {
		try {
			Customer user=sessionFactory.getCurrentSession().get(Customer.class, user_id);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Customer loginUser(String email, String password) {
		
		try {
			Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email and password=:password" , Customer.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {

          return null;
		}	
	}

	@Override
	public List<Customer> getVendorDetails() {
		try {
			Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from User where role='vendor'",Customer.class);
			return query.getResultList();
		}
	   catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	
	}

	@Override
	public Customer getUserDetailsByEmail(String email) {
		try {
			Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email", Customer.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	}

	@Override
	public List<Customer> getActiveVendorDetails() {
		try {
			Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from User where role='vendor' and status=true",Customer.class);
			return query.getResultList();
		}
	   catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	}

}
