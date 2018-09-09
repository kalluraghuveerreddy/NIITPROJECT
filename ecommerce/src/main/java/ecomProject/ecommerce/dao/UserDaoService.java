package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.Customer;

public interface UserDaoService {

	public boolean registerUser(Customer user);
	public boolean updateUser(Customer user);
	public boolean deleteUser(Customer user);
	public Customer getUserDetails(int user_id);
	public Customer getUserDetailsByEmail(String email);
	public Customer loginUser(String email,String password);
	public List<Customer>  getVendorDetails();
	public List<Customer>  getActiveVendorDetails();
	
	
	
}
