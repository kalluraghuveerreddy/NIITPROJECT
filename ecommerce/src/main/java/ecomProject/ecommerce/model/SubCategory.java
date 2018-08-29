package ecomProject.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Entity
@Component
public class SubCategory {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int subCategory_id;
	private String subCategory_name;
	
	

	@ManyToOne
	private Category category;
	

	public int getSubCategory_id() {
		return subCategory_id;
	}

	public void setSubCategory_id(int subCategory_id) {
		this.subCategory_id = subCategory_id;
	}

	public String getSubCategory_name() {
		return subCategory_name;
	}

	public void setSubCategory_name(String subCategory_name) {
		this.subCategory_name = subCategory_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
