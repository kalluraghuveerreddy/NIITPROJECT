package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Customer;

public interface CustomerDaoService {
	
	public boolean addEndUser(Customer endUser);
	public boolean delete(Customer endUser);
	public Customer getCustomer(int customerId);
	public Customer login(String email,String password);

}
