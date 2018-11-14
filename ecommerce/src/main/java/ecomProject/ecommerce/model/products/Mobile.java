package ecomProject.ecommerce.model.products;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecomProject.ecommerce.model.Product;

@Entity
@Component
public class Mobile extends Product {
	
	@NotBlank
	@NotNull(message="Enter the Mobile Name")
	private String name;
	@NotBlank
	@NotNull(message="Enter the ram size")
	private String ram;
	@NotBlank
	@NotNull(message="Enter the memory size")
	private String memory;
	@NotBlank
	@NotNull(message="Enter the screen size")
	private String screenSize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

}
