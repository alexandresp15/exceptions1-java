package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}
	
	public String updateDates(Date checkIn, Date checkOut) { 
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservetion dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Chack-out date must be after chack-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut; 
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Resevation: Room " + roomNumber);
		sb.append(", check-in: " + sdf.format(checkIn));
		sb.append(", check-out: " + sdf.format(checkOut));
		sb.append(", " + duration() + " night(s)");
		return sb.toString();
	}
	

}
