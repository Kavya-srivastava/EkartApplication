package com.infy.microservice.validator;

import com.infy.microservice.dto.BuyerDTO;
import com.infy.microservice.exception.UserMSException;

public class BuyerValidator {
	
	public static void validateBuyerforLogin(String email,String password) throws UserMSException{
		
		if(!validateEmail(email)) {
//			System.out.println("email");
			throw new UserMSException("UserValidator.INVALID_EMAIL_FORMAT");
		}
		if(!validatePassword(password)) {
//			System.out.println("password");
			throw new UserMSException("UserValidator.INVALID_PASSWORD_FORMAT");
		}
		
	}
	
	public static void validateBuyerForRegister(BuyerDTO buyer) throws UserMSException {
		if(!validatePhoneNumber(buyer.getPhoneNumber())) {
//			System.out.println("phone number");
			throw new UserMSException("UserValidator.INVALID_PHONE_NUMBER_FORMAT");
		}
		if(!validatePassword(buyer.getPassword())) {
//			System.out.println("password");
			throw new UserMSException("UserValidator.INVALID_PASSWORD_FORMAT");
		}

		if(!validateBuyerName(buyer.getName())) {
//			System.out.println("name");
			throw new UserMSException("UserValidator.INVALID_NAME_FORMAT");
		}
		if(!validateEmail(buyer.getEmail())) {
//			System.out.println("email");
			throw new UserMSException("UserValidator.INVALID_EMAIL_FORMAT");
		}
		
	}
	
	public static Boolean validateBuyerName(String name) {
		if(name==null || name.trim().length()!=name.length())
				return false;
	//	return name.matches("[A-Za-z]+");
		return name.matches("([A-Za-z])+(\\s[A-Za-z]+)*");
	}
	public static Boolean validateEmail(String email) {
		if(email==null) {
			return false;
		}
		return email.matches("[A-Za-z0-9_]+@[A-Za-z]+[.]com");
	}
	
	
	public static Boolean validatePassword(String password) {
		if(password==null) {
			return false;
		}
		if(password.length()>=7 && password.length()<=20) {
			if(password.matches(".*[A-Z]+.*")) {
				if(password.matches(".*[a-z]+.*")) {
					if(password.matches(".*[0-9]+.*")) {
						if(password.matches(".*[!@#$%^&].*")) {
							return true;
						}
					}
				}
			}
		}	
			return false;
	}
	
	public static Boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber==null) {
			return false;
		}
		if(phoneNumber.matches("[6-9][0-9]{9}")) {
			return true;
		}
		return false;	
	}

}
