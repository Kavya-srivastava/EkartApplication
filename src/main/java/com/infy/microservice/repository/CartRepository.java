package com.infy.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.microservice.entity.Cart;
import com.infy.microservice.entity.CompositeKeyCart;

public interface CartRepository extends CrudRepository<Cart,CompositeKeyCart>{
	
	

}
