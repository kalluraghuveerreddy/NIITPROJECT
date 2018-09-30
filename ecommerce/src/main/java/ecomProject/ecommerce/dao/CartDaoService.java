package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Cart;

public interface CartDaoService {

	public boolean addCart(Cart cart);

	public boolean updateCart(Cart cart);

	public boolean deleteCart(Cart cart);

	public Cart getCart(int customer_id);

}
