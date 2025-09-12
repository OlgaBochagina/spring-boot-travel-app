package com.example.demo20.service;

import com.example.demo20.obj.Bookings;
import com.example.demo20.obj.Clients;
import com.example.demo20.obj.Tours;
import com.example.demo20.repo.BookingsRepository;
import com.example.demo20.repo.ClientsRepository;
import com.example.demo20.repo.ToursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    private final ToursRepository toursRepository;
    private final BookingsRepository bookingsRepository;
    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ToursRepository toursRepository,
                          BookingsRepository bookingsRepository,
                          ClientsRepository clientsRepository) {
        this.toursRepository = toursRepository;
        this.bookingsRepository = bookingsRepository;
        this.clientsRepository = clientsRepository;
    }

    // 1. Просмотр всех доступных туров
    public List<Tours> getAllAvailableTours() {
        return toursRepository.findAll();
    }

    // 2. Поиск туров по направлению
    public List<Tours> searchToursByDestination(String destination) {
        return toursRepository.findByDestinationContainingIgnoreCase(destination);
    }

    // 3. Просмотр всех бронирований конкретного клиента
    public List<Bookings> getClientBookings(Long clientId) {
        Clients client = clientsRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Клиент с ID " + clientId + " не найден"));
        return client.getBookings();
    }

    // 4. Просмотр информации о конкретном бронировании
    public Optional<Bookings> getBookingById(Long bookingId) {
        return bookingsRepository.findById(bookingId);
    }

    // 5. Получение всех клиентов (для администратора)
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    // 6. Регистрация нового клиента (для администратора)
    public Clients registerClient(Clients client) {
        return clientsRepository.save(client);
    }
}

