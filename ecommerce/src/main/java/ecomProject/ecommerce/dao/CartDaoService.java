package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Cart;

public interface CartDaoService {
	
	public boolean addCart(Cart cart);
	public Cart getCart(int customer_id);

	
}
