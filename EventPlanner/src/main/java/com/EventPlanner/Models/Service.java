package com.EventPlanner.Models;

import java.math.BigDecimal;

public class Service extends User {
		private int ServiceTypeId;
		private  String ServiceName;
		private String Description;
		private BigDecimal price;
		
		
		
		public Service(int typeid,String name,String email, String PhoneNumber,String pwd,int ServiceTypeId, String ServiceName,String Description, BigDecimal price) {
			
			super(typeid, name, email,PhoneNumber, pwd);
			this.ServiceTypeId = ServiceTypeId;
			this.ServiceName = ServiceName;
			this.Description = Description;
			this.price = price;
		}
		
		
		public Service() {
			super();
			
		}


		public int getServiceTypeId() {
			return ServiceTypeId;
		}


		public void setServiceTypeId(int serviceTypeId) {
			ServiceTypeId = serviceTypeId;
		}


		public String getServiceName() {
			return ServiceName;
		}


		public void setServiceName(String serviceName) {
			ServiceName = serviceName;
		}
		
		
		public String getDescription() {
			return Description;
		}


		public void setDescription(String description) {
			Description = description;
		}


		public BigDecimal getPrice() {
			return price;
		}


		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		
		


}
