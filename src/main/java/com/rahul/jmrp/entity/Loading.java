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
public class Loading {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Company name cannot be null")
	@Column(name = "company_name", length = 50)
	@Size(min = 2, max = 50, message = "Company name cannot exceed 50 characters")
	private String companyName;

	@NotNull(message = "Loading date cannot be null")
	@Column(name = "loading_date")
	private LocalDate loadingDate;

	@NotNull(message = "Loading time cannot be null")
	@Column(name = "loading_time")
	private LocalTime loadingTime;

	@OneToOne
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

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

	public LocalDate getLoadingDate() {
		return loadingDate;
	}

	public void setLoadingDate(LocalDate loadingDate) {
		this.loadingDate = loadingDate;
	}

	public LocalTime getLoadingTime() {
		return loadingTime;
	}

	public void setLoadingTime(LocalTime loadingTime) {
		this.loadingTime = loadingTime;
	}

}
