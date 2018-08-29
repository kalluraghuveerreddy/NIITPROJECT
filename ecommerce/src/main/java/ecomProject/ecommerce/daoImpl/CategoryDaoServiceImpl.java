package ecomProject.ecommerce.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecomProject.ecommerce.dao.CategoryDaoService;
import ecomProject.ecommerce.model.Category;


@Component
@Transactional
public class CategoryDaoServiceImpl implements CategoryDaoService{
	
	  @Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public boolean addCategory(Category category) {
			
			try {
				sessionFactory.getCurrentSession().save(category);
				return true;			
			} catch (HibernateException e) {
				
				return false;
			}
			
		}

}
