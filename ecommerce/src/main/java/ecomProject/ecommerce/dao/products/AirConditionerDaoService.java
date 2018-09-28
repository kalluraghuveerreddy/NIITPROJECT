package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.AirConditioner;

public interface AirConditionerDaoService {

	public boolean add(AirConditioner airConditioner);
	public boolean delete(AirConditioner airConditioner);
	public boolean update(AirConditioner airConditioner);
	public AirConditioner getAirConditioners(int product_id);
	
	
}
