package com.rahul.jmrp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.jmrp.dao.LoadingDao;
import com.rahul.jmrp.entity.Loading;
import com.rahul.jmrp.response.structure.ResponseStructure;

@Service
public class LoadingService {

	@Autowired
	private LoadingDao loadingDao;

	public ResponseEntity<ResponseStructure<Loading>> saveLoading(Loading loading) {

		Loading recieveLoading = loadingDao.saveLoading(loading);

		ResponseStructure<Loading> responseStructure = new ResponseStructure<Loading>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveLoading);

		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<List<Loading>>> getALlLoading() {

		List<Loading> loading = loadingDao.getAllLoading();

		ResponseStructure<List<Loading>> responseStructure = new ResponseStructure<List<Loading>>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Loading Found...!");
		responseStructure.setData(loading);

		return new ResponseEntity<ResponseStructure<List<Loading>>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Loading>> updateLoading(Loading loading) {

		Loading recieveLoading = loadingDao.updateLoading(loading);

		ResponseStructure<Loading> responseStructure = new ResponseStructure<Loading>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveLoading);

		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure, HttpStatus.OK);

	}

	public String deleteLoadingById(int id) {

		loadingDao.deleteLoadingById(id);

		return "Loading Point with id " + id + " is successfully deleted...!";

	}

}
