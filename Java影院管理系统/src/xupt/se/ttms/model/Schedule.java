package xupt.se.ttms.model;

public class Schedule {
	private String schedule_id;			//演出计划id
	private String studio_id;			//演出厅id
	private String play_name;			//剧目名字
	private String play_showTime;		//剧目上映时间
	private String play_time;			//剧目播放时长
	private String play_ticketPrice;	//剧目票价
	
	public String getSchedule_id() {
		return schedule_id;
	}
	
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	public String getStudio_id() {
		return studio_id;
	}
	
	public void setStudio_id(String studio_id) {
		this.studio_id = studio_id;
	}
	
	public String getPlay_name() {
		return play_name;
	}
	
	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}
	
	public String getPlay_showTime() {
		return play_showTime;
	}
	
	public void setPlay_showTime(String play_showTime) {
		this.play_showTime = play_showTime;
	}
	
	public String getPlay_time() {
		return play_time;
	}
	
	public void setPlay_time(String play_time) {
		this.play_time = play_time;
	}
	
	public String getPlay_ticketPrice() {
		return play_ticketPrice;
	}
	
	public void setPlay_ticketPrice(String play_ticketPrice) {
		this.play_ticketPrice = play_ticketPrice;
	}

	@Override
	public String toString() {
		return "Schedule [schedule_id=" + schedule_id + ", studio_id=" + studio_id + ", play_name=" + play_name
				+ ", play_showTime=" + play_showTime + ", play_time=" + play_time + ", play_ticketPrice="
				+ play_ticketPrice + "]";
	}
	
}
