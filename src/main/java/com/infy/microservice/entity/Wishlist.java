package com.infy.microservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="wishlist")
public class Wishlist {
	
	@EmbeddedId
	private CompositeKey wishlistId;

	public CompositeKey getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(CompositeKey wishlistId) {
		this.wishlistId = wishlistId;
	}

}
