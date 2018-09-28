package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.PantDaoService;
import ecomProject.ecommerce.model.products.Kurta;
import ecomProject.ecommerce.model.products.Pant;
@Component
@Transactional
public class PantDaoServiceImpl implements PantDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean add(Pant pant) {
		 try {
				sessionFactory.getCurrentSession().save(pant);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean delete(Pant pant) {
		 try {
				sessionFactory.getCurrentSession().delete(pant);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean update(Pant pant) {
		 try {
				sessionFactory.getCurrentSession().update(pant);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public Pant getPants(int product_id) {
		 try {
				Query<Pant> query=sessionFactory.getCurrentSession().createQuery("from Pant where product_id=:id",Pant.class);
				query.setParameter("id", product_id);
				return query.getSingleResult();
				
			} catch (Exception e) {
				return null;
			}
		}
	

}
