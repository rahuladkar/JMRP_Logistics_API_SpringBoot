package com.rahul.jmrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.jmrp.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
//
//	@Modifying
//	@Transactional
//	@Query("UPDATE Driver d SET d.carrierId = ?1 WHERE d.id = 21331")
//	int updateCarrierId(int carrierId);

}
