package ecomProject.ecommerce.daoImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.ProductDaoService;
import ecomProject.ecommerce.model.Product;

@Component
@Transactional
public class ProductDaoServiceImp implements ProductDaoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}

	@Override
	public boolean deleteProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {

			return false;
		}

	}

	@Override
	public List<Product> getAllProducts(int vendor_id) {
		try {
			Query<Product> query = sessionFactory.getCurrentSession()
					.createQuery("from Product where vendor_vendor_id =: id", Product.class);
			query.setParameter("id", vendor_id);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getSubCategoryId(int product_id) {

		try {
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product where product_id =:id",
					Product.class);
			query.setParameter("id", product_id);
			Product product = query.getSingleResult();
			System.out.println(product.getSubCategory().getSubCategory_id());
			return product.getSubCategory().getSubCategory_id();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Product> getProducts(int subCategory_id) {
		try {
			Query<Product> query = sessionFactory.getCurrentSession()
					.createQuery("from Product where subCategory_subCategory_id =: id", Product.class);
			query.setParameter("id", subCategory_id);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product getProduct(int product_id) {
		try {
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product where product_id =:id",
					Product.class);
			query.setParameter("id", product_id);
			return query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product ", Product.class);

			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getProducts(String product_name) {
		try {
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product where product_name=:product_name ", Product.class);
            query.setParameter("product_name", product_name);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
