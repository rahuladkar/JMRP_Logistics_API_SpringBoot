package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Carrier;
import com.rahul.jmrp.repository.CarrierRepository;

@Repository
public class CarrierDao {

	@Autowired
	private CarrierRepository carrierRepository;

	// to add the Carrier
	public Carrier saveCarrier(Carrier carrier) {

		return carrierRepository.save(carrier);
	}

	// to get the Carrier
	public List<Carrier> getAllCarrier() {

		return carrierRepository.findAll();

	}

	// to update the Carrier
	public Carrier updateCarrier(Carrier carrier) {

		return carrierRepository.save(carrier);

	}

	// to delete the Carrier
	public void deleteCarrierById(int id) {

		carrierRepository.deleteById(id);

	}

}
