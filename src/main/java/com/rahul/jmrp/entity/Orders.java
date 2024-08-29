package com.rahul.jmrp.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Orders {

	@Id
	@NotNull(message = "ID cannot be null")
	private int id;

	@NotNull(message = "Date of order cannot be null")
	@Column(name = "date_of_order")
	private LocalDate dateOfOrder;

	@NotNull(message = "Order status cannot be null")
	@Size(min = 2, max = 50, message = "Order status cannot exceed 50 characters")
	@Column(name = "order_status", length = 50)
	private String orderStatus;

	@NotNull(message = "Freight cost cannot be null")
	@Min(value = 0, message = "Freight cost cannot be negative")
	@Column(name = "freight_Cost")
	private double freightCost;

	@Size(max = 50, message = "Additional information cannot exceed 50 characters")
	@Column(name = "addition_all_info", length = 50)
	private String additionAllInfo;

	@ManyToOne
	private Carrier carriers;

	@OneToOne
	private Cargo cargo;

	@OneToOne
	private Loading loading;

	@OneToOne
	private Unloading unloading;

	@ManyToMany
	private List<Users> loadingUser;

	@ManyToMany
	private List<Users> unloadingUser;

	// getter() and setter()

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getFreightCost() {
		return freightCost;
	}

	public void setFreightCost(double freightCost) {
		this.freightCost = freightCost;
	}

	public String getAdditionAllInfo() {
		return additionAllInfo;
	}

	public void setAdditionAllInfo(String additionAllInfo) {
		this.additionAllInfo = additionAllInfo;
	}

	public Carrier getCarriers() {
		return carriers;
	}

	public void setCarriers(Carrier carriers) {
		this.carriers = carriers;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Loading getLoading() {
		return loading;
	}

	public void setLoading(Loading loading) {
		this.loading = loading;
	}

	public Unloading getUnloading() {
		return unloading;
	}

	public void setUnloading(Unloading unloading) {
		this.unloading = unloading;
	}

	public List<Users> getLoadingUser() {
		return loadingUser;
	}

	public void setLoadingUser(List<Users> loadingUser) {
		this.loadingUser = loadingUser;
	}

	public List<Users> getUnloadingUser() {
		return unloadingUser;
	}

	public void setUnloadingUser(List<Users> unloadingUser) {
		this.unloadingUser = unloadingUser;
	}

}
