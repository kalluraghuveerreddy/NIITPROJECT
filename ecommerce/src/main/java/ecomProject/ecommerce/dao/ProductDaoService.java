package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Product;

public interface ProductDaoService {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);

}
