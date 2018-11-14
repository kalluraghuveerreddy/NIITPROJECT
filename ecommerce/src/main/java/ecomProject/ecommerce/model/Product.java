package ecomProject.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int product_id;
	@NotBlank
	@NotNull(message="Enter the product Name")
	private String product_name;
	@NotBlank
	@NotNull(message="Enter the product brand")
	private String product_brand;
	@NotBlank
	@NotNull(message="Enter the product Price")
	private int product_price;
	@NotBlank
	@NotNull(message="Enter the number of products")
	private int numberOfProducts;
	@Transient
	private MultipartFile image;

	@ManyToOne
	private Vendor vendor;

	@ManyToOne
	private SubCategory subCategory;
	


	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<NoOfProducts> noOfProducts;

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<NoOfProducts> getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(List<NoOfProducts> noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", product_brand="
				+ product_brand + ", product_price=" + product_price + ", numberOfProducts=" + numberOfProducts
				+ ", image=" + image + ", vendor=" + vendor + ", subCategory=" + subCategory + ", noOfProducts="
				+ noOfProducts + "]";
	}
	
	
	

}
