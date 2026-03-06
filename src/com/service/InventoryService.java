package com.service;

import com.room.RoomInventory;

public class InventoryService {
	
	private RoomInventory inventory;

	public InventoryService(RoomInventory inventory) {
		this.inventory = inventory;
	}
	// initialising with prices and count
	public void initializeDefaultRooms() {
		inventory.addRoomType("Single", 10, 2000.0);
		inventory.addRoomType("Double", 5, 3500.0);
		inventory.addRoomType("Suite", 0, 8000.0);
	}
	// invokes update details 
	public void updateRoom(String type, int count, double price) {
		inventory.updateRoomCount(type, count);
		inventory.updateRoomPrice(type, price);
	}
	// show availabilty of room
	public void showAvailability(String type) {
		System.out.println(type + " rooms available: " + inventory.getAvailability(type));
	}
	// shows prices
	public void showPrice(String type) {
		System.out.println(type + " room price per night: ₹" + inventory.getPrice(type));
	}

}
