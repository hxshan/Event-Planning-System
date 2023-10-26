package com.EventPlanner.Models;

public class ServiceType {
	private	int ServiceId;
	private String Type;
	private String Description;
	
	public ServiceType(int serviceId, String type, String description) {
		
		this.ServiceId = serviceId;
		this.Type = type;
		this.Description = description;
	}

	public int getServiceId() {
		return ServiceId;
	}

	public void setServiceId(int serviceId) {
		ServiceId = serviceId;
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
