package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Cargo;
import com.rahul.jmrp.repository.CargoRepository;

@Repository
public class CargoDao {
	

	@Autowired
	private CargoRepository cargoRepository;

	// to add the Cargo
	public Cargo saveCargo(Cargo cargo) {

		return cargoRepository.save(cargo);
	}

	// to get the Cargo
	public List<Cargo> getAllCargo() {

		return cargoRepository.findAll();

	}

	// to update the Cargo
	public Cargo updateCargo(Cargo Cargo) {

		return cargoRepository.save(Cargo);

	}

	// to delete the Cargo
	public void deleteCargoById(int id) {

		cargoRepository.deleteById(id);

	}

}
