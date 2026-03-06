package com.room;

import java.util.*;
public class RoomInventory {
	HashMap<String,Integer> roomCounts;
	HashMap<String, Double> roomPrices;
	public RoomInventory() {
		roomCounts = new HashMap<String, Integer>();
		roomPrices = new HashMap<String, Double>();
	}
	// setting the values 
	public void addRoomType(String Type, int count, double price) {
		roomCounts.put(Type, count);
		roomPrices.put(Type, price);
	}

	public void updateRoomCount(String type, int count) {
		if(roomCounts.containsKey(type)) {
			roomCounts.put(type, count);
		}
	}

	public void updateRoomPrice(String type, double price) {
		if(roomPrices.containsKey(type)) {
			roomPrices.put(type, price);
		}
	}

	// Get availability
	public int getAvailability(String type) {
		return roomCounts.getOrDefault(type, 0);
	}

	// Get price
	public double getPrice(String type) {
		return roomPrices.getOrDefault(type, 0.0);
	}

	public HashMap<String, Integer> getRoomCounts() {
		return roomCounts;
	}

	// Display inventory
	public void displayInventory() {
		System.out.println("=== Current Room Inventory ===");
		for (String type : roomCounts.keySet()) {
			System.out.println(type + " → Count: " + roomCounts.get(type) +
					", Price: ₹" + roomPrices.get(type));
		}
	}

}




