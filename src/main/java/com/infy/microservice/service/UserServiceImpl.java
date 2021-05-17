package com.infy.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.microservice.dto.BuyerDTO;
import com.infy.microservice.dto.SellerDTO;
import com.infy.microservice.entity.Buyer;
import com.infy.microservice.entity.Seller;
import com.infy.microservice.exception.UserMSException;
import com.infy.microservice.repository.BuyerRepository;
import com.infy.microservice.repository.SellerRepository;
import com.infy.microservice.validator.BuyerValidator;
import com.infy.microservice.validator.SellerValidator;


@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
//------------------------------BUYER SERVICE IMPLEMENTATION---------------------------
	@Override
	public String registerBuyer(BuyerDTO buyer) throws UserMSException{
		BuyerValidator.validateBuyerForRegister(buyer);
		if(buyerRepository.findByPhoneNumber(buyer.getPhoneNumber())!=null) {
			throw new UserMSException("UserService.PHONE_NUMBER_ALREADY_EXIST");
		}
		if(buyerRepository.findByEmail(buyer.getEmail())!=null) {
			throw new UserMSException("UserService.EMAIL_ALREADY_EXIST");
		}
		try {
			Buyer buyerEntity= new Buyer();
			buyerEntity.setBuyerId(buyer.getBuyerId());
			buyerEntity.setEmail(buyer.getEmail());
			buyerEntity.setName(buyer.getName());
			buyerEntity.setPhoneNumber(buyer.getPhoneNumber());
			buyerEntity.setPassword(buyer.getPassword());
			buyerEntity.setIsPrivileged(buyer.getIsPrivileged());
			buyerEntity.setIsActive(buyer.getIsActive());
			buyerEntity.setRewardPoints(buyer.getRewardPoints());
			buyerRepository.save(buyerEntity);
			return buyerEntity.getName();	
		}
		catch(Exception e) {
			throw new UserMSException("UserService.ERROR_MSG");
		}		
	}
	
	@Override
	public BuyerDTO authenticateBuyer(String email, String password) throws UserMSException{
		BuyerValidator.validateBuyerforLogin(email, password);
		Buyer buyer= buyerRepository.findByEmail(email);
		if(buyer==null) {
			throw new UserMSException("UserService.INVALID_CREDENTIALS");
		}
		String passwordDB= buyer.getPassword();
		if(passwordDB!=null) {
			try {
				if(passwordDB.equals(password)) {
					BuyerDTO buyerDTO= new BuyerDTO();
					buyerDTO.setBuyerId(buyer.getBuyerId());
					buyerDTO.setName(buyer.getName());
					buyerDTO.setPhoneNumber(buyer.getPhoneNumber());
					buyerDTO.setEmail(buyer.getEmail());
					buyerDTO.setPassword(buyer.getPassword());
					buyerDTO.setRewardPoints(buyer.getRewardPoints());
					buyerDTO.setIsPrivileged(buyer.getIsPrivileged());
					buyerDTO.setIsActive(buyer.getIsActive());
					
					return buyerDTO;
				}
				else {
					throw new UserMSException("UserService.INVALID_CREDENTIALS");
				}
			}
			catch(Exception e) {
				throw new UserMSException("UserService.INVALID_CREDENTIALS");
			}
		}
		else {
			throw new UserMSException("UserService.INVALID_CREDENTIALS");
		}
	}
	
	@Override
	public void deleteBuyer(String email) throws UserMSException{
		Buyer buyer= buyerRepository.findByEmail(email);
		if(buyer==null) {
			throw new UserMSException("UserService.NO_SUCH_USER_EXISTS");
		}
		buyerRepository.delete(buyer);
	}
	
	
	@Override
	public void deactivateBuyer(String email) throws UserMSException{
		Buyer buyer= buyerRepository.findByEmail(email);
		if(buyer==null) {
			throw new UserMSException("UserService.NO_SUCH_USER_EXISTS");
		}
		if(buyer.getIsActive()==true) {
			buyer.setIsActive(false);
		}
		
	}
	
	//------------------------------SELLER SERVICE IMPLEMENTATION---------------------------
	
	@Override
	public String registerSeller(SellerDTO seller) throws UserMSException{
		SellerValidator.validateSellerForRegister(seller);
		if(sellerRepository.findByPhoneNumber(seller.getPhoneNumber())!=null) {
			throw new UserMSException("UserService.PHONE_NUMBER_ALREADY_EXIST");
		}
		if(sellerRepository.findByEmail(seller.getEmail())!=null) {
			throw new UserMSException("UserService.EMAIL_ALREADY_EXIST");
		}
		try {
			Seller sellerEntity= new Seller();
			sellerEntity.setSellerId(seller.getSellerId());
			sellerEntity.setName(seller.getName());
			sellerEntity.setEmail(seller.getEmail());
			sellerEntity.setPhoneNumber(seller.getPhoneNumber());
			sellerEntity.setPassword(seller.getPassword());
			sellerEntity.setIsActive(seller.getIsActive());
			sellerRepository.save(sellerEntity);
			return sellerEntity.getName();
			
		}
		catch(Exception e) {
			throw new UserMSException("UserService.ERROR_MSG");
		}		
	}
	
	@Override
	public SellerDTO authenticateSeller(String email, String password) throws UserMSException{
		SellerValidator.validateSellerforLogin(email, password);
		Seller seller= sellerRepository.findByEmail(email);
		if(seller==null) {
			throw new UserMSException("UserService.INVALID_CREDENTIALS");
		}
		String passwordDB= seller.getPassword();
		if(passwordDB!=null) {
			try {
				if(passwordDB.equals(password)) {
					SellerDTO sellerDTO= new SellerDTO();
					sellerDTO.setSellerId(seller.getSellerId());
					sellerDTO.setName(seller.getName());
					sellerDTO.setPhoneNumber(seller.getPhoneNumber());
					sellerDTO.setEmail(seller.getEmail());
					sellerDTO.setPassword(seller.getPassword());
					sellerDTO.setIsActive(seller.getIsActive());
					return sellerDTO;
				}
				else {
					throw new UserMSException("UserService.INVALID_CREDENTIALS");
				}
			}
			catch(Exception e) {
				throw new UserMSException("UserService.INVALID_CREDENTIALS");
			}
		}
		else {
			throw new UserMSException("UserService.INVALID_CREDENTIALS");
		}
	}
	
	@Override
	public void deleteSeller(String email) throws UserMSException{
		Seller seller= sellerRepository.findByEmail(email);
		if(seller==null) {
			throw new UserMSException("UserService.NO_SUCH_USER_EXISTS");
		}
		sellerRepository.delete(seller);
	}

}
