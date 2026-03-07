package com.reservation;

public class Reservation {
	String guestName;
	String roomType;
	String roomId;
	public Reservation(String guestName, String roomType, String roomId) {
		this.guestName = guestName;
		this.roomType = roomType;
		this.roomId = roomId;

	}
	public String getGuestName() {
		return guestName;
	}
	public String getRoomType() {
		return roomType;
	}
		
	public String getRoomId() {
		return roomId;
	}
}
