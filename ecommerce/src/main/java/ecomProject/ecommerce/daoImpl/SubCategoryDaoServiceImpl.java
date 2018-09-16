package ecomProject.ecommerce.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.SubCategoryDaoService;
import ecomProject.ecommerce.model.SubCategory;

@Component
@Transactional
public class SubCategoryDaoServiceImpl implements SubCategoryDaoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SubCategory getSubCategoryId(int subcategory_Id) {

		try {

			return sessionFactory.getCurrentSession().get(SubCategory.class, subcategory_Id);

		} catch (HibernateException e) {

			return null;
		}

	}

	@Override
	public List<SubCategory> getSubcategory(int category_id) {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=:id", SubCategory.class);
			query.setParameter("id", category_id);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getSubcategoryId(String subCategory_name) {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where subCategory_name=:name", SubCategory.class);
			query.setParameter("name", subCategory_name);
			return query.getSingleResult().getSubCategory_id();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<SubCategory> getAllSubCategoryList() {

		try {
			return sessionFactory.getCurrentSession().createCriteria(SubCategory.class).list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getElectronics() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=1", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getMen() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=2", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getWomen() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=3", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getKids() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=4", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getHomeAppliances() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=5", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<SubCategory> getBooks() {
		try {
			Query<SubCategory> query = sessionFactory.getCurrentSession()
					.createQuery("from SubCategory where category_category_id=6", SubCategory.class);

			return query.getResultList();
		} catch (Exception e) {
			return null;
		}

	}
}
