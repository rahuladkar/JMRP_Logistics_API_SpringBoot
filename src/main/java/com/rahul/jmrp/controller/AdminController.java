package com.rahul.jmrp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.jmrp.entity.Cargo;
import com.rahul.jmrp.entity.Carrier;
import com.rahul.jmrp.entity.Driver;
import com.rahul.jmrp.entity.Loading;
import com.rahul.jmrp.entity.Orders;
import com.rahul.jmrp.entity.Truck;
import com.rahul.jmrp.entity.Unloading;
import com.rahul.jmrp.entity.Users;
import com.rahul.jmrp.response.structure.ResponseStructure;
import com.rahul.jmrp.service.CargoService;
import com.rahul.jmrp.service.CarrierService;
import com.rahul.jmrp.service.DriverService;
import com.rahul.jmrp.service.LoadingService;
import com.rahul.jmrp.service.OrderService;
import com.rahul.jmrp.service.TruckService;
import com.rahul.jmrp.service.UnloadingService;
import com.rahul.jmrp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private TruckService truckService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CarrierService carrierService;
	@Autowired
	private LoadingService loadingService;
	@Autowired
	private UnloadingService unloadingService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private CargoService cargoService;

	// --------------------------------------------Truck----------------------------------------------------

	@PostMapping("/truck")
	public ResponseEntity<ResponseStructure<Truck>> addTrucks(@Valid @RequestBody Truck truck,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return truckService.saveTruck(truck);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/truck")
	public ResponseEntity<ResponseStructure<Truck>> updateTruck(@Valid @RequestBody Truck truck,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return truckService.updateTruck(truck);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/truck/{id}")
	public ResponseEntity<String> deleteTruck(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(truckService.deleteTruckById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/truck")
	public ResponseEntity<ResponseStructure<List<Truck>>> getAllTrucks(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return truckService.getAllTruck();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Orders----------------------------------------------------

	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> saveOrders(@Valid @RequestBody Orders orders,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return orderService.saveOrder(orders);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/order")
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(@Valid @RequestBody Orders orders,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return orderService.updateOrder(orders);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/order")
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return orderService.getAllOrder();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> deleteOrders(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(orderService.deleteOrderById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Carrier----------------------------------------------------

	@PostMapping("/carrier")
	public ResponseEntity<ResponseStructure<Carrier>> addCarrier(@Valid @RequestBody Carrier carrier,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return carrierService.saveCarrier(carrier);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/carrier")
	public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(@Valid @RequestBody Carrier carrier,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return carrierService.updateCarrier(carrier);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/carrier/{id}")
	public ResponseEntity<String> deleteCarrier(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(carrierService.deleteCarrierById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/carrier")
	public ResponseEntity<ResponseStructure<List<Carrier>>> getAllCarrier(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return carrierService.getAllCarrier();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Loading----------------------------------------------------

	@PostMapping("/loading")
	public ResponseEntity<ResponseStructure<Loading>> addLoading(@Valid @RequestBody Loading loading,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return loadingService.saveLoading(loading);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/loading")
	public ResponseEntity<ResponseStructure<Loading>> updateLoading(@Valid @RequestBody Loading loading,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return loadingService.updateLoading(loading);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/loading/{id}")
	public ResponseEntity<String> deleteLoading(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(loadingService.deleteLoadingById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/loading")
	public ResponseEntity<ResponseStructure<List<Loading>>> getAllLoading(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return loadingService.getALlLoading();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Unloading----------------------------------------------------

	@PostMapping("/unloading")
	public ResponseEntity<ResponseStructure<Unloading>> addUnloading(@Valid @RequestBody Unloading unloading,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return unloadingService.saveUnloading(unloading);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/unloading")
	public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(@Valid @RequestBody Unloading unloading,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return unloadingService.updateUnloading(unloading);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/unloading/{id}")
	public ResponseEntity<String> deleteUnloading(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(unloadingService.deleteUnloadingById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/unloading")
	public ResponseEntity<ResponseStructure<List<Unloading>>> getAllUnloading(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return unloadingService.getAllUnloading();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Users----------------------------------------------------

	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<Users>> addUser(@Valid @RequestBody Users user,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return userService.saveUser(user);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<Users>> updateUser(@Valid @RequestBody Users user,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return userService.updateUser(user);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable int id, @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(userService.deleteUserById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<List<Users>>> getAllUsers(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return userService.getAllUser();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Cargo----------------------------------------------------

	@PostMapping("/cargo")
	public ResponseEntity<ResponseStructure<Cargo>> addCargo(@Valid @RequestBody Cargo cargo,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return cargoService.saveCargo(cargo);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/cargo")
	public ResponseEntity<ResponseStructure<Cargo>> updateCargo(@Valid @RequestBody Cargo cargo,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return cargoService.updateCargo(cargo);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/cargo/{id}")
	public ResponseEntity<String> deleteCargo(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(cargoService.deleteCargoById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/cargo")
	public ResponseEntity<ResponseStructure<List<Cargo>>> getAllCargo(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return cargoService.getAllCargo();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	// --------------------------------------------Driver----------------------------------------------------

	@PostMapping("/driver")
	public ResponseEntity<ResponseStructure<Driver>> addDriver(@Valid @RequestBody Driver driver,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return driverService.saveDriver(driver);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@PutMapping("/driver")
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(@Valid @RequestBody Driver driver,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return driverService.updateDriver(driver);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@DeleteMapping("/driver/{id}")
	public ResponseEntity<String> deleteDriver(@Valid @PathVariable int id,
			@CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return ResponseEntity.ok(driverService.deleteDriverById(id));
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/driver")
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDrivers(
			@Valid @CookieValue(name = "userRole") String role) {
		if (role.equals("ADMIN")) {
			return driverService.getAllDriver();
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	
}
