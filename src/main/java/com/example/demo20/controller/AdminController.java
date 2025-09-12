package com.example.demo20.controller;

import com.example.demo20.obj.Bookings;
import com.example.demo20.obj.Clients;
import com.example.demo20.obj.Tours;
import com.example.demo20.service.BookingsService;
import com.example.demo20.service.ClientsService;
import com.example.demo20.service.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tours")
public class AdminController {

    private final ToursService toursService;
    private final BookingsService bookingsService;
    private final ClientsService clientsService;

    @Autowired
    public AdminController(ToursService toursService,
                           BookingsService bookingsService,
                           ClientsService clientsService) {
        this.toursService = toursService;
        this.bookingsService = bookingsService;
        this.clientsService = clientsService;
    }

    // Добавление нового тура
    @PostMapping("/add")
    public ResponseEntity<Tours> addNewTour(@RequestBody Tours tour) {
        System.out.println("Добавление тура: " + tour);
        return ResponseEntity.ok(toursService.addNewTour(tour));
    }


    // Удаление тура по ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id) {
        toursService.deleteTourById(id);
        return ResponseEntity.ok("Тур с ID " + id + " успешно удален");
    }

    // Получение всех туров
    @GetMapping("/all")
    public ResponseEntity<List<Tours>> getAllTours() {
        return ResponseEntity.ok(toursService.getAllAvailableTours());
    }

    // Получение всех бронирований
    @GetMapping("/bookings/all")
    public ResponseEntity<List<Bookings>> getAllBookings() {
        return ResponseEntity.ok(bookingsService.getAllBookings());
    }

    // Получение всех клиентов
    @GetMapping("/clients/all")
    public ResponseEntity<List<Clients>> getAllClients() {
        return ResponseEntity.ok(clientsService.getAllClients());
    }

    // Регистрация нового клиента от имени администратора
    @PostMapping("/clients/register")
    public ResponseEntity<Clients> registerNewClient(@RequestBody Clients client) {
        return ResponseEntity.ok(clientsService.registerClient(client));
    }
}




