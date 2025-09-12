package com.example.demo20.service;

import com.example.demo20.obj.Roles;
import com.example.demo20.obj.User;
import com.example.demo20.repo.UserRepository;
import com.example.demo20.DataTransferObject.RegisterRequest;
import com.example.demo20.DataTransferObject.LoginRequest;
import com.example.demo20.config.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RolesService rolesService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(UserRepository userRepository,
                       RolesService rolesService,
                       PasswordEncoder passwordEncoder,
                       JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.rolesService = rolesService;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public void registerClient(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Пользователь с таким именем уже существует");
        }

        Roles clientRole = rolesService.getRoleByName(Roles.RoleName.CLIENT);
        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail(),
                clientRole
        );
        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Неверное имя пользователя или пароль"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Неверное имя пользователя или пароль");
        }
        return jwtProvider.generateToken(user.getUsername(), user.getRole().getRoleName().name());
    }
}
