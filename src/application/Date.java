package application;
public class Date implements Comparable<Date>{
	int day;
	int year;
	int month;
	
	public Date(int day, int month, int year) { 
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean equals(Object other) { 
		return (other instanceof Date &&
				this.day == ((Date)other).day &&
				this.year == ((Date)other).year &&
				this.month == ((Date)other).month);
	}
	 
	public int hashCode() { 
		return day * year * month;
	}
	

	public int compareTo(Date other) { 
		if(year != other.year)
			return year - other.year;
		if(month != other.month)
			return month - other.month;
		return day-other.day;
	}
	

	public String toString() { 
		return String.format("%02d/%02d/%04d", day, month, year);
	}
}