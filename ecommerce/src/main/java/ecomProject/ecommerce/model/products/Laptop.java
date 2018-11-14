package ecomProject.ecommerce.model.products;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecomProject.ecommerce.model.Product;


@Entity
@Component
public class Laptop extends Product {

	@NotBlank
	@NotNull(message="Enter the ram size")
	private String ram;

	@NotBlank
	@NotNull(message="Enter the laptop Name")
	private String laptopName;

	@NotBlank
	@NotNull(message="Enter the processor")
	private String processor;

	@NotBlank
	@NotNull(message="Enter the Size of harddisk")
	private String harddisk;
	
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getHarddisk() {
		return harddisk;
	}
	public void setHarddisk(String harddisk) {
		this.harddisk = harddisk;
	}
	
	
	

}
