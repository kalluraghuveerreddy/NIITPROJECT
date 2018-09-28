package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Accessories;

public interface AccessoriesDaoService {

	
	public boolean add(Accessories accessories);
	public boolean delete(Accessories accessories);
	public boolean update(Accessories accessories);
	public  Accessories getAccessories(int product_id);
	
	
}
