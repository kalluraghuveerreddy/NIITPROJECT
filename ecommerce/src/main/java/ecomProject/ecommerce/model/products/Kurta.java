package ecomProject.ecommerce.model.products;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecomProject.ecommerce.model.Product;

@Entity
@Component
public class Kurta extends Product {

	@NotBlank
	@NotNull(message="Enter the Kurta  Name")
	private String name;

	@NotBlank
	@NotNull(message="Enter the Kurta color")
	private String color;

	@NotBlank
	@NotNull(message="Enter the Kurta size")
	private String size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
