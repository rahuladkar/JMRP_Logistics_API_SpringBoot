package com.rahul.jmrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.jmrp.entity.Loading;

@Repository
public interface LoadingRepository extends JpaRepository<Loading, Integer>{

}
