package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.UserDaoService;
import ecomProject.ecommerce.model.User;


@Component
@Transactional
public class UserDaoServiceImpl  implements UserDaoService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registerUser(User user) {
	
		try {
			
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		   
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public User getUserDetails(int user_id) {
		try {
			User user=sessionFactory.getCurrentSession().get(User.class, user_id);
			return user;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public User loginUser(String email, String password) {
		
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email and password=:password" , User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {

          return null;
		}	
	}

	@Override
	public List<User> getVendorDetails() {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where role='vendor'",User.class);
			return query.getResultList();
		}
	   catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	
	}

	@Override
	public User getUserDetailsByEmail(String email) {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email", User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	}

	@Override
	public List<User> getActiveVendorDetails() {
		try {
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where role='vendor' and status=true",User.class);
			return query.getResultList();
		}
	   catch (Exception e) {
		     e.printStackTrace();
		     return null;
		}
	}

}
