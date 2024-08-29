package com.rahul.jmrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.TruckDao;
import com.rahul.jmrp.entity.Truck;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class TruckService {

	@Autowired
	private TruckDao truckDao;

	public ResponseEntity<ResponseStructure<Truck>> saveTruck(Truck truck) {

		Truck recieveTruck = truckDao.saveTruck(truck);

		ResponseStructure<Truck> responseStructure = new ResponseStructure<Truck>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveTruck);

		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Truck>>> getAllTruck() {

		List<Truck> trucks = truckDao.getAllTruck();

		ResponseStructure<List<Truck>> responseStructure = new ResponseStructure<List<Truck>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Truck Found...!");
		responseStructure.setData(trucks);

		return new ResponseEntity<ResponseStructure<List<Truck>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Truck>> updateTruck(Truck truck) {

		Truck recieveTruck = truckDao.updateTruck(truck);

		ResponseStructure<Truck> responseStructure = new ResponseStructure<Truck>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveTruck);

		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, HttpStatus.OK);

	}

	public String deleteTruckById(int id) {

		truckDao.deleteTruckById(id);

		return "Truck with id " + id + " is successfully deleted...!";

	}

}
