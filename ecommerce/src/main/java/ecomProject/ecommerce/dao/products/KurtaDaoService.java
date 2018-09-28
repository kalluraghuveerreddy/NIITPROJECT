package ecomProject.ecommerce.dao.products;

import ecomProject.ecommerce.model.products.Kurta;

public interface KurtaDaoService {

	public boolean add(Kurta kurta);
	public boolean update(Kurta kurta);
	public boolean delete(Kurta kurta);
	public Kurta getKurtas(int product_id);
}
