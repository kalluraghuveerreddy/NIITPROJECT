package ecomProject.ecommerce.dao;

import java.util.List;

import ecomProject.ecommerce.model.Product;
import ecomProject.ecommerce.model.Vendor;

public interface VendorDaoService {
	
	public boolean registerVendor(Vendor vendor);
	public Vendor loginVendor(String vendor_email,String vendor_password);
	public boolean update(Vendor vendor);
	public boolean delete(Vendor vendor);
	public Vendor getVendorById(int vendor_id);
	public Vendor getVendorByEmail(String vendor_email);
	public List<Vendor> getAllVendorDetails();
	


}
