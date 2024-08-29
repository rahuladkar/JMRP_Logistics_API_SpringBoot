package com.rahul.jmrp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Driver {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Driver name cannot be null")
	@Column(name = "driver_name")
	@Size(min = 2, max = 20, message = "Driver name must be between 2 and 20 characters")
	private String driverName;

	@NotNull(message = "Driver phone number cannot be null")
	@Column(name = "driver_phone_number")
	@Digits(integer = 10, fraction = 0, message = "Driver phone number must be a valid 10-digit number")
	private long driverPhoneNumber;


	@OneToOne
	private Truck truck;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Carrier carrier;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public long getDriverPhoneNumber() {
		return driverPhoneNumber;
	}

	public void setDriverPhoneNumber(long driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

}
