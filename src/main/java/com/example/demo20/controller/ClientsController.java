package com.example.demo20.controller;

import com.example.demo20.obj.Bookings;
import com.example.demo20.obj.Tours;
import com.example.demo20.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    // 1. Получение всех туров
    @GetMapping("/tours")
    public ResponseEntity<List<Tours>> getAllTours() {
        return ResponseEntity.ok(clientsService.getAllAvailableTours());
    }

    // 2. Поиск туров по направлению
    @GetMapping("/tours/search")
    public ResponseEntity<List<Tours>> searchTours(@RequestParam String destination) {
        return ResponseEntity.ok(clientsService.searchToursByDestination(destination));
    }

    // 3. Получение всех бронирований клиента
    @GetMapping("/{clientId}/bookings")
    public ResponseEntity<List<Bookings>> getClientBookings(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientsService.getClientBookings(clientId));
    }

    // 4. Получение информации о конкретном бронировании
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable Long bookingId) {
        return clientsService.getBookingById(bookingId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

