package com.service;

import com.room.RoomInventory;

public class SearchService {
	private RoomInventory inventory;
	public SearchService(RoomInventory inventory) {
		this.inventory = inventory;
	}

	public void displayAvailableRooms() {
		System.out.println("Available rooms:");
		for(String type : inventory.getRoomCounts().keySet()) {
			int available = inventory.getAvailability(type);
			if(available > 0) {
				System.out.println(type + " → Available: " + available +
						", Price: ₹" + inventory.getPrice(type));
			}
		}
	}
	public boolean isRoomAvailable(String type) {
		return inventory.getAvailability(type) > 0;
	}
	public void showAmenities(String type) {
		switch (type) {
		case "Single":
			System.out.println("Amenities: WiFi, TV, AC");
			break;
		case "Double":
			System.out.println("Amenities: WiFi, TV, AC, Mini-bar");
			break;
		case "Suite":
			System.out.println("Amenities: WiFi, TV, AC, Mini-bar, Jacuzzi");
			break;
		default:
			System.out.println("No amenities listed for " + type);
		}
	}

}
