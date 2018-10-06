package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.CartItemId;

public interface CartItemIdDaoService {

	public boolean addCartItemId(CartItemId cartItemId);

	public boolean deleteCartItemId(CartItemId cartItemId);

	public boolean updateCartItemId(CartItemId cartItemId);

	public boolean deleteAllCartItemId(int cartItem_id);

	public List<CartItemId> getAllCartItemId(int cartItem_id);

}
