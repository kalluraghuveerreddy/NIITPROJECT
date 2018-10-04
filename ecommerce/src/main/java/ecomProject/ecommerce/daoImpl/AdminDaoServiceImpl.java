package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.AdminDaoService;
import ecomProject.ecommerce.model.AdminPerson;
import ecomProject.ecommerce.model.Vendor;
@Component
@Transactional
public class AdminDaoServiceImpl implements AdminDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean registerAdmin(AdminPerson adminPerson) {
		try {
			sessionFactory.getCurrentSession().save(adminPerson);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public AdminPerson login(String email, String password) {
		try {
			Query<AdminPerson> query=sessionFactory.getCurrentSession().createQuery("from AdminPerson where email=:email and password=:password",AdminPerson.class);
			query.setParameter("email", email);
			query.setParameter("password",password);
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AdminPerson getAdminDetailsById(int id) {
		try {
			Query<AdminPerson> query=sessionFactory.getCurrentSession().createQuery("from AdminPerson where id=:id",AdminPerson.class);
			query.setParameter("id", id);
	
			return query.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Vendor> getAllVendors() {
		try {
			Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor ",Vendor.class);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AdminPerson getAdminDetailsByEmail(String email) {
		try {
			Query<AdminPerson> query=sessionFactory.getCurrentSession().createQuery("from AdminPerson where email=:email ",AdminPerson.class);
			query.setParameter("email",email);
		
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
