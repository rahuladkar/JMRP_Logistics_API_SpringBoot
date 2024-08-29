package com.rahul.jmrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.CarrierDao;
import com.rahul.jmrp.entity.Carrier;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class CarrierService {

	@Autowired
	private CarrierDao carrierDao;

	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(Carrier carrier) {

		Carrier recieveCarrier = carrierDao.saveCarrier(carrier);

		ResponseStructure<Carrier> responseStructure = new ResponseStructure<Carrier>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveCarrier);

		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Carrier>>> getAllCarrier() {

		List<Carrier> carrier = carrierDao.getAllCarrier();

		ResponseStructure<List<Carrier>> responseStructure = new ResponseStructure<List<Carrier>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Carrier Found...!");
		responseStructure.setData(carrier);

		return new ResponseEntity<ResponseStructure<List<Carrier>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(Carrier carrier) {

		Carrier recieveCarrier = carrierDao.updateCarrier(carrier);

		ResponseStructure<Carrier> responseStructure = new ResponseStructure<Carrier>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveCarrier);

		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure, HttpStatus.OK);

	}

	public String deleteCarrierById(int id) {

		carrierDao.deleteCarrierById(id);

		return "Carrier with id " + id + " is successfully deleted..!";

	}

}
