package com.rahul.jmrp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Carrier {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Carrier company name cannot be null")
	@Column(name = "carrier_company_name", length = 50)
	@Size(min = 2, max = 50, message = "Carrier company name must be between 1 and 50 characters")
	private String carrierCompanyName;

	@NotNull(message = "Carrier contact cannot be null")
	@Column(name = "carrier_contact")
	@Digits(integer = 10, fraction = 0, message = "Carrier contact must be a 10-digit number")
	private long carrierContact;

	@NotNull(message = "Carrier email cannot be null")
	@Column(name = "carrier_email", length = 50)
	@Email(message = "Carrier email must be a valid email address")
	@Size(max = 50, message = "Carrier email must be at most 50 characters long")
	private String carrierEmail;

	@ManyToMany(mappedBy = "carrier")
	private List<Driver> drivers;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarrierCompanyName() {
		return carrierCompanyName;
	}

	public void setCarrierCompanyName(String carrierCompanyName) {
		this.carrierCompanyName = carrierCompanyName;
	}

	public long getCarrierContact() {
		return carrierContact;
	}

	public void setCarrierContact(long carrierContact) {
		this.carrierContact = carrierContact;
	}

	public String getCarrierEmail() {
		return carrierEmail;
	}

	public void setCarrierEmail(String carrierEmail) {
		this.carrierEmail = carrierEmail;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

}
