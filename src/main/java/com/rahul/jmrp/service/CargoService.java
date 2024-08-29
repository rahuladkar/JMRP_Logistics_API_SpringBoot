package com.rahul.jmrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.CargoDao;
import com.rahul.jmrp.entity.Cargo;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class CargoService {

	@Autowired
	private CargoDao cargoDao;

	public ResponseEntity<ResponseStructure<Cargo>> saveCargo(Cargo cargo) {

		Cargo recieveCargo = cargoDao.saveCargo(cargo);

		ResponseStructure<Cargo> responseStructure = new ResponseStructure<Cargo>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveCargo);

		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Cargo>>> getAllCargo() {

		List<Cargo> cargo = cargoDao.getAllCargo();

		ResponseStructure<List<Cargo>> responseStructure = new ResponseStructure<List<Cargo>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Cargo Found...!");
		responseStructure.setData(cargo);

		return new ResponseEntity<ResponseStructure<List<Cargo>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Cargo>> updateCargo(Cargo cargo) {

		Cargo recieveCargo = cargoDao.updateCargo(cargo);

		ResponseStructure<Cargo> responseStructure = new ResponseStructure<Cargo>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveCargo);

		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, HttpStatus.OK);

	}

	public String deleteCargoById(int id) {

		cargoDao.deleteCargoById(id);

		return "Cargo with id  " + id + " is Successfully deleted...!";

	}

}
