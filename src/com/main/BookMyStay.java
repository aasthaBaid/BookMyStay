package com.main;

import java.util.*;

import com.reservation.BookingHistory;
import com.reservation.BookingQueueService;
import com.reservation.Reservation;
import com.room.RoomInventory;
import com.service.InventoryService;
import com.service.SearchService;
import com.service.Service;
import com.service.ServiceManagementModule;

public class BookMyStay {

	public static void main(String[] args) {
		RoomInventory inventory = new RoomInventory();
        InventoryService adminService = new InventoryService(inventory);
        SearchService guestService = new SearchService(inventory);
        BookingQueueService bookingService = new BookingQueueService(inventory);
        ServiceManagementModule serviceModule = new ServiceManagementModule();
        BookingHistory history = new BookingHistory();


        // Admin initializes rooms
        adminService.initializeDefaultRooms();
        inventory.displayInventory();

        // Guests search rooms
        guestService.displayAvailableRooms();

        // Guests place booking requests
        bookingService.requestBooking("Alice", "Single");
        bookingService.requestBooking("Bob", "Suite");

        // Process bookings
        List<Reservation> confirmed = bookingService.processBookings();

        // Add confirmed reservations to history
        for (Reservation r : confirmed) {
            history.addReservation(r);
        }

        // Generate report
        history.generateReport();

        // Cancel one reservation
        if (!confirmed.isEmpty()) {
            Reservation toCancel = confirmed.get(0);
            inventory.cancelRoom(toCancel.getRoomId(), toCancel.getRoomType());
            history.cancelReservation(toCancel.getRoomId());
        }

        // Updated report
        history.generateReport();
        inventory.displayInventory();
    }



}
