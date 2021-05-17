package com.infy.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.microservice.entity.CompositeKey;
import com.infy.microservice.entity.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist,CompositeKey>{
//	findByIdBuyerId(Integer buyerId)
}
