package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.AdminPerson;
import ecomProject.ecommerce.model.Vendor;

public interface AdminDaoService {
	
	public boolean registerAdmin(AdminPerson adminPerson);
	public AdminPerson login(String email,String password);
	public AdminPerson getAdminDetailsById(int id);
	public List<Vendor>  getAllVendors();

}
