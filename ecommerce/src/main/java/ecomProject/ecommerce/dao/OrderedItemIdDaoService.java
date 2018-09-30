package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.OrderedItemId;

    public interface OrderedItemIdDaoService {
	public abstract boolean addOrderedItemIds(OrderedItemId orderedItemId);
	public abstract boolean deleteOrderedItemIds(OrderedItemId orderedItemId);
	public abstract boolean updateOrderedItemIds(OrderedItemId orderedItemId);
    public abstract List<OrderedItemId> getOrderedItemIdsList(int orderedItem_id);
}
