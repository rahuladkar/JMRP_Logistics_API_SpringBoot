package com.rahul.jmrp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Address {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Street name cannot be null")
	@Column(name = "street_name", length = 50)
	@Size(min = 2, max = 30, message = "Street name length must be less than or equal to 100 characters")
	private String streetName;

	@NotNull(message = "House number cannot be null")
	@Column(name = "house_number")
	@Max(value = 99999, message = "House number must be less than or equal to 99999")
	private int houseNumber;

	@NotNull(message = "Area pincode cannot be null")
	@Column(name = "area_pincode")
	@Max(value = 999999, message = "Area pincode must be less than or equal to 999999")
	private int areaPincode;

	@NotNull(message = "District cannot be null")
	@Column(length = 50)
	@Size(min = 2, max = 20, message = "District name must be between 2 and 20 characters")
	private String district;

	@NotNull(message = "State cannot be null")
	@Column(length = 50)
	@Size(min = 2, max = 20, message = "State name must be between 2 and 20 characters")
	private String state;

	@NotNull(message = "Country cannot be null")
	@Column(length = 50)
	@Size(min = 2, max = 20, message = "Country name must be between 2 and 20 characters")
	private String country;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getAreaPincode() {
		return areaPincode;
	}

	public void setAreaPincode(int areaPincode) {
		this.areaPincode = areaPincode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
