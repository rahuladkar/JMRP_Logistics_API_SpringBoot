package com.rahul.jmrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.jmrp.entity.Loading;
import com.rahul.jmrp.entity.Orders;
import com.rahul.jmrp.entity.Unloading;
import com.rahul.jmrp.response.structure.ResponseStructure;
import com.rahul.jmrp.service.LoadingService;
import com.rahul.jmrp.service.OrderService;
import com.rahul.jmrp.service.UnloadingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private LoadingService loadingService;
	@Autowired
	private UnloadingService unloadingService;

	// --------------------------------------------Orders----------------------------------------------------

	// to add Orders
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> saveOrders(@Valid @RequestBody Orders orders,
			@CookieValue(name = "userRole" ) String role) {
		if (role.equals("USER")) {
			return orderService.saveOrder(orders);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(@Valid @RequestBody Orders orders,
			@CookieValue(name = "userRole" ) String role) {
		if (role.equals("USER")) {
			return orderService.updateOrder(orders);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Loading----------------------------------------------------

	@PutMapping("/loading")
	public ResponseEntity<ResponseStructure<Loading>> updateLoading(@Valid @RequestBody Loading loading,
			@CookieValue(name = "userRole" ) String role) {
		if (role.equals("USER")) {
			return loadingService.updateLoading(loading);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Unloading----------------------------------------------------

	@PutMapping("/unloading")
	public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(@Valid @RequestBody Unloading unloading,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("USER")) {
			return unloadingService.updateUnloading(unloading);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

}
