package com.rahul.jmrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
