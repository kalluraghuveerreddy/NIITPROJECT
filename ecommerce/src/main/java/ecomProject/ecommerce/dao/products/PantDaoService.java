package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Pant;

public interface PantDaoService {

	public boolean add(Pant pant);
	public boolean delete(Pant pant);
	public boolean update(Pant pant);
	public Pant getPants(int product_id);
}
