package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class UserDto {
	
private String userName;
	
	
	private String email;
	
	
	private String password;
	private String imagePath;
	
	private long contactNumber;
	private Date regisdate;
	
	private String streetNo;
	private String city;
	private String state;
	private String country;
	private long pincode;
	
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getRegisdate() {
		return regisdate;
	}
	public void setRegisdate(Date regisdate) {
		this.regisdate = regisdate;
	}
	

}
