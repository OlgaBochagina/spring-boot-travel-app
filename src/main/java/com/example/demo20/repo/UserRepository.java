package com.example.demo20.repo;

import com.example.demo20.obj.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Для поиска пользователя по имени

    boolean existsByUsername(String username);
}
