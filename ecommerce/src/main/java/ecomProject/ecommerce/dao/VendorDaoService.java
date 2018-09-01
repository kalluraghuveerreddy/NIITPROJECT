package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Vendor;

public interface VendorDaoService {

	
	public boolean  register(Vendor vendor);
	public boolean deleteVendor(Vendor vendor);
	public boolean updateVendor(Vendor vendor);
	public Vendor getVendorById(int vendor_id);
	public Vendor login(String vendor_email,String vendor_password);
	public Vendor getVendorByEmail(String vendor_email);
	
}
