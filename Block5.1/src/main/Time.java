package main;

/**
 * Time class for adding , decreasing time and similar time operation
 * @author Tribel
 *
 */
public class Time {

	private int hour;
	private int minute;
	private int second;
	
	public Time() {
	}

	/**
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 */
	public Time(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	/**
	 * Adding one hour to the existing time
	 */
	public void addHour() {
		this.hour++;
	}
	
	
	/**
	 * Decrease one hour to the existing time
	 */
	public void decHour() {
		this.hour--;
	}
	
	/**
	 * Adding one minute to the existing time
	 */
	public void addMinute() {
		this.minute++;
	}
	
	/**
	 * Decrease one minute to the existing time
	 */
	public void decMinute() {
		this.minute--;
	}
	
	/**
	 * Adding one second to the existing time 
	 */
	public void addSecond() {
		this.second++;
	}
	
	/**
	 * Decrease one second to the existing time 
	 */
	public void decSecond() {
		this.second--;
	}
 
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	/**
	 * Returns a hash code value for the object.
	 * @return  a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
		result = prime * result + second;
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * @return  {@code true} if this object is the same as the obj.
     *          argument; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

	/**
	 * @return  a string representation of the object.
	 */
	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second="
				+ second + "]";
	}	
	
}
