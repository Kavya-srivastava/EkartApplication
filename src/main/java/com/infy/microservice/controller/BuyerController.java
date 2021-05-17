package com.infy.microservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.microservice.dto.BuyerDTO;
import com.infy.microservice.service.UserService;


@RestController
@CrossOrigin
@RequestMapping(value="/buyer")
public class BuyerController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerBuyer(@RequestBody BuyerDTO buyer){
		try {
			String name= userService.registerBuyer(buyer);
			String message= environment.getProperty("UserController.CONGRATULATION")+name+" "+
					environment.getProperty("UserController.REGISTRATION_SUCCESS");
//			String message= "Congo you have registered";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
		
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<BuyerDTO> loginBuyer(@RequestBody BuyerDTO buyer){
		try {
			BuyerDTO buyerDTO= userService.authenticateBuyer(buyer.getEmail(), buyer.getPassword());
			return new ResponseEntity<BuyerDTO>(buyerDTO, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@DeleteMapping(value = "/delete/{email}")
	public ResponseEntity<String> deleteBuyer(@PathVariable String email){
		try {
			userService.deleteBuyer(email);
			String message= environment.getProperty("UserController.BUYER_DELETED");
//			String message="Buyer deleted " ;
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
		
	
	@PutMapping(value = "/deactivate/{email}")
	public ResponseEntity<String> deactivateBuyer(@PathVariable String email){
		try {
			userService.deactivateBuyer(email);
			String message= environment.getProperty("UserController.BUYER_DELETED");
//			String message="Buyer deactivated " ;
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	
	
	
	
}
