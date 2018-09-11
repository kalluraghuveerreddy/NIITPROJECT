package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.Category;

public interface CategoryDaoService {
	
	public boolean addCategory(Category category);
	
	public List<Category> getCategories();
	
	public Category getCategoryById(int category_id);
	
}
