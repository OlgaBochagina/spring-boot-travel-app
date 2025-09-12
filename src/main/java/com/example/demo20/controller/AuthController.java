package com.example.demo20.controller;

import com.example.demo20.DataTransferObject.LoginRequest;
import com.example.demo20.DataTransferObject.RegisterRequest;
import com.example.demo20.DataTransferObject.TokenResponse;
import com.example.demo20.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerClient(@RequestBody RegisterRequest request) {
        authService.registerClient(request);
        return ResponseEntity.ok("Клиент успешно зарегистрирован");
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(new TokenResponse(token));
    }
}

