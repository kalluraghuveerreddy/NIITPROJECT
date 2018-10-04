package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.NoOfProductDaoService;
import ecomProject.ecommerce.model.NoOfProducts;

@Component
@Transactional
public class NoOfProductDaoServiceImpl implements NoOfProductDaoService {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addNoOfProducts(NoOfProducts noOfProducts) {

		try {
			sessionFactory.getCurrentSession().save(noOfProducts);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<NoOfProducts> getNoOfProducts(int product_id) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from NoOfProducts where product_product_id=:id and sold=false")
					.setParameter("id", product_id).getResultList();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public NoOfProducts  getNoOfProductsByNoOfproductsId(int item_no) {
		try {
			return (NoOfProducts) sessionFactory.getCurrentSession()
					.createQuery("from NoOfProducts where item_no=:id").setParameter("id", item_no)
					.getSingleResult();
		} catch (HibernateException e) {
			
			return null;
		}
	}

}
