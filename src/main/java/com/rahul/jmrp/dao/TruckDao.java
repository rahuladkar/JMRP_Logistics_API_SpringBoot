package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Truck;
import com.rahul.jmrp.repository.TruckRepository;

@Repository
public class TruckDao {

	@Autowired
	private TruckRepository truckRepository;

	// to add the Truck
	public Truck saveTruck(Truck truck) {

		return truckRepository.save(truck);
	}

	// to get the Truck
	public List<Truck> getAllTruck() {

		return truckRepository.findAll();

	}

	// to update the Truck
	public Truck updateTruck(Truck truck) {

		return truckRepository.save(truck);

	}

	// to delete the Truck
	public void deleteTruckById(int id) {

		truckRepository.deleteById(id);

	}

}
