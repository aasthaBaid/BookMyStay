package com.main;

import com.reservation.BookingQueueService;
import com.room.RoomInventory;
import com.service.InventoryService;
import com.service.SearchService;

public class BookMyStay {

	public static void main(String[] args) {
		RoomInventory inventory = new RoomInventory();
        InventoryService service = new InventoryService(inventory);
        SearchService guestService = new SearchService(inventory);
        BookingQueueService bookingService = new BookingQueueService(inventory);
		// by default initialize 
        service.initializeDefaultRooms();
        inventory.displayInventory();
//        service.showPrice("Single");
//        service.updateRoom("Single", 8, 2200.0);
//        service.updateRoom("Suite", 3, 8500.0);
//        inventory.displayInventory();
        
        guestService.displayAvailableRooms();

        // Guest checks amenities
        guestService.showAmenities("Suite");

        bookingService.requestBooking("Alice", "Single");
        bookingService.requestBooking("Bob", "Suite");
        bookingService.requestBooking("Charlie", "Suite");
        bookingService.requestBooking("Diana", "Double");

        // Process bookings in FIFO order
        bookingService.processBookings();

        // Show updated inventory after bookings
        inventory.displayInventory();


	}

}
