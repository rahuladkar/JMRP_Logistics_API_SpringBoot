package com.rahul.jmrp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Address;
import com.rahul.jmrp.repository.AddressRepository;

@Repository
public class AddressDao {


	@Autowired
	private AddressRepository addressRepository;

	// to add the Address
	public Address saveAddress(Address address) {

		return addressRepository.save(address);
	}

	// to get the Address
	public Address getAddressById(int id) {

		Optional<Address> optional = addressRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}

	}

	// to update the Address
	public Address updateAddress(Address address) {

		return addressRepository.save(address);

	}

	// to delete the Address
	public void deleteAddressById(int id) {

		addressRepository.deleteById(id);

	}
	
}
