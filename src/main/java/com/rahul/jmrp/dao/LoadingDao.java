package com.rahul.jmrp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Loading;
import com.rahul.jmrp.repository.LoadingRepository;

@Repository
public class LoadingDao {

	@Autowired
	private LoadingRepository loadingRepository;

	// to add the Loading
	public Loading saveLoading(Loading loading) {

		return loadingRepository.save(loading);
	}

	// to get the Loading
	public List<Loading> getAllLoading() {

		return loadingRepository.findAll();

	}

	// to update the Loading
	public Loading updateLoading(Loading loading) {

		return loadingRepository.save(loading);

	}

	// to delete the Loading
	public void deleteLoadingById(int id) {

		loadingRepository.deleteById(id);

	}

}
