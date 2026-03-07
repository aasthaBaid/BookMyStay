package com.service;

import java.util.*;

public class ServiceManagementModule {
	private Map<String, List<Service>> reservationServices;

    public ServiceManagementModule() {
        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
        System.out.println("Service added: " + service.getName() + " → Reservation ID: " + reservationId);
    }

    public double calculateTotalServiceCost(String reservationId) {
        return reservationServices.getOrDefault(reservationId, Collections.emptyList())
                                  .stream()
                                  .mapToDouble(Service::getCost)
                                  .sum();
    }

    public void displayServices(String reservationId) {
        System.out.println("=== Services for Reservation " + reservationId + " ===");
        List<Service> services = reservationServices.getOrDefault(reservationId, Collections.emptyList());
        for (Service s : services) {
            System.out.println(s.getName() + " → ₹" + s.getCost());
        }
    }

}
