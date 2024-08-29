package com.rahul.jmrp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Truck {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 50, message = "Name cannot exceed 50 characters")
	@Column(length = 50)
	private String name;

	@NotNull(message = "Registered number cannot be null")
	@Min(value = 1, message = "Registered number must be greater than 0")
	@Column(name = "register_number")
	private int registerdNumber;

	@NotNull(message = "Capacity cannot be null")
	@Min(value = 1, message = "Capacity must be greater than 0")
	private int capacity;

	@NotNull(message = "Status cannot be null")
	@Size(min = 2, max = 50, message = "Status cannot exceed 50 characters")
	@Column(length = 50)
	private String status;

	@NotNull(message = "Carried ID cannot be null")
	@Min(value = 1, message = "Carried ID must be greater than 0")
	@Column(name = "carried_id")
	private int carriedId;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegisterdNumber() {
		return registerdNumber;
	}

	public void setRegisterdNumber(int registerdNumber) {
		this.registerdNumber = registerdNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCarriedId() {
		return carriedId;
	}

	public void setCarriedId(int carriedId) {
		this.carriedId = carriedId;
	}

}
