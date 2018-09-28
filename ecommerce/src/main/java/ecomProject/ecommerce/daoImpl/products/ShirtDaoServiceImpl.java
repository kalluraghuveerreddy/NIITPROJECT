package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.ShirtDaoService;
import ecomProject.ecommerce.model.products.Pant;
import ecomProject.ecommerce.model.products.Shirt;
@Component
@Transactional
public class ShirtDaoServiceImpl implements ShirtDaoService{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean add(Shirt shirt) {
		 try {
				sessionFactory.getCurrentSession().save(shirt);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean delete(Shirt shirt) {
		 try {
				sessionFactory.getCurrentSession().delete(shirt);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean update(Shirt shirt) {
		 try {
				sessionFactory.getCurrentSession().update(shirt);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public Shirt getShirts(int product_id) {
		 try {
				Query<Shirt> query=sessionFactory.getCurrentSession().createQuery("from Shirt where product_id=:id",Shirt.class);
				query.setParameter("id", product_id);
				return query.getSingleResult();
				
			} catch (Exception e) {
				return null;
			}
	}

}
