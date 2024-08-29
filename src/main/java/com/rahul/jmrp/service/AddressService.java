package com.rahul.jmrp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rahul.jmrp.dao.AddressDao;
import com.rahul.jmrp.entity.Address;
import com.rahul.jmrp.exception.IdDoesNotFoundException;
import com.rahul.jmrp.response.structure.ResponseStructure;

public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {

		Address recieveAddress = addressDao.saveAddress(address);

		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Success...!");
		responseStructure.setData(recieveAddress);

		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {

		Address address = addressDao.getAddressById(id);

		if (address != null) {

			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();

			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMeassage("Address Found...!");
			responseStructure.setData(address);

			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);

		} else {
			throw new IdDoesNotFoundException("Id " + id + " , Not Present...!");
		}

	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {

		Address recieveAddress = addressDao.updateAddress(address);

		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMeassage("Updated...!");
		responseStructure.setData(recieveAddress);

		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id) {

		addressDao.deleteAddressById(id);

		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();

		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMeassage("Address Deleted...!");
		responseStructure.setData(null);

		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.NO_CONTENT);

	}

}
