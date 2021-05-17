package com.infy.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.microservice.entity.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer,Integer>{
	
	public Buyer findByPhoneNumber(String phoneNumber); 
	
	public Buyer findByEmail(String email); 

}
