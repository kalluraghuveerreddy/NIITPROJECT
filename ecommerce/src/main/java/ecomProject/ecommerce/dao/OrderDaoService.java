package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.Ordered;

public interface OrderDaoService {
	
	public  boolean addOrder(Ordered order);
	public  boolean deleteOrder(Ordered order);
	public boolean updateOrder(Ordered order);
    public  List<Ordered> getOrderListByCustomerId(int customer_id);

}
