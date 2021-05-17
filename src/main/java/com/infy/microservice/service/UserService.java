package com.infy.microservice.service;

import com.infy.microservice.dto.BuyerDTO;
import com.infy.microservice.dto.SellerDTO;
import com.infy.microservice.exception.UserMSException;

public interface UserService {
	
// ------BUYER SERVICE-----------------
	public String registerBuyer(BuyerDTO buyer) throws UserMSException;
	
	public BuyerDTO authenticateBuyer(String email, String password) throws UserMSException;
	
	public void deleteBuyer(String email) throws UserMSException;
	
	public void deactivateBuyer(String email) throws UserMSException;
	
//	public void privilegedMode(String email) throws UserMSException;
	
	
//------------------SELLER SERVICE------------------------------	
	public String registerSeller(SellerDTO seller) throws UserMSException;
	
	public SellerDTO authenticateSeller(String email, String password) throws UserMSException;
	
	public void deleteSeller(String email) throws UserMSException;
}
