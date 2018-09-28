package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.CartItems;

public interface CartItemsDaoService {

	public boolean addCartItems(CartItems cartItems);
	public CartItems getCartItems(int cart_id);
}
