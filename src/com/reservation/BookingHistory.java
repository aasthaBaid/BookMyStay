package com.reservation;

import java.util.*;

public class BookingHistory {
	 private List<Reservation> history;

	    public BookingHistory() {
	        history = new ArrayList<>();
	    }

	    public void addReservation(Reservation reservation) {
	        history.add(reservation);
	    }

	    public void cancelReservation(String roomId) {
	        history.removeIf(r -> r.getRoomId().equals(roomId));
	        System.out.println("Reservation with Room ID " + roomId + " cancelled from history.");
	    }

	    public void generateReport() {
	        System.out.println("\n=== Booking History Report ===");
	        for (Reservation r : history) {
	            System.out.println("Guest: " + r.getGuestName() +
	                               ", Room Type: " + r.getRoomType() +
	                               ", Room ID: " + r.getRoomId());
	        }
	    }
	}
