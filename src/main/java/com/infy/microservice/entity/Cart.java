package com.infy.microservice.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@EmbeddedId
	private CompositeKeyCart cartId;
	private Integer quantity;
	public CompositeKeyCart getCartId() {
		return cartId;
	}
	public void setCartId(CompositeKeyCart cartId) {
		this.cartId = cartId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
