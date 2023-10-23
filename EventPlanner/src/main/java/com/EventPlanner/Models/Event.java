package com.EventPlanner.Models;


import java.time.LocalDate;

public class Event {
	private int id;
	private String name;
	private int type_id;
	private LocalDate startdate;
	private LocalDate enddate;
	private float budget;
	private int ownerId;
	
	
	public Event() {
		
	}
	public Event(int Id,String name,int typeid,LocalDate startdate2,LocalDate enddate2,int ownerid) {
		this.id=Id;
		this.name=name;
		this.type_id=typeid;
		this.startdate=startdate2;
		this.enddate=enddate2;
		this.ownerId=ownerid;
	}
	
	public Event(String name,int typeid,LocalDate startdate2,LocalDate enddate2,int ownerid) {
		this.name=name;
		this.type_id=typeid;
		this.startdate=startdate2;
		this.enddate=enddate2;
		this.ownerId=ownerid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public LocalDate getEnddate() {
		return enddate;
	}
	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
}
