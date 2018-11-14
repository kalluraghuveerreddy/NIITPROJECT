package ecomProject.ecommerce.model.products;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecomProject.ecommerce.model.Product;

@Entity
@Component
public class Shirt extends Product {

	@NotBlank
	@NotNull(message="Enter the quality type")
	private String qualityType;

	@NotBlank
	@NotNull(message="Enter the shirt Name")
	private String name;

	@NotBlank
	@NotNull(message="Enter the shirt size")
	private String size;

	@NotBlank
	@NotNull(message="Enter the shirt color")
	private String color;

	public String getQualityType() {
		return qualityType;
	}

	public void setQualityType(String qualityType) {
		this.qualityType = qualityType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
