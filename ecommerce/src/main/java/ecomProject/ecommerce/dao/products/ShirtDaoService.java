package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Shirt;

public interface ShirtDaoService {

	public boolean add(Shirt shirt);
	public boolean delete(Shirt shirt);
	public boolean update(Shirt shirt);
	public Shirt getShirts(int product_id);
	
}
