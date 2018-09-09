package ecomProject.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class VendorAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorAddress_id;
	private String city;
	private String streetName;
	private long pincode;

	@ManyToOne
	private Vendor vendor;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public int getVendorAddress_id() {
		return vendorAddress_id;
	}

	public void setVendorAddress_id(int vendorAddress_id) {
		vendorAddress_id = vendorAddress_id;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}
