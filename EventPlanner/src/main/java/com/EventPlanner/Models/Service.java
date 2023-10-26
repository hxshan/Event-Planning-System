package com.EventPlanner.Models;

import java.math.BigDecimal;

public class Service {
		private int Id;
		private int vendorId;
		private int TypeId;
		private  String ServiceName;
		private String Description;
		private BigDecimal price;
		
		
		
		
		public Service(int TypeId, int vendorId,String Description, BigDecimal price) {
			
			
			this.vendorId=vendorId;
			this.TypeId=TypeId;
			
			this.Description = Description;
			this.price = price;
		}
		
		
		public Service(int id,int ServiceTypeId, int vendorId,String ServiceName,String Description, BigDecimal price) {
			
			this.Id=id;
			
			this.vendorId=vendorId;
			this.ServiceName = ServiceName;
			this.Description = Description;
			this.price = price;
		}
		


		
		public Service() {
			
		}


		public int getTypeId() {
			return TypeId;
		}


		public void setTypeId(int typeId) {
			TypeId = typeId;
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


		public int getVendorId() {
			return vendorId;
		}


		public void setVendorId(int vendorId) {
			this.vendorId = vendorId;
		}


		public int getId() {
			return Id;
		}


		public void setId(int id) {
			Id = id;
		}
		
		


}
