package com.rahul.jmrp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Users {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Username cannot be null")
	@Size(min = 2, max = 50, message = "Username cannot exceed 50 characters")
	@Column(length = 50)
	private String username;

	@NotNull(message = "Password cannot be null")
	@Size(min = 2, max = 50, message = "Password cannot exceed 50 characters")
	@Column(length = 50)
	private String password;

	@NotNull(message = "Phone number cannot be null")
	@Digits(integer = 10, fraction = 0, message = "Phone number must be a valid 10-digit number")
	@Column(name = "phone_number")
	private long phoneNumber;

	@NotNull(message = "User role cannot be null")
	@Size(min = 2, max = 50, message = "User role cannot exceed 50 characters")
	@Column(name = "user_role", length = 50)
	private String userRole;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
