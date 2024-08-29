package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Unloading;
import com.rahul.jmrp.repository.UnloadingRepository;

@Repository
public class UnloadingDao {

	@Autowired
	private UnloadingRepository unloadingRepository;

	// to add the Unloading
	public Unloading saveUnloading(Unloading unloading) {

		return unloadingRepository.save(unloading);
	}

	// to get the Unloading
	public List<Unloading> getAllUnloading() {

		return unloadingRepository.findAll();

	}

	// to update the Unloading
	public Unloading updateUnloading(Unloading unloading) {

		return unloadingRepository.save(unloading);

	}

	// to delete the Unloading
	public void deleteUnloadingById(int id) {

		unloadingRepository.deleteById(id);

	}

}
