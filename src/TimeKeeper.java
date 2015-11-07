
////////////////////////////////////////////////////////////////////
//
//	This class keeps and allows the driver class to update the time.
//	Holds methods to update and display the current time.
//
//
////////////////////////////////////////////////////////////////////

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeKeeper {

	Time time;
	Date date;

	SimpleDateFormat format = new SimpleDateFormat("k:mm:ss");

	String currentTime;
	int day;
	int hour;
	int minute;
	int second;

	@SuppressWarnings("deprecation")
	public TimeKeeper(Date date) {
		time = new Time(System.currentTimeMillis());
		hour = time.getHours();
		minute = time.getMinutes();
		second = time.getSeconds();
		day = date.getDay();
		this.date = date;
	}

	public void updateTime() {
		int count = second;
		if (count == 60) {
			second = 0;
			minute++;
		} else {
			if (minute == 60) {
				minute = 0;
				hour++;
			} else {
				second++;
				currentTime = format.format(new Date());
			}
		}
	}

	public void displayTime() {
		System.out.println(hour + ":" + minute + ":" + second);
	}

	public String day() {
		switch (day) {
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		default:
			return "Not a school day";
		}
	}

	public long getHour() {
		return hour;
	}

	public long getMinute() {
		return minute;
	}
	
	public long getSecond(){
		return second;
	}

	public String displayInfo() {
		return currentTime;
	}
}
