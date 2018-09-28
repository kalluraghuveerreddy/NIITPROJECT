package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Refrigerator;

public interface RefrigeratorDaoService {
	
	
	public boolean addRefrigerator(Refrigerator refrigerator);
	public boolean deleteRefrigerator(Refrigerator refrigerator);
	public boolean updateRefrigerator(Refrigerator refrigerator);
	public Refrigerator getRefrigerator(int product_id);

}
