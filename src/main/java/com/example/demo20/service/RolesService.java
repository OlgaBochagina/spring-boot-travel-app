package com.example.demo20.service;

import com.example.demo20.obj.Roles;
import com.example.demo20.repo.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService {

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Roles getRoleByName(Roles.RoleName roleName) {
        return rolesRepository.findByRoleName(roleName)
                .orElseThrow(() -> new IllegalArgumentException("Роль не найдена: " + roleName));
    }

    public boolean roleExists(Roles.RoleName roleName) {
        return rolesRepository.existsByRoleName(roleName);
    }
}
