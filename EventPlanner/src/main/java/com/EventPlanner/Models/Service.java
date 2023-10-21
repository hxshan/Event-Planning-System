package com.EventPlanner.Models;

import java.math.BigDecimal;

public class Service extends Vendor {
		private int ServiceTypeId;
		private  String ServiceName;
		private BigDecimal price;
		
		
		
		public Service(int typeid, String name, String email, String PhoneNumber, String pwd, String des,
				String address,int ServiceTypeId, String ServiceName, BigDecimal price) {
			super(typeid, name, email, PhoneNumber, pwd, des, address);
			this.ServiceTypeId = ServiceTypeId;
			this.ServiceName = ServiceName;
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


		public BigDecimal getPrice() {
			return price;
		}


		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		
		


}
