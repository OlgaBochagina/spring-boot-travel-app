package com.example.demo20.DataTransferObject;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    @NotNull
    @Size(min = 3, max = 100)
    private String username;

    @NotNull
    @Size(min = 8)
    private String password;

    // Геттеры и сеттеры
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

