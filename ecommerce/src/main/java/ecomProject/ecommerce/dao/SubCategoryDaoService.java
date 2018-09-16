package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.SubCategory;

public interface SubCategoryDaoService {

	
	public SubCategory getSubCategoryId(int subCategoryId);
	public List<SubCategory> getSubcategory(int category_id);
	public int getSubcategoryId(String subCategory_name);
	public List<SubCategory> getAllSubCategoryList();
	public List<SubCategory> getElectronics();
	public List<SubCategory> getMen();
	public List<SubCategory> getWomen();
	public List<SubCategory> getKids();
	public List<SubCategory> getHomeAppliances();
	public List<SubCategory> getBooks();
	
}
