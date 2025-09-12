package com.example.demo20.service;

import com.example.demo20.obj.Bookings;
import com.example.demo20.obj.Bookings.BookingStatus;
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
public class BookingsService {

    private final BookingsRepository bookingsRepository;
    private final ClientsRepository clientsRepository;
    private final ToursRepository toursRepository;

    @Autowired
    public BookingsService(BookingsRepository bookingsRepository,
                           ClientsRepository clientsRepository,
                           ToursRepository toursRepository) {
        this.bookingsRepository = bookingsRepository;
        this.clientsRepository = clientsRepository;
        this.toursRepository = toursRepository;
    }

    // 1. Добавление нового бронирования (для менеджера)
    public Bookings addBooking(Long clientId, Long tourId, BookingStatus status) {
        Clients client = clientsRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Клиент с ID " + clientId + " не найден"));
        Tours tour = toursRepository.findById(tourId)
                .orElseThrow(() -> new IllegalArgumentException("Тур с ID " + tourId + " не найден"));

        Bookings booking = new Bookings(client, tour, status);
        return bookingsRepository.save(booking);
    }

    // 2. Удаление бронирования (для менеджера)
    public void deleteBooking(Long bookingId) {
        if (!bookingsRepository.existsById(bookingId)) {
            throw new IllegalArgumentException("Бронирование с ID " + bookingId + " не найдено");
        }
        bookingsRepository.deleteById(bookingId);
    }

    // 3. Просмотр всех бронирований (для менеджера)
    public List<Bookings> getAllBookings() {
        return bookingsRepository.findAll();
    }

    // 4. Просмотр всех бронирований конкретного клиента (для клиента)
    public List<Bookings> getClientBookings(Long clientId) {
        Clients client = clientsRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Клиент с ID " + clientId + " не найден"));
        return client.getBookings();
    }

    // 5. Просмотр информации о конкретном бронировании (для клиента)
    public Optional<Bookings> getBookingById(Long bookingId) {
        return bookingsRepository.findById(bookingId);
    }
}
