package ecomProject.ecommerce.model.products;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import ecomProject.ecommerce.model.Product;

@Entity
@Component
public class AirConditioner extends Product {

	@NotBlank
	@NotNull(message="Enter the Airconditioner Name")
	private String name;

	@NotBlank
	@NotNull(message="Enter the Airconditioner voltage")
	private String voltage;

	@NotBlank
	@NotNull(message="Enter the Airconditioner model Numbe")
	private String modelNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

}
