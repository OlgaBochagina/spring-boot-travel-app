package com.example.demo20.service;

import com.example.demo20.obj.Tours;
import com.example.demo20.repo.ToursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ToursService {

    private final ToursRepository toursRepository;

    @Autowired
    public ToursService(ToursRepository toursRepository) {
        this.toursRepository = toursRepository;
    }

    // 1. Просмотр всех доступных туров (для клиентов)
    public List<Tours> getAllAvailableTours() {
        return toursRepository.findAll();
    }

    // 2. Поиск туров по направлению (для админа)
    public List<Tours> searchToursByDestination(String destination) {
        return toursRepository.findByDestinationContainingIgnoreCase(destination);
    }

    // 3. Добавление нового тура (для администратора)
    public Tours addNewTour(Tours tour) {
        if (tour.getPrice().compareTo(tour.getPrice().min(BigDecimal.ZERO)) < 0) {
            throw new IllegalArgumentException("Цена тура не может быть отрицательной");
        }
        return toursRepository.save(tour);
    }

    // 4. Удаление тура по ID (для администратора)
    public void deleteTourById(Long tourId) {
        if (!toursRepository.existsById(tourId)) {
            throw new IllegalArgumentException("Тур с ID " + tourId + " не найден");
        }
        toursRepository.deleteById(tourId);
    }

    // 5. Получение информации о конкретном туре (для общей логики, может использоваться дополнительно)
    public Optional<Tours> getTourById(Long tourId) {
        return toursRepository.findById(tourId);
    }
}
