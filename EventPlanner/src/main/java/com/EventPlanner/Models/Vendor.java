package com.EventPlanner.Models;

public class Vendor extends User {
	
	private String description;
	private String address;
	private int serviceTypeId;
	
	
	public Vendor(int typeid, String name, String email, String pwd,String des,String address,int servType ) {
		super(typeid, name, email, pwd);
		this.setDescription(des);
		this.setAddress(address);
		this.setserviceTypeId(servType);
		
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

	public int getserviceTypeId() {
		return serviceTypeId;
	}

	public void setserviceTypeId(int serviceType) {
		this.serviceTypeId = serviceType;
	}

}
