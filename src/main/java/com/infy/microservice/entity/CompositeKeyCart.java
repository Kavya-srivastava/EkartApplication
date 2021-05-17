package com.infy.microservice.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKeyCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer buyerId;
	private Integer productId;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}
