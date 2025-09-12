package com.example.demo20.obj;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true, length = 50)
    private RoleName roleName;

    public Roles() {
        // Default constructor for JPA
    }

    public Roles(RoleName roleName) {
        this.roleName = roleName;
    }

    public Roles(String roleName) {
        this.roleName = RoleName.valueOf(roleName.toUpperCase());
    }


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(roleId, roles.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }

    public String getName() {
        return roleName.name(); // Получаем строковое имя из enum RoleName
    }

    public enum RoleName {
        ADMIN,
        CLIENT,
        MANAGER;
    }
}

