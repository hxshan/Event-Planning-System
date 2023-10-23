package com.EventPlanner.Services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.EventType;
import com.EventPlanner.Utils.DBConnectionUtil;
import com.EventPlanner.Utils.ErrorLoggerUtil;

public class EventService {
	
	public void addEvent(Event event) {
		
		
		Connection con=DBConnectionUtil.getDBConnection();
		String sql="insert into event(name,type_id,startDate,endDate,ownerId) values(?,?,?,?,?);";
		
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,event.getName());
			stmt.setInt(2, event.getType_id());
			stmt.setObject(3,event.getStartdate());
			stmt.setObject(4,event.getEnddate());
			stmt.setInt(5, event.getOwnerId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("EventService(addEvent)", "Sql Error", e);
		}
		
	}
	public void deleteEvent(int eventid) {
		Connection con=DBConnectionUtil.getDBConnection();
		String sql="delete from event where id=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,eventid);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			ErrorLoggerUtil.logError("EventService(DeleteEvent)", "Sql Error", e);
		}
		
	}
	
	public List<Event> getUsersEvents(int userid){
		Connection con = DBConnectionUtil.getDBConnection();		
		String sql="select * from event where ownerId=?";
		ResultSet rs = null;
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,userid);
			rs=stmt.executeQuery();		
		} catch (SQLException e) {
			
			ErrorLoggerUtil.logError("EventService(getUsersEvents)", "Sql Error prepared stmt", e);
		}
		List<Event> Elist= new ArrayList<Event>();
		try {
			while(rs.next()) {
				int Id=rs.getInt("id");
				String ename=rs.getString("name");
				int typeid=rs.getInt("type_id");
				LocalDate startDate=rs.getDate("startDate").toLocalDate();
				LocalDate endDate=rs.getDate("endDate").toLocalDate();
				int ownerid=rs.getInt("ownerId");
				
				Elist.add(new Event(Id,ename,typeid,startDate,endDate,ownerid));
			}
		} catch (SQLException e) {
			
			ErrorLoggerUtil.logError("EventService(getUsersEvents)", "Sql Error resultset loop", e);
		}
		return Elist;
		
	}
	
	public List<EventType> getEventTypes() {
		Connection con = DBConnectionUtil.getDBConnection();		
		
		String sql="select * from event_types order by type asc;";
		ResultSet rs = null;
		try {
			PreparedStatement stmt= con.prepareStatement(sql);
			rs=stmt.executeQuery();
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("EventService", "Sql Error", e);
		}
		List<EventType> Etypelist= new ArrayList<EventType>();
		
		try {
			while(rs.next()) {	
				Etypelist.add(new EventType(rs.getInt("id"),rs.getString("type")));
			}
		} catch (SQLException e) {
			
			ErrorLoggerUtil.logError("EventService(getEventTypes)", "Sql Error", e);
		}
		
		return Etypelist;
	}
	
	public Event getEventDetails(int eventId) {
		Connection con = DBConnectionUtil.getDBConnection();		
		String sql="select * from event where id=?";
		Event event=new Event();
		ResultSet rs = null;
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,eventId);
			rs=stmt.executeQuery();	
		} catch (SQLException e) {
		
			ErrorLoggerUtil.logError("EventService(getEventDetails)", "Sql Error prepared stmt", e);
		}
		try {
			if(rs.next()) {
				event.setId(rs.getInt("id"));
				event.setName(rs.getString("name"));
				event.setType_id(rs.getInt("type_id"));
				event.setStartdate(rs.getDate("startDate").toLocalDate());
				event.setEnddate(rs.getDate("endDate").toLocalDate());
				event.setOwnerId(rs.getInt("ownerId"));
			}
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("EventService(getUsersEvents)", "Sql Error resultset loop", e);
		}
		return event;
	}
}
