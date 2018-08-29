package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
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
	public SubCategory getSubCategory(int subcategory_Id) {
		
		try {
			
		return	sessionFactory.getCurrentSession().get(SubCategory.class,subcategory_Id);
			
			
		} catch (HibernateException e) {
			
			return null;
		}

	}

}
