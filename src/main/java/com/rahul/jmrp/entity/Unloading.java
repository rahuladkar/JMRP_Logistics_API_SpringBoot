package com.rahul.jmrp.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Unloading {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Company name cannot be null")
	@Size(min = 2, max = 50, message = "Company name cannot exceed 50 characters")
	@Column(name = "company_name", length = 50)
	private String companyName;

	@NotNull(message = "Unloading date cannot be null")
	@Column(name = "unloading_date")
	private LocalDate unloadingDate;

	@NotNull(message = "Unloading time cannot be null")
	@Column(name = "unloading_time")
	private LocalTime unloadingTime;

	@OneToOne
	private Address address;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDate getUnloadingDate() {
		return unloadingDate;
	}

	public void setUnloadingDate(LocalDate unloadingDate) {
		this.unloadingDate = unloadingDate;
	}

	public LocalTime getUnloadingTime() {
		return unloadingTime;
	}

	public void setUnloadingTime(LocalTime unloadingTime) {
		this.unloadingTime = unloadingTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
