package com.example.demo20.obj;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tours tour;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "booking_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private BookingStatus status;

    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELED
    }

    @PrePersist
    public void prePersist() {
        if (bookingDate == null) {
            bookingDate = LocalDateTime.now();
        }
    }

    protected Bookings() {
        // Default constructor for JPA
    }

    public Bookings(Clients client, Tours tour, BookingStatus status) {
        this.client = client;
        this.tour = tour;
        this.status = status;
        this.bookingDate = LocalDateTime.now();
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Tours getTour() {
        return tour;
    }

    public void setTour(Tours tour) {
        this.tour = tour;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(bookingId, bookings.bookingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId);
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", client=" + client +
                ", tour=" + tour +
                ", bookingDate=" + bookingDate +
                ", status=" + status +
                '}';
    }
}

