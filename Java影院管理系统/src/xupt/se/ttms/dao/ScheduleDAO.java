package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xupt.se.ttms.model.Schedule;
import xupt.se.util.DBUtil;

public class ScheduleDAO {
	
	private DBUtil conn = null;
	
	public List<Schedule> prinfSchedules() {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "select * from schedule";
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		
		ResultSet rs = conn.selectTable(sql);
		try {
			while(rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setSchedule_id(rs.getString(1));
				schedule.setStudio_id(rs.getString(2));
				schedule.setPlay_name(rs.getString(3));
				schedule.setPlay_showTime(rs.getString(4));
				schedule.setPlay_time(rs.getString(5));
				schedule.setPlay_ticketPrice(rs.getString(6));
				scheduleList.add(schedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheduleList;
	}
	
	public List<Schedule> prinfSchedule(String play_name) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		String sql = "select * from schedule where play_name = '" + play_name + "'";
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		
		ResultSet rs = conn.selectTable(sql);
		try {
			while(rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setSchedule_id(rs.getString(1));
				schedule.setStudio_id(rs.getString(2));
				schedule.setPlay_name(rs.getString(3));
				schedule.setPlay_showTime(rs.getString(4));
				schedule.setPlay_time(rs.getString(5));
				schedule.setPlay_ticketPrice(rs.getString(6));
				scheduleList.add(schedule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheduleList;
	}
	
	public void addSchedule(String studio_id, String play_name, String play_showTime
			, String play_time, String play_ticketPrice) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		String sql = "insert into schedule(studio_id,play_name," +
				"play_showTime,play_time,play_ticketPrice) values('" 
				+ studio_id + "','" 
				+ play_name + "','" 
				+ play_showTime + "','" 
				+ play_time + "','" 
				+ play_ticketPrice + "')";
		
		if(conn.insertTable(sql)) {
			conn.close();
			return;
		}
	}
	
	public void modSchedule(String studio_id, String play_name, String play_showTime
			, String play_time, String play_ticketPrice) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		String sql = "update schedule set studio_id = '"
				+ studio_id + "',play_name = '"
				+ play_name + "',play_showTime = '"
				+ play_showTime + "',play_time = '"
				+ play_time + "',play_ticketPrice = '"
				+ play_ticketPrice + "' "
				+ "where play_name = '" + play_name + "'";

		if(conn.updateTable(sql)) {
			conn.close();
			return;
		}
	}

	public void delSchedule(String schedule_id) {
		conn = new DBUtil(); // 连接数据库
		conn.openConnection();
		
		int id = Integer.parseInt(schedule_id);
		
		String sql = "delete from schedule where schedule_id = " + id;
		
		if(conn.deleteTable(sql)) {
			conn.close();
			return;
		}
	}
}
