package com.EventPlanner.Models;

public class User {
	private int Id;
	private int UserTypeId;
	private String Name;
	private String Email;
	private String Password;
	private String ImageId;
	private String ImageName;
	
	
	
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



	public String getImageName() {
		return ImageName;
	}



	public void setImageName(String imageName) {
		ImageName = imageName;
	}



	public String getImageId() {
		return ImageId;
	}



	public void setImageId(String imageId) {
		ImageId = imageId;
	}
	
}
