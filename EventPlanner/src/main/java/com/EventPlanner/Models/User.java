package com.EventPlanner.Models;

public class User {
	private int Id;
	private int UserTypeId;
	private String Name;
	private String Email;
	private String Password;
	
	
	
	
	public User(int typeid,String name,String email,String pwd){
	
		this.UserTypeId=typeid;
		this.Name=name;
		this.Email=email;
		this.Password=pwd;
	}
	
	
	
	public User() {
		
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	public int getUserTypeId() {
		return UserTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		UserTypeId = userTypeId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
