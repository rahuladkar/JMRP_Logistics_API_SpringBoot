package com.rahul.jmrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.jmrp.entity.Driver;
import com.rahul.jmrp.response.structure.ResponseStructure;
import com.rahul.jmrp.service.DriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;

	// to update the personal information (Driver)
	@PutMapping("/driver")
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(@Valid @RequestBody Driver driver,
			@CookieValue(name = "userRole") String role) {

		if (role.equals("DRIVER")) {
			return driverService.updateDriver(driver);
		}

		return new ResponseEntity<ResponseStructure<Driver>>(HttpStatus.FORBIDDEN);
	}

//	@GetMapping("/contries")
//	public List<Object> getCountries() {
//
//		String url = "https://restcountries.com/v3.1/all";
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		Object[] countries = restTemplate.getForObject(url, Object[].class);
//
//		return Arrays.asList(countries);
//
//	}

}