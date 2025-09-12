package com.example.demo20.controller;

import com.example.demo20.obj.Bookings;
import com.example.demo20.obj.Bookings.BookingStatus;
import com.example.demo20.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/bookings")
public class ManagerController {

    private final BookingsService bookingsService;

    @Autowired
    public ManagerController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    // Добавление нового бронирования
    @PostMapping("/add")
    public ResponseEntity<Bookings> addBooking(@RequestParam Long clientId,
                                               @RequestParam Long tourId,
                                               @RequestParam BookingStatus status) {
        return ResponseEntity.ok(bookingsService.addBooking(clientId, tourId, status));
    }

    // Удаление бронирования
    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long bookingId) {
        bookingsService.deleteBooking(bookingId);
        return ResponseEntity.ok("Бронирование удалено успешно");
    }

    // Просмотр всех бронирований
    @GetMapping("/all")
    public ResponseEntity<List<Bookings>> getAllBookings() {
        return ResponseEntity.ok(bookingsService.getAllBookings());
    }
}


