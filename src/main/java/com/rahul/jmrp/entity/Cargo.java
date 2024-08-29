package com.rahul.jmrp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cargo {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Cargo name cannot be null")
	@Column(name = "cargo_name", length = 50)
	@Size(min = 2, max = 50, message = "Cargo name must be between 1 and 50 characters")
	private String cargoName;

	@NotNull(message = "Cargo description cannot be null")
	@Column(name = "cargo_description", length = 100)
	@Size(min = 2, max = 100, message = "Cargo description must be between 1 and 100 characters")
	private String cargoDescription;

	@NotNull(message = "Cargo weight cannot be null")
	@Column(name = "cargo_weight")
	@Min(value = 0, message = "Cargo weight must be positive")
	private double cargoWeight;

	@NotNull(message = "Cargo count cannot be null")
	@Column(name = "cargo_count")
	@Min(value = 0, message = "Cargo count must be positive")
	private int cargoCount;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public String getCargoDescription() {
		return cargoDescription;
	}

	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}

	public double getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	public int getCargoCount() {
		return cargoCount;
	}

	public void setCargoCount(int cargoCount) {
		this.cargoCount = cargoCount;
	}

}
