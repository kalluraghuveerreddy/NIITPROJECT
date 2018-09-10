package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.Customer;

public interface CustomerDaoService {
	
	
	public boolean registerCustomer(Customer customer);
	public Customer loginCustomer(String customer_email,String customer_password);
	public boolean deleteCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(int customer_id);
	public Customer getCustomerByEmail(String customer_email);
	public List<Customer> getAllCustomerDetails();

	
	
}
