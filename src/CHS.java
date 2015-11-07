import java.util.Date;

public class CHS {

	private long timeLeft;

	private Date date;

	private int period;
	private int day;

	private Hours first, second, third, forth, fifth, sixth, seventh, eighth;

	public CHS(Date date) {
		this.date = date;
		day = date.getDay();
		createSchedule();
	}

	public void update(long timeH, long timeM) {

		setPeriod(timeH, timeM);

		switch (period) {
		case 1:
			timeLeft = first.timeRemaining(timeH, timeM);
			break;
		case 2:
			timeLeft = second.timeRemaining(timeH, timeM);
			break;
		case 3:
			timeLeft = third.timeRemaining(timeH, timeM);
			break;
		case 4:
			timeLeft = forth.timeRemaining(timeH, timeM);
			break;
		case 5:
			timeLeft = fifth.timeRemaining(timeH, timeM);
			break;
		case 6:
			timeLeft = sixth.timeRemaining(timeH, timeM);
			break;
		case 7:
			timeLeft = seventh.timeRemaining(timeH, timeM);
			break;
		case 8:
			timeLeft = eighth.timeRemaining(timeH, timeM);
			break;
		}
	}

	private void createSchedule() {
		switch (day) {

		case 1: // Monday
			first = new Hours(810, 903, 1, 53);
			second = new Hours(908, 1001, 2, 53);
			third = new Hours(1006, 1059, 3, 53);
			forth = new Hours(000, 000, 4, 0);
			fifth = new Hours(1104, 1212, 5, 68);
			sixth = new Hours(1217, 1310, 6, 53);
			seventh = new Hours(1315, 1408, 7, 53);
			eighth = new Hours(1413, 1506, 8, 53);
			break;
		case 2: // Tuesday
			first = new Hours(810, 857, 1, 47);
			second = new Hours(902, 949, 2, 47);
			third = new Hours(954, 1041, 3, 47);
			forth = new Hours(1046, 1117, 4, 31);
			fifth = new Hours(1122, 1230, 5, 68);
			sixth = new Hours(1235, 1322, 6, 47);
			seventh = new Hours(1327, 1414, 7, 47);
			eighth = new Hours(1419, 1506, 8, 47);
			break;
		case 3: // Wednesday
			first = new Hours(810, 855, 1, 45);
			second = new Hours(900, 945, 2, 45);
			third = new Hours(950, 1035, 3, 45);
			forth = new Hours(1040, 1125, 4, 45);
			fifth = new Hours(1130, 1236, 5, 66);
			sixth = new Hours(1241, 1326, 6, 45);
			seventh = new Hours(1331, 1416, 7, 45);
			eighth = new Hours(1421, 1506, 8, 45);
			break;
		case 4: // Thursday
			first = new Hours(810, 855, 1, 45);
			second = new Hours(900, 945, 2, 45);
			third = new Hours(950, 1035, 3, 45);
			forth = new Hours(1040, 1125, 4, 45);
			fifth = new Hours(1130, 1236, 5, 66);
			sixth = new Hours(1241, 1326, 6, 45);
			seventh = new Hours(1331, 1416, 7, 45);
			eighth = new Hours(1421, 1506, 8, 45);
			break;
		case 5: // Friday
			first = new Hours(810, 853, 1, 43);
			second = new Hours(858, 941, 2, 43);
			third = new Hours(946, 1029, 3, 43);
			forth = new Hours(000, 000, 4, 0);
			fifth = new Hours(1034, 1117, 5, 43);
			sixth = new Hours(1122, 1230, 6, 68);
			seventh = new Hours(1235, 1318, 7, 43);
			eighth = new Hours(1323, 1406, 8, 43);
			break;
		}
	}

	public String stringPeriod() {
		switch (period) {
		case 1:
			return "first period";
		case 2:
			return "second period";
		case 3:
			return "third period";
		case 4:
			return "fourth period";
		case 5:
			return "fifth period";
		case 6:
			return "sixth period";
		case 7:
			return "seventh period";
		case 8:
			return "eighth period";
		default:
			return "travel time";
		}
	}

	public void setPeriod(long hour, long minute) {
		if (first.thisHour(hour, minute)) {
			period = 1;
			return;
		}
		if (second.thisHour(hour, minute)) {
			period = 2;
			return;
		}

		if (third.thisHour(hour, minute)) {
			period = 3;
			return;
		}
		if (forth.thisHour(hour, minute)) {
			period = 4;
			return;
		}
		if (fifth.thisHour(hour, minute)) {
			period = 5;
			return;
		}
		if (sixth.thisHour(hour, minute)) {
			period = 6;
			return;
		}

		if (seventh.thisHour(hour, minute)) {
			period = 7;
			return;
		}
		if (eighth.thisHour(hour, minute)) {
			period = 8;
		} else {
			period = 9;
		}
	}

	public int getPeriod() {
		return period;
	}

	public String displayPeriod() {
		return "It is " + stringPeriod();
	}
	
	public String displayTimeLeft(){
		return "There is " + timeLeft + " minutes left";
	}
	
	public long getTimeLeft(){
		return timeLeft;
	}

	@Override
	public String toString() {
		return "It is " + period + " period. With " + timeLeft + " minutes left";
	}
}
