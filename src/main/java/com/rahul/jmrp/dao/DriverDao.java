package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Driver;
import com.rahul.jmrp.repository.DriverRepository;

@Repository
public class DriverDao {


	@Autowired
	private DriverRepository driverRepository;

	// to add the Driver
	public Driver saveDriver(Driver driver) {

		return driverRepository.save(driver);
	}

	// to get the Driver
	public List<Driver> getAllDriver() {

		return driverRepository.findAll();

	}

	// to update the Driver
	public Driver updateDriver(Driver driver) {

		return driverRepository.save(driver);

	}

	// to delete the Driver
	public void deleteDriverById(int id) {

		driverRepository.deleteById(id);

	}
	
	// update carrier id
//	public void updateCarrierId(int cid ) {
//		
//		driverRepository.updateCarrierId(cid);
//		
//	}
	
}
