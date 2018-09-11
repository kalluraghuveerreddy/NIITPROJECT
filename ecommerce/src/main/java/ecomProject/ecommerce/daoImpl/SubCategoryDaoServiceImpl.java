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
public class SubCategoryDaoServiceImpl implements SubCategoryDaoService{
	
	
	 @Autowired
		private SessionFactory sessionFactory;
	
	@Override
	public SubCategory getSubCategoryId(int subcategory_Id) {
		
		try {
			
		return	sessionFactory.getCurrentSession().get(SubCategory.class,subcategory_Id);
			
			
		} catch (HibernateException e) {
			
			return null;
		}

	}

	@Override
	public List<SubCategory> getSubcategory(int category_id) {
		try {
			Query<SubCategory> query=sessionFactory.getCurrentSession().createQuery("from SubCategory where category_category_id=:id", SubCategory.class);
			query.setParameter("id", category_id);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
