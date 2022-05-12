package studyJava2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Schedule {
	private String schedule, place;
	
	Date now = new Date();
	SimpleDateFormat dayf = new SimpleDateFormat("yyyyMMdd"); //변수 틀 만들어줌
	private String day = dayf.format(now).toString();
	
	public Schedule(String schedule, String place) {
		this.schedule = schedule;
		this.place = place;
	}
	
	public Schedule(String schedule, String place, String day) {
		this.schedule = schedule;
		this.place = place;
		this.day = day;
	}

	public String getSchedule() {
		return schedule;
	}

	public String getPlace() {
		return place;
	}

	public String getDay() {
		return day;
	}

}
