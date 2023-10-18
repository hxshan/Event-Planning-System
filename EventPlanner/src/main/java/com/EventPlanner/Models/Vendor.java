package com.EventPlanner.Models;

public class Vendor extends User {
	
	private String description;
	private String address;
	
	
	
	public Vendor(int typeid, String name, String email, String PhoneNumber, String pwd,String des,String address ) {
		super(typeid, name, email,PhoneNumber, pwd);
		this.setDescription(des);
		this.setAddress(address);
		
	}

	public Vendor() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
