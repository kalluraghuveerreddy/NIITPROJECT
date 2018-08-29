package ecomProject.ecommerce.dao;

import ecomProject.ecommerce.model.Address;

public interface AddressDaoService {
	
	public boolean addAddress(Address address);
	public boolean deleteAddress(Address address);
	public  Address updateAddress(Address address);
	public Address getAddress(int addressId);

}
