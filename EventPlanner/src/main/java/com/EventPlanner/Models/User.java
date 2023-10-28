package com.EventPlanner.Models;

public class User {
	private int Id;
	private int UserTypeId;
	private String Name;
	private String Email;
	private String PhoneNumber;
	private String Password;
	private byte[] image;
	private String encodedImage;
	
	
	
	public User(int typeid,String name,String email, String PhoneNumber,String pwd){
	
		this.UserTypeId=typeid;
		this.Name=name;
		this.Email=email;
		this.PhoneNumber=PhoneNumber;
		this.Password=pwd;
	}
	public User(int id,int typeid,String name,String email, String PhoneNumber,String pwd){
		this.Id=id;
		this.UserTypeId=typeid;
		this.Name=name;
		this.Email=email;
		this.PhoneNumber=PhoneNumber;
		this.Password=pwd;
	}
	
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
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



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getEncodedImage() {
		return encodedImage;
	}



	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}


}
