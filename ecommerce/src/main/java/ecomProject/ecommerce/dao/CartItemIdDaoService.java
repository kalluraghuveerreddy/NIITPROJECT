package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.CartItemId;

public interface CartItemIdDaoService {

	public boolean addCartItemIds(CartItemId cartItemId);

	public boolean deleteCartItemIds(CartItemId cartItemId);

	public boolean updateCartItemIds(CartItemId cartItemId);

	public boolean deleteAllCartItemIds(int cartItem_id);

	public List<CartItemId> getAllCartItemIds(int cartItem_id);

}
