package com.rahul.jmrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
