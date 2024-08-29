package com.rahul.jmrp.service;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.DriverDao;
import com.rahul.jmrp.entity.Driver;
//import com.rahul.jmrp.exception.IdDoesNotFoundException;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class DriverService {

	@Autowired
	private DriverDao driverDao;

	public ResponseEntity<ResponseStructure<Driver>> saveDriver(Driver driver) {

		Driver recieveDriver = driverDao.saveDriver(driver);

		ResponseStructure<Driver> responseStructure = new ResponseStructure<Driver>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveDriver);

		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDriver() {

		List<Driver> driver = driverDao.getAllDriver();

		ResponseStructure<List<Driver>> responseStructure = new ResponseStructure<List<Driver>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Driver Found...!");
		responseStructure.setData(driver);

		return new ResponseEntity<ResponseStructure<List<Driver>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Driver>> updateDriver(Driver driver) {

		Driver recieveDriver = driverDao.updateDriver(driver);

		ResponseStructure<Driver> responseStructure = new ResponseStructure<Driver>();

		responseStructure.setStatusCode(HttpStatus.RESET_CONTENT.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveDriver);

		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.RESET_CONTENT);

	}

//	public ResponseEntity<ResponseStructure<String>> updateCarrierId(int cid) {
//		
//		driverDao.updateCarrierId(cid);
//		
//		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
//		
//		responseStructure.setStatusCode(HttpStatus.RESET_CONTENT.value());
//		responseStructure.setMeassage("Updated...!");
//		responseStructure.setData("Carrier Id is updated...!");
//		
//		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.RESET_CONTENT);
//		
//	}

	public String deleteDriverById(int id) {

		driverDao.deleteDriverById(id);

		return "Driver with id " + id + " is successfully deleted...!";

	}
}
