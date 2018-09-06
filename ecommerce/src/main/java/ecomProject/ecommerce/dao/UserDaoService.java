package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.User;

public interface UserDaoService {

	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User getUserDetails(int user_id);
	public User getUserDetailsByEmail(String email);
	public User loginUser(String email,String password);
	public List<User>  getVendorDetails();
	
}
