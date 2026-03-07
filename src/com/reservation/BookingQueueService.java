package com.reservation;

import java.util.*;

import com.room.RoomInventory;

public class BookingQueueService {
	private Queue<Reservation> bookingQueue;
    private RoomInventory inventory;

    public BookingQueueService(RoomInventory inventory) {
        this.inventory = inventory;
        bookingQueue = new LinkedList<>();
    }
    // Accept booking request (enqueue)
    public void requestBooking(String guestName, String roomType) {
        Reservation reservation = new Reservation(guestName, roomType, null);
        bookingQueue.add(reservation);
        System.out.println("Booking request added for " + guestName + " → " + roomType);
    }
    public List<Reservation> processBookings() {
        System.out.println("\n=== Processing Booking Requests ===");
        List<Reservation> confirmedReservations = new ArrayList<>();
        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            String type = reservation.getRoomType();
            String roomId = inventory.allocateRoom(type, reservation.getGuestName());
            if (roomId != null) {
                Reservation confirmed = new Reservation(reservation.getGuestName(), type, roomId);
                confirmedReservations.add(confirmed);
                System.out.println("Booking CONFIRMED for " + confirmed.getGuestName() +
                                   " → " + type + " (Room ID: " + roomId + ")");
            } else {
                System.out.println("Booking FAILED for " + reservation.getGuestName() +
                                   " → " + type + " (No availability)");
            }
        }
        return confirmedReservations;
    }


}
