package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.AirConditionerDaoService;
import ecomProject.ecommerce.model.products.Accessories;
import ecomProject.ecommerce.model.products.AirConditioner;
@Component
@Transactional
public class AirConditionerDaoServiceImpl implements AirConditionerDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(AirConditioner airConditioner) {
		
		   try {
				sessionFactory.getCurrentSession().save(airConditioner);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean delete(AirConditioner airConditioner) {
		 try {
				sessionFactory.getCurrentSession().delete(airConditioner);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean update(AirConditioner airConditioner) {
		 try {
				sessionFactory.getCurrentSession().update(airConditioner);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public AirConditioner getAirConditioners(int product_id) {
	    try {
				Query<AirConditioner> query=sessionFactory.getCurrentSession().createQuery("from AirConditioner where product_id=:id", AirConditioner.class);
				query.setParameter("id", product_id);
				return query.getSingleResult();
				
			} catch (Exception e) {
				return null;
			}
		}
}
