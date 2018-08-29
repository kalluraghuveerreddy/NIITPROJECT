package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Laptop;

public interface LaptopDaoService {
	
	public boolean  addLaptop(Laptop Laptop);
	public boolean  deleteLaptop(Laptop laptop);
	public Laptop getLaptopDetails(int product_id);

}
