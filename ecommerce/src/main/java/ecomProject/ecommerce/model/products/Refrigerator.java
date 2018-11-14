package ecomProject.ecommerce.model.products;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecomProject.ecommerce.model.Product;

@Entity
@Component
public class Refrigerator extends Product {

	@NotBlank
	@NotNull(message = "Enter the Refrigrator Name")
	private String name;

	@NotBlank
	@NotNull(message = "Enter the refrigerator capacity")
	private String capacity;

	@NotBlank
	@NotNull(message = "Enter the color")
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
