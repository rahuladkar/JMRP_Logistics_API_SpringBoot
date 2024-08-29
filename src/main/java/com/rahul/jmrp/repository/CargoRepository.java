package com.rahul.jmrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
