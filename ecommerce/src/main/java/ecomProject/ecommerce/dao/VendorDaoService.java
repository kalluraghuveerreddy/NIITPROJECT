package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Vendor;

public interface VendorDaoService {

	
	public boolean addVendor(Vendor vendor);
	public boolean deleteVendor(Vendor vendor);
	public boolean updateVendor(Vendor vendor);
	public Vendor getVendor(int vendor_id);
	public Vendor login(String vendor_email,String vendor_password);
	
}
