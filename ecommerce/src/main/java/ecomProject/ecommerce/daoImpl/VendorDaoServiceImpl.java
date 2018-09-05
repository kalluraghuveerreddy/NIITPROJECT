package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.VendorDaoService;
import ecomProject.ecommerce.model.Vendor;

@Component
@Transactional
public class VendorDaoServiceImpl implements VendorDaoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean register(Vendor vendor) {

		try {

			sessionFactory.getCurrentSession().save(vendor);
			return true;

		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public boolean deleteVendor(Vendor vendor) {
		try {
			sessionFactory.getCurrentSession().delete(vendor);
			return true;
		} catch (HibernateException e) {

			return false;
		}

	}

	@Override
	public boolean updateVendor(Vendor vendor) {
		try {
			sessionFactory.getCurrentSession().update(vendor);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public Vendor getVendorById(int vendor_id) {
		try {
			return sessionFactory.getCurrentSession().get(Vendor.class, vendor_id);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Vendor login(String vendor_email, String vendor_password) {
		try {
			Query<Vendor> query = sessionFactory.getCurrentSession().createQuery(
					"from Vendor where vendor_email=:vendor_email and vendor_password=:vendor_password", Vendor.class);
			query.setParameter("vendor_email", vendor_email);
			query.setParameter("vendor_password", vendor_password);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Vendor getVendorByEmail(String vendor_email) {
	
		try {
			Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor where vendor_email=:vendor_email",Vendor.class);
			query.setParameter("vendor_email", vendor_email);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Vendor>getAllVendorsDetails() {
		try {
			return sessionFactory.getCurrentSession().createCriteria(Vendor.class).list();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
