package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.SubCategory;

public interface SubCategoryDaoService {

	
	public SubCategory getSubCategoryId(int subCategoryId);
	public List<SubCategory> getSubcategory(int category_id);
	
}
