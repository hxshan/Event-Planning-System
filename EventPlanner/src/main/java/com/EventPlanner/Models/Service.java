package com.EventPlanner.Models;

import java.math.BigDecimal;

public class Service {
		private int Id;
		private int ServiceTypeId;
		private int vendorId;
		private  String ServiceName;
		private String Description;
		private BigDecimal price;
		
		
		//for views only :)
		private String VendorName;
		
		
		public Service() {
			
		}
		
		public Service(int ServiceTypeId, int vendorId,String ServiceName,String Description, BigDecimal price) {
			
			this.ServiceTypeId = ServiceTypeId;
			this.vendorId=vendorId;
			this.ServiceName = ServiceName;
			this.Description = Description;
			this.price = price;
		}
		
		
		public Service(int id,int ServiceTypeId, int vendorId,String ServiceName,String Description, BigDecimal price) {
			
			this.Id=id;
			this.ServiceTypeId = ServiceTypeId;
			this.vendorId=vendorId;
			this.ServiceName = ServiceName;
			this.Description = Description;
			this.price = price;
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

		public String getVendorName() {
			return VendorName;
		}

		public void setVendorName(String vendorName) {
			VendorName = vendorName;
		}
		
		


}
