package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.Product;

public interface ProductDaoService {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> getAllProducts(int vendor_id);
	public int getSubCategoryId(int product_id);
	

}
