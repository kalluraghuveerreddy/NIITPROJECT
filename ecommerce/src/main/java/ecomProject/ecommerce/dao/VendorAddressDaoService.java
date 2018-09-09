package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.VendorAddress;

public interface VendorAddressDaoService {
	
	public boolean addAddress(VendorAddress vendorAddress);
	public boolean deleteAddress(VendorAddress vendorAddress);
	public  VendorAddress updateAddress(VendorAddress vendorAddresss);
	public VendorAddress getAddress(int vendorAddress_id);

}
