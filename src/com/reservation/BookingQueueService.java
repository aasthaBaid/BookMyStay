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
        Reservation reservation = new Reservation(guestName, roomType);
        bookingQueue.add(reservation);
        System.out.println("Booking request added for " + guestName + " → " + roomType);
    }
    public void processBookings() {
        System.out.println(" ----Processing Booking Requests:----");
        // while queue is not empty
        while (!bookingQueue.isEmpty()) {
            Reservation reservation = bookingQueue.poll();
            String type = reservation.getRoomType();

            if (inventory.getAvailability(type) > 0) {
                inventory.decrementRoom(type);
                System.out.println("Booking CONFIRMED for " + reservation.getGuestName() +
                                   " → " + type);
            } else {
                System.out.println("Booking FAILED for " + reservation.getGuestName() +
                                   " → " + type + " (No availability)");
            }
        }
    }

}
