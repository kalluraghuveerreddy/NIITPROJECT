package ecomProject.ecommerce.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendor_id;
	private String vendor_name;
	@Column(unique = true)
	private String vendor_email;
	@Column(unique = true)
	private String vendor_mobile;
	private String vendor_password;
	private String company_name;
	@Column(nullable = false)
	private boolean status;
	private final String role="vendor";

	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	private Set<VendorAddress> vendorAddress;

	@OneToMany(mappedBy = "vendor")
	private List<Product> product;

	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_email() {
		return vendor_email;
	}

	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}

	public String getVendor_mobile() {
		return vendor_mobile;
	}

	public void setVendor_mobile(String vendor_mobile) {
		this.vendor_mobile = vendor_mobile;
	}

	public String getVendor_password() {
		return vendor_password;
	}

	public void setVendor_password(String vendor_password) {
		this.vendor_password = vendor_password;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<VendorAddress> getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(Set<VendorAddress> vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public String getRole() {
		return role;
	}

	
}
