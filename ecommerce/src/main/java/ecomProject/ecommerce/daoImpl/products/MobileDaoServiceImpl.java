package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.MobileDaoService;
import ecomProject.ecommerce.model.products.Mobile;
@Component
@Transactional
public class MobileDaoServiceImpl implements MobileDaoService{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().save(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().delete(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean updateMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().update(mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
