package com.infy.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import com.infy.microservice.entity.Seller;

public interface SellerRepository extends CrudRepository<Seller,Integer>{
	
	public Seller findByPhoneNumber(String phoneNumber); 
	
	public Seller findByEmail(String email); 

}
