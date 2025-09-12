package com.example.demo20.repo;

import com.example.demo20.obj.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    // Метод для поиска роли по имени (RoleName)
    Optional<Roles> findByRoleName(Roles.RoleName roleName);

    // Метод для проверки наличия роли по имени
    boolean existsByRoleName(Roles.RoleName roleName);
}
