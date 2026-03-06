package com.main;

import com.room.RoomInventory;
import com.service.InventoryService;

public class BookMyStay {

	public static void main(String[] args) {
		RoomInventory inventory = new RoomInventory();
        InventoryService service = new InventoryService(inventory);

		// by default initialize 
        service.initializeDefaultRooms();
        inventory.displayInventory();
        service.showPrice("Single");
        service.updateRoom("Single", 8, 2200.0);
        service.updateRoom("Suite", 3, 8500.0);
        inventory.displayInventory();
	}

}
