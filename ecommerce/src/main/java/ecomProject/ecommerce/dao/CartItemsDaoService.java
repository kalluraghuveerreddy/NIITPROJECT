package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.CartItems;

public interface CartItemsDaoService {

	public boolean addCartItem(CartItems cartItems);

	public boolean deleteCartItem(CartItems cartItems);

	public boolean updateCartItem(CartItems cartItems);

	public List<CartItems> getAllCartItemsByCartId(int cart_id);

	public CartItems getCartItemByCartId(int cart_id);

	public boolean deleteCartItems(int cartItem_id);
	public CartItems getCartItems(int cartItems_id);

}
