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
public class Address {
	   
		@Id
	     @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int addressId;
		private String city;
		private String streetName;
		private long pincode;
		
		@ManyToOne
		private User user;
		
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
		public int getAddressId() {
			return addressId;
		}
		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
	
		
		

}
