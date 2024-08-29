package com.rahul.jmrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer>{

}
