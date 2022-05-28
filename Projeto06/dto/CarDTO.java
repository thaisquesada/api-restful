package org.serratec.backend.projeto06.dto;

import java.io.Serializable;

public class CarDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer carId;
	private String model;
	private String brand;
	private String year;
	
	public CarDTO() {}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
