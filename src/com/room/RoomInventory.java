package com.room;

import java.util.*;
public class RoomInventory {
	HashMap<String,Integer> roomCounts;
	HashMap<String, Double> roomPrices;
	private HashMap<String, Set<String>> allocatedRooms; // room type → assigned IDs
    private Set<String> bookedRoomIds; 
	public RoomInventory() {
		roomCounts = new HashMap<String, Integer>();
		roomPrices = new HashMap<String, Double>();
		allocatedRooms = new HashMap<>();
	    bookedRoomIds = new HashSet<>();
	}
	// setting the values 
	public void addRoomType(String type, int count, double price) {
	    roomCounts.put(type, count);
	    roomPrices.put(type, price);
	    allocatedRooms.put(type, new HashSet<>()); 
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
	public void decrementRoom(String type) {
		if (roomCounts.containsKey(type) && roomCounts.get(type) > 0) {
			roomCounts.put(type, roomCounts.get(type) - 1);
		}
	}


	public String allocateRoom(String type, String guestName) {
	    if (getAvailability(type) > 0) {
	        String roomId = type.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 6);
	        if (!bookedRoomIds.contains(roomId)) {
	            bookedRoomIds.add(roomId);
	            allocatedRooms.computeIfAbsent(type, k -> new HashSet<>()).add(roomId);
	            roomCounts.put(type, roomCounts.get(type) - 1);
	            return roomId;
	        }
	    }
	    return null;
	}

	 public void cancelRoom(String roomId, String type) {
	        if (bookedRoomIds.contains(roomId)) {
	            bookedRoomIds.remove(roomId);
	            allocatedRooms.getOrDefault(type, new HashSet<>()).remove(roomId);
	            roomCounts.put(type, roomCounts.get(type) + 1);
	            System.out.println("Room " + roomId + " cancelled and availability restored.");
	        }
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




