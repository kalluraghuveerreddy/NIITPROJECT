package ecomProject.ecommerce.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@NotNull(message = "Enter the Name")
	@NotBlank(message = "Name Should not be blank")
	private String customer_name;
	@NotNull(message = "Enter the Email")
	@NotBlank(message = "Email Should not be blank")
	@Column(unique = true)
	private String customer_email;
	@NotNull(message = "Enter the Password")
	@NotBlank(message = "Password Should not be blank")
	private String customer_password;
	@NotNull(message = "Enter the Mobile")
	@NotBlank(message = "Mobile Should not be blank")
	@Column(unique = true)
	private String customer_mobile;

	private boolean status = true;
	private final String role = "customer";

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<CustomerAddress> customerAddress;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_mobile() {
		return customer_mobile;
	}

	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}

	public Set<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(Set<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

}
