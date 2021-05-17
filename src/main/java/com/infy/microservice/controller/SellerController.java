package com.infy.microservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.microservice.dto.SellerDTO;
import com.infy.microservice.service.UserService;


@RestController
@CrossOrigin
@RequestMapping(value="/seller")
public class SellerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerSeller(@RequestBody SellerDTO seller){
		try {
			String name= userService.registerSeller(seller);
//			String message= environment.getProperty("CONGRATULATION")+name+
//					environment.getProperty("REGISTRATION SUCCESS");
			String message= "Congo seller have registered";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
		
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<SellerDTO> loginSeller(@RequestBody SellerDTO seller){
		try {
			SellerDTO sellerDTO= userService.authenticateSeller(seller.getEmail(), seller.getPassword());
			return new ResponseEntity<SellerDTO>(sellerDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@DeleteMapping(value = "/delete/{email}")
	public ResponseEntity<String> deleteSeller(@PathVariable String email){
		try {
			userService.deleteSeller(email);
//			String message= environment.getProperty("UserController.BUYER_DELETED");
			String message="Seller deleted " ;
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
		
	
	
	
	
	
	
}
