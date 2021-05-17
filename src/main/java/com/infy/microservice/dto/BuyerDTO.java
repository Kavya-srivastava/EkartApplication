package com.infy.microservice.dto;

public class BuyerDTO {
	
	private Integer buyerId;
	
//	@NotNull(message="{name.absent}")
//	@Pattern(regexp= "([A-Za-z])+(\\s[A-Za-z]+)*", message= "{invalid.name.format}")
//	@NotNull(message="no name")
//	@Pattern(regexp= "[A-Za-z]+", message= "invalid name format")
	private String name;
	
	
//	@NotNull(message="{email.absent}")
//	@Pattern(regexp="[A-Za-z0-9_.]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message= "{invalid.email.format}")
//	@NotNull(message=" no email")
//	@Pattern(regexp="[A-Za-z0-9_]+@[A-Za-z]+[.]com", message= "invalid email format")
	private String email;
	
//	@NotNull(message="{phonenumber.absent}")
//	@Pattern(regexp= "[6-9][0-9]{9}", message= "{invalid.phonenumber.format}")
//	@NotNull(message="phonenumber absent")
//	@Pattern(regexp= "[6-9][0-9]{9}", message= "invalid phonenumber format")
	private String phoneNumber;
	
//	@NotNull(message="{password.absent}")
//	@Pattern(regexp= ".*[A-Z]+.*", message= "{invalid.password.format.uppercase}")
//	@Pattern(regexp= ".*[a-z]+.*", message= "{invalid.password.format.lowercase}")
//	@Pattern(regexp= ".*[0-9]+.*" , message= "{invalid.password.format.number}")
//	@Pattern(regexp= ".*[!@#$%^&].*", message= "{invalid.password.format.specialcharacter}")
//	@NotNull(message="password absent")
//	@Pattern(regexp= ".*[A-Z]+.*", message= "invalid password format uppercase")
//	@Pattern(regexp= ".*[a-z]+.*", message= "invalid password format lowercase")
//	@Pattern(regexp= ".*[0-9]+.*" , message= "invalid password format number")
//	@Pattern(regexp= ".*[!@#$%^&].*", message= "invalid password format specialcharacter")
	private String password;
	
	private Boolean isPrivileged;
	private Integer rewardPoints;
	private Boolean isActive;
	
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsPrivileged() {
		return isPrivileged;
	}
	public void setIsPrivileged(Boolean isPrivileged) {
		this.isPrivileged = isPrivileged;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "BuyerDTO [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", isPrivileged=" + isPrivileged + ", rewardPoints=" + rewardPoints
				+ ", isActive=" + isActive + "]";
	}
	

}
