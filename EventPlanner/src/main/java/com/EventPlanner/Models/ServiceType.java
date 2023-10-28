package com.EventPlanner.Models;

public class ServiceType {
	private	int Id;
	private String Type;
	private String Description;
	
	public ServiceType(int Id, String type, String description) {
		
		this.Id = Id;
		this.Type = type;
		this.Description = description;
	}

	public ServiceType() {
		
	}

	public int getServiceId() {
		return Id;
	}

	public void setServiceId(int Id) {
		this.Id =Id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
