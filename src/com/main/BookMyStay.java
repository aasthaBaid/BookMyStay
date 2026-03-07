package com.main;

import java.util.*;
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
        for (Reservation r : confirmed) {
            if (r.getGuestName().equals("Alice")) {
                serviceModule.addService(r.getRoomId(), new Service("Breakfast", 500.0));
                serviceModule.addService(r.getRoomId(), new Service("Airport Pickup", 1200.0));
            }
            if (r.getGuestName().equals("Bob")) {
                serviceModule.addService(r.getRoomId(), new Service("Spa", 2000.0));
            }
        }

        // Display services and calculate costs
        for (Reservation r : confirmed) {
            serviceModule.displayServices(r.getRoomId());
            double totalCost = serviceModule.calculateTotalServiceCost(r.getRoomId());
            System.out.println("Total Add-On Cost for " + r.getGuestName() + ": ₹" + totalCost);
        }


	}

}
