package com.main;

import com.room.RoomInventory;
import com.service.InventoryService;
import com.service.SearchService;

public class BookMyStay {

	public static void main(String[] args) {
		RoomInventory inventory = new RoomInventory();
        InventoryService service = new InventoryService(inventory);
        SearchService guestService = new SearchService(inventory);
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

        String requestedRoom = "Suite";
        if (guestService.isRoomAvailable(requestedRoom)) {
            System.out.println(requestedRoom + " room is available for booking.");
        } else {
            System.out.println(requestedRoom + " room is NOT available.");
        }

	}

}
