
public class Hours {

	long start;
	long end;

	int period;
	int length;

	long hourS, minuteS;
	long hourE, minuteE;

	public Hours(long start, long end, int period, int length) {
		this.start = start;
		this.end = end;
		this.period = period;
		this.length = length;

		hourS = (start / 100);
		minuteS = (start % 100);

		hourE = (end / 100);
		minuteE = (end % 100);
	}

	public boolean thisHour(long hour, long minute) {
		return afterStart(hour, minute) && beforeEnd(hour, minute);
	}

	private boolean afterStart(long hour, long minute) {
		if (hour > hourS) {
			return true;
		} else if (hour == hourS && minute >= minuteS) {
			return true;
		}
		return false;
	}

	private boolean beforeEnd(long hour, long minute) {
		if (hour < hourE) {
			return true;
		} else if (hour == hourE && minute < minuteE) {
			return true;
		}
		return false;
	}

	public long timeRemaining(long hour, long minute) {
		long remainingM = minuteE - minute;
		long remainingH = hourE - hour;
		if (remainingM > 0)
			if (remainingH > 0) {
				return remainingM + 60;
			} else {
				return remainingM;
			}
		return remainingM + 60;
	}

	public long getStart() {
		return start;
	}

	public long getEnd() {
		return end;
	}

	public long getHourS() {
		return hourS;
	}

	public long getMinuteS() {
		return minuteS;
	}

	public long getHourE() {
		return hourE;
	}

	public long getMinuteE() {
		return minuteE;
	}

	public int getPeriod() {
		return period;
	}
}
