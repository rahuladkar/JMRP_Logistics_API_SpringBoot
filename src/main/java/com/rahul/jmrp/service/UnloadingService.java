package com.rahul.jmrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.UnloadingDao;
import com.rahul.jmrp.entity.Unloading;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class UnloadingService {

	@Autowired
	private UnloadingDao unloadingDao;

	public ResponseEntity<ResponseStructure<Unloading>> saveUnloading(Unloading unloading) {

		Unloading recieveUnloading = unloadingDao.saveUnloading(unloading);

		ResponseStructure<Unloading> responseStructure = new ResponseStructure<Unloading>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveUnloading);

		return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Unloading>>> getAllUnloading() {

		List<Unloading> unloading = unloadingDao.getAllUnloading();

		ResponseStructure<List<Unloading>> responseStructure = new ResponseStructure<List<Unloading>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Unloading Found...!");
		responseStructure.setData(unloading);

		return new ResponseEntity<ResponseStructure<List<Unloading>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Unloading>> updateUnloading(Unloading unloading) {

		Unloading recieveUnloading = unloadingDao.updateUnloading(unloading);

		ResponseStructure<Unloading> responseStructure = new ResponseStructure<Unloading>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveUnloading);

		return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure, HttpStatus.OK);

	}

	public String deleteUnloadingById(int id) {

		unloadingDao.deleteUnloadingById(id);

		return "Unloading Point with id " + id + " is successfully deleted...!";

	}

}
