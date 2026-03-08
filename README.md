# BookMyStay

## UC1: Room Inventory Setup & Management
**Overview**  
Keeps track of room types, their counts, and prices in a centralized way.  

**Details**  
- Initialize room types (Single, Double, Suite)  
- Store counts and prices in HashMaps  
- Allow updates and show availability  
- Solves the problem of manual registers and overbooking  

## UC2: Room Search & Availability Check
**Overview**  
Guests can search for rooms without changing the inventory.  

**Details**  
- Display available room types with prices and amenities  
- Prevent booking when rooms are unavailable  
- Provides accurate and up‑to‑date availability  

## UC3: Booking Request (First-Come-First-Served)
**Overview**  
Handles booking requests fairly using a queue.  

**Details**  
- Requests are stored in FIFO order  
- Ensures fairness during peak demand  
- Avoids race conditions and inconsistent allocations  

## UC4: Reservation Confirmation & Room Allocation
**Overview**  
Assigns unique room IDs to confirmed bookings to prevent overlaps.  

**Details**  
- Generates unique IDs for each reservation  
- Updates availability immediately  
- Guarantees no double‑booking  


## UC5: Add-On Service Selection
**Overview**  
Guests can attach optional services to their bookings.  

**Details**  
- Services like breakfast, spa, pickup can be added  
- Multiple services per booking supported  
- Calculates additional costs cleanly  

## UC6: Booking History & Reporting
**Overview**  
Maintains a record of all confirmed reservations for audit and support.  

**Details**  
- Stores reservations in a list  
- Supports cancellation and review  
- Generates simple reports for admins  
