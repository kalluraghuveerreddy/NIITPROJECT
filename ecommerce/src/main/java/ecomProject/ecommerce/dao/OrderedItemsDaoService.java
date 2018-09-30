package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.OrderedItems;

public interface OrderedItemsDaoService {
	public  boolean addOrderedItems(OrderedItems orderedItems);
	public  boolean deleteOrderedItems(OrderedItems orderedItems);
	public  boolean updateOrederedItems(OrderedItems orderedItems);
    public  List<OrderedItems> getOrderedItemsList(int order_id);
}
