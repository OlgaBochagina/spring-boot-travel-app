package com.example.demo20.repo;

import com.example.demo20.obj.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToursRepository extends JpaRepository<Tours, Long> {
    List<Tours> findByDestinationContainingIgnoreCase(String destination);
}



