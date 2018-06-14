package xupt.se.ttms.service;

import java.util.List;

import xupt.se.ttms.dao.ScheduleDAO;
import xupt.se.ttms.model.Schedule;

public class ScheduleSrv {
	ScheduleDAO scheduleDAO = new ScheduleDAO();
	
	public List<Schedule> prinfSchedules() {
		return scheduleDAO.prinfSchedules();
	}
	
	public List<Schedule> prinfSchedule(String play_name) {
		return scheduleDAO.prinfSchedule(play_name);
	}
	
	public void addSchedule(String studio_id, String play_name, String play_showTime
			, String play_time, String play_ticketPrice) {
		
		scheduleDAO.addSchedule(studio_id, play_name, play_showTime, play_time, play_ticketPrice);
	}
	
	public void modSchedule(String studio_id, String play_name, String play_showTime
			, String play_time, String play_ticketPrice) {
		
		scheduleDAO.modSchedule(studio_id, play_name, play_showTime, play_time, play_ticketPrice);
	}

	public void delSchedule(String schedule_id) {
		scheduleDAO.delSchedule(schedule_id);
		
	}

}
