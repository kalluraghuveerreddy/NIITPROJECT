package ecomProject.ecommerce.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.products.KurtaDaoService;
import ecomProject.ecommerce.model.products.AirConditioner;
import ecomProject.ecommerce.model.products.Kurta;
@Component
@Transactional
public class KurtaDaoServiceImpl implements KurtaDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(Kurta kurta) {
		 try {
				sessionFactory.getCurrentSession().save(kurta);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean update(Kurta kurta) {
		 try {
				sessionFactory.getCurrentSession().delete(kurta);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public boolean delete(Kurta kurta) {
		 try {
				sessionFactory.getCurrentSession().update(kurta);
				return true;
			} catch (Exception e) {
				return false;
			}
	}

	@Override
	public Kurta getKurtas(int product_id) {
		 try {
				Query<Kurta> query=sessionFactory.getCurrentSession().createQuery("from Kurta where product_id=:id",Kurta.class);
				query.setParameter("id", product_id);
				return query.getSingleResult();
				
			} catch (Exception e) {
				return null;
			}
		}
	

}
